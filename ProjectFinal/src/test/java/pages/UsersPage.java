package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class UsersPage 
  {
	WebDriver driver;
	public UsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchfield;
	
    public void enterSearchValue(String search_value) 
	  {
		
		searchfield.sendKeys(search_value);
		  
	  }
}
