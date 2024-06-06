package testcases;
    import java.util.List;
    import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.Test;
    import automationcore.BrowserLaunch;
    import utilities.ExcelUtility;
	import utilities.RandomDataUtility;

	public class AddUser extends BrowserLaunch
	{
	  
	    //Random Data Generator 
		@Test
		
		public void verifyAddingUser() 
		{
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+"."+last_name+"@yahoo.com";
			String password_new = first_name+"."+last_name;
			
			driver.get("https://qalegend.com/billing/public/login");
	        WebElement username_field = driver.findElement(By.id("username"));
		    username_field.sendKeys("admin");
		    WebElement password_field = driver.findElement(By.id("password"));
		    password_field.sendKeys("123456");
		    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
		    login_button.click();
		    WebElement application_tour = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		    application_tour.click();
		    WebElement users_button = driver.findElement(By.xpath("//a[@href='https://qalegend.com/billing/public/users']//i[@class='fa fa-user']"));
		    users_button.click();
			WebElement add_button = driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']//i[@class='fa fa-plus']"));
		    add_button.click();
		    WebElement first_namefield = driver.findElement(By.id("first_name"));
		    first_namefield.sendKeys(first_name);
		    WebElement last_namefield = driver.findElement(By.id("last_name"));
		    last_namefield.sendKeys(last_name);
		    WebElement email_id = driver.findElement(By.id("email"));
		    email_id.sendKeys(mailid);
		    WebElement password = driver.findElement(By.id("password"));
		    password.sendKeys(password_new);
		    WebElement confirm_password = driver.findElement(By.id("confirm_password"));
		    confirm_password.sendKeys(password_new);
		    WebElement save_button= driver.findElement(By.id("submit_user_button"));
		    save_button.click();
		    
		 }
		@Test
		
			
		public void verifyAddingUserd() 
		{
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+"."+last_name+"@yahoo.com";
			String password_new = first_name+"."+last_name;
			driver.get("https://qalegend.com/billing/public/login");
	        WebElement username_field = driver.findElement(By.id("username"));
		    username_field.sendKeys("admin");
		    WebElement password_field = driver.findElement(By.id("password"));
		    password_field.sendKeys("123456");
		    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
		    login_button.click();
		    WebElement application_tour = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		    application_tour.click();
		    WebElement usermangmnt_button = driver.findElement(By.xpath("//span[@class='title'and text()='User Management']"));
		    usermangmnt_button.click();
		    List<WebElement> userelements = driver.findElements(By.xpath("//span[@class='title']")); 
	        for(int i= 0; i < userelements.size();i++)	
		    { 
			  String userElementText = userelements.get(i).getText();
			  System.out.println(userElementText);
			  if (userElementText.equals("User")) 
			 { 
				  userelements.get(i).click();
			}
			}
		    WebElement users_button = driver.findElement(By.xpath("//a[@href='https://qalegend.com/billing/public/users']//i[@class='fa fa-user']"));
		    users_button.click();
			WebElement add_button = driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
		    add_button.click();
		    WebElement first_namefield = driver.findElement(By.id("first_name"));
		    first_namefield.sendKeys(first_name);
		    WebElement last_namefield = driver.findElement(By.id("last_name"));
		    last_namefield.sendKeys(last_name);
		    WebElement email_id = driver.findElement(By.id("email"));
		    email_id.sendKeys(mailid);
		    WebElement password = driver.findElement(By.id("password"));
		    password.sendKeys(password_new);
		    WebElement confirm_password = driver.findElement(By.id("confirm_password"));
		    confirm_password.sendKeys(password_new);
		    WebElement save_button= driver.findElement(By.id("submit_user_button"));
		    save_button.click();
		    WebElement search_field = driver.findElement(By.xpath("//input[@type='search']"));
		    search_field.sendKeys(mailid);
		    
		    
		}
		
		@Test
		
		public void verifyUserLoginWithNewAddedUser() 
		{

			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+"."+last_name+"@yahoo.com";
			String password_new = first_name+"."+last_name;
			driver.get("https://qalegend.com/billing/public/login");
	        WebElement username_field = driver.findElement(By.id("username"));
		    username_field.sendKeys("admin");
		    WebElement password_field = driver.findElement(By.id("password"));
		    password_field.sendKeys("123456");
		    WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
		    login_button.click();
		    WebElement application_tour = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		    application_tour.click();
		    WebElement usermangmnt_button = driver.findElement(By.xpath("//span[@class='title'and text()='User Management']"));
		    usermangmnt_button.click();
		    List<WebElement> userelements = driver.findElements(By.xpath("//span[@class='title']")); 
	        for(int i= 0; i < userelements.size();i++)	
		    { 
			  String userElementText = userelements.get(i).getText();
			  System.out.println(userElementText);
			  if (userElementText.equals("User")) 
			 { 
				  userelements.get(i).click();
			}
			}
		    WebElement users_button = driver.findElement(By.xpath("//a[@href='https://qalegend.com/billing/public/users']//i[@class='fa fa-user']"));
		    users_button.click();
			WebElement add_button = driver.findElement(By.xpath("//a[@class='btn btn-block btn-primary']"));
		    add_button.click();
		    WebElement first_namefield = driver.findElement(By.id("first_name"));
		    first_namefield.sendKeys(first_name);
		    WebElement last_namefield = driver.findElement(By.id("last_name"));
		    last_namefield.sendKeys(last_name);
		    WebElement email_id = driver.findElement(By.id("email"));
		    email_id.sendKeys(mailid);
		    WebElement password = driver.findElement(By.id("password"));
		    password.sendKeys(password_new);
		    WebElement confirm_password = driver.findElement(By.id("confirm_password"));
		    confirm_password.sendKeys(password_new);
		    WebElement save_button= driver.findElement(By.id("submit_user_button"));
		    save_button.click();
		   
		    WebElement sigout_dashboard = driver.findElement(By.xpath("//span[text()='XYZ PQR']"));
		    sigout_dashboard.click();
		    WebElement signout_button = driver.findElement(By.xpath("//a[@class='btn btn-default btn-flat'and@href='https://qalegend.com/billing/public/user/logout']"));
		    signout_button.click();
		   
		
	    }}



