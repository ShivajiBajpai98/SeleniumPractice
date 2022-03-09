package task2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_Alerts
{
        public void simpleAlert(WebDriver webDriver) {
            webDriver.findElement(By.xpath("//button[@id='alertButton']")).click();
           // Thread.sleep(1000);
            Alert alert = webDriver.switchTo().alert();
            String alert_message = alert.getText();
            System.out.println("Alert Message" + alert_message);
            //Thread.sleep(1000);
            alert.accept();
        }


        // alert with ok and cancel
    public void alertWithOkAndCancel(WebDriver webDriver) {
        webDriver.findElement(By.xpath("//button[@id='confirmButton']")).click();
       Alert alert1= webDriver.switchTo().alert();
        String alert_message1=alert1.getText();
        System.out.println("Alert Message"+alert_message1);
       // Thread.sleep(1000);
        alert1.accept();
        //alert1.dismiss();
    }


        // alerts with input
        public  void alertWithInput(WebDriver webDriver)
    {
       webDriver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Alert alert2 = webDriver.switchTo().alert();
        String alert_message2=alert2.getText();
        System.out.println("Alert Message"+alert_message2);
        //Thread.sleep(1000);
        alert2.sendKeys("Shivaji");
        alert2.accept();
        //alert2.dismiss();
    }






    }

