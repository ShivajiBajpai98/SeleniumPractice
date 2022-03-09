package Checkboxes;

import Checkboxes.Amazon_CheckBoxes;
import org.openqa.selenium.WebDriver;

class Amazon_CheckBoxes_Runner
 {
     WebDriver driver=null;


     public static void main(String[] args)
     {
         WebDriver driver=null;

         Amazon_CheckBoxes amazon_checkBoxes = new Amazon_CheckBoxes();

         amazon_checkBoxes.initializeDriver();
         driver= amazon_checkBoxes.launchBrowse();
         amazon_checkBoxes.launchApp(driver);
         amazon_checkBoxes.windowMaximize(driver);
         amazon_checkBoxes.today_deal_click(driver);
         amazon_checkBoxes.departmentPresentOrNot(driver);
        //amazon_checkBoxes.elementListUnderDepartment(driver);
       // amazon_checkBoxes.checkElement(driver);
         //amazon_checkBoxes.numberOFCHeckBoxex(driver);
        // amazon_checkBoxes.checkElement(driver);
        amazon_checkBoxes.clickAllCheckboxes(driver);
       // amazon_checkBoxes.selectLastTwoCheckBoxes(driver);
         //amazon_checkBoxes.selectStartTwoCheckBoxes(driver);




     }


}
