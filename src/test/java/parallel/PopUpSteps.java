package parallel;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.actions.Price_HomePageActions;
import pages.locators.Price_HomePageLocators;

public class PopUpSteps {
	
	Price_HomePageActions price_HomePageActions = new Price_HomePageActions();
	
	public void navigateToPriceURL()
	{
		DriverFactory.getDriver().get("https://price.com/");
	}
	
	@Given("As a normal user in Price.com")
	public void as_a_normal_user_in_price_com() {
	    navigateToPriceURL();
	}

	@When("I click on login menu tab")
	public void i_click_on_login_menu_tab() {
		price_HomePageActions.clickOnLoginButton();
	}

	@Then("Login popup window enabled")
	public void login_popup_window_enabled() {
	    price_HomePageActions.popupWindowEnabled();
	}

	@Then("Enter {string} in email field")
	public void enter_in_email_field(String email) {
		price_HomePageActions.enterEmail(email);
	}

	@Then("Enter {string} in password field")
	public void enter_in_password_field(String password) {
		price_HomePageActions.enterPassword(password);
	}

	@Then("Select SignIn button")
	public void select_sign_in_button() {
		price_HomePageActions.clickOnSignInButton();
	}

	@Then("Home page visible with login situation")
	public void home_page_visible_with_login_situation() {
	    boolean actualResult = price_HomePageActions.successfullLogin();
	    boolean expectedResult = true;
	    System.out.println("-------------"+actualResult);
	    Assert.assertEquals(actualResult, expectedResult);
	}

}
