package com.ttn.WebAutomation.utillib;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriverUtil {

    private String browser;
    private PropertyReader prop;
    private Properties properties;
    private File directory = new File(".");
    private String fileDownloadPath;




    synchronized public WebDriver startSeleniumDriver(ThreadLocal<WebDriver> driver) {

        try {
            prop = new PropertyReader();
            properties = prop.setup_properties();
            browser = properties.getProperty(GlobalVariables.BROWSER);

            driver.set(initDriver(browser));
            driver.get().manage().window().maximize();


        } catch (IOException e) {
        }
        return  driver.get();

    }


    public void stopSeleniumDriver(ThreadLocal<WebDriver> driver){
        try{
        driver.get().quit();
        } catch (Exception e) {
        }
    }


    public WebDriver initDriver(String browser) {
        String os = properties.getProperty(GlobalVariables.OS);
        System.out.println(">>>>> Initializing the webdriver: " + browser + " on OS: " + os);

        String driversPath = "/lib/";
        try {
            driversPath = directory.getCanonicalPath() + File.separator + "lib" + File.separator +
                    "webdrivers" + File.separator;
        } catch (IOException e) {
        }

        switch (browser.toUpperCase()) {


            case "CHROME":
                WebDriverManager.chromedriver().create();
                return new ChromeDriver(setChromeCaps("chrome"));


            default:
            	WebDriverManager.chromedriver().create();
                return new ChromeDriver(setChromeCaps("chrome"));
        }
    }


    private ChromeOptions setChromeCaps(String browserType) {

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", fileDownloadPath);
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeOptionsMap = new HashMap<>();
        
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions"); //to disable browser extension popup
        options.addArguments("--headless");
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.setExperimentalOption("useAutomationExtension", false);
        

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);
        return options;

    }



}