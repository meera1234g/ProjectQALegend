package testcases;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;

import automationcore.BrowserLaunch;

	

	public class Users extends BrowserLaunch {
		
	@Test
		
		public void verifyRememberMeCheckBox()
		{
			// TODO Auto-generated method stub
	    driver.get("https://qalegend.com/billing/public/login");
	    WebElement username_field = driver.findElement(By.id("username"));
	    username_field.sendKeys("admin");
	    WebElement password_field = driver.findElement(By.id("password"));
	    password_field.sendKeys("123456");
	    WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	    checkbox.click();
	    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
	    login_button.click();
	    WebElement application_tour = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
	    application_tour.click();
	    WebElement logout_button = driver.findElement(By.xpath("//span[text()='XYZ PQR']"));
	    logout_button.click();
	    WebElement signout_button = driver.findElement(By.xpath("//div[@class='pull-right']//a[@class='btn btn-default btn-flat']"));
	    signout_button.click();
	    String text_username = username_field.getText();
	    String actual_username = "admin";
	    Assert.assertEquals(text_username,actual_username, "RememberMe is not working as expected");
	    }
}
