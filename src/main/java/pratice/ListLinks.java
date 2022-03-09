package pratice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListLink {
    static void getLinks(String url, Set<String> urls) {

        if (urls.contains(url)) {
            return;
        }
        urls.add(url);

        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("a");
            for (Element element : elements) {
                System.out.println(element.absUrl("href"));
                getLinks(element.absUrl("href"), urls);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();


        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://www.atmecs.com/");
        webDriver.manage().window().maximize();


        List<WebElement> allLinks = webDriver.findElements(By.tagName("a"));
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        //Traversing through the list and printing its text along with link address
        for (WebElement link : allLinks) {
            //System.out.println(link.getText() + " - " + link.getAttribute("href"));
            data.add(new String[]{link.getText() + " - " + link.getAttribute("href")});
        }



       // List<WebElement> lst=d.findElements(By.tagName("a"));
        List<String> strings = new ArrayList<String>();
        for(WebElement e : allLinks){
            strings.add(e.getText());
        }

        // List<WebElement> efirstpagecount = driver.findElements(By.xpath("//*[@id='usersList']/tbody/tr/td[3]"));

        Set<String> uniquecount = new HashSet<String>(strings);
        System.out.println("Unique count: " + uniquecount.size());

       /* for (String u : uniquecount) {
            System.out.println(u.getText());
        }*/
       // Set<String> links = new HashSet<>();
        getLinks("https://www.example.com/", uniquecount);



       /* ListLink listLink = new ListLink();
        Set<String> links = new HashSet<>();
        ListLink.getLinks("https://www.atmecs.com/", links);
    }*/
    }
}