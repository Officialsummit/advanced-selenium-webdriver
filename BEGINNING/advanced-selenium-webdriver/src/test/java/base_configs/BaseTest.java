package base_configs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseTest {

protected WebDriver driver;
protected Logger log;
	


	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true )
	public void setUp(@Optional("chrome") String browser, ITestContext context) {
		String testname = context.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testname);
		
		
		BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(browser,log);
		driver = browserDriverFactory.createDriver();		
		driver.manage().window().maximize();
	}


	@AfterMethod(alwaysRun = true )
	public  void tearDown() {
		log.info("Close driver");
		// Close browser
		driver.quit();
	}
	
	
}
