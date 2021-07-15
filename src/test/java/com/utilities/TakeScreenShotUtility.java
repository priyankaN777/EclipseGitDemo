package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.TestCases.TestBase;

public class TakeScreenShotUtility {

	
		
		public static String getScreenShot(WebDriver driver, String name)
		{
			SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyyhhmmss");
			String date=sdf.format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			                    File src=  ts.getScreenshotAs(OutputType.FILE);
			                    String destpath = System.getProperty("user.dir")+"/ScreenshotOFTC/image"+name+date+".jpg";
			                    File dest = new File(System.getProperty("user.dir")+"/ScreenshotOFTC/image"+name+date+".jpg");
			                    
			                    try {
									FileUtils.copyFile(src, dest);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			                    
			                    return destpath;
	    }

}
