package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import KnowIT.KnowIT.Driver;
import KnowIT.KnowIT.Utilits;

public class WelcomePage {
	WebDriver driver;
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchButton = By.xpath("//a[@class='js-toggle-button toggle-searchfield hide-for-medium-down']/div/span[text()='Sök']");
	By searchText = By.xpath("//input[@name='q']");
	By searchResult = By.xpath("//a[starts-with(text(),'Alla')]");
	By facebookLogo = By.xpath("//a[@class='social-media ']");
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void getText() {
		String defaultText= driver.findElement(searchText).getAttribute("placeholder");
		System.out.println(defaultText);
	}
	
	public void setText(String value) {
		driver.findElement(searchText).sendKeys(value);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='Vad söker du idag?']")).sendKeys(Keys.ENTER);
		//driver.findElement(searchButton).sendKeys(Keys.RETURN);
	}
	
	public String getSearchResult() {
		String result = driver.findElement(searchResult).getText();
		return result;
	}
	
	
	public void scrollIntoBotton() {
		WebElement element = driver.findElement(facebookLogo);
		Utilits.scrollIntoView(driver, element);
		element.click();
	}
	
	public void scrollIntoTop() {
		WebElement element = driver.findElement(searchButton);
		Utilits.scrollIntoView(driver, element);
	}
	
}
