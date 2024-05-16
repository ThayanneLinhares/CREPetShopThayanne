package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class RegistrationPage {

    private  WebDriver driver;
    private final WebDriverWait wait;

    private final By elementUserID = By.xpath("//input[@name='username']");
    private final By elementPassword = By.xpath("//input[@name='password']");
    private final By elementRepeatPassword = By.xpath("//input[@name='repeatedPassword']");
    private final By elementFirstName = By.xpath("//input[@name='account.firstName']");
    private final By elementLastName = By.xpath("//input[@name='account.lastName']");
    private final By elementEmail = By.xpath("//input[@name='account.email']");
    private final By elementPhone = By.xpath("//input[@name='account.phone']");
    private final By elementAddress1 = By.xpath("//input[@name='account.address1']");
    private final By elementAddress2 = By.xpath("//input[@name='account.address2']");
    private final By elementCity = By.xpath("//input[@name='account.city']");
    private final By elementState = By.xpath("//input[@name='account.state']");
    private final By elementZip = By.xpath("//input[@name='account.zip']");
    private final By elementCountry = By.xpath("//input[@name='account.country']");
    private final By elementSaveAccountInformation = By.xpath("//input[@name='newAccount']");
 
    
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    }
    
    public String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        return RandomStringUtils.random(10, allowedChars) + "@example.com";
    }

    public void fillUsername(String username) {
        driver.findElement(elementUserID).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(elementPassword).sendKeys(password);
    }

    public void fillRepeatPassword(String repeatPassword) {
        driver.findElement(elementRepeatPassword).sendKeys(repeatPassword);
    }

    public void fillFirstName(String firstName) {
        driver.findElement(elementFirstName).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(elementLastName).sendKeys(lastName);
    }

    public void fillEmail(String email) {
        driver.findElement(elementEmail).sendKeys(email);
    }

    public void fillPhone(String phone) {
        driver.findElement(elementPhone).sendKeys(phone);
    }

    public void fillAddress1(String address1) {
        driver.findElement(elementAddress1).sendKeys(address1);
    }

    public void fillAddress2(String address2) {
        driver.findElement(elementAddress2).sendKeys(address2);
    }

    public void fillCity(String city) {
        driver.findElement(elementCity).sendKeys(city);
    }

    public void fillState(String state) {
        driver.findElement(elementState).sendKeys(state);
    }

    public void fillZip(String zip) {
        driver.findElement(elementZip).sendKeys(zip);
    }

    public void fillCountry(String country) {
        driver.findElement(elementCountry).sendKeys(country);
    }

  
    public void clickToSaveAccountButton() {
        WebElement waitRegister = wait.until(ExpectedConditions.elementToBeClickable(elementSaveAccountInformation));
        waitRegister.click();
        wait.until(ExpectedConditions.urlContains("/actions/Catalog.action"));
    }
    
 
	
}

