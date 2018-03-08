package com.toysrus.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.config.BrowserConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Header__GlobalNav__ShopBy {

	public class Selectors {
		public final String btn__global_shopByMenu = ".header-fat__tile.header-fat__tile-shop-by";

		public String getCategoryLoc(String category) {
			return "//*[@class='shop-by-menu__left-side-menu']//*[contains(text(),'"
					+ category + "')]";
		}
	}

	WebDriver driver = BrowserConfiguration.driver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();

	@Then("^the user verify Shop By menu displays$")
	public void verifyShopByMenuButton() throws Exception {
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.cssSelector(selector.btn__global_shopByMenu)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^user clicks on 'Shop By menu' button$")
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
}