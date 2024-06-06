package automationcore;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BrowserLaunch 
{
protected	WebDriver driver ;
	
public  void initialisebrowser(String browser) 
{
		if(browser.equals("Chrome"))
			{
			driver = new ChromeDriver();
			}
			
		else if(browser.equals("edge")	)	{
			driver = new EdgeDriver();
		}
		else if ( browser.equals("Firefox")) {
			driver = new FirefoxDriver();
			
		}
		else {
			throw new RuntimeException("Invalid browser received");
		}
		
		driver.manage().window().maximize();
		
		
	}
@BeforeMethod

//first
  public void setup() 
  { 
	
	  initialisebrowser("Chrome"); 
	
	  
  }
  
@AfterMethod
public void closeBrowser() 
{
	
	  driver.close();
 }


	}



