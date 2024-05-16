package Helpers;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductManager {
	private final WebDriver driver;
	private WebElement waitProductInfo;

	String itemDescription, itemPrice, productID, itemID;

	// --------- LOCATORS product DETAILS after SEARCH ---------
	private final By elemenentProductID = By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)");
	private final By elemenentProductDescription = By.cssSelector("tbody tr:nth-child(2) td:nth-child(3)");
	private final By elementProductPrice = By.cssSelector("tbody tr:nth-child(2) td:nth-child(4)");
	
	// --------- LOCATORS product CART ---------
	private final By elementDescriptionCart = By.cssSelector("tbody tr td:nth-child(3)");
	private final By elementPriceCart = By.cssSelector("tbody tr td:nth-child(6)");
	private final By elementItemIDCart = By.cssSelector("tbody tr:nth-child(2) td:nth-child(1)");
	
	// --------- LOCATORS products in ORDER CONFIRMATION ---------
	private final By elementOrderID= By.cssSelector("tbody tr:nth-child(2) td:nth-child(1)");

	public ProductManager(WebDriver driver) {
		this.driver = driver;
	}

	public void verifySearchResult() {
		waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elemenentProductDescription));
		itemDescription = waitProductInfo.getText();

		waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementProductPrice));
		itemPrice = waitProductInfo.getText();

		waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elemenentProductID));
		productID = waitProductInfo.getText();

		// --------- VERIFY that the product ID is on the url to assert correct result
		String currentUrl = driver.getCurrentUrl();
		if (!currentUrl.contains(productID)) {
			throw new IllegalStateException("Expected URL to contain item ID '" + productID + "', but it did not.");
		}
	}
	
	public void verifyCartItem() {
		waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.elementToBeClickable(elementDescriptionCart));
		
			String actualProductCart = waitProductInfo.getText();
			Assert.assertEquals(itemDescription, actualProductCart );
			System.out.println("A descrição do produto no carrinho é: " + actualProductCart);
				
			
			waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.elementToBeClickable(elementPriceCart));
			
			String actualProductPriceCart = waitProductInfo.getText();
			Assert.assertEquals(itemPrice, actualProductPriceCart);
			System.out.println("O preço do produto no carrinho é: " + actualProductPriceCart);
			
			waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.elementToBeClickable(elementItemIDCart));
			itemID = waitProductInfo.getText();
		}
	
	public void verifyOrderedItem() {
		
		waitProductInfo = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementOrderID));
	
		String actualProductOrder = waitProductInfo.getText();
		Assert.assertEquals(itemID, actualProductOrder );
		System.out.println("O ID do produto na encomenda é: " + actualProductOrder);		
	}


}
