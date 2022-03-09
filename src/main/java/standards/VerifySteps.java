package standards;

import org.openqa.selenium.WebDriver;

public class VerifySteps {
    public boolean verifyPageTitle(WebDriver webDriver, String expectedTitle)
    {
       String actualTitle= webDriver.getTitle();
       //System.out.println(actualTitle);

        if (actualTitle.equals(expectedTitle))
        {
            System.out.println("Expected Title is"+" "+actualTitle+" "+true);
        }
        else
            System.out.println("Expected title is not matched:"+actualTitle+" "+false);
        return false;



    }
}