package com.testNGTCs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.UDF.BrowserInitialization;
import com.pages.HomePage;


public class AddAProductToCart  {
  
	  @Test	
	  @Parameters("browser")
	  public void addAProductToCart(String browser) throws Exception {
		  WebDriver driver = BrowserInitialization.selectBrowser(browser);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.com/");
		  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		  homePage.search.sendKeys("Portable Jump Starter");
		  homePage.search.submit();
		  homePage.departments.click();
		  driver.close();
		  
	  }
}
