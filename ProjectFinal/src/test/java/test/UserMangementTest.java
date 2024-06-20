package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.UserMangementPage;
import utilities.ExcelUtility;

public class UserMangementTest extends BaseClass {
	@Test(description = "Verify Selection and Printing of list of elements under UserMangement")
	public void verifyPoolElementinUserMangement() {
		String username = ExcelUtility.readStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.applicationTourPopupBoxClose();
		homepage.clickOnUserManagementbutton();
		UserMangementPage usrmgntpage = new UserMangementPage(driver);
		List<WebElement> elementsnew = usrmgntpage.getProductPoolElements();
		for (WebElement element : elementsnew) {
			Assert.assertTrue(element.isDisplayed());

		}

	}
}
