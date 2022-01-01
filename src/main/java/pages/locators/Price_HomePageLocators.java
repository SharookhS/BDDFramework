package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Price_HomePageLocators {
	
	@FindBy(how = How.XPATH,using = "//h4[contains(text(),'Brooks')]")
	public WebElement cardContent;
	
	@FindBy(how = How.XPATH,using ="//*[contains(text(),'Set Your First Alert')]")
	public WebElement setYourFirstAlertButton;
	
	@FindBy(how = How.CLASS_NAME,using ="main-container__action--log-in")
	public WebElement loginButton;
	
	@FindBy(how = How.XPATH,using ="//*[@class='main-container__action'][contains(@style,'display: none')]")
	public WebElement registerloginPanel;
	
	@FindBy(how = How.ID,using = "email-register")
	public WebElement email;
	
	@FindBy(how = How.ID,using = "password")
	public WebElement password;
	
	@FindBy(how = How.XPATH,using ="//button[@type='submit' and contains(., 'Sign In')]")
	public WebElement signInButton;

}
