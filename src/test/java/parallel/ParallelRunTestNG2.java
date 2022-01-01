package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;


public class ParallelRunTestNG2 {
	
	public String launchBrowser4(String browser) {
		String browser2 = browser;
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%browser value is: " + browser);
		return browser;
	};
	
	
	
	@CucumberOptions(
			plugin = {"pretty",				
					//"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
					//"junit:target/cucumber-reports/cucumber.xml",
//					"json:target/cucumber/report.json","html:target/cucumber/report.html",
//					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/",
					"rerun:target/failedrerun.txt"
					},
			tags = "@GB or @FB or @Edge", 
//			tags = "@GB",
//			tags = "@GB",
			monochrome = true,
			glue = { "parallel" },
//			glue = { "testrunners" },
			features = { "src/test/resources/FeatureFiles/Suite2" }
			)
	public class PositiveTest extends AbstractTestNGCucumberTests {
		
		//String bro;
		
		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}

		/**
		 * https://www.lambdatest.com/support/docs/running-cucumber-scripts-with-testng-and-selenium/
		 * 
		 * https://stackoverflow.com/questions/55808880/how-to-pass-testng-parameter-into-cucumber
		 */
		
		@BeforeMethod(alwaysRun = true)
		@Parameters({"browser"})		
		public void launchBrowser2(String browser) {
			
			System.out.println("+++++++++++++++++++++++++browser value is: " + browser);
			launchBrowser4(browser);
			Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

		}
		


		
//		public DriverFactory driverFactory;
//		public WebDriver driver;
//		public ConfigReader configReader;
//		Properties prop;
//	
//
//		@BeforeMethod(alwaysRun = true)
//		@Parameters({"browser"})		
//		public void launchBrowser(String browser) {
//			
//			System.out.println("+++++++++++++++++++++++++browser value is: " + browser);
//
//			if (browser.equals("chrome")) {
//				
//				/**
//				 * Run at Local Machine
//				 */
//				driverFactory = new DriverFactory();
//				driver = driverFactory.init_driver(browser);
//				
//				/**
//				 * Run at Remote (AWS)
//				 */
////				DesiredCapabilities cap = new DesiredCapabilities();
////				cap.setCapability("browserName", "chrome");
////				try {
////					driver = new RemoteWebDriver(new URL("http://13.233.157.149:4444/wd/hub"), cap);
////				} catch (MalformedURLException e) {
////					e.printStackTrace();
////				}
//				
//			} else if (browser.equals("firefox")) {
//				
//				/**
//				 * Run at Local Machine
//				 */
//				driverFactory = new DriverFactory();
////				driver = driverFactory.init_driver(browserName);
//				driver = driverFactory.init_driver(browser);
//
//				
//				/**
//				 * Run at Remote (AWS)
//				 */
//				
//				
////				https://www.browserstack.com/guide/geckodriver-vs-marionette
//				
////				DesiredCapabilities cap = new DesiredCapabilities();
////				cap.setCapability("browserName", "firefox");		
////				try {
////					driver = new RemoteWebDriver(new URL("http://13.233.157.149:4444/wd/hub"), cap);
////				} catch (MalformedURLException e) {
////					e.printStackTrace();
////				}
//			} else if (browser.equals("safari")) {
//				
//			} else if (browser.equals("edge")) {
//				
////				String browserName = "edge";
//				/**
//				 * Run at Local Machine
//				 */
//				driverFactory = new DriverFactory();
//				driver = driverFactory.init_driver(browser);	
//		
////				
////				/**
////				 * Run at Remote (AWS)
////				 */
//		//
////				
//			}
//			else {
//				System.out.println("Please pass the correct browser value: " + browser);
//			}
//			
//			
//			
////			System.out.println("+++++++++++++++++++++++++"+browser+"+++++++++++++++++++++++++++++");
////			String browserName = "firefox";
////			/**
////			 * Run at Local Machine
////			 */
////			driverFactory = new DriverFactory();
//////			driver = driverFactory.init_driver(browserName);
////			driver = driverFactory.init_driver(browser);
////
////			
////			/**
////			 * Run at Remote (AWS)
////			 */
////			
////			
//////			https://www.browserstack.com/guide/geckodriver-vs-marionette
////			
//////			DesiredCapabilities cap = new DesiredCapabilities();
//////			cap.setCapability("browserName", "firefox");		
//////			try {
//////				driver = new RemoteWebDriver(new URL("http://13.233.157.149:4444/wd/hub"), cap);
//////			} catch (MalformedURLException e) {
//////				e.printStackTrace();
//////			}
//			
//		}
		

		
		
	
		


			
		

	}


}
