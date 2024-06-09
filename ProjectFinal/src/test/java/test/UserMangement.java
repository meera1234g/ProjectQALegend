package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationcore.BrowserLaunch;
import utilities.ExcelUtility;

public class UserMangement extends BrowserLaunch 
{
	@Test
	
	public void verifyUserMangement() 
	{
		
		
		driver.get("https://qalegend.com/billing/public/login");
        WebElement username_field = driver.findElement(By.id("username"));
	    username_field.sendKeys(ExcelUtility.readStringData(0, 0,"UserMangement"));
	    WebElement password_field = driver.findElement(By.id("password"));
	    password_field.sendKeys(ExcelUtility.readIntegerData(0, 1,"UserMangement"));
	    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
	    login_button.click();
	    WebElement application_tour = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
	    application_tour.click();
	    WebElement usermanagement_button = driver.findElement(By.xpath("//span[@class='title' and text()='User Management']"));
	    usermanagement_button.click();
	    List<WebElement> userelements = driver.findElements(By.xpath("//span[@class='title']")); 
        for(int i= 0; i < userelements.size();i++)	
	    { 
		  String userElementText = userelements.get(i).getText();
		  System.out.println(userElementText);
		  }
		}
}
