	package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {
	public static WebDriver driver;

	public void setDriver() {
		if (getProperty("browser").equalsIgnoreCase("firefox")) {
			initFirefox();
		} else {
			// set deafult browser;
			initFirefox();
		}
		setDriverProperties();
	}

	public void initFirefox() {
		driver = new FirefoxDriver();
	}
	
	public void initChrome() {
		
		System.setProperty("webdriver.chrome.driver", "chrome driver path");
		
		
	}

	public void setDriverProperties() {
		driver.manage().window().maximize();
		driver.get(getProperty("appUrl"));
	}

}
