package PageObjects;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.Helper;

public class LoginPage {

	private final WebDriver driver;
	private final WebDriverWait wait;

	private final By elementUserName = By.name("username");
	private final By elementPassword = By.name("password");
	private final By elementLogin = By.cssSelector("input[value='Login']");

	private WebElement waitLoginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));

	}

	public void fillUserNameAndPassword(String username, String password) {

		WebElement waitLogin = wait.until(ExpectedConditions.elementToBeClickable(elementUserName));
		waitLogin.clear();
		waitLogin.sendKeys(username);

		waitLogin = wait.until(ExpectedConditions.elementToBeClickable(elementPassword));
		waitLogin.clear();
		waitLogin.sendKeys(password);

	}

	public void clickToLoginButton() {
		waitLoginButton = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementLogin));
		waitLoginButton.click();

	}

	public void verifyHomepage() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.urlContains("/actions/Catalog.action"));
		} catch (Exception e) {
			// Take a screenshot if assertion fails
			Helper.takeScreenshot(driver, "redirect_failureLogin");
			// Re-throw the exception to fail the test
			throw e;
		}
	}
}