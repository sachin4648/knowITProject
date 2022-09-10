package KnowIT.KnowIT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	ExtentTest logger;
	GetProperties classObj=GetProperties.getProperty();
	String bName = classObj.getPropValue("browserName");
	
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	public String getBrowserName() {
		return classObj.getPropValue("browserName");
	}
	
	
	public Base() {
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		
	}
	
	@BeforeClass
	public void beforeBaseClass() {
		
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	
	
}
