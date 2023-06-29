package com.ttn.WebAutomation.base;

/**
 * This Java program demonstrates the Browser initiated code .
 *
 * @author TTN
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Reporter;
import java.net.MalformedURLException;
import com.ttn.WebAutomation.listeners.MyProjectListener;

import io.github.bonigarcia.wdm.WebDriverManager;

//import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BrowserFactory {

	public static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	private static MyProjectListener listeners;
	private WebDriver driver;
	private RemoteWebDriver rDriver;
	private String exePath= System.getProperty("user.dir") + "/resources/exefiles";

	/*
	 * Normal method for getting browsers
	 */
	public WebDriver getBrowser(String browserName,String Port) throws MalformedURLException {
		driver = null;
		String l_browserName = browserName.toLowerCase();
		switch (l_browserName) {
		case "firefox":
			configFirefoxDriver();
			break;
		case "edge":
			configEdgeDriver();
			break;
		case "chrome":
			configChromeDriver();
			break;
		case "safari":
			configSafariDriver();
			break;
		default:
			configChromeDriver();
		}
		return driver;
	}


	public WebDriver getSingletonBrowser(String browserName,String gridBrowser) throws MalformedURLException {
		driver = null;
		String l_browserName = browserName.toLowerCase();
		switch (l_browserName) {
		case "firefox":
			driver = drivers.get("firefox");
			if (driver != null) {
				FirefoxDriver f = (FirefoxDriver) driver;
				if (f.getSessionId() == null) {
					configFirefoxDriver();
					drivers.put("firefox", driver);
				}
			} else {
				configFirefoxDriver();
				drivers.put("firefox", driver);
			}
			break;
		case "edge":
			driver = drivers.get("edge");
			if (driver != null) {
				EdgeDriver edge = (EdgeDriver)driver;
				if (edge.getSessionId() == null) {
					configEdgeDriver();
					drivers.put("edge", driver);
				}
			} else {
				configEdgeDriver();
				drivers.put("edge", driver);
			}
			break;
		case "chrome":
			driver = drivers.get("chrome");
			if (driver != null) {
				ChromeDriver cd =  (ChromeDriver)driver;
				if (cd.getSessionId() == null) {
					configChromeDriver();
					drivers.put("chrome", driver);
				}
			} else {
				configChromeDriver();
				drivers.put("chrome", driver);
			}
			break;
		case "safari":
			driver = drivers.get("safari");
			if (driver != null) {
				SafariDriver sd = new SafariDriver();
				if (sd.getSessionId() == null) {
					configSafariDriver();
					drivers.put("safari", driver);
				}
			} else {
				configSafariDriver();
				drivers.put("safari", driver);
			}
			break;
		case "grid":
			if(gridBrowser.equalsIgnoreCase("chrome") ) {
				driver = drivers.get("chrome");
				if (driver != null) {
					RemoteWebDriver cd = (RemoteWebDriver) driver;
					//rDriver = new ChromeDriver();
					if (cd.getSessionId() == null) {
						configChromeDriver("chrome");
						drivers.put("chrome", driver);
					}
				} else {
					configChromeDriver("chrome");
					drivers.put("chrome", driver);
				}
			}
			else if(gridBrowser.equalsIgnoreCase("firefox") )
				{
					driver = drivers.get("firefox");
					if (driver != null) {
						RemoteWebDriver cd = (RemoteWebDriver) driver;
						// rDriver = new FirefoxDriver();
						if (cd.getSessionId() == null) {
							configFirefoxDriver("firefox");
							drivers.put("firefox", driver);
						}
					} else {
						configFirefoxDriver("firefox");
						drivers.put("firefox", driver);
					}
				}
			else if(gridBrowser.equalsIgnoreCase("safari") )
				{
					driver = drivers.get("safari");
					if (driver != null) {
						RemoteWebDriver cd = (RemoteWebDriver) driver;
					    //rDriver = new SafariDriver();
						if (cd.getSessionId() == null) {
							configSafariDriver("safari");
							drivers.put("safri", driver);
						}
					} else {
						configSafariDriver("safari");
						drivers.put("safari", driver);
					}
				}
			break;
		default:
			driver = drivers.get("chrome");
			if (driver != null) {
				ChromeDriver cd1 = new ChromeDriver();
				if (driver == null || cd1.getSessionId() != null) {
					configChromeDriver();
					drivers.put("chrome", driver);
				}
			} else {
				configChromeDriver();
				drivers.put("chrome", driver);
			}
		}
		return driver;
	}

	/*
	 * Chrome Browser Configuration Method
	 */

	private void configChromeDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("window-size=1200x600");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        options.addArguments("--disable-dev-shm-usage");
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("profile.managed_default_content_settings.geolocation", locationParam);
//        options.setExperimentalOption("prefs", prefs);
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        
        
        Reporter.log("Chrome Launched in " + BaseLib.OS, true);
    }


	public void configFirefoxDriver(String browser) throws MalformedURLException {
		System.out.println("Inside configFirefox");
		String nodeURL = BaseLib.properties.getProperty("hub_URL");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        
        // for headless
     		//        browserOptions.addArguments("--headless");
     		//        browserOptions.addArguments("--incognito");
        
		

		System.out.println("Firefox Browser Initiated");

		driver = WebDriverManager.firefoxdriver()
                .capabilities(firefoxOptions)
                .remoteAddress(nodeURL)
                .create();

		Reporter.log("Firefox Launched in " + BaseLib.OS, true);

	}
	

	public void configSafariDriver(String browser) throws MalformedURLException {
		System.out.println("Inside configSafari");
		String nodeURL = BaseLib.properties.getProperty("hub_URL");
        SafariOptions safariOptions = new SafariOptions();
        
        // for headless
     		//        browserOptions.addArguments("--headless");
     		//        browserOptions.addArguments("--incognito");
        

        System.out.println("Safari Browser Initiated");

		driver = WebDriverManager.safaridriver()
                .capabilities(safariOptions)
                .remoteAddress(nodeURL)
                .create();

		Reporter.log("Safari Launched in " + BaseLib.OS, true);

	}
	public void configChromeDriver(String browser) throws MalformedURLException {
		System.out.println("Inside Configchrome");
		
		String nodeURL = BaseLib.properties.getProperty("hub_URL");
		ChromeOptions chromeOptions = new ChromeOptions();

		// for headless
		//        chromeOptions.addArguments("--headless");
		//        chromeOptions.addArguments("--incognito");

	

			System.out.println("Chrome Browser Initiated");

		
		driver = WebDriverManager.chromedriver()
                .capabilities(chromeOptions)
                .remoteAddress(nodeURL)
                .create();
		
		Reporter.log("Chrome Launched in " + BaseLib.OS, true);

	}
	/*
	 * Firefox Browser Configuration Method
	 */
	private void configFirefoxDriver() {
		driver = WebDriverManager.firefoxdriver().create();
		Reporter.log("Firefox Launched in " + BaseLib.OS, true);
	}

	/*
	 * Internet Explorer Browser Configuration Method
	 */
	private void configEdgeDriver() {
		driver = WebDriverManager.edgedriver().create();
		Reporter.log("Edge Launched in " + BaseLib.OS, true);
	}

	/*
	 * Safari Browser Configuration Method
	 */
	private void configSafariDriver() {
		try {
			driver = WebDriverManager.safaridriver().create();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		Reporter.log("Safari Launched in " + BaseLib.OS, true);
	}
	/**
	 * Override theDevice mode of launching the app

	 */
	public void OverrideDeviceMode(){
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setDeviceMetricsOverride(375,
				812,
				50,
				true,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty()));
	}
	/**
	 * launch the app as per the location given
	 * @param latitude,longitude,accuracy
	 */
	public void geolocation(double latitude, double longitude, double accuracy){
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude),
				Optional.of(longitude),
				Optional.of(accuracy)));

	}


	/*
	 * Method to close All browsers
	 */
	public void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
