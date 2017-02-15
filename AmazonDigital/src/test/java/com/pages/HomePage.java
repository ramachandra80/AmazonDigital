package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id="twotabsearchtextbox") public WebElement search; 
	@FindBy(id="nav-search-submit-text") public WebElement searchIcon;
	@FindBy(id="nav-link-shopall") public WebElement departments;
	@FindBy(xpath="//div/div/div[4]/div[4]/div[2]/span[6]") public WebElement fireTablets;
	@FindBy(xpath="//div/div/div[4]/div[4]/div[3]/div[6]/div/div/a[3]/span") public WebElement HD10;
	//public By HD10 = By.xpath("//div/div/div[4]/div[4]/div[3]/div[6]/div/div/a[4]/span");
	
	public void searchClick()
	{
		this.search.click();
	}
}
