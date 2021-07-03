package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.OperatorPage;

public class OperatorTest extends TestBase {
	WebDriver driver=null;
	 OperatorPage op=null;
	
	 @BeforeClass
	   public void openBrowser()
	   {
		 driver=launchApplication();
		  	 	   
	     op=loadLoginPage().navigateToDashboard().navigateToOperatorslink();
		// op=dp.navigateToOperatorslink();
	   }
	 
	  @Test (priority=1)
	   public void verifyDashboardTitle()
	   {
		   	   
		   Assert.assertEquals(driver.getTitle(), "JavaByKiran | Operators");
		   
	   }
	  
	  @AfterClass
	   public void closeBrowser()
	   {
		  driver.close();
	   }
	

}
