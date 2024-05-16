package PageObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddToCartPage {
    private WebDriver driver;
    private final By elementProceedToCheckOut = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    
    private final By addToCartButton = By.cssSelector("tbody tr:nth-child(2) td:nth-child(5) a:nth-child(1)");
	private final By elementCartTitle = By.xpath("//h2[normalize-space()='Shopping Cart']");

	
	private WebElement waitCart;

    
    private WebElement searchField;
    private WebElement searchButton;
    private WebElement selectProduct;
    private WebElement itemProduct;
    private WebElement productNameElement;
    private WebElement addToCart;

    private final By searchElement = By.xpath("//input[@name='keyword']");
    private final By searchButtonElement = By.name("searchProducts");
    private final By selectIdProduct = By.xpath("//td[normalize-space()='Salt Water fish from Australia']");
    private final By itemIdProduct = By.xpath("//a[normalize-space()='EST-1']");
    private final By productName = By.xpath("//font[contains(text(),'Large')]");
    
  
 
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterSearchKeyword(String keyword) {
        searchField = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(searchElement));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    
    public void clickSearchButton() {
        searchButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchButtonElement));
        searchButton.click();
    }
    
    public void selectProduct() {
        selectProduct = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectIdProduct));
        selectProduct.click();
    }
      
    
    public void clickOnProduct() {
        itemProduct = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(itemIdProduct));
        itemProduct.click();
    }
    
    public void confirmAnimalDetails(String expectedProductName) {
    	productNameElement = driver.findElement(productName);
        String productName = productNameElement.getText();
        Assert.assertTrue("Product name contains 'Large Angelfish'", productName.contains(expectedProductName));
    
    }

	public void clickAddToCartButton() {
		addToCart = new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCart.click();
    }


	public void verifyCartTitle() {
		waitCart = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(elementCartTitle));

		String cartText = waitCart.getText();
		Assert.assertTrue(cartText.contains("Shopping Cart"));
		System.out.println("O titulo da página é: " + cartText);
	}
	
	
    public void clickToProceedToCheckOut() {
        driver.findElement(elementProceedToCheckOut).click();
    }

}



