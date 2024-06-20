package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectDropDownByIndexValue(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
	}

	public void verifyRightClick(WebDriver driver, WebElement rightclickbutton) {

		Actions action = new Actions(driver);
		action.contextClick(rightclickbutton).build().perform();
	}

	public void verifyDoubleClick(WebDriver driver, WebElement doubleclick) {
		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).build().perform();
	}

	public void verifyDragAndDrop(WebDriver driver, WebElement dragelement, WebElement dropelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragelement, dropelement).build().perform();
	}

	public void verifySimpleAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void validateConfirmationAlertclickonDismiss(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		alert.dismiss();
	}

	public void validateConfirmationAlertclickonAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		alert.accept();
	}

	public void validatePromptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		alert.sendKeys("The name is test");
		alert.accept();
	}

	public void toSwitcToAFrame(WebDriver driver, WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void toSwitcToAFrameDefaultFrame(WebDriver driver, WebElement frame) {
		driver.switchTo().defaultContent();
	}
}
