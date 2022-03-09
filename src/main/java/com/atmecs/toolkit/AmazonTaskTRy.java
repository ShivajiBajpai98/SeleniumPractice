package com.atmecs.toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonTaskTRy {

    private static void check(String[] arr, String toCheckValue) {
        // check if the specified element
        // is present in the array or not
        // using contains() method
        boolean test = Arrays.asList(arr).contains(toCheckValue);

        // Print the result
        System.out.println("Is " + toCheckValue
                + " present in the array: " + test);
    }

    private static String Chrome;
    // private static WebDriver driver;

    public static void main(String[] args) throws IOException {
        WebDriver driver = null;


        String chromeDriverPath = PropertyManager.getInstance().getChormeDriverPath();
        String path = System.getProperty("user.dir");
       // System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
        System.out.println(path + chromeDriverPath);


        String browserType = PropertyManager.getInstance().getbrowserType();
        System.out.println(browserType);
        if (browserType.equals("Chrome")) {
            driver = new ChromeDriver();
        }


        String url = PropertyManager.getInstance().getAppMangtURL();
        System.out.println(url);
        assert driver != null;
        driver.get(url);

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]")).click();


        // first check department element is present or not.
        String xpath = "//div[contains(text(),'Departments')]/self::div[text()='Departments']/following::div[starts-with(@class,'CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49')]";
        List<WebElement> check = driver.findElements(By.xpath(xpath));
        if (check.size() != 0) {
            //If list size is non-zero, element is present
            System.out.println("Department is present");
        } else {
            //Else if size is 0, then element is not present
            System.out.println("Element is not present");
        }

        // check how many element or checkboxes present under departments
        int checkboxes = driver.findElements(By.xpath(xpath)).size();
        System.out.println(checkboxes + " " + "Element or checkboxes present under Department");


        //Element list are below:
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        System.out.println("Element under the Department are below:");
        for (WebElement webElement : elementList) {
            System.out.println(webElement.getText());


        }


        //Scanner scanner1 = new Scanner(System.in);
        //System.out.println("Enter element");
        //String e=scanner1.nextLine();
        //System.out.println(e);
        //String xpath2="//div[contains(text(),'Departments')]/self::div[text()='Departments']/following::div[starts-with(@class,'CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49')]//span[text()='"+e+"']";


        /*List<WebElement> elementLists = driver.findElements(By.xpath(xpath2));
        for (WebElement webElements : elementLists) {
            //System.out.println(webElement.getText());
            if (webElements.getText().equals(e))
            {
                System.out.println("e present");
            }
            else {
                System.out.println("not present");
            }

        }*/

        List<WebElement> codes = driver.findElements(By.xpath(xpath));
        List<String> strings = new ArrayList<String>();
        for (WebElement c : codes) {
            strings.add(c.getText());
        }

        //System.out.println(strings);

        String arr[] = strings.toArray(new String[0]);

        // Get the value to be checked
        String toCheckValue = "aaa";

        // Print the array
        System.out.println("Array: "
                + Arrays.toString(arr));

        // Check if this value is
        // present in the array or not
        check(arr, toCheckValue);


        //Select all checkboxes
        List<WebElement> tick = driver.findElements(By.xpath(xpath));
        System.out.println();
        for (int i = 0; i < tick.size(); i++) {
            tick.get(i).click();
        }


// based on my choice checkboxes:
       /* for (WebElement cbox:tick)
        {
            cbox.getAttribute(xpath);
            if (cbox.equals("Video Games")||cbox.equals("Women’s Fashion"))
            {
                cbox.click();
            }
        }*/

        // select last 2 check boxes
        List<WebElement> ticks  = driver.findElements(By.xpath(xpath));
      int  totalcheckboxes =ticks.size();
        System.out.println(totalcheckboxes + " " + "Element or checkboxes present under Department");
for ( int i =totalcheckboxes-2; i<totalcheckboxes;i++)
{
    ticks.get(i).click();
}

// check 2 boxes from start
        for (int i=0;i<=totalcheckboxes;i++)
        {
            if(i<2)
            {
                tick.get(i).click();
            }
        }
    }
}