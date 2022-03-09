package task2;

import com.atmecs.toolkit.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckBoxes
{
    public void homePresentOrNot(WebDriver webDriver)
    {
        //String xpath = PropertyManager.getInstance().getElements_under_department();
        List<WebElement> check = webDriver.findElements(By.xpath("//span[contains(text(),'Home')]"));
        if (check.size() != 0) {
            //If list size is non-zero, element is present
            System.out.println("Home is present");
        } else {
            //Else if size is 0, then element is not present
            System.out.println("Home is not present");
        }
    }

    public void numberOFCHeckBoxex(WebDriver webDriver)
    {
        // String xpath= PropertyManager.getInstance().getElements_under_department();

        // if chained checkboxes
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        //then
        int checkboxes = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li")).size();
        System.out.println(checkboxes + " " + "Element or checkboxes present under Home");
    }

    public void elementListUnderHome(WebDriver webDriver)
    {

        //String xpath= PropertyManager.getInstance().getElements_under_department();
        // if chained checkboxes
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        //then
        List<WebElement> elementList = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li"));
        System.out.println("Element under the Department are below:");
        for (WebElement webElement : elementList) {
            System.out.println(webElement.getText());
        }
    }


    public void checkElement(WebDriver webDriver)
    {
       // String xpath= PropertyManager.getInstance().getElements_under_department();
        // if chained checkboxes
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        //then
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
       // toCheckValue.equalsIgnoreCase(scanner.nextLine());

        boolean test = Arrays.asList(elements_to_array).contains(toCheckValue);
        // Print the result
        System.out.println("Is " + toCheckValue + " present in the array: " + test);
    }

    public  void clickAllCheckboxes(WebDriver webDriver)
    {
       // String xpath= PropertyManager.getInstance().getElements_under_department();

        // if chained checkboxes
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        //then
       // List<WebElement> tick_select = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li"));

        //leaf xpath
        List<WebElement> tick_select = webDriver.findElements(By.xpath("//span[@class='rct-checkbox']//*"));

        System.out.println();
        for (int select_check_box = 0; select_check_box < tick_select.size(); select_check_box++)
        {
            tick_select.get(select_check_box).click();
        }


    }

    public void selectLastTwoCheckBoxes(WebDriver webDriver)
    {
        //String xpath= PropertyManager.getInstance().getElements_under_department();



        // String xpath= PropertyManager.getInstance().getElements_under_department();

        // if chained checkboxes
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        //then
         List<WebElement> ticks_select = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li"));

        //leaf xpath
        //List<WebElement> ticks_select = webDriver.findElements(By.xpath("//span[@class='rct-checkbox']//*"));
       // List<WebElement> ticks_select  = webDriver.findElements(By.xpath(xpath));
        int  total_checkboxes =ticks_select.size();
        System.out.println(total_checkboxes + " " + "Element or checkboxes present under Department");
        for ( int select_check_box =total_checkboxes-2; select_check_box<total_checkboxes;select_check_box++)
        {
            ticks_select.get(select_check_box).click();
        }
    }

    public void selectStartTwoCheckBoxes(WebDriver webDriver)
    {
        //String xpath= PropertyManager.getInstance().getElements_under_department();
       // List<WebElement> ticks_select  = webDriver.findElements(By.xpath());

        // if chained checkboxes
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        //then
       // List<WebElement> ticks_select = webDriver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']//li"));
//leaf
        List<WebElement> ticks_select = webDriver.findElements(By.xpath("//span[@class='rct-checkbox']//*"));
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
    public void selectChoiceValues(WebDriver webDriver,String... value)
    {
        webDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
        List<WebElement> ticks_select = webDriver.findElements(By.xpath("//span[@class='rct-checkbox']//*"));
        if (!value[0].equalsIgnoreCase("all"))
        {
            for (WebElement item: ticks_select)
            {
                String text =item.getText();
                for (String val:value)
                {
                    if (text.equals(val))
                    {
                        item.click();
                        break;
                    }
                }
            }

        }else
        {
            for (WebElement item:ticks_select)
            {
                item.click();
            }
        }
    }
}
