package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@class='content-header']")
	WebElement welcome_user;

	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement date_field;

	@FindBy(xpath = "//i[@class='fa fa-calculator fa-lg']")
	WebElement calculator_field;

	@FindBy(xpath = "//button[@id='3']")
	WebElement first_number;

	@FindBy(xpath = "//button[@id='4']")
	WebElement second_number;

	@FindBy(xpath = "//button[@id='+']")
	WebElement sum_number;

	@FindBy(xpath = "//button[@id='equals']")
	WebElement equalto_button;

	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	WebElement application_tour;

	@FindBy(xpath = "//input[@type='text']")
	WebElement result_field;

	@FindBy(xpath = "//span[@class='title' and text()='User Management']")
	WebElement usermanagement_button;

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
	WebElement user_button;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement signout_dashboard;

	@FindBy(xpath = "//a[@class='btn btn-default btn-flat'and@href='https://qalegend.com/billing/public/logout']")
	WebElement signout_button;

	public String getLoginUserText() {
		String user = welcome_user.getText();
		return user;
	}

	public String getActualTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getLoginDate() {
		String logindate = date_field.getText();
		return logindate;
	}

	public String getCurrentDate() {
		String currentdate = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return currentdate;
	}

	public void getCalculatorfield() {
		calculator_field.click();
	}

	public void applicationTourPopupBoxClose() {
		application_tour.click();
	}

	public String getSumofTwoNumbers() {
		first_number.click();
		sum_number.click();
		second_number.click();
		String resultText = result_field.getText();
		return resultText;

	}

	public void clickOnUserManagementbutton() {
		usermanagement_button.click();
	}

	public void clickOnUsersbutton() {
		user_button.click();
	}

	public void clickOnSignoutDashBoad() {
		signout_dashboard.click();
	}

	public void clickOnSignoutButton() {
		signout_button.click();
	}

	public String getTextofProfile() {
		String text = welcome_user.getText();
		return text;

	}
}
