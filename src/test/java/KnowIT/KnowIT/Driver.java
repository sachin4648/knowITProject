package KnowIT.KnowIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Driver
{
	protected WebDriver driver;

	protected Driver(WebDriver driver) 
	{
		this.driver=driver;		
	}
	
	public void quit() {
		this.driver.quit();
	}
	
	public void close() {
		this.driver.close();
	}
	
	public void implicitlyWait(long seconds) {
		this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	

	protected WebDriver getDriver()
	{
		return this.driver;		
	}

	public void get(String url)
	{
		driver.get(url);
	}

	public String getTitle()
	{
		return driver.getTitle();
	}
	

	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public void switchToWindow(String windowName) {
		driver.switchTo().window(windowName);
	}
	
	public void scrollToView(WebElement element) {
		
	}
}
