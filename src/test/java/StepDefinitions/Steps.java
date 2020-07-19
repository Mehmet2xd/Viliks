package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MEHMET\\eclipse-workspace\\Viliks\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    lp=new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    
		driver.get(url);
	}

	@When("User enter emails as {string} and password as {string}")
	public void user_enter_emails_as_and_password_as(String email, String password) {
	    
		lp.setUsername(email);
		lp.setPassword(password);
	}

	@When("click on Login button")
	public void click_on_login_button() {
		
		lp.clickLogin();
	   
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	   
	}

	@When("User click on log out button")
	public void user_click_on_log_out_button() throws InterruptedException {
	    
		lp.clickLogout();
		
		Thread.sleep(2000);
	}

	@Then("close browser")
	public void close_browser() {
	    
		driver.quit();
	}


}
