package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import utilities.ExcelUtility;

	

	public class UsersTest extends BaseClass {
		
	@Test(description = "Verify Search By Field Functionality")
		
		public void verifySearchByField()
		{
		String username  = ExcelUtility.readStringData(0, 0, Constants.USERS_PAGE);
	    String password  = ExcelUtility.readIntegerData(0, 1, Constants.USERS_PAGE);
	    String expected_name = ExcelUtility.readStringData(0, 3,Constants.USERS_PAGE);
	    
	    LoginPage login  = new LoginPage(driver);
	    login.enterUserName(username);
	    login.enterPassword(password);
	    login.clickOnLoginButton();
	    HomePage homepage = new HomePage(driver);
	    homepage.applicationTourPopupBoxClose();
	    homepage.clickOnUserManagementbutton();
	    homepage.clickOnUsersbutton();
        UsersPage userpage = new UsersPage(driver);
        userpage.enterSearchValue(expected_name);
        String actual_name = userpage.getTextOfName();
        Assert.assertEquals(actual_name, expected_name,Messages.SEARCHBYFIELD_ERROR);
        }
	}

