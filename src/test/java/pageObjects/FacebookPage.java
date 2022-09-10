package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookPage {
	
	WebDriver driver;
	public FacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By knowITLogo = By.xpath("//h1[text()='Knowit']");
	
	@SuppressWarnings("deprecation")
	WebDriverWait waitElement  = new WebDriverWait(driver, 30);
	
	public void waitForElementToVisible() {
		waitElement.until(ExpectedConditions.presenceOfElementLocated(knowITLogo));
	}
	
}
