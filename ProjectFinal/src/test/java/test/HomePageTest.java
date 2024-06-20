package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends BaseClass {
	@Test(groups = "Sanity", description = "Get the title of the Page")
	public void getPageTitle() {
		String username = ExcelUtility.readStringData(0, 0, Constants.HOME_PAGE);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.HOME_PAGE);
		String expected_title = ExcelUtility.readStringData(0, 2, Constants.HOME_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		String actual_title = home.getActualTitle();
		System.out.println("The title of the page is " + actual_title);
		Assert.assertEquals(actual_title, expected_title, Messages.TITLE_MISMATCH);
	}

	@Test(groups = "Smoke", description = "Verify User Login Date")
	public void verifyUserLoginDate() {

		String username = ExcelUtility.readStringData(0, 0, Constants.HOME_PAGE);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.HOME_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		String date_fieldtext = home.getLoginDate();
		String system_date = home.getCurrentDate();
		Assert.assertEquals(date_fieldtext, system_date, Messages.DATE_MISMATCH);
	}
}
