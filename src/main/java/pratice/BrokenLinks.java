package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://demo.guru99.com/test/newtours/support.php");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      List<WebElement> links  =webDriver.findElements(By.tagName("a"));
        System.out.println("Number of links"+":"+links.size());
        for (int i=0;i<links.size();i++)
        {
            // by using the href we can get url of requried link
            WebElement element = links.get(i);
            String url= element.getAttribute("href");

            try {
                URL link = new URL(url);
                // create a connection by using url object "link"
                HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
                Thread.sleep(2000);
                httpURLConnection.connect();
               int responseCode = httpURLConnection.getResponseCode();// return response code if the code is above 4000 then broken
                if (responseCode>=400)
                {
                    System.out.println(url+"_ "+"broken links");
                }
                    else
                {
                    System.out.println(url+"_ "+" not broken links");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
