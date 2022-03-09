package demoqa;

import com.atmecs.toolkit.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class QA {
    public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://demoqa.com/automation-practice-form");
            webDriver.manage().window().maximize();

            //String xpath= PropertyManager.getInstance().getElements_under_department();
            //List<WebElement> tick_select = webDriver.findElements(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[7]/div[2]/div[*]"));
            //System.out.println();
           /* for (int select_check_box = 0; select_check_box < tick_select.size(); select_check_box++) {
                tick_select.get(select_check_box).click();
            }*/
       // webDriver.findElement(By.xpath("//label[text()='Sports']")).click();
        webDriver.findElement(By.id("hobbies-checkbox-1")).click();
      // System.out.println(s);
        }
    }

