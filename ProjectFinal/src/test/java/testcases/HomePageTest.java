package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;




	
	public class HomePageTest extends BrowserLaunch 
	  {
		
		@Test
		
		public void getPageTitle() 
		{
			    driver.get("https://qalegend.com/billing/public/login");
			    WebElement username_field = driver.findElement(By.id("username"));
			    username_field.sendKeys("admin");
			    WebElement password_field = driver.findElement(By.id("password"));
			    password_field.sendKeys("123456");
			    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
			    login_button.click();
			    String actual_title = driver.getTitle();
			    String expected_title = "Home - Maxfest Enterprises PVT LTD,Kochi";
			    System.out.println("The title of the page is " +actual_title);
			    Assert.assertEquals(actual_title, expected_title,"The Titles do not match");
		}
		
		@Test
		
		public void verifyDateDisplayedtToSystemDate() 
		{
			 driver.get("https://qalegend.com/billing/public/login");
			 WebElement username_field = driver.findElement(By.id("username"));
			 username_field.sendKeys("admin");
			 WebElement password_field = driver.findElement(By.id("password"));
			 password_field.sendKeys("123456");
			 WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
			 login_button.click();	
			 WebElement date_field = driver.findElement(By.xpath("//strong[text()='06-06-2024']"));//When date changes?
			 String date_text = date_field.getText();
			 String system_date = "06-06-2024";
		     System.out.println("The system date is " +system_date);
			 System.out.println("Date Text" + date_text );
			 Assert.assertEquals(date_text, system_date,"The Date Displayed is not as same as System Date");
			
		}
		
	}



