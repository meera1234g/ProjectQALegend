package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;



	
	public class ResetPageTest extends BrowserLaunch
	{

	@Test
		
		public void verifyForgotpasswordWithInvalidEmailid() 
		{
			driver.get("https://qalegend.com/billing/public/login");
		    WebElement forgot_password = driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		    forgot_password.click();
		    WebElement emailid = driver.findElement(By.id("email"));
		    emailid.sendKeys("h@gmail.com")	;
		    WebElement passwrd_resetbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		    passwrd_resetbutton.click();
		    WebElement error_text = driver.findElement(By.xpath("//span[@class='help-block']"));
		    String actual_text = error_text.getText();
		    String expected_text = "We can't find a user with that e-mail address.";
		    Assert.assertEquals(actual_text,expected_text, "No error message found");
		}

	@Test

	   public void verifyForgotpasswordWithValidEmailid() 
	{
		driver.get("https://qalegend.com/billing/public/login");
	    WebElement forgot_password = driver.findElement(By.xpath("//a[@class='btn btn-link']"));
	    forgot_password.click();
	    WebElement emailid = driver.findElement(By.id("email"));
	    emailid.sendKeys("jamesthomas@gmail.com")	;
	    WebElement passwrd_resetbutton = driver.findElement(By.xpath("//button[@type='submit']"));
	    passwrd_resetbutton.click();
	    WebElement success_text = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
	    String actual_text = success_text.getText();
	    String expected_text = "We have e-mailed your password reset link!";
	    Assert.assertEquals(actual_text,expected_text, "No success message found");
	}
		
	}



