package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;

public class DashboardTest extends TestBase{
	
	WebDriver driver=null;
	DashboardPage dp= null;
	
	 @BeforeClass
	   public void openBrowser()
	   {
		   driver=launchApplication();
		  	 	   
		   dp=loadLoginPage().navigateToDashboard();
		 
		 //dp=lp.navigateToDashboard();
	   }
	 
	  @Test (priority=1)
	   public void verifyDashboardTitle()
	   {
		   	   
		   Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		   
	   }
	  
	  @AfterClass
	   public void closeBrowser()
	   {
		  driver.close();
	   }
	




}
