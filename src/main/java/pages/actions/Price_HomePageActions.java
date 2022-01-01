package pages.actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import pages.locators.Price_HomePageLocators;

public class Price_HomePageActions {
	
//	WebDriver driver = DriverFactory.getDriver();
	
	Price_HomePageLocators  price_HomePageLocators = null;
	public Price_HomePageActions()
	{
		this.price_HomePageLocators = new Price_HomePageLocators();
		PageFactory.initElements(DriverFactory.getDriver(), price_HomePageLocators);
	}
	
	public Price_AlertPageActions clickSetYourFirstAlertbutton()
	{
		Actions action= new Actions(DriverFactory.getDriver());
		action.moveToElement(price_HomePageLocators.setYourFirstAlertButton).perform();
		
		clickOnExplicitWait(DriverFactory.getDriver(), price_HomePageLocators.setYourFirstAlertButton, 5);
		
//		clickOnFluentWait(price_HomePageLocators.setYourFirstAlertButton);

		
		return new Price_AlertPageActions();
		
	}
	
	/**
	 * Explicit Wait:  
	•There can be instance when a particular element takes more than a minute to load.
	•In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser will going to wait for the same time for every element.
	•To avoid that situation you can simply put a separate time on the required element only.
	•By following this your browser implicit wait time would be short for every element and it would be large for specific element.
	 */
	public static void clickOnExplicitWait(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	/**
	 * FluentWait
	 * 
	 */
//	private static void clickOnFluentWait(WebElement element) {
//		Wait<WebDriver> fWait = new FluentWait<WebDriver>(DriverFactory.getDriver())
//				.withTimeout(30, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		element.click();		
//	}
	
	/**
	 * This method will make sure element is visible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
			int pollingEveryInMiliSec) {
		//log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		//log.info("element is visible now");
	}
	
	/**
	 * This will help us to get WebDriverWait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	/**
	 * This method will make sure invisibilityOf element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		//log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		//log.info("element is invisibile now");
		return status;
	}
	
	public void clickOnLoginButton()
	{
		clickOnExplicitWait(DriverFactory.getDriver(),price_HomePageLocators.loginButton, 30);
		
	}
	
	public void popupWindowEnabled()
	{
		WaitForElementVisibleWithPollingTime(price_HomePageLocators.email,60,5);
	}
	
	public void enterEmail(String email)
	{
		price_HomePageLocators.email.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		price_HomePageLocators.password.sendKeys(password);
	}
	
	public void clickOnSignInButton()
	{
		clickOnExplicitWait(DriverFactory.getDriver(),price_HomePageLocators.signInButton, 30);		
	}
	
	public boolean successfullLogin()
	{
		return waitForElementNotPresent(price_HomePageLocators.registerloginPanel,30);
	}
	
	

}
