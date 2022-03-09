package Checkboxes;

import com.atmecs.toolkit.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Amazon_CheckBoxes
{
   // WebDriver driver=null;
    public void initializeDriver()
    {
        String chromeDriverPath= PropertyManager.getInstance().getChormeDriverPath();
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver",path+chromeDriverPath);

    }


    public WebDriver launchBrowse()
    {
        String browserType = PropertyManager.getInstance().getbrowserType();
        //System.out.println(browserType);
        if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriver driver = new ChromeDriver();
           // System.out.println(driver.hashCode());
            return driver;
        }
        return null;
    }


    public void launchApp(WebDriver driver)
    {
        String url = PropertyManager.getInstance().getAppMangtURL();
        System.out.println(url);
       // assert driver != null;
       // WebDriver  driver = new ChromeDriver();
        driver.get(url);
    }

    public void windowMaximize(WebDriver driver)
    {
        driver.manage().window().maximize();
    }
    public void today_deal_click(WebDriver driver)
    {
        String todayDealXpath= PropertyManager.getInstance().getToday_Deal_Xpath();
        driver.findElement(By.xpath(todayDealXpath)).click();
    }
    public void departmentPresentOrNot(WebDriver driver)
    {
        String xpath = PropertyManager.getInstance().getElements_under_department();
        List<WebElement> check = driver.findElements(By.xpath(xpath));
        if (check.size() != 0) {
            //If list size is non-zero, element is present
            System.out.println("Department is present");
        } else {
            //Else if size is 0, then element is not present
            System.out.println("Department not present");
        }
    }

    public void numberOFCHeckBoxex(WebDriver driver)
    {
        String xpath= PropertyManager.getInstance().getElements_under_department();
        int checkboxes = driver.findElements(By.xpath(xpath)).size();
        System.out.println(checkboxes + " " + "Element or checkboxes present under Department");
    }

    public void elementListUnderDepartment (WebDriver driver)
    {
        String xpath= PropertyManager.getInstance().getElements_under_department();
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        System.out.println("Element under the Department are below:");
        for (WebElement webElement : elementList) {
            System.out.println(webElement.getText());
        }
    }

    public void checkElement(WebDriver driver)
    {
        String xpath= PropertyManager.getInstance().getElements_under_department();
        List<WebElement> selenium_element_list = driver.findElements(By.xpath(xpath));
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

    public  void clickAllCheckboxes(WebDriver driver)
    {
        String xpath= PropertyManager.getInstance().getElements_under_department();
        List<WebElement> tick_select = driver.findElements(By.xpath(xpath));
        System.out.println();
        for (int select_check_box = 0; select_check_box < tick_select.size(); select_check_box++) {
            tick_select.get(select_check_box).click();
        }
    }
    public void selectLastTwoCheckBoxes(WebDriver driver)
    {
        String xpath= PropertyManager.getInstance().getElements_under_department();
        List<WebElement> ticks_select  = driver.findElements(By.xpath(xpath));
        int  total_checkboxes =ticks_select.size();
        //System.out.println(checkboxes + " " + "Element or checkboxes present under Department");
        for ( int select_check_box =total_checkboxes-2; select_check_box<total_checkboxes;select_check_box++)
        {
            ticks_select.get(select_check_box).click();
        }
    }
    public void selectStartTwoCheckBoxes(WebDriver driver)
    {
        String xpath= PropertyManager.getInstance().getElements_under_department();
        List<WebElement> ticks_select  = driver.findElements(By.xpath(xpath));
        int  total_checkboxes =ticks_select.size();
        //System.out.println(checkboxes + " " + "Element or checkboxes present under Department");
        for ( int select_check_box =0; select_check_box<total_checkboxes;select_check_box++)
        {
            if(select_check_box<2)
            {
                ticks_select.get(select_check_box).click();
            }
        }
    }
}
