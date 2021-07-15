package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.objectrepository.LoginObjectRepository;

public class LoginPage extends LoginObjectRepository {
	
	WebDriver driver=null;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enteruname(String text)
	{
		email.sendKeys(text);
	}
	
	public void enterpass(String text)
	{
		pass.sendKeys(text);
	}
	
	public void clickLoginBtn()
	{
		loginbutton.click();
	}
	
	public boolean verifyLogo()
	{
		boolean img = image.isDisplayed();
		System.out.println(img);
		return img;
	}
	
	  
	
	public DashboardPage navigateToDashboard()
	{
		enteruname("kiran@gmail.com");
		enterpass("123456");
		clickLoginBtn();
		
		return new DashboardPage(driver);
	}




}
