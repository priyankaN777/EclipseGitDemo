package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.UsefulLinksPage;

public class UsefulLinksTest extends TestBase {
	WebDriver driver=null;
	 UsefulLinksPage ufp =null;
	
	 @BeforeClass
	   public void openBrowser()
	   {
		  driver=launchApplication();
		  	 	   
		  ufp=loadLoginPage().navigateToDashboard().navigateToUsefulLinks();
		 
		 //ufp=dp.navigateToUsefulLinks();
	   }
	 
	  @Test (priority=1)
	   public void verifyDashboardTitle()
	   {
		   	   
		   Assert.assertEquals(driver.getTitle(), "JavaByKiran | Useful Links");
		   
	   }
	  
	  @AfterClass
	   public void closeBrowser()
	   {
		  driver.close();
	   }
	

}
