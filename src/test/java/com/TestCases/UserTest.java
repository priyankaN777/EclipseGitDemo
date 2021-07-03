package com.TestCases;




import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.UserPage;

public class UserTest extends TestBase {
	WebDriver driver=null;
	 UserPage up=null;
	  
	  
	  @BeforeClass
	   public void openBrowser()
	   {
	     driver=launchApplication();
		  	 	   
		  up=loadLoginPage().navigateToDashboard().navigateToUserPage();
		  
		 // up=dp.navigateToUserPage();
	   }
 	
	@Test (priority=1)
	   public void verifyUserTitle()
	   {
		   	   
		   Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	   }
	   
	  @Test (priority=2)
	   public void CompareTableWithoutHashmap()
	   {
		   
		 boolean flag =	up.compare();
		 Assert.assertTrue(flag);
		   }
	   
	   @Test (priority=3)
	   public void CompareTableWithHashmap()
	   {
		      HashMap actual=up.verifyTableWithHashmap();
			  HashMap expected=up.verifyTableWithHashmapExcel();
			  Assert.assertEquals(actual, expected);
		   }
	   
	   @Test (priority=4)
	   public void compareGenderAndName()
	   {
		   TestBase.log.info("Executing test4 for comparing hasgmap");
		  
		  HashMap actual=up.compareGender();	
		  HashMap expected=up.converExcelToHashMAp();
			 
		 Assert.assertEquals(actual, expected);
		
	   }
	   
	 /*  @Test (priority=5)
		public void mobileTest() {
			SoftAssert sa = new SoftAssert();
			List<Boolean> mobile = up.mobileLength();
			for(boolean b :mobile) {
				sa.assertFalse(b);
			}
			sa.assertAll();
		}
*/
	   
	   
	   @AfterClass
	   public void closeBrowser()
	   {
		  driver.close();
	   }
	
	
	
}
		






	


