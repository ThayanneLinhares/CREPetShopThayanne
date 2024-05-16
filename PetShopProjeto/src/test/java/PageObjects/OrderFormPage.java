package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderFormPage {

	private WebDriver driver;
	private WebElement waitOrder;
	
	private final By elementButtonCheckout = By
			.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)");
	private final By cardNumberField = By.xpath("//input[@name='order.creditCard']");
	private final By expiryDateField = By.xpath("//input[@name='order.expiryDate']");
	private final By billToFirstName = By.xpath("//input[@name='order.billToFirstName']");
	private final By billToLastName = By.xpath("//input[@name='order.billToLastName']");
	private final By billAddress1 = By.name("order.billAddress1");
	private final By billAddress2 = By.name("order.billAddress2");
	private final By billCity = By.xpath("//input[@name='order.billCity']");
	private final By billState = By.name("order.billState");
	private final By billZip = By.name("order.billZip");
	private final By billCountry = By.name("order.billCountry");
	private final By continueButton = By.xpath("//input[@name='newOrder']");

	public OrderFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void pressCheckout() {
		waitOrder = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementButtonCheckout));
		waitOrder.click();
	}

	public void insertCardInfo(String cardNum, String expiryDate) {
		waitOrder = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(cardNumberField));
		waitOrder.clear();
		waitOrder.sendKeys(cardNum);

		
		waitOrder = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(expiryDateField));
		waitOrder.clear();
		waitOrder.sendKeys(expiryDate);
	}
	
	
	public void enterbillToFirstName(String name) {
		driver.findElement(billToFirstName).sendKeys(name);

	}

	public void enterbillToLastName(String lastName) {
		driver.findElement(billToLastName).sendKeys(lastName);

	}

	public void enterbillAddress1(String billAdd1) {
		driver.findElement(billAddress1).sendKeys(billAdd1);

	}

	public void enterbillAddress2(String billAdd2) {
		driver.findElement(billAddress2).sendKeys(billAdd2);

	}

	public void enterbillCity(String cityBill) {
		driver.findElement(billCity).sendKeys(cityBill);

	}

	public void enterbillState(String stateBill) {
		driver.findElement(billState).sendKeys(stateBill);

	}

	public void enterbillZip(String zipBill) {
		driver.findElement(billZip).sendKeys(zipBill);

	}

	public void enterbillCountry(String countryBill) {
		driver.findElement(billCountry).sendKeys(countryBill);

	}

	public void clickContinueButton() {
		driver.findElement(continueButton).click();

	}
}