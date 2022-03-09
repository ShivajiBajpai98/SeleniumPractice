package Link;

import com.atmecs.toolkit.PropertyManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GetLinkTask
{
    public void initializeDriver()
    {
        String chromeDriverPath= PropertyManager.getInstance().getChormeDriverPath();
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver",path+chromeDriverPath);

    }
    public WebDriver launchBrowse()
    {
        String browserType = PropertyManager.getInstance().getbrowserType();
        //System.out.println(browserType);
        if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriver webDriver = new ChromeDriver();
            // System.out.println(driver.hashCode());
            return webDriver;
        }
        return null;
    }
    public void launchApp(WebDriver webDriver)
    {
        String url = PropertyManager.getInstance().getLink_task_app_launch();
        System.out.println(url);
        // assert driver != null;
        // WebDriver  driver = new ChromeDriver();
        webDriver.get(url);
    }
    public void windowMaximize(WebDriver driver)
    {
        driver.manage().window().maximize();
    }
     public void loginApp(WebDriver webDriver)
     {
         String username_xpath =PropertyManager.getInstance().getLink_task_app_username_xpath();
         WebElement userName = webDriver.findElement(By.id(username_xpath));
         userName.clear();
         String username= PropertyManager.getInstance().getLink_task_app_username();
         userName.sendKeys(username);

         String password_xpath =PropertyManager.getInstance().getLink_task_app_password_xpath();
         WebElement passWord = webDriver.findElement(By.id(password_xpath));
         passWord.clear();
         String password = PropertyManager.getInstance().getLink_task_app_password();
         passWord.sendKeys("demo");

         String login_button =PropertyManager.getInstance().getLink_task_login_button();
         webDriver.findElement(By.xpath(login_button)).click();

     }

     public  void  homePageLinks(WebDriver webDriver)
     {

         String tag_name= PropertyManager.getInstance().getLink_task_url();


         List<WebElement> allURLs = webDriver.findElements(By.tagName(tag_name));
         System.out.println("Total links on the Web Page: " + allURLs.size());

         for (int i=0;i<allURLs.size();i++) {
             // by using the href we can get url of requried link
             WebElement element = allURLs.get(i);
             String urls = element.getAttribute("href");
             System.out.println("link is:"+urls);

         }

/////////////////////// LINK IN THE NAME  ONLY//////////////////////////////
        /* String url="";
         List<WebElement> allURLs = webDriver.findElements(By.tagName(tag_name));
         System.out.println("Total links on the Wb Page: " + allURLs.size());

         //We will iterate through the list and will check the elements in the list.
         for (WebElement allURL : allURLs) {
             url = allURL.getText();
             System.out.println(url);
         }
*/





         List<WebElement> selenium_element_list = webDriver.findElements(By.tagName(tag_name));

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
     }



     public void clickSales(WebDriver webDriver)
     {
         String sales_xpath=PropertyManager.getInstance().getLink_task_sales_xpath();
         webDriver.findElement(By.xpath(sales_xpath)).click();
     }






    public void clickOrders(WebDriver webDriver)
    {
        String orders_xpath=PropertyManager.getInstance().getLink_task_orders_xpath();
        webDriver.findElement(By.xpath(orders_xpath)).click();
    }




    public void LinkOnPerPage(WebDriver webDriver)
    {
        String tag_name= PropertyManager.getInstance().getLink_task_url();

        String total_pages_xpaths = PropertyManager.getInstance().getLink_task_total_pages_xpath();

        // total number of pages in a table
        String stringText = webDriver.findElement(By.xpath(total_pages_xpaths)).getText();
        System.out.println(stringText);

        int total_pages = Integer.valueOf(stringText.substring(stringText.indexOf("(") + 1, stringText.indexOf("Pages") - 1));
        System.out.println("Total number of pages:" + total_pages);

        // for (int p=1; p<=total_pages; p++) // takes a lot of time
        for (int p = 1; p <= 2; p++)
        {
            WebElement active_page = webDriver.findElement(By.xpath("//ul[@class='pagination']//li/span"));
            System.out.println("Active page" + active_page.getText());
            active_page.getText();


            String url = "";
            List<WebElement> allURLs = webDriver.findElements(By.tagName(tag_name));
            System.out.println("Total links on the Wb Page: " + allURLs.size());

            //We will iterate through the list and will check the elements in the list.
           /* for (WebElement allURL : allURLs) {
                url = allURL.getText();
                System.out.println(url);
            }*/

            for (int i = 0; i < allURLs.size(); i++) {
                // by using the href we can get url of requried link
                WebElement element = allURLs.get(i);
                String urls = element.getAttribute("href");
                System.out.println("link is:" + urls);

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
            for (int i = 0; i < elements_to_array.length; i++) {
                for (int j = i + 1; j < elements_to_array.length; j++) {
                    if (elements_to_array[i] == elements_to_array[j])
                        System.out.println(elements_to_array[j]);
                    else {
                        //System.out.println("No duplicate elements");
                    }
                }
            }
            String page_number = Integer.toString(p + 1);
            System.out.println(page_number);
            webDriver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + page_number + "']")).click();
        }
    }


    public static class Excel {
        public static void main(String[] args) throws IOException {
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

           /* List<WebElement> selenium_element_list = webDriver.findElements(By.tagName("a"));


            System.out.println(selenium_element_list.size());

            for (WebElement webElement : selenium_element_list) {
                String name = webElement.getText();
                System.out.println(name);
            }*/


           /* List<String> element_list = new ArrayList<String>();
            for (WebElement element : selenium_element_list) {
                element_list.add(element.getText());
               // System.out.println(element_list.add(element.getText()));
            }*/
            //System.out.println(strings);
          /*  String[] elements_to_array = element_list.toArray(new String[0]);
            System.out.println(Arrays.toString(elements_to_array));
    */
    //Get list of web-elements with tagName  - a
            List<WebElement> allLinks = webDriver.findElements(By.tagName("a"));
            ArrayList<Object[]> data=new ArrayList<Object[]>();
            //Traversing through the list and printing its text along with link address
            for(WebElement link:allLinks){
                System.out.println(link.getText() + " - " + link.getAttribute("href"));
                data.add(new String[]{link.getText() + " - " + link.getAttribute("href")});
            }




           /* String []linkText =new String[allLinks.size()];
            int i=0;*/

    //Storing List elements text into String array
           /* for(WebElement a: allLinks)
            {
                linkText[i]=a.getText();
                i++;
            }*/









            XSSFWorkbook workbook = new XSSFWorkbook();

            //Create a blank sheet
            XSSFSheet sheet = workbook.createSheet("Link");

            /*ArrayList<Object[]> data=new ArrayList<Object[]>();
            data.add(new String[]{"Country","Capital","Population"});
            data.add(new Object[]{"India","Delhi",10000});
            data.add(new Object[]{"France","Paris",40000});
            data.add(new Object[]{"Germany","Berlin",20000});
            data.add(new Object[]{"England","London",30000});*/

            //Iterate over data and write to sheet
            int rownum = 0;
            for (Object[] countries : data)
            {
                Row row = sheet.createRow(rownum++);

                int cellnum = 0;
                for (Object obj : countries)
                {
                    Cell cell = row.createCell(cellnum++);
                    if(obj instanceof String)
                        cell.setCellValue((String)obj);
                    else if(obj instanceof Double)
                        cell.setCellValue((Double)obj);
                    else if(obj instanceof Integer)
                        cell.setCellValue((Integer)obj);
                }
            }
            try
            {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(new File("Link.xlsx"));
                workbook.write(out);
                out.close();
                System.out.println("links.xlsx has been created successfully");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                workbook.close();
            }






        }
    }
}
