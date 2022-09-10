package stepDefination;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import KnowIT.KnowIT.Base;
import KnowIT.KnowIT.GetProperties;
import KnowIT.KnowIT.Utilits;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FacebookPage;
import pageObjects.WelcomePage;


public class stepDefination {
	WebDriver driver;
	WebDriverWait wait;
	GetProperties classObj;
	WelcomePage welcomePage;
	FacebookPage facebookPage;
	
	@SuppressWarnings("deprecation")
	@Given("^User navigated to knowIT website$")
	public void user_logged_into_crm_application() throws InterruptedException {
		driver = Base.getDriver();
		classObj = GetProperties.getProperty();
		driver.get(classObj.getPropValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='coi-button-group']/button[3]")).click();
	}

	
	@Given("^User click on search button and print default value$")
	public void User_print_default_value() {
		welcomePage = new WelcomePage(driver);
		welcomePage.clickSearchButton();
		welcomePage.getText();
	}
	
	
	@When("^User entered (.+) and hit enter key$")
	public void user_enters_required_details_(String searchString) {
		welcomePage = new WelcomePage(driver);
		welcomePage.setText(searchString);
		
	}
	
	@Then("^Verify search result$")
	public void Verify_search_result() {
		welcomePage = new WelcomePage(driver);
		String result = welcomePage.getSearchResult();
		Utilits.takeScreenShot(driver, "D:\\sachin\\JavaLearning2\\KnowIT\\resources\\screenshot\\TC1_01.jpeg");
		org.testng.Assert.assertTrue(result.contains("Alla"), "Failed to load results");
	}
	
	
	@Given("^User scroll to botton page and clicks on facebook logo$")
	public void User_scroll_to_botton_page_and_clicks_on_facebook_logo() {
		welcomePage = new WelcomePage(driver);
		welcomePage.scrollIntoBotton();
	}

	@When("^User navigate to new window and close it$")
	public void User_navigate_to_new_window_and_close_it() {
		Set<String> wList = driver.getWindowHandles();
		Iterator<String> wL= wList.iterator();
		String parentdWindow = wL.next();
		String childWindow = wL.next();
		driver.switchTo().window(childWindow);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebDriverWait waitElement  = new WebDriverWait(driver, 30);
		waitElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Knowit']")));
		Utilits.takeScreenShot(driver, "D:\\sachin\\JavaLearning2\\KnowIT\\resources\\screenshot\\TC2_01.jpeg");
		driver.close();
		driver.switchTo().window(parentdWindow);
	}
	
	@Then("^User scroll to top into Parent Window$")
	public void Scroll_to_top_into_parent_window() {
		welcomePage = new WelcomePage(driver);
		welcomePage.scrollIntoTop();
		Utilits.takeScreenShot(driver, "D:\\sachin\\JavaLearning2\\KnowIT\\resources\\screenshot\\TC2_02.jpeg");
	}
	
	@After
	public void tearDown() {
		driver.close();

		if(driver!=null) {
			driver.quit();
		}
	}
}
