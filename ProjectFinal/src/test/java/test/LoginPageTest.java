package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import dataprovider.DataProviders;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass {

	@Test(groups = "Reggression", description = "Verify UserLogin With Valid Credentials")
	public void verifyUserLoginWithValidCredentials() {
		String username = ExcelUtility.readStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.LOGIN_PAGE);
		String expected_result = ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		String actual_result = home.getLoginUserText();
		Assert.assertEquals(actual_result, expected_result, Messages.LOGIN_FAILURE);
	}

	@Test(groups = "Sanity", description = "Verify Login with Invalid Credentials", dataProvider = "invaliduserCredentials", dataProviderClass = DataProviders.class)
	public void verifyUserLoginWithInvalidCredential(String username, String password) {
		String expected_errormsg = ExcelUtility.readStringData(0, 3, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		String actual_errormsg = login.getInvalidLoginUserText();
		Assert.assertEquals(actual_errormsg, expected_errormsg, Messages.LOGIN_INVALIDCREDIALS);
	}
}
