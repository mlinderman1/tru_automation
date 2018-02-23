package com.toysrus.automation.steps.overlays;

import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Overlay__AddToCart extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String overlay__add_to_cart = ".atc-overlay";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();

	@Then("^the Add to Cart overlay is displayed$")
	public void theAddToCartOverlayIsDisplayed() throws Throwable {
		try {
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//*[contains(text(),'view cart & checkout')]"))
					.click();
			Thread.sleep(5000);
			Assert.assertEquals(
					true,
					driver.findElement(
							By.xpath("//*[contains(text(),'Your cart subtotal')]"))
							.isDisplayed());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("^the user verifies if Add to Cart overlay is displayed$")
	public Boolean theUserVerifiesIfAddToCartOverlayIsDisplayed()
			throws Throwable {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.cssSelector(selector.overlay__add_to_cart)));
			WebElement overlay__add_to_cart = driver.findElement(By
					.cssSelector(selector.overlay__add_to_cart));

			if (overlay__add_to_cart.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@And("^the user waits for the Add to Cart overlay to not be displayed$")
	public void theUserWaitsForTheAddToCartOverlayToNotBeDisplayed()
			throws Throwable {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.cssSelector(selector.overlay__add_to_cart)));
	}
}
