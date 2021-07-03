package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.DownloadPage;

public class DownloadTest extends TestBase {
	
	WebDriver driver=null;
     DownloadPage download =null;
	
     @BeforeClass
	   public void openBrowser()
	   {
		  driver=launchApplication();
		  	 	   
		   download=loadLoginPage().navigateToDashboard().navigateToDownloads();
		 //download=dp.navigateToDownloads();
	   }
	 
	 @Test (priority=1)
	   public void verifyDashboardTitle()
	   {
		   	   
		   Assert.assertEquals(driver.getTitle(), "JavaByKiran | Downloads");
		   
	   }
	 
	 @AfterClass
	   public void closeBrowser()
	   {
		  driver.close();
	   }
	

}
