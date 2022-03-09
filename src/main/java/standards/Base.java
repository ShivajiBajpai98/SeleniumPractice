package standards;

import com.atmecs.toolkit.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    // declaration and instantiation of objects/variables
    public static WebDriver webDriver;

    // Launch Browser
    public static WebDriver launchBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = PropertyManager.getInstance().getChormeDriverPath();
            String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
             webDriver = new ChromeDriver();
            return webDriver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            String firefoxDriverPath = PropertyManager.getInstance().getFirefox_driver_path();
            String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.gecko.driver", path + firefoxDriverPath);
             webDriver = new FirefoxDriver();
            return webDriver;
        }
            return webDriver;
    }


    // Launch website
        public static void navigateUrl(String url)
        {
            webDriver.get(url);
        }
    public static void windowMaximize()
    {
        webDriver.manage().window().maximize();
    }
    }

