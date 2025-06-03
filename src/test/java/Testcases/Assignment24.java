package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment24 {

	public static void main(String[] args) {

				//1.Launch Chrome Browser
				       
		WebDriver driver=new ChromeDriver();
		
				//2.Maximize the browser window
		driver.manage().window().maximize();

	       
				//3.Launch the application (https://demoqa.com/frames)
		driver.get("https://demoqa.com/frames");

				//4.Locate elements
		driver.switchTo().frame("frame1");
		    
				//5.Print frame element text
		
             String firstfremae=driver.findElement(By.id("sampleHeading")).getText();	
             
             System.out.println("First frame text is: "+firstfremae);
             
				//6.Print main window element text
             
             driver.switchTo().defaultContent();
             
            String mainheadingtext= driver.findElement(By.id("framesWrapper")).getText();

            System.out.println(" mainheading text is: "+mainheadingtext);

				//7.Close browser window
		
		      driver.quit();
	}

}
