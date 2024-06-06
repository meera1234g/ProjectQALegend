package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;
import dataprovider.DataProviders;
import utilities.ExcelUtility;


public class LoginPageTest extends BrowserLaunch
{
	
@Test
  public void verifyUserLoginWithValidCredentials()
  {
	
		driver.get("https://qalegend.com/billing/public/login");
	    WebElement username_field = driver.findElement(By.id("username"));
	    username_field.sendKeys("admin");
	    WebElement password_field = driver.findElement(By.id("password"));
	    password_field.sendKeys("123456");
	    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
	    login_button.click();
	    WebElement welcome_message = driver.findElement(By.xpath("//section[@class='content-header']"));
	    String welcome_textexpected = welcome_message.getText();
	    String welcome_textactual = "Welcome XYZ,";
	    Assert.assertEquals(welcome_textactual, welcome_textexpected,"Login not Successful");
    
   }
	//Using Data Provider
	@Test(dataProvider = "invaliduserCredentials", dataProviderClass = DataProviders.class)
  public void verifyUserLoginWithInvalidCredentials(String username , String password)
  {
		
	    driver.get("https://qalegend.com/billing/public/login");
	    WebElement username_field = driver.findElement(By.id("username"));
	    username_field.sendKeys(username);
	    WebElement password_field = driver.findElement(By.id("password"));
	    password_field.sendKeys(password);
	    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
	    login_button.click();
	    WebElement error_message = driver.findElement(By.xpath("//span[@class='help-block']"));
	    String welcome_textexpected = error_message.getText();
	    String welcome_textactual = "These credentials do not match our records.";
	    Assert.assertEquals(welcome_textactual, welcome_textexpected,"Login not Successful");
  }
}

