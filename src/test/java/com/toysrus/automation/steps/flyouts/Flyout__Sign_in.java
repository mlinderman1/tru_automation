package com.toysrus.automation.steps.flyouts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;



public class Flyout__Sign_in extends AbstractPage_StepDefs {


	public static class Selectors {

		public static final String flyout__sign_in__side_panel = ".tru-side-panel__content.tru-side-panel__content--small";
		public static final String txt__flyout__sign_in__email = "#email-0";
		public static final String txt__flyout__sign_in__password = "#password-1";
		public static final String submit_btn__flyout__sign_in  = ".form-sign-in__actions > button:nth-child(1)";




	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Common_StepDefs common = new Common_StepDefs();



	@When("^the user enters the email \"([^\"]*)\" and password \"([^\"]*)\" from flyout$")
	public void the_user_enters_the_email_and_password_through_MiniCart(String email, String password) throws Throwable {

		try {

			inputLoginEmail(email);
			inputLoginPassword(password);

		}
		catch (Exception e) {

		}

	}

	private void inputLoginEmail(String email){

		String cssSelector = Selectors.txt__flyout__sign_in__email;
		common.inputField(cssSelector, email);

	}

	private void inputLoginPassword(String password){

		String cssSelector = Selectors.txt__flyout__sign_in__password;
		common.inputField(cssSelector, password);

	}

	@And("^the user submits the signIn button from flyout$")
	public void the_user_submits_the_signIn_button_from_flyout() throws Throwable {
		try{

			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Selectors.submit_btn__flyout__sign_in)));
			driver.findElement(By.cssSelector(Selectors.submit_btn__flyout__sign_in)).click();

		}catch(Exception e){
			System.out.println(e);
		}

	} 
}