package factory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.microsoft.edge.seleniumtools.EdgeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ConfigReader;

public class DriverFactory {
	
public WebDriver driver;
private ConfigReader configReader;
Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {
		
		

		System.out.println("browser value is: " + browser);
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		


		if (browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver());
			
			String chromeDriverPath = prop.getProperty("chrome_driver_path");
            String path = System.getProperty("user.dir");

            System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
            System.out.println("initialized path");
//            System.setProperty("webdriver.edge.UseChromium", "true");



             ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("window-size=1200x600");
//            options.setHeadless(true);
//            options.addArguments("headless");
//            options.addArguments("disable-gpu");

            tlDriver.set(new ChromeDriver(options));
			
		} else if (browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDriver.set(new FirefoxDriver());
			
			String firefoxDriverPath = prop.getProperty("firefox_driver_path");
            String path = System.getProperty("user.dir");

            System.setProperty("webdriver.gecko.driver", path + firefoxDriverPath);
            System.out.println("initialized path");
//            System.setProperty("webdriver.edge.UseChromium", "true");



            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("marionette", true);
            
//            options.addArguments("--headless");
//            options.addArguments("window-size=1200x600");
//            options.setHeadless(true);
//            options.addArguments("headless");
//            options.addArguments("disable-gpu");

            tlDriver.set(new FirefoxDriver(options));
			

		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else if (browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
//			tlDriver.set(new EdgeDriver());
			
			String edgeDriverPath = prop.getProperty("edge_driver_path");
            String path = System.getProperty("user.dir");

            System.setProperty("webdriver.edge.driver", path + edgeDriverPath);
            System.out.println("initialized path");
//            System.setProperty("webdriver.edge.UseChromium", "true");



            EdgeOptions options = new EdgeOptions();
//            options.addArguments("--headless");
//            options.addArguments("window-size=1200x600");
//            options.setHeadless(true);
//            options.addArguments("headless");
//            options.addArguments("disable-gpu");

            tlDriver.set(new EdgeDriver(options));
            
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		/**
		 * Implicit Wait: •During Implicit wait if the Web Driver cannot find it
		 * immediately because of its availability, it will keep polling the DOM to get
		 * the element. •If the element is not available within the specified Time an
		 * NoSuchElementException will be raised. •The default setting is zero. •Once we
		 * set a time, the Web Driver waits for the period of the WebDriver object
		 * instance.
		 */
//		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}

