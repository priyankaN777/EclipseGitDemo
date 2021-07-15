package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjectRepository {
	
		
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(xpath="//button")
	public WebElement loginbutton;
	

	@FindBy(xpath="//img[@src = '../images/jbk.png']")
	public WebElement image;
	
	




}
