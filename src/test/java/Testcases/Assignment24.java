package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Reports;

public class Assignment24 extends Reports{

	public static WebDriver driver;
	
	
	@BeforeMethod
	@Parameters({"BROWSER"})
	public void launchBrowserAndApplication(String browser) {
		
		//1.Launch Chrome Browser
		 driver=new ChromeDriver();
		 
		 //Reports.logger.info("Browser launched successfully");
			//2.Maximize the browser window
			driver.manage().window().maximize();
					//3.Launch the application (https://demoqa.com/frames)
		
	}
	
	@Test
	public void demoframes() {
		driver.get("https://demoqa.com/frames");
		 Reports.logger.info("url launched successfully");
				//4.Locate elements
		
		driver.switchTo().frame("frame1");
		
		 Reports.logger.info("switch to frame 1 successfully");

				//5.Print frame element text
		
             String firstfremae=driver.findElement(By.id("sampleHeadin")).getText();	
             
             System.out.println("First frame text is: "+firstfremae);
             
				//6.Print main window element text
             
             driver.switchTo().defaultContent();
             
			 Reports.logger.info("switch to  default parent window successfully");

             
            String mainheadingtext= driver.findElement(By.id("framesWrapper")).getText();

            System.out.println(" mainheading text is: "+mainheadingtext);

				//7.Close browser window
			 Reports.logger.info("mainheading text is"+mainheadingtext);

		     
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		 driver.quit();
		System.out.println("Browser is closed....");
	}

}
