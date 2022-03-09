package standards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task2.Base;

public class TestSample
{
    public static void main(String[] args)
    {
        WebDriver webDriver= task2.Base.launchBrowser("chrome");
       // Base.navigateUrl("http://183.82.103.245/nareshit/login.php");
        Base.navigateUrl("https://demo.opencart.com/admin/index.php");
        Base.windowMaximize();

        UserAction userAction = new UserAction();
        boolean result_page_available=  userAction.isElementPresent(webDriver, By.xpath("//body"));
        System.out.println("Page is present"+" "+result_page_available);
       String expectedTitle= userAction.getTitle(webDriver);
       System.out.println("Expected Title"+": "+expectedTitle);
     // boolean result_text_box= userAction.loginNameTextBox(webDriver,By.xpath("//tbody/tr[2]/td[2]/input[1]"),"nareshit");
        boolean result_text_box= userAction.loginNameTextBox(webDriver,By.xpath("//input[@id='input-username']"),"demo");

      System.out.println("Login_Name_TextBox_Present"+": "+result_text_box);
     // boolean result_password_Text_Box =userAction.passwordTextBox(webDriver,By.xpath("//tbody/tr[3]/td[2]/input[1]"),"nareshit");
        boolean result_password_Text_Box =userAction.passwordTextBox(webDriver,By.xpath("//input[@id='input-password']"),"demo");
        System.out.println("Password_TextBox_Present"+": "+result_password_Text_Box);
       //boolean result_login_button= userAction.loginButton(webDriver,By.name("Submit"));
        boolean result_login_button= userAction.loginButton(webDriver,By.xpath("//body/div[@id='container']/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]"));
      System.out.println("login_button_present"+": "+result_login_button);
        //boolean result_clear_button= userAction.clearButton(webDriver,By.xpath("//tbody/tr[4]/td[2]/input[1]"));
        //System.out.println("clear_button_present"+" "+result_clear_button);


        VerifySteps verifySteps = new VerifySteps();
       //verifySteps.verifyPageTitle(webDriver,expectedTitle);

        Login login = new Login();
        ///login.enterValueLoginNameTextBox(webDriver,"Login Name","nareshit");
        //login.enterValuePasswordTextBox(webDriver,"Password ","nareshit");
        //login.login(webDriver);






















    }
}
