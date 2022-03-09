package pratice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.navigate().to("http://183.82.103.245/nareshit/login.php");
            webDriver.findElement(By.name("txtUserName")).sendKeys("nareshit");
            webDriver.findElement(By.name("txtPassword")).sendKeys("nareshit");
            webDriver.findElement(By.name("Submit")).click();
            Thread.sleep(3000);
            WebElement element = webDriver.findElement(By.linkText("PIM"));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(element).perform();
            Thread.sleep(3000L);
            webDriver.findElement(By.linkText("Add Employee123")).click();
            Thread.sleep(4000);
            System.out.println("Clicked on submenu");
            webDriver.findElement(By.linkText("Logout")).click();
        }
        catch (Exception e)
        {

            File file =((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file,new File("D:\\TestResults.png"));
        }
            webDriver.quit();

    }
}