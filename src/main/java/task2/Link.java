package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Link {
    public void allLinks(WebDriver webDriver)
    {
        String url = "";
        List<WebElement> allURLs = webDriver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());

        for (int i=0;i<allURLs.size();i++) {
            // by using the href we can get url of requried link
            WebElement element = allURLs.get(i);
            String urls = element.getAttribute("href");
            System.out.println("link is:"+urls);

        }
    }
}
