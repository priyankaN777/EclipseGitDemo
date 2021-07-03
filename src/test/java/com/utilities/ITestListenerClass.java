package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import com.TestCases.TestBase;

public class ITestListenerClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		//System.out.println("TestCase Name "+result.getName()+ " is start");
	}

	public void onTestSuccess(ITestResult result) {
		
		//System.out.println("TestCase Name "+result.getName()+ " is Pass");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestCase Name "+result.getName()+ " is Fail");
		SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyyhhmmss");
		String date=sdf.format(new Date());
		TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
		
		                    File src=  ts.getScreenshotAs(OutputType.FILE);
		                    File dest = new File(System.getProperty("user.dir")+"/ScreenshotOFTC/image"+result.getName()+date+".jpg");
		                    
		                    try {
								FileUtils.copyFile(src, dest);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	}

	public void onTestSkipped(ITestResult result) {
	
		//System.out.println("TestCase Name "+result.getName()+ " is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		//System.out.println("TestCase Name "+result.getName()+ " is Failed with success percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
				
		//System.out.println("TestCase Name "+result.getName()+ " is failed with timeout");
	}

	public void onStart(ITestContext context) {
		
		//System.out.println("Starting all test case... "+context.getAllTestMethods());
	}

	public void onFinish(ITestContext context) {
		
		//System.out.println("Failed test cases are... "+context.getFailedTests());
	}

}
