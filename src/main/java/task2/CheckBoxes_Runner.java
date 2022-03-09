package task2;

import org.openqa.selenium.WebDriver;

public class CheckBoxes_Runner
{
    public static void main(String[] args)
    {
        CheckBoxes checkBoxes = new CheckBoxes();
        WebDriver webDriver=Base.launchBrowser("chrome");
        Base.navigateUrl("https://demoqa.com/checkbox");
        Base.windowMaximize();
        checkBoxes.homePresentOrNot(webDriver);
        checkBoxes.numberOFCHeckBoxex(webDriver);
        checkBoxes.elementListUnderHome(webDriver);
        ////checkBoxes.checkElement(webDriver);
       // checkBoxes.clickAllCheckboxes(webDriver);
        //checkBoxes.selectLastTwoCheckBoxes(webDriver);
       // checkBoxes.selectStartTwoCheckBoxes(webDriver);
       // checkBoxes.selectChoiceValues(webDriver,"Word File.doc","Excel File.doc");
       // checkBoxes.clickAllCheckboxes(webDriver,"all");


    }
}
