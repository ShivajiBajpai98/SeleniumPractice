package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class GetLinks
{
    public static void main(String[] args) {

        //Create WebDriver instance and open the website.
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://demoqa.com/links");
        driver.get("https://razorpay.com/");

        String url="";
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());

        //We will iterate through the list and will check the elements in the list.
        for (WebElement allURL : allURLs) {
            url = allURL.getText();
            System.out.println(url);
        }

        //Close the browser session
        driver.quit();
    }
}
