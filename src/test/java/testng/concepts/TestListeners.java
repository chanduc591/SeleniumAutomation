package testng.concepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Testcases.Assignment24;
import Utilities.Reports;

public class TestListeners extends Reports implements ITestListener {

	

	@Override
	public void onTestStart(ITestResult result) {
		
	String testName=result.getMethod().getMethodName();
	
	startReporting(testName);
	
	Reports.logger.info("Test case execution startd: "+testName);
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		
		Reports.logger.info("Test case execution passed: "+testName);
		
		stopReporting();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		
		Reports.logger.fail("Test case Execution Failed :"+testName);
		try {
			TakesScreenshot ts=(TakesScreenshot)Assignment24.driver;
			String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
			File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile,new File(screenshotPath));
			Reports.logger.addScreenCaptureFromPath(screenshotPath, testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reports.logger.fail("Test case Execution Failed :"+result.getThrowable().getLocalizedMessage());
		stopReporting();
	}
	
	
	
}
