package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.objectrepository.DashboardObjectRepository;

public class DashboardPage extends DashboardObjectRepository{
	
	WebDriver driver=null;
	
	/*@FindBy(xpath="//span[text()='Users']")
	private WebElement userlink;*/
	
		
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

 
	public void clickuser()
	{
		userlink.click();
	}
	
	public void clickoperatorslink()
	{
		operatorslink.click();
	}
	
	public void clickusefullinks()
	{
		usefullinks.click();
	}
	
	public void clickdownloadlinks()
	{
		downloadlinks.click();
	}
	
	public UserPage navigateToUserPage()
	{
		clickuser();
		return new UserPage(driver);
	}
	
	public OperatorPage navigateToOperatorslink()
	{
		clickoperatorslink();
		return new OperatorPage(driver);
	}
	
	public UsefulLinksPage navigateToUsefulLinks()
	{
		clickusefullinks();
		return new UsefulLinksPage(driver);
	}
	
	public DownloadPage navigateToDownloads()
	{
		clickdownloadlinks();
		return new DownloadPage(driver);
	}




}
