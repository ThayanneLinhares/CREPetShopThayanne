package PageObjects;

import java.time.Duration;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.Helper;

public class OrderCompletedPage {
	private WebElement waitOrder;

	private WebDriver driver;
	
	
	private final By elementButtonCheckout = By
			.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)");
	private final By elementCardNumber = By.xpath("//input[@name='order.creditCard']");
	private final By elementExpiryDate = By.xpath("//input[@name='order.expiryDate']");
	private final By elementContinueOrder = By.xpath("//input[@name='newOrder']");
	private final By elementConfirmOrder = By.xpath("//a[normalize-space()='Confirm']");
	




	public OrderCompletedPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyOrderUrl() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.urlContains("/actions/Order.action"));
		} catch (Exception e) {
			// Take a screenshot if assertion fails
			Helper.takeScreenshot(driver, "redirect_failureOrder");
			// Re-throw the exception to fail the test
			throw e;
		}
	}

	public void pressConfirmOrder() {
		waitOrder = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementConfirmOrder));
		waitOrder.click();
	}
	public void pressCheckout() {
		waitOrder = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementButtonCheckout));
		waitOrder.click();
	}


	public void pressContinueOrder() {
		waitOrder = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementContinueOrder));
		waitOrder.click();
	}

	
	public void assertUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("/Order.action?newOrder=&confirmed=true/"));

	}





}
