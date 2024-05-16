package PetShopProjetoBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import PageObjects.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {

	WebDriver driver;
	RegistrationPage registrationPage;

	@Given("I am on the registration page using {string}")
	public void i_am_on_the_registration_page_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		registrationPage = new RegistrationPage(driver);
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		Helper.takeScreenshot(driver, "tiraprint");

	}

	@When("I enter valid credentials to register")
	public void i_enter_valid_credentials_to_register() {
		// Gerar um endereço de e-mail único e um ID de usuário único
		String email = Helper.generateUniqueEmail();
		String randomUserID = Helper.generateRandomIDString(5);

		registrationPage.fillUsername(randomUserID);
		registrationPage.fillPassword("AMOR2328*");
		registrationPage.fillRepeatPassword("AMOR2328*");
		registrationPage.fillFirstName("Amora");
		registrationPage.fillLastName("Esteves");
		registrationPage.fillEmail(email);
		registrationPage.fillPhone("1234567890");
		registrationPage.fillAddress1("123 Main St");
		registrationPage.fillAddress2("Apt 101");
		registrationPage.fillCity("Anytown");
		registrationPage.fillState("CA");
		registrationPage.fillZip("12345");
		registrationPage.fillCountry("USA");

		// Esperar por um curto período de tempo (opcional)
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("I click the save account button and I should be registered successfully")
	public void i_click_the_save_account_button() {
		registrationPage.clickToSaveAccountButton();

		try {
			Thread.sleep(10000); // Wait for 10 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
