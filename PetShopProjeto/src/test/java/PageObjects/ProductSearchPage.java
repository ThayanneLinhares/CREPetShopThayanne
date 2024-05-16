package PageObjects;



import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchPage {
	private final WebDriver driver;
	private WebElement waitProduct;

	private final By elementSearchInput = By.xpath("//input[@name='keyword']");
	private final By elementSearchResult = By.cssSelector("tbody tr:nth-child(3) td:nth-child(1) a:nth-child(1)");

	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchProduct(String product) {

		// --------- SEARCH for product and ENTER ---------
		waitProduct = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementSearchInput));
		waitProduct.clear();
		waitProduct.sendKeys(product);
		waitProduct.sendKeys(Keys.ENTER);

		// --------- VERIFY that product found is the same as the INPUT ---------
		waitProduct = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.visibilityOfElementLocated(elementSearchResult));
		Assert.assertTrue(waitProduct.getText().contains(product));
		System.out.println("O produto encontrado é: " + product);
	}

	public void clickSearchResult() {
		waitProduct = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementSearchResult));
		waitProduct.click();
	}

}

