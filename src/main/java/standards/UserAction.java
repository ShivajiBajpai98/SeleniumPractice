package standards;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class UserAction
{
    // check the page is present oe not
    public boolean isElementPresent(WebDriver webDriver, By by) {
        try {

            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // return the title of url
    public String getTitle(WebDriver webDriver) {
        return webDriver.getTitle();
    }

// Check login name  text box present or not
    public boolean loginNameTextBox(WebDriver webDriver, By by, String loginNameValue)
    {

        if (isElementPresent(webDriver, by)) {
            try {
                webDriver.findElement(by).sendKeys(loginNameValue);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }else
            System.out.println("Locator is not present");
            return false;
    }

    // Check password text box  present or not
    public boolean passwordTextBox(WebDriver webDriver, By by, String passwordValue)
    {

        if (isElementPresent(webDriver, by)) {
            try {
                webDriver.findElement(by).sendKeys(passwordValue);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }else
            System.out.println("Locator is not present");
        return false;
    }
 // check login button present or not
    public boolean loginButton(WebDriver webDriver, By by)
    {

        if (isElementPresent(webDriver, by)) {
            try {
                webDriver.findElement(by).click();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }else
            System.out.println("Locator is not present");
        return false;
    }

    // check clear button present or not
    public boolean clearButton(WebDriver webDriver, By by)
    {

        if (isElementPresent(webDriver, by)) {
            try {
                webDriver.findElement(by).click();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }else
            System.out.println("Locator is not present");
        return false;
    }
}