package Testcases;

import java.awt.event.WindowStateListener;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.invokers.ExpectedExceptionsHolder;

public class Assignment22 {

	
	private static WebDriver driver;
	
	static String url="https://demoqa.com/automation-practice-form";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Launch browser window(Chrome)
		
	        driver=new ChromeDriver();
	       
		//2. Maximize the browser window
	        
	        driver.manage().window().maximize();

		//3. Delete all the cookies
	        
	        driver.manage().deleteAllCookies();
		       
		//4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
		    
	        driver.get(url);
	        
		//5. Wait for Page-load
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        wait.until(ExpectedConditions.urlToBe(url));
	        

		//6. Enter First name and Last name
	        
	    WebElement firstname=driver.findElement(By.xpath("//input[@id='firstName']"));
	    firstname.sendKeys("Chandra");
	    WebElement lastname=driver.findElement(By.xpath("//input[@id='lastName']"));
	    lastname.sendKeys("sekhar");
	    
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollBy(0, 500);");
		           
		//7. Enter Email
	    
	    WebElement email=driver.findElement(By.xpath("//input[@id='userEmail']"));
	    email.sendKeys("sekharc5916@gmail.com");
		               
		//8. Select Gender (Female)
	    WebElement genderfemale=driver.findElement(By.xpath("//label[text()='Female']"));
	      
	  wait.until(ExpectedConditions.visibilityOf(genderfemale));
	  
	  genderfemale.click();
		               
		//9. Enter mobile number
	    
	    
	    WebElement mobilenum=driver.findElement(By.xpath("//input[@id='userNumber']"));
	      
	    mobilenum.sendKeys("8500617448");
	    
	    
	    
		               
		//10.Select DOB (1-Feb-1991)
	    
	    WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
	    dobInput.click();

	    // Select the year
	    WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
	    Select selectYear = new Select(yearDropdown);
	    selectYear.selectByVisibleText("1994");

	    // Select the month
	    WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
	    Select selectMonth = new Select(monthDropdown);
	    selectMonth.selectByVisibleText("August");

	    // Select the day (10)
	    List<WebElement> days = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, 'outside-month'))]"));
	    for (WebElement day : days) {
	        if (day.getText().equals("10")) {
	            day.click();
	            break;
	        }
	    }     
		//11.Search and Select Computer Science
	    
	    
	    WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
	 subjectInput.sendKeys("Computer Science");
	 subjectInput.sendKeys(Keys.ENTER);
	 subjectInput.sendKeys(Keys.TAB);
		               
		//12.Select Hobbies as Sports and Reading

  WebElement hobbie=driver.findElement(By.xpath("//label[text()='Sports']"));
   
    
    wait.until(ExpectedConditions.visibilityOf(hobbie));
	  
    hobbie.click();
		               
    WebElement reading=driver.findElement(By.xpath("//label[text()='Reading']"));
    wait.until(ExpectedConditions.visibilityOf(reading));
	  
    reading.click();
  
		               
		//13.Upload photo
  
   WebElement upload = driver.findElement(By.id("uploadPicture"));
   upload.sendKeys("C:\\Users\\USER\\OneDrive\\Pictures\\Screenshots\\image.png");
		               
		//14. Wait till file upload
   
   try {
       Thread.sleep(3000); 
   } catch (InterruptedException e) {
       e.printStackTrace();
   }
   
   
   ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

		               
		//15.Submit Details
		               
		//16. Close browser window




	}

}
