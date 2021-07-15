package com.objectrepository;

import java.util.List;

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
		
	 @FindBy(xpath ="//div//parent::div[contains(@class,'small-box')]")
	 public List<WebElement> coursecolor;
	 
	 @FindBy(xpath ="//div[@class='icon']/i")
	 public List<WebElement> coursesymbol;
	



}
