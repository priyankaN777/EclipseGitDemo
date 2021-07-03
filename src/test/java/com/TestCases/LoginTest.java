package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Pages.LoginPage;




public class LoginTest extends TestBase
{
  WebDriver driver= null;
  LoginPage lp= null;

   
   @BeforeClass
   public void openBrowser()
   {
	 driver=launchApplication();
	   lp=loadLoginPage();
	   log.info("in openbrowser of logintest");
	   
   }
   
   @Test (priority=1)
   public void verifyDLoginTitle()
   {
	   
	   Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	   
   }
   
   @Test (priority=2)
   public void validLogin()
   {
	   
	  lp.navigateToDashboard();
	   
   }
   
   @AfterClass
   public void closeBrowser()
   {
	  driver.close();
   }

    
   
   
   
   
}
