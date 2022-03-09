package com.atmecs.toolkit;


import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

        private static PropertyManager instance;
        private static final Object lock = new Object();
        //private static String propertyFilePath=System.getProperty("user.dir") + "\\configuration.properties";
        private static String app_url;
       // private static String auth_uname_pwd_autoit_path;
        private static String chrome_driver_path;
    private static String firefox_driver_path;
        private static String browser_type;
       // private static String ie_driver_path;
       // private static String auth_uname_pwd_autoit_path_ie;


        private static String today_Deal_Xpath;
        private static String elements_under_department;
        private static String driver;

        /////////////////////////LINK_TASK/////////////////////////////////////
    private  static String link_task_app_launch;
        private  static String link_task_url;
    private  static String link_task_app_username_xpath;
    private  static String link_task_app_password_xpath;
        private static String link_task_app_username;
        private static String link_task_app_password;
        private static String link_task_login_button;
    private static String link_task_sales_xpath;
    private static String link_task_orders_xpath;
    private static String link_task_total_pages_xpath;









        //Create a Singleton instance. We need only one instance of Property Manager.
        public static PropertyManager getInstance () {
            if (instance == null) {
                synchronized (lock) {
                    instance = new PropertyManager();
                    instance.loadData();
                }
            }
            return instance;
        }

        //Get all configuration data and assign to related fields.
        private void loadData() {
            //Declare a properties object
            Properties prop = new Properties();

            //Read configuration.properties file
            try {
                //prop.load(new FileInputStream(propertyFilePath));
                prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
            } catch (IOException e) {
                System.out.println("Configuration properties file cannot be found");
            }

            //Get properties from configuration.properties
            app_url = prop.getProperty("app_url");
          // auth_uname_pwd_autoit_path=prop.getProperty("auth_uname_pwd_autoit_path");
            chrome_driver_path=prop.getProperty("chrome_driver_path");
            firefox_driver_path=prop.getProperty("firefox_driver_path");
            browser_type=prop.getProperty("browser_type");
           // ie_driver_path=prop.getProperty("ie_driver_path");
            //auth_uname_pwd_autoit_path_ie=prop.getProperty("auth_uname_pwd_autoit_path_ie");
           today_Deal_Xpath=prop.getProperty("today_Deal_Xpath");
            elements_under_department=prop.getProperty("elements_under_department");
            driver =prop.getProperty("new ChromeDriver()");




            ///////////////////////////////LINK TASK////////////////////////////
            link_task_url=prop.getProperty("link_task_url");
            link_task_app_launch=prop.getProperty("link_task_app_launch");
            link_task_app_username=prop.getProperty("link_task_app_username");
            link_task_app_password=prop.getProperty("link_task_app_password");
            link_task_login_button=prop.getProperty("link_task_login_button");
            link_task_app_username_xpath=prop.getProperty("link_task_app_username_xpath");
            link_task_app_password_xpath=prop.getProperty("link_task_app_password_xpath");
            link_task_sales_xpath=prop.getProperty("link_task_sales_xpath");
             link_task_orders_xpath=prop.getProperty("link_task_orders_xpath");
            link_task_total_pages_xpath=prop.getProperty("link_task_total_pages_xpath");







        }

        public String getAppMangtURL () {
            return app_url;
        }
       /* public String getAuthUnamePwdAutoIT () {
            return auth_uname_pwd_autoit_path;
        }*/
        public String getChormeDriverPath () {
            return chrome_driver_path;
        }
        public String getFirefox_driver_path(){return firefox_driver_path;}
         public String getbrowserType () {
        return browser_type;
    }
        /*public String getIEDriverPath () {
            return ie_driver_path;
        }*/
       /* public String getAuthUnamePwdAutoITIE () {
            return auth_uname_pwd_autoit_path_ie;
        }*/
        public String getToday_Deal_Xpath(){return today_Deal_Xpath;}
        public String getElements_under_department(){return elements_under_department;}
         public String getDriver(){return driver;}



////////////////////////////////LInk Task//////////////////////////////////
    public String getLink_task_url(){return link_task_url;}
    public  String getLink_task_app_launch(){ return link_task_app_launch;}
    public String getLink_task_app_username_xpath(){
        return link_task_app_username_xpath;
    }
    public String getLink_task_app_username(){return link_task_app_username;}
    public String getLink_task_app_password_xpath(){return link_task_app_password_xpath;}
    public String getLink_task_app_password() {return link_task_app_password;}
    public String getLink_task_login_button(){return link_task_login_button;}
    public String getLink_task_sales_xpath(){return link_task_sales_xpath;}
    public String getLink_task_orders_xpath(){return link_task_orders_xpath;}
    public String getLink_task_total_pages_xpath(){return link_task_total_pages_xpath;}


    }

