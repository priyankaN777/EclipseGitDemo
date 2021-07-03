package com.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.Pages.DashboardPage;
import com.Pages.DownloadPage;
import com.Pages.LoginPage;
import com.Pages.OperatorPage;
import com.Pages.UsefulLinksPage;
import com.Pages.UserPage;




public class TestBase 
{
	
  public static Logger log =Logger.getLogger(TestBase.class);
  public static WebDriver driver = null;
  FileInputStream fis;
  Properties prop;
 /*  LoginPage lp= null;
   DashboardPage dp= null;
   OperatorPage op=null;
  DownloadPage download =null;
  UsefulLinksPage ufp =null;
  UserPage up=null;*/
  
 
  
  
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
		  log.info("Intitializing chrome driver");
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
  
  @AfterSuite
  public void closeBrowser()
  {
	  driver.close();
  }

}
