package test;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;

	import org.testng.annotations.Test;

import automationcore.BrowserLaunch;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import utilities.ExcelUtility;

	

	public class Users extends BrowserLaunch {
		
	@Test
		
		public void verifySearchByField()
		{
		String username  = ExcelUtility.readStringData(0, 0, "Users");
	    String password  = ExcelUtility.readIntegerData(0, 1, "Users");
	    String search_value = ExcelUtility.readStringData(0, 2, "Users");
		LoginPage login  = new LoginPage(driver);
	    login.enterUserName(username);
	    login.enterPassword(password);
	    login.clickOnLoginButton();
	    HomePage homepage = new HomePage(driver);
	    homepage.applicationTourPopupBoxClose();
	    homepage.clickOnUserManagementbutton();
	    homepage.clickOnUsersbutton();
        UsersPage userpage = new UsersPage(driver);
        userpage.enterSearchValue(search_value);
	    }
	}
