package com.toysrus.automation.steps.pdp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PDP_AddToCart_FromCollections_Steps extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String bru_logo = "//span[contains(@class,'top-line-header__logo-img')]";
		public static final String menu_shop_by = ".header-fat__tile.header-fat__tile-shop-by";
		public static final String btn_view_details = "(//a[contains(@id,'ViewDetails')])[1]";
		public static final String lbl_choose_items = "//h2[text()='choose your items']";
		public static final String btn_add_to_cart = "(//button[contains(text(),'add to cart')])[1]";
		public static final String btn_view_cart_checkout = "//*[contains(text(),'view cart & checkout')]";
		public static final String lbl_cart_subtotal = "//*[contains(text(),'Your cart subtotal')]";
	}

	WebElement element;
	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();
	Overlay__LightBox lightBox = new Overlay__LightBox();
	String siteURL = null;

	Actions actions;

	/*@Given("^the user click on Babiesrus Logo$")
	public void bruLogo() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(Selectors.bru_logo)).click();
	}*/

	@Then("^view the product details$")
	public void viewProdDetails() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath(Selectors.btn_view_details))
					.isDisplayed())
				System.out.println("Verified collections items search");
			driver.findElement(By.xpath(Selectors.btn_view_details)).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^click on Add to Cart$")
	public void clickOnAddToCartBtn() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			actions = new Actions(driver);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			actions.moveToElement(
					driver.findElement(By.xpath(Selectors.lbl_choose_items)))
					.perform();
			driver.findElement(By.xpath(Selectors.btn_add_to_cart)).click();
			Thread.sleep(9000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^check it in shopping cart$")
	public void checkShoppingCart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			new WebDriverWait(driver, 10).until(
					ExpectedConditions.presenceOfElementLocated(By
							.xpath(Selectors.btn_view_cart_checkout)))
					.isDisplayed();
			driver.findElement(By.xpath(Selectors.btn_view_cart_checkout))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (driver.findElement(By.xpath(Selectors.lbl_cart_subtotal))
				.isDisplayed()) {
			System.out.println("Verified Collecions item add to cart");
		}
	}
}