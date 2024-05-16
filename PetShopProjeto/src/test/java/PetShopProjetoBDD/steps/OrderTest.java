package PetShopProjetoBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import Helpers.ProductManager;
import PageObjects.AddToCartPage;

import PageObjects.LoginPage;
import PageObjects.OrderCompletedPage;
import PageObjects.OrderFormPage;

import PageObjects.ProductSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTest {
	WebDriver driver;
	LoginPage loginPage;
	OrderFormPage orderFormPage;
	AddToCartPage addToCartPage;
	OrderCompletedPage orderCompletedPage;
	ProductSearchPage productSearchPage;
	String selectedProduct = "Large Angelfish";
	ProductManager productManager;

	@Given("I am logged and able to search a product using {string}")
	public void i_am_logged_and_able_to_search_a_product_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		loginPage = new LoginPage(driver);
		addToCartPage = new AddToCartPage(driver);
		orderFormPage = new OrderFormPage(driver);
		productSearchPage = new ProductSearchPage(driver);
		productManager = new ProductManager(driver);
	    orderCompletedPage = new OrderCompletedPage(driver); 

		driver.get(
				"https://petstore.octoperf.com/actions/Account.action;jsessionid=F7FA4F107DBE97B29BCEB0F877DD17F4?signonForm=");

		loginPage.fillUserNameAndPassword("bejasec", "AMOR2328*");
		loginPage.clickToLoginButton();
		productSearchPage.searchProduct("fish");
		productSearchPage.clickSearchResult();
		productManager.verifySearchResult();
	}

	@When("I add the product to the shopping cart")
	public void i_add_the_product_to_the_shopping_cart() {
		addToCartPage.clickAddToCartButton();
	}

	@And("I proceed to checkout from the shopping cart")
	public void i_proceed_to_checkout_from_the_shopping_cart() {
		addToCartPage.clickToProceedToCheckOut();
	}

	@Then("I fill the form and confirm the order")
	public void i_fill_the_form_and_confirm_the_order() {
		orderFormPage.insertCardInfo(Helper.generateRandomVisaNumber(), Helper.generateRandomExpiryDate());
		orderFormPage.enterbillToFirstName("John");
		orderFormPage.enterbillToLastName("Doe");
		orderFormPage.enterbillAddress1("123 Main St");
		orderFormPage.enterbillAddress2("Apt 101");
		orderFormPage.enterbillCity("Anytown");
		orderFormPage.enterbillState("CA");
		orderFormPage.enterbillZip("12345");
		orderFormPage.enterbillCountry("USA");
		orderFormPage.clickContinueButton();
		orderCompletedPage.pressConfirmOrder();
	}
		
		
		


	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
