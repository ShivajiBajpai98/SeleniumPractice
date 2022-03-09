package task2;

import org.openqa.selenium.WebDriver;

public class LinkRunner
{
    public static void main(String[] args) {

Link link = new Link();
        WebDriver webDriver = Base.launchBrowser("chrome");
        Base.navigateUrl("https://demoqa.com/");
        Base.windowMaximize();
        link.allLinks(webDriver);

    }
}
