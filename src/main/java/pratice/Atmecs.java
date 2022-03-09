package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Atmecs {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();


        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://www.atmecs.com/");
        webDriver.manage().window().maximize();



        String url="";
       // System.out.println("Total links on the Wb Page: " + allURLs.size());

        List<WebElement> allLinks = webDriver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allLinks.size());
        /*ArrayList<Object[]> data=new ArrayList<Object[]>();
        //Traversing through the list and printing its text along with link address
        for(WebElement link:allLinks){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
            data.add(new String[]{link.getText() + " - " + link.getAttribute("href")});
        }*/

    }
}