package PetShopProjetoBDD.steps;

import org.openqa.selenium.WebDriver;


import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	WebDriver driver;
    LoginPage loginPage;
 
	
    @Given("I am on the login page using {string}")
    public void i_am_on_the_login_page_using(String browser) {
        driver = WebDriverConfig.startBrowser(browser);
        loginPage = new LoginPage(driver);
        driver.get("https://petstore.octoperf.com/actions/Account.action;jsessionid=F7FA4F107DBE97B29BCEB0F877DD17F4?signonForm=");
        Helper.takeScreenshot(driver, "tiraprint");
    }
    

  
    @When("I insert valid data to log in")
    public void i_insert_valid_data_to_log_in() {
        loginPage.fillUserNameAndPassword("bejasec", "AMOR2328*");
        Helper.takeScreenshot(driver, "tiraprint");
    }
    
    @When("I click to login button")
    public void i_click_to_login_button() {
    	 loginPage.clickToLoginButton();
    }
    
    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
		loginPage.verifyHomepage();
    }
    
    @After
    public void closeBrowser() {
        WebDriverConfig.closeBrowser(driver);
    }
}
