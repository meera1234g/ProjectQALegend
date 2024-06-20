package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UserMangementPage {
	WebDriver driver;

	public UserMangementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='treeview-menu menu-open']//a[contains(@href, 'https://qalegend.com/billing/public')]")
	List<WebElement> productPoolElements;

	public List<WebElement> getProductPoolElements() {
		List<WebElement> elements = new ArrayList<>();

		for (int i = 0; i < productPoolElements.size(); i++) {
			WebElement element = productPoolElements.get(i);
			WaitUtility.waitforElementtobeVisible(driver, element);
			String pollElementText = element.getText();
			System.out.println("Element text: " + pollElementText);

			elements.add(element);
		}

		return elements;
	}

}
