package pratice;



import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.ws.util.ReadAllStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class L2
{
    public static Set<String> uniqueURL = new HashSet<String>();
    public static String my_site;
    public static Set<String> uniqueURLAtmecs = new HashSet<String>();
    public static String my_siteAtmecs;

    public static void main(String[] args) {
       // ReadAllStream
        L2 obj = new L2();
        my_site = "stackoverflow.com";
        obj.get_links("http://stackoverflow.com/");
    }

    private void get_links(String url) {
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
            Elements links = doc.select("a");

            if (links.isEmpty()) {
                return;
            }

            links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
                boolean add = uniqueURL.add(this_url);
                if (add && this_url.contains(my_site)) {

                    int count=0;
                    count++;
                    System.out.println(this_url);
                    get_links(this_url);
                    System.out.println("count"+count);



                }
            });

        } catch (IOException ex) {

        }

    }
}
