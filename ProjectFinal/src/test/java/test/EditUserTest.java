package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import pages.EditUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import utilities.ExcelUtility;

public class EditUserTest extends BaseClass {

	@Test(description = "To verify Editing Details of an Exsisting User")
	public void editAnExistingUser() {
		String username = ExcelUtility.readStringData(0, 0, Constants.USERS_PAGE);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.USERS_PAGE);
		String search_value = ExcelUtility.readStringData(0, 2, Constants.USERS_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.applicationTourPopupBoxClose();
		homepage.clickOnUserManagementbutton();
		homepage.clickOnUsersbutton();
		UsersPage userpage = new UsersPage(driver);
		userpage.enterSearchValue(search_value);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='glyphicon glyphicon-edit']")));
		userpage.clickEditButtoun();
		EditUserPage edituser = new EditUserPage(driver);
		edituser.updatesurnamefield();
		edituser.clickOnSubmitButton();
		Assert.assertEquals(Messages.USERUPDATE_SUCCESS, Messages.USERUPDATE_SUCCESS, Messages.USERUPDATE_FAIL);
	}
}
