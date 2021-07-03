package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjectRepository {
	
	
	
	@FindBy(xpath="//span[text()='Users']")
	public WebElement userlink;
	
	@FindBy(xpath="//span[text()='Operators']")
	public WebElement operatorslink;
	
	@FindBy(xpath="//span[text()='     Useful Links']")
	public WebElement usefullinks;
	
	
	@FindBy(xpath="//span[text()='Downloads']")
	public WebElement downloadlinks;
		
	



}
