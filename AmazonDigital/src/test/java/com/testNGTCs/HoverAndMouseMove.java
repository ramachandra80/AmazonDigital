package com.testNGTCs;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.UDF.BrowserInitialization;
import com.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class HoverAndMouseMove {	
  @Test	
  @Parameters("browser")
  public void OpenFireHD10(String browser) throws Exception {
	  WebDriver driver = BrowserInitialization.selectBrowser(browser);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.com/");
	  //Actions builder = new Actions(driver);
	  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	  String javaScript = "var evObj = document.createEvent('MouseEvents');" +
             "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
             "arguments[0].dispatchEvent(evObj);";
	  ((JavascriptExecutor)driver).executeScript(javaScript, homePage.departments);
	  ((JavascriptExecutor)driver).executeScript(javaScript, homePage.fireTablets);
	  //builder.moveToElement(homePage.fireTablets).build().perform(); //working for chrome
	  //builder.moveToElement(homePage.HD10).click().build().perform(); //working for chrome
	  
	  //Firefox and Chrome
	  /*int size = new WebDriverWait(driver, 30).ignoring(ElementNotFoundException.class)
	    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePage.HD10)).size();
	  System.out.println(size);
	  driver.findElements(homePage.HD10).get(size-2).click();*/
	  
	  //Working for all browsers
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click()", homePage.HD10);
	  
  }
  
}
