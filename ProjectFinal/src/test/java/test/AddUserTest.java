package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import pages.AddUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserTest extends BaseClass {

	@Test(description = "Verify Adding A New User")

	public void verifyAddingUser() {
		String username = ExcelUtility.readStringData(0, 0, Constants.ADD_USER);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.ADD_USER);
		String first_name = RandomDataUtility.getFirstName();
		String last_name = RandomDataUtility.getLastName();
		String mailid = first_name + Constants.DOT + last_name + Constants.MAILID_EXTENSION;
		String username_fieldnew = first_name + Constants.USRNAME_EXTNSN;
		String password_new = first_name + Constants.DOT + last_name;
		String search_value = mailid;

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.applicationTourPopupBoxClose();
		homepage.clickOnUserManagementbutton();
		homepage.clickOnUsersbutton();
		AddUserPage adduser = new AddUserPage(driver);
		adduser.clickOnAddUserButton();
		adduser.addFirstname(first_name);
		adduser.addLastname(last_name);
		adduser.addEmail(mailid);
		adduser.addUserName(username_fieldnew);
		adduser.addpassword(password_new);
		adduser.addConfirmpassword(password_new);
		adduser.clickOnSubmitButton();
		UsersPage userpage = new UsersPage(driver);
		userpage.enterSearchValue(search_value);
		Assert.assertEquals(Messages.USER_SUCSSEMSG, Messages.USER_SUCSSEMSG, Messages.USER_SUCSSERROREMSG);
	}

	@Test(description = "Verify user Login with Newly Added User")
	public void verifyUserLoginWithNewAddedUser() {
		String username = ExcelUtility.readStringData(0, 0, Constants.ADD_USER);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.ADD_USER);
		String first_name = RandomDataUtility.getFirstName();
		String last_name = RandomDataUtility.getLastName();
		String mailid = first_name + Constants.DOT + last_name + Constants.MAILID_EXTENSION;
		String password_new = first_name + Constants.DOT + last_name;
		String username_fieldnew = first_name + Constants.USRNAME_EXTNSN;
		String expected_result = Constants.Welcome_MSG + first_name + Constants.COMMA;

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.applicationTourPopupBoxClose();
		homepage.clickOnUserManagementbutton();
		homepage.clickOnUsersbutton();
		AddUserPage adduser = new AddUserPage(driver);
		adduser.clickOnAddUserButton();
		adduser.addFirstname(first_name);
		adduser.addLastname(last_name);
		adduser.addEmail(mailid);
		adduser.addUserName(username_fieldnew);
		adduser.addpassword(password_new);
		adduser.addConfirmpassword(password_new);
		adduser.clickOnSubmitButton();
		adduser.waitForTexttobeinvisible();
		homepage.clickOnSignoutDashBoad();
		homepage.clickOnSignoutButton();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username_fieldnew);
		loginpage.enterPassword(password_new);
		loginpage.clickOnLoginButton();
		adduser.waitForTexttobeVisible();
		String actual_result = homepage.getTextofProfile();
		Assert.assertEquals(actual_result, expected_result, Constants.NEWUSERLOGIN_ERROR);
	}

	@Test(description = "Verify Deleting a New Added User")
	public void verifyDeleteingNewlyAddedUser() {
		String username = ExcelUtility.readStringData(0, 0, Constants.ADD_USER);
		String password = ExcelUtility.readIntegerData(0, 1, Constants.ADD_USER);
		String first_name = RandomDataUtility.getFirstName();
		String last_name = RandomDataUtility.getLastName();
		String mailid = first_name + Constants.DOT + last_name + Constants.MAILID_EXTENSION;
		String password_new = first_name + Constants.DOT + last_name;
		String username_fieldnew = first_name + Constants.USRNAME_EXTNSN;;
		String search_value = mailid;

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		HomePage homepage = new HomePage(driver);
		homepage.applicationTourPopupBoxClose();
		homepage.clickOnUserManagementbutton();
		homepage.clickOnUsersbutton();
		AddUserPage adduser = new AddUserPage(driver);
		adduser.clickOnAddUserButton();
		adduser.addFirstname(first_name);
		adduser.addLastname(last_name);
		adduser.addEmail(mailid);
		adduser.addUserName(username_fieldnew);
		adduser.addpassword(password_new);
		adduser.addConfirmpassword(password_new);
		adduser.clickOnSubmitButton();
		adduser.waitForTexttobeinvisible();
		UsersPage userpage = new UsersPage(driver);
		userpage.enterSearchValue(search_value);
		userpage.clickDeleteButtoun();
		userpage.clickOkButtoun();
		Assert.assertEquals(Messages.USER_DELTEMSG, Messages.USER_DELTEMSG,Messages.USER_DELTEERRORMSG);
	}
}
