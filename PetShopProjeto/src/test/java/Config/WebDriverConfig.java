package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverConfig {

	public static WebDriver driver;

	public static WebDriver startBrowser(String browser) {

		if (driver == null) {
			{
				switch (browser.toLowerCase()) {
				case "chrome":
					// Configuring the path for ChromeDriver (Linux)
					//String chromeDriverPath = "drivers/chromedriver.exe";
					// Setting the property for the ChromeDriver path
					//System.setProperty("webdriver.chrome.driver", chromeDriverPath);
					// Initializing the WebDriver for Chrome
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					// Configuring the path for GeckoDriver (Linux)
					//String geckoDriverPath = "drivers/geckodriver.exe";
					// Setting the property for the GeckoDriver path
					//System.setProperty("webdriver.gecko.driver", geckoDriverPath);
					// Initializing the WebDriver for Firefox
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					// Configuring the path for EdgeDriver (Linux)
					//String edgeDriverPath = "drivers/msedgedriver.exe";
					// Setting the property for the EdgeDriver path
					//System.setProperty("webdriver.edge.driver", edgeDriverPath);
					// Initializing the WebDriver for Edge
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "safari":
					// SafariDriver does not require a path configuration
					// Initializing the WebDriver for Safari
					driver = new SafariDriver();
					break;
				default:
					throw new IllegalArgumentException("Unsupported browser: " + browser);
				}

			}

		}
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
	    if (driver != null) {
	        driver.quit();
	    }
	}


}