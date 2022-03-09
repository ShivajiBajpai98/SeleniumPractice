package Link;

import Link.GetLinkTask;
import org.openqa.selenium.WebDriver;

public class GetLinkTaskRunner
{
    public static void main(String[] args)
    {
        WebDriver  webDriver=null;




        GetLinkTask getLinkTask = new GetLinkTask();
        getLinkTask.initializeDriver();
        webDriver= getLinkTask.launchBrowse();
        getLinkTask.launchApp(webDriver);
        getLinkTask.windowMaximize(webDriver);
        getLinkTask.loginApp(webDriver);
        getLinkTask.homePageLinks(webDriver);
        getLinkTask.clickSales(webDriver);
        getLinkTask.clickOrders(webDriver);
        getLinkTask.LinkOnPerPage(webDriver);

    }
}
