package Testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment23 {
	
	public static void main(String[] args) {
		
		//1.Launch Chrome Browser
		
		WebDriver driver=new ChromeDriver();
	       
		//2.Maximize the browser window
		
		driver.manage().window().maximize();

		       
		//3.Launch the application (https://demoqa.com/alerts)
		
		driver.get("https://demoqa.com/alerts");
		       
		//4.Locate Alert buttons
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		WebElement alertbutton= driver.findElement(By.id("alertButton"));
		
		
		js.executeScript("arguments[0].scrollIntoView(true)", alertbutton);

		
		alertbutton.click();
		
		       
		//5.Launch Information alert
		
		Alert alert=driver.switchTo().alert();
		
		       
		//6.Print Alert message
		
		 String alertmessage= alert.getText();
		 
		 System.out.println("alert message is: "+alertmessage);
		 
		       
		//7.Click on OK button
		       
		 alert.accept();
		 
		//8.Launch confirmation alert
		 
		WebElement confrmalrt= driver.findElement(By.id("timerAlertButton"));
		js.executeScript("arguments[0].scrollIntoView(true)", confrmalrt);
		confrmalrt.click();
		

		//9.Print Alert message
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert confrmalert=  driver.switchTo().alert();
		
		String confrmMessage=confrmalert.getText();
		
		System.out.println("confirm alert message is: "+confrmMessage);
		
		       
		//10.Click on Cancel button
		confrmalert.dismiss();
		       
		//11.Launch prompt alert with dialog box alert
		WebElement promptalert=  driver.findElement(By.id("promtButton"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", promptalert);
		promptalert.click();
		
		//12.Print message
		
     Alert promptalert1 = driver.switchTo().alert();
		
		String promptaleMessage=promptalert1.getText();
		
		System.out.println("prompt alert message is: "+promptaleMessage);
		
		//13.Enter Text in Alert
		promptalert1.sendKeys("This is aprompt alert");
		       
		//14.Click on OK button
		
		promptalert1.accept();
		
		driver.quit();
	}

}
