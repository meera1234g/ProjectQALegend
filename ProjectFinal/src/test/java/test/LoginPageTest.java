package test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;
import dataprovider.DataProviders;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginPageTest extends BrowserLaunch
{
	
@Test
  public void verifyUserLoginWithValidCredentials()
  {
	    String username = ExcelUtility.readStringData(0, 0, "LoginPage");
	    String password = ExcelUtility.readIntegerData(0, 1, "LoginPage");
	    String expected_result = ExcelUtility.readStringData(0, 2, "LoginPage");
	    
	    LoginPage login = new LoginPage(driver);
	    login.enterUserName(username);
	    login.enterPassword(password);
	    HomePage home =  login.clickOnLoginButton();
	    String  actual_result = home.getLoginUserText();
	    Assert.assertEquals(actual_result,expected_result ,"Login not Successful");
   }

@Test(dataProvider = "invaliduserCredentials", dataProviderClass = DataProviders.class)
public void verifyUserLoginWithInvalidCredential(String username , String password)
	{
		String expected_errormsg = ExcelUtility.readStringData(0, 3 , "LoginPage");
		LoginPage login = new LoginPage(driver);
	    login.enterUserName(username);
	    login.enterPassword(password);
	    login.clickOnLoginButton();
		String actual_errormsg = login.getInvalidLoginUserText();
		Assert.assertEquals(actual_errormsg,expected_errormsg ,"Please Check");
	}

}



