package base_configs;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser;
		this.log = log;
	}
	
	public WebDriver createDriver() {
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "D:\\eclipse ide\\eclipse projects\\advance_selenium\\advanced-selenium-webdriver\\BEGINNING\\advanced-selenium-webdriver\\src\\main\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();			
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "D:\\eclipse ide\\eclipse projects\\advance_selenium\\advanced-selenium-webdriver\\BEGINNING\\advanced-selenium-webdriver\\src\\main\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;

		default:
			log.info("Do not know how to start: " + browser + ", starting chrome.");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}
		return driver.get();
		
	}
	
	

}
