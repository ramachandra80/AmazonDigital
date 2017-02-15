package com.UDF;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserInitialization {
	
	private static WebDriver driver;
	private static String node;

	public static WebDriver selectBrowser(String browser) throws Exception{
		if(browser.equalsIgnoreCase("Firefox"))
		{
			node = "http://192.168.2.8:5557/wd/hub";
			//System.setProperty("webdriver.gecko.driver", "/Users/Vani_darling/Desktop/softwares/geckodriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			//cap.setCapability("marionette", true);
			//cap.setCapability(FirefoxDriver.BINARY, "\\\\192.168.2.8\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			//cap.setCapability("binary", value);
			driver = new RemoteWebDriver(new URL(node), cap);
			return driver;
		}
		else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandrakanth\\Desktop\\Edu\\Softwares\\Selenium\\Drivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
			// https://www.microsoft.com/en-us/download/details.aspx?id=49962 --> there are multiple version of webdrivers for Edge
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Chandrakanth\\Desktop\\Edu\\Softwares\\Selenium\\Drivers\\Edge Latest\\MicrosoftWebDriver.exe");
			return new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome-incognito"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandrakanth\\Desktop\\Edu\\Softwares\\Selenium\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			return new ChromeDriver(capabilities);
		}
		else
		{
			System.out.println("Please specify the correct browser before test run");
			return null;
		}
	}
	

}
