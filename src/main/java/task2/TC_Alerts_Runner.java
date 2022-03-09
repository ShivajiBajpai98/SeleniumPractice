package task2;


import org.openqa.selenium.WebDriver;

public class TC_Alerts_Runner
{
    public static void main(String[] args)
    {

       TC_Alerts tc_alerts = new TC_Alerts();
       WebDriver webDriver= Base.launchBrowser("chrome");
        Base.navigateUrl("https://demoqa.com/alerts");
        Base.windowMaximize();
        tc_alerts.simpleAlert(webDriver);
        tc_alerts.alertWithOkAndCancel(webDriver);
        tc_alerts.alertWithInput(webDriver);






    }
}
