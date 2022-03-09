package pratice;

import com.atmecs.toolkit.PropertyManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Alerts
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        //webDriver.get("https://demoqa.com/alerts");
        webDriver.manage().window().maximize();

        /*webDriver.findElement(By.xpath("//button[@id='alertButton']")).click();
       // Thread.sleep(1000);
        Alert alert = webDriver.switchTo().alert();
        String alert_message= alert.getText();
        System.out.println("Alert Message"+""+ alert_message);
        Thread.sleep(1000);
        alert.accept();*/



        //webDriver.findElement(By.xpath("//span[contains(text(),'Home')]"));
            //String xpath = PropertyManager.getInstance().getElements_under_department();
        webDriver.get("https://demoqa.com/checkbox");
            List<WebElement> check = webDriver.findElements(By.xpath("//span[contains(text(),'Home')]"));
            if (check.size() != 0) {
                //If list size is non-zero, element is present
                System.out.println("Home is present");
            } else {
                //Else if size is 0, then element is not present
                System.out.println("Home is not present not present");
            }

            webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();


// number of checkboxex.
        //String xpath= PropertyManager.getInstance().getElements_under_department();
       // int checkboxes = webDriver.findElements(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]")).size();
        int checkboxes=webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li")).size();
        System.out.println(checkboxes + " " + "Element or checkboxes present under Department");

        //list

        List<WebElement> elementList = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li"));
        System.out.println("Element under the Department are below:");
        for (WebElement webElement : elementList) {
            System.out.println(webElement.getText());


            // check


            //String xpath= PropertyManager.getInstance().getElements_under_department();
            List<WebElement> selenium_element_list = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li"));
            List<String> element_list = new ArrayList<String>();
            for (WebElement element : selenium_element_list) {
                element_list.add(element.getText());
            }
            //System.out.println(strings);
            String[] elements_to_array = element_list.toArray(new String[0]);
            // Get the value to be checked
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the element you want to check");
            String toCheckValue = scanner.nextLine();
            //String value= toCheckValue.equalsIgnoreCase(String.valueOf(elements_to_array));
            // Print the array
            //System.out.println("Array: " + Arrays.toString(elements_to_array));
            // Check if this value is
            // present in the array or not
            //check(elements_to_array, toCheckValue);
            boolean test = Arrays.asList(elements_to_array).contains(toCheckValue);
            // Print the result
            System.out.println("Is " + toCheckValue + " present in the array: " + test);
        }

        }
    }

