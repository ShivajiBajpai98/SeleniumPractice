package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteGooglePlacesDropDown
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        //webDriver.get("https://demoqa.com/alerts");
        webDriver.manage().window().maximize();
        webDriver.get("https://www.twoplugs.com/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
        WebElement searchBox= webDriver.findElement(By.id("autocomplete"));
        searchBox.clear();
        Thread.sleep(3000);
        searchBox.sendKeys("Toronto");
        Thread.sleep(3000);
        String text;
        do {

            searchBox.sendKeys(Keys.ARROW_DOWN);
            text=searchBox.getAttribute("value");
            if (text.equals("Toronto, OH, USA"))
            {
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
            Thread.sleep(3000);

        }while (!text.isEmpty());

    }
}
