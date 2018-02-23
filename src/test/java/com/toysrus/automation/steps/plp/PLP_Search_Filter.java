package com.toysrus.automation.steps.plp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PLP_Search_Filter extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String category_filter = "//span[text()='category']";
		public static final String category_top_rated = "//span[(text()='Top Rated')]";
		public static final String selected_category_top_rated = "//div[text()='category: Cooking for Kids']";
		public static final String btn__add_to_cart = "//button/span[text()='add to cart']";
		public static final String search_close = ".filter-tags__tag__close";
		public static final String plp_select_item = "(//*[@class='product-item__product-title']/span)[1]";
		public static final String menu_shop_by = "a.header-fat__tile.header-fat__tile-shop-by > svg.tru-icon.tru-icon__closed > use";
		
	}

	WebElement element;
	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();
	Overlay__LightBox lightBox = new Overlay__LightBox();
	String siteURL = null;

	@When("^the user navigates by Menu \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\"sub menu option$")
	public void navigateToSpecificMenu(String menu_option, String sub_option,
			String sub_sub_option) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector(Selectors.menu_shop_by)).click();
		driver.findElement(
				By.xpath("//span[contains(text(),'" + menu_option + "')]"))
				.click();
		driver.findElement(
				By.xpath("(//a[@class='shop-by-menu__taxonomy__row']/span[contains(text(),'"
						+ sub_option + "')])[1]")).click();
		driver.findElement(
				By.xpath("(//a[@class='shop-by-menu__taxonomy-link']/span[contains(text(),'"
						+ sub_sub_option + "')])[1]")).click();

	}

	@When("^user select a category filter \"([^\"]*)\"$")
	public void selectCategoryFilter(String category_selected) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(Selectors.category_filter)).click();
		driver.findElement(
				By.xpath("//span[text()='" + category_selected + "']")).click();
	}

	@Then("^check the its filterd accordingly by \"([^\"]*)\"$")
	public void checkAppliedFilter(String category_selected) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.presenceOfElementLocated(By
						.xpath(Selectors.plp_select_item))).isDisplayed();
		element = new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[text()='category: "
						+ category_selected + "']")));
		if (element.isDisplayed()) {
			System.out.println("Its filtered sucessfully");
		} else {
			System.out.println("Its not filtered base on selection");
		}

	}

	@Then("^remove the filter applied on \"([^\"]*)\"$")
	public void removeFilter(String category_selected) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(
				By.xpath("//div[text()='category: " + category_selected + "']"))
				.click();
		// new WebDriverWait(driver,
		// 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Selectors.selected_category_top_rated)));
		// invisibilityOfTheElementLocated
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.invisibilityOfElementLocated(By
						.xpath("//div[text()='category: " + category_selected
								+ "']")));
		System.out.println("Filter removed sucessfully");

	}
}