package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LinkCountTask {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();


        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://demo.opencart.com/admin/index.php");
        webDriver.manage().window().maximize();

        WebElement userName = webDriver.findElement(By.id("input-username"));
        userName.clear();
        userName.sendKeys("demo");

        WebElement passWord = webDriver.findElement(By.id("input-password"));
        passWord.clear();
        passWord.sendKeys("demo");


        webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]")).click();

        webDriver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")).click();
        webDriver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/ul[@id='collapse26']/li[1]/a[1]")).click();

        // total number of pages in a table
        String stringText = webDriver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 20 of 11080 (554 Pages)')]")).getText();
        System.out.println(stringText);

        int total_pages = Integer.valueOf(stringText.substring(stringText.indexOf("(") + 1, stringText.indexOf("Pages") - 1));
        System.out.println("Total number of pages:" + total_pages);

        // for (int p=1; p<=total_pages; p++) // takes a lot of time
        for (int p = 1; p <= 2; p++) {
            WebElement active_page = webDriver.findElement(By.xpath("//ul[@class='pagination']//li/span"));
            System.out.println("Active page" + active_page.getText());
            active_page.getText();


            String url = "";
            List<WebElement> allURLs = webDriver.findElements(By.tagName("a"));
            System.out.println("Total links on the Wb Page: " + allURLs.size());

            //We will iterate through the list and will check the elements in the list.
           /* for (WebElement allURL : allURLs) {
                url = allURL.getText();
                System.out.println(url);
            }*/

            for (int i=0;i<allURLs.size();i++) {
                // by using the href we can get url of requried link
                WebElement element = allURLs.get(i);
                String urls = element.getAttribute("href");
                System.out.println("link is:"+urls);

            }



            List<WebElement> selenium_element_list = webDriver.findElements(By.tagName("a"));
            List<String> element_list = new ArrayList<String>();
            for (WebElement element : selenium_element_list) {
                element_list.add(element.getText());
            }
            //System.out.println(strings);
            String[] elements_to_array = element_list.toArray(new String[0]);

            System.out.println("Duplicate elements in given array: ");
            //Searches for duplicate element
            for(int i = 0; i < elements_to_array.length; i++) {
                for(int j = i + 1; j < elements_to_array.length; j++) {
                    if(elements_to_array[i] == elements_to_array[j])
                        System.out.println(elements_to_array[j]);
                    else
                    {
                        //System.out.println("No duplicate elements");
                    }
                }
            }




           /* List<WebElement> links =webDriver.findElements(By.tagName("a"));
            System.out.println("Number of links"+":"+links.size());
            for (int i=0;i<links.size();i++)
            {
                // by using the href we can get url of requried link
                WebElement element = links.get(i);
                String url= element.getAttribute("href");

                try {
                    URL link = new URL(url);
                    // create a connection by using url object "link"
                    HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
                    Thread.sleep(2000);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();// return response code if the code is above 4000 then broken
                    if (responseCode>=400)
                    {
                        System.out.println(url+"_ "+"broken links");
                    }
                    else
                    {
                        System.out.println(url+"_ "+" this is not broken links");
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
*/














           /* int rows = webDriver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
            System.out.println("Number of rows"+ rows);

            //read all  rows from page
            for(int r=1;r<=rows;r++)
            {
                // take onlly starting three elements becuse it takes lot of time at time of execution
                String orderId = webDriver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
                String customer = webDriver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
                String status = webDriver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();
                System.out.println(orderId+" "+customer+" "+status);
            }*/

            String page_number = Integer.toString(p + 1);
            System.out.println(page_number);
            webDriver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + page_number + "']")).click();


        }
    }

}