package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;
import pages.AddUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

 public class AddUser extends BrowserLaunch
	{
	  //Random Data Generator 
		@Test
		
		public void verifyAddingUser() 
		{
			String username = ExcelUtility.readStringData(0, 0, "AddUser");
			String password = ExcelUtility.readIntegerData(0, 1, "AddUser");
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+"."+last_name+"@yahoo.com";
			String password_new = first_name+"."+last_name;
			
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
		    adduser.addpassword(password_new);
		    adduser.addConfirmpassword(password_new);
		    adduser.clickOnSubmitButton();
	    }
		
		
	@Test
	public void verifyUserLoginWithNewAddedUser() 
		{
		    String username = ExcelUtility.readStringData(0, 0, "AddUser");
		    String password = ExcelUtility.readIntegerData(0, 1, "AddUser");
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+"."+last_name+"@yahoo.com";
			String password_new = first_name+"."+last_name;
			String username_fieldnew = first_name+"user";
			
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
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));
	        homepage.clickOnSignoutDashBoad();
	        homepage.clickOnSignoutButton();
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.enterUserName(username_fieldnew);
	        loginpage.enterPassword(password_new);
		    loginpage.clickOnLoginButton();
		  }
	
	}


