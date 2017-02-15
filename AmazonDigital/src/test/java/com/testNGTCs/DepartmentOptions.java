package com.testNGTCs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.UDF.BrowserInitialization;
import com.pages.HomePage;
import junit.framework.Assert;

public class DepartmentOptions {
  @Test
  @Parameters("browser")
  public void departmentOptionsMethod(String browser) throws Exception {
	  WebDriver driver = BrowserInitialization.selectBrowser(browser);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.com/");
	 // Actions builder = new Actions(driver);
	  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	  String javaScript = "var evObj = document.createEvent('MouseEvents');" +
             "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
             "arguments[0].dispatchEvent(evObj);";
	   ((JavascriptExecutor)driver).executeScript(javaScript, homePage.departments);
	  //((JavascriptExecutor)driver).executeScript(javaScript, driver.findElement(By.id("nav-link-accountList")));
	  
	  /*List<WebElement> allOptions = driver.findElements
			                               (By.className("nav-text"));
	  
	  for(WebElement we:allOptions){
		  String str = we.getAttribute("innerHTML");
		  if(str.equalsIgnoreCase("Your Amazon Credit Card Accounts")){
			  we.click();
		  }
		  System.out.println(str);
	  }*/
	  
	  List<WebElement> departmentOptions = driver.findElements
			  (By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/span"));
	  WebElement fullStoreDirectoryLink = driver.findElement(By.linkText("Full Store Directory"));
	  departmentOptions.add(fullStoreDirectoryLink);
	  
	  System.out.println(departmentOptions.size());
	  for(WebElement we:departmentOptions){
		  String str = we.getText();
		  if (str.equalsIgnoreCase("Full Store Directory"))
			  we.click();
		  System.out.println(str);
	  }
	    
	  //String expectedURL = driver.getCurrentUrl();
	  //String actualURL = "https://www.amazon.com/gp/site-directory/ref=nav_shopall_fullstore";
	  //Assert.assertEquals("Passed!", expectedURL, actualURL);
  }
}
