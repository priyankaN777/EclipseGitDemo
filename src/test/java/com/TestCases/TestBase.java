package com.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Pages.LoginPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestBase 
{
	
  public static Logger log =null;
  public static WebDriver driver = null;
  FileInputStream fis;
  Properties prop;
  public ExtentReports extent;
  public ExtentTest logger;
	 public ExtentHtmlReporter htmlReporter;
	 
	
  
 /*  LoginPage lp= null;
   DashboardPage dp= null;
   OperatorPage op=null;
  DownloadPage download =null;
  UsefulLinksPage ufp =null;
  UserPage up=null;*/
	 
	 
  
	// @BeforeSuite
	  public void setup()
	  {
		  
		 
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
	  	 //Create an object of Extent Reports
	      extent = new ExtentReports(); 
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "DESKTOP-IGE51IO");
			  	extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "Priyanka Nikam");
			htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
			          // Name of the report
			htmlReporter.config().setReportName("Name of the Report Comes here "); 
			          // Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD); 
			 System.out.println("Beforesuite method");
			
	  }
  
  
  public String readAnyProperty(String Key )
  {
	  String val=null;
	  
	  	  try {
			fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources"+"/config.properties");
			prop=new Properties();
			prop.load(fis);
			
			val=prop.getProperty(Key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  return val;
  }
  
  public WebDriver launchApplication()
  {
	  
	  String URL = readAnyProperty("url");
	  String browser = readAnyProperty("browser");
	  
	  if (browser.equals("Chrome"))
	  {
		  testLogs().info("Intitializing chrome driver");
	  System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwares\\chromedriver.exe");
	  driver=new ChromeDriver();
	  }
	  
	  if (browser.equals("Firefox"))
	  {
	  System.setProperty("webdriver.gecko.driver","D:\\SeleniumSoftwares\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  }
	  
	 driver.get(URL);
	return driver;
	  
  }
  
 
  public LoginPage loadLoginPage()
	{
	  
		return new LoginPage(driver);
	}
  
  
  public Logger testLogs() {
		log=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir")+"/src/main/java/log4jTest.properties");
		PropertyConfigurator.configure(path);
		return log;
	}
  
  
  
  //@AfterSuite
  public void closeBrowser1()
  {
	  
		
		   System.out.println("Beforesuite method");
	        driver.close();
	        extent.flush();
	       // extent.
	 
  }

}
