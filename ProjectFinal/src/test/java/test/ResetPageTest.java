package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;
import pages.LoginPage;
import pages.ResetPage;
import utilities.ExcelUtility;



	
  public class ResetPageTest extends BrowserLaunch
	{
       @Test
		public void verifyForgotpasswordWithInvalidEmailid() 
		{
		    String emailid = ExcelUtility.readStringData(0, 0, "ResetPage");
		    String expected_text = ExcelUtility.readStringData(0, 1, "ResetPage") ;
		    
		    LoginPage login = new LoginPage(driver);
		    login.forgotPasswordelement();
		    ResetPage reset = new ResetPage(driver);
		    reset.getEmailidField(emailid);
	        reset.clickpasswordreset_button();
	        String actual_text = reset.getTextmsgOfResetmailfail(emailid);
	        Assert.assertEquals(actual_text, expected_text,"The error messages does not match");
		 }
	
     @Test
	  public void verifyForgotpasswordWithValidEmailid() 
	   {
		   String valid_emailid = ExcelUtility.readStringData(0, 2, "ResetPage");
		   String expected_text = ExcelUtility.readStringData(0, 3, "ResetPage") ;
		   LoginPage login = new LoginPage(driver);
		   login.forgotPasswordelement();
		   ResetPage reset = new ResetPage(driver);
		   reset.getEmailidField(valid_emailid);
	       reset.clickpasswordreset_button();
	       String actual_text = reset.getTextmsgOfResetmailsuccess(valid_emailid);
	       Assert.assertEquals(actual_text, expected_text,"The success messages does not match");
	   }
	}



