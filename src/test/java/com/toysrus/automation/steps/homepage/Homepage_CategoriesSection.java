package com.toysrus.automation.steps.homepage;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Homepage_CategoriesSection extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String pdp_title = "h1.product-item__product-title.pdp-header__title";

		public String getItemsLocator(String loc) {
			return "//h3[text()='"+loc+"']/following-sibling::div/descendant::div[@class='product-item__product-title']";
		}

		public String getLeftCarouselLocator(String loc) {
			return "//h3[text()='"+loc+"']/following-sibling::div/child::div/button[2]";
		}
		public String getRightCarouselLocator(String loc) {
			return "//h3[text()='"+loc+"']/following-sibling::div/child::div/button[1]";
		}
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Random rand = new Random();
	Selectors selector = new Selectors();
	int n;
	public static String txt_item;

	@When("^the user clicks on an item from \"([^\"]*)\"$")
	public void clickOnItem(String locator_txt) throws Throwable {
		List<WebElement> items_list = driver.findElements(By.xpath(selector.getItemsLocator(locator_txt)));
		System.out.println(locator_txt);
		int n = rand.nextInt(items_list.size());
		txt_item = items_list.get(n).getAttribute("title");
		while (!items_list.get(n).isDisplayed()) {
			driver.findElement(By.xpath(selector.getLeftCarouselLocator(locator_txt))).click();
			Thread.sleep(6000);
		}
		items_list.get(n).click();
	}

	@Then("^selected items PDP page displays$")
	public void verifyItemDisplayed() throws Throwable {
		// this method depends on clickOnItem(String) method for the txt_item variable value
		String pdp_title = driver.findElement(By.cssSelector(selector.pdp_title)).getAttribute("title");
		Assert.assertEquals(true, txt_item.contains(pdp_title));

	}
}