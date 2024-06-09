package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BrowserLaunch;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


  public class HomePageTest extends BrowserLaunch 
   {
	  @Test
	  public void getPageTitle() 
		{
		    String username = ExcelUtility.readStringData(0, 0, "HomePage");
		    String password = ExcelUtility.readIntegerData(0, 1, "HomePage");
		    String expected_title = ExcelUtility.readStringData(0, 2, "HomePage");
		    
		    LoginPage login = new LoginPage(driver);
		    login.enterUserName(username);
		    login.enterPassword(password);
		    HomePage home =  login.clickOnLoginButton();
		    String actual_title = home.getActualTitle();
		    System.out.println("The title of the page is " +actual_title);
			Assert.assertEquals(actual_title, expected_title,"The Titles do not match");
		}
	  
	  @Test
		
		public void verifyDateDisplayedtToSystemDate() 
		{

		    String username = ExcelUtility.readStringData(0, 0, "HomePage");
		    String password = ExcelUtility.readIntegerData(0, 1, "HomePage");
		    LoginPage login = new LoginPage(driver);
		    login.enterUserName(username);
		    login.enterPassword(password);
		    HomePage home =  login.clickOnLoginButton();
			String  date_fieldtext = home.getDisplayedDate();
			String system_date = home.getSystemDate();
            System.out.println("The system date is " +system_date);
			System.out.println("Date Text" + date_fieldtext );
			Assert.assertEquals(date_fieldtext, system_date,"The Date Displayed is not as same as System Date");
			
		}
	  
	  @Test
	  
	  public void getCaluculatorResult() 
	  {
		    String username = ExcelUtility.readStringData(0, 0, "HomePage");
		    String password = ExcelUtility.readIntegerData(0, 1, "HomePage");
		    LoginPage login = new LoginPage(driver);
		    login.enterUserName(username);
		    login.enterPassword(password);
		    login.clickOnLoginButton();
		    HomePage homepage = new HomePage(driver);
		    homepage.applicationTourPopupBoxClose();
		    homepage.getCalculatorfield();
		    String result_new = homepage.getSumofTwoNumbers();
		    System.out.println("The result is " +result_new);
		}
   }
	  
	  
	  
	  
	 
	  
	  
	 
	  
	  