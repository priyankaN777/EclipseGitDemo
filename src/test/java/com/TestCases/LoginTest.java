package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utilities.TakeScreenShotUtility;

public class LoginTest extends TestBase
{
  WebDriver driver= null;
  LoginPage lp= null;
  

	 
   @BeforeClass
   public void openBrowser()
   {
	  	setup();   
	   driver=launchApplication();
	   lp=loadLoginPage();
	   testLogs().info("in openbrowser of logintest");
	   
   }
   
   @Test (priority=1)
   public void verifyDLoginTitle()
   {
	  logger= extent.createTest("verifyDLoginTitle");
	  logger.createNode("JavaByKiran | Log in");
	 
	  	  Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	  	     
   }
   
   @Test (priority=2)
   public void verifyLogo()
   {
	  logger= extent.createTest("verify Logo on jbk page");
	   
	  boolean img = lp.verifyLogo();
	  logger.createNode("Image is Present");
	  Assert.assertTrue(img);
	  logger.createNode("Image is not Present");
	  Assert.assertFalse(img);
	   	  
	     
   }
   
   @Test (priority=3)
   public void validLogin()
   {
	 logger= extent.createTest("validLogin");
	
	  lp.navigateToDashboard();
	   
   }
   
   @AfterMethod
   public void getResult(ITestResult result) throws Exception{
   if(result.getStatus() == ITestResult.FAILURE){
   //MarkupHelper is used to display the output in different colors
   logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
   logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
   //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
   //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
   //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
   String screenshotPath = TakeScreenShotUtility.getScreenShot(driver, result.getName());
   //To add it in the extent report 
   logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
   }
   else if(result.getStatus() == ITestResult.SKIP){
   logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
   } 
   else if(result.getStatus() == ITestResult.SUCCESS)
   {
   logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
   }
   //driver.quit();
   }
   
   @AfterClass
   public void closeBrowser()
   {
	  closeBrowser1();	
	  driver.close();
	 
   }
   


    
   
   
   
   
}
