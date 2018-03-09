package com.toysrus.automation.steps.header;

import java.util.ArrayList;
import java.util.List;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header__GlobalNav__ShopBy extends AbstractPage_StepDefs {

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();

	public class Selectors {
		public final String btn__global_shopByMenu = ".header-fat__tile.header-fat__tile-shop-by";
		public final String btn__global_shopByMenu_categoryGrid = ".shop-by-menu__left-side-menu>li";

		public String getCategoryLoc(String category) {
			return "//*[@class='shop-by-menu__left-side-menu']//*[contains(text(),'"
					+ category + "')]";
		}
	}

	@Then("^the user verify Shop By menu displays$")
	public void verifyShopByMenuButton() throws Exception {
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.cssSelector(selector.btn__global_shopByMenu)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^the user clicks on 'Shop By menu' button$")
	public void clickShopByMenuButton() throws Exception {
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.cssSelector(selector.btn__global_shopByMenu)));

			driver.findElement(By.cssSelector(selector.btn__global_shopByMenu))
					.click();

		} catch (WebDriverException re) {

			try {
				Actions act = new Actions(driver);
				act.click(
						driver.findElement(By
								.cssSelector(selector.btn__global_shopByMenu)))
						.build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@And("^the user selects \"([^\"]*)\" category$")
	public void userClickOnMovieHQLink(String category) {
		try {

			String categoryLocator = selector.getCategoryLoc(category);

			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath(categoryLocator)));

			driver.findElement(By.xpath(categoryLocator)).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* Verifing all the Category Items */
	@And("^verify all the category list$")
	public void verifyAllCategoryLinks() {
		List<String> allLinks = Data.shop_ByMenu_categoryList();

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(selector.btn__global_shopByMenu_categoryGrid)));
		List<WebElement> linksLst = driver.findElements(By
				.cssSelector(selector.btn__global_shopByMenu_categoryGrid));
		for (WebElement linkName : linksLst) {
			Assert.assertEquals(true,
					allLinks.contains(linkName.getText().trim()));

		}
	}
}