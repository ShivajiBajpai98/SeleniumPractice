package standards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login
{
    public void enterValueLoginNameTextBox(WebDriver webDriver ,String loginUserName  ,String userName)
    {

        webDriver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(userName);
    }

    public void enterValuePasswordTextBox(WebDriver webDriver ,String loginUserName  ,String userPassword)
    {

        webDriver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys(userPassword);
    }

    public void login(WebDriver webDriver)
    {
        webDriver.findElement(By.name("Submit")).click();
    }
   /* enterValueInTextBox(eleUsername, usernameValue);
    enterValueInTextBox(elePassword, passwordValue);
    clickButton(“Login”);*/
}
