package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ShadowLocator
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
       // webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to("https://books-pwakit.appspot.com/");
        webDriver.manage().window().maximize();
       WebElement root= webDriver.findElement(By.tagName("book-app"));

       JavascriptExecutor js = (JavascriptExecutor)webDriver;
        WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot",root);
        WebElement appheader=shadowDom1.findElement(By.tagName("app-header"));
       WebElement apptoolbar= appheader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
       WebElement bookinputdecorator =apptoolbar.findElement(By.tagName("book-input-decorator"));
       bookinputdecorator.findElement(By.cssSelector("input#input")).sendKeys("Testing");


    }
}
