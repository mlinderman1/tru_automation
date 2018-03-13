package com.toysrus.automation.steps.header;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Header__GlobalNav__ShopBy extends AbstractPage_StepDefs {

	public static class Selectors {
		public static final String shopbymenu = ".header-fat__tile__text";
		public static final String container_shopbymenu_column = ".shop-by-menu__taxonomy__column-container";
		public static final String parent_menu_options = ".shop-by-menu__taxonomy__column-container>a";
		public static final String child_menu_options = "(//div[@class='shop-by-menu__taxonomy__column-container'])[2]/descendant::a";
		public static final String grandchild_menu_options = "(//div[@class='shop-by-menu__taxonomy__column-container'])[3]/child::*";
		public static final String plp_header = ".page-title.webstore-plp-page__page-title";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	public static String txt_parent_option, txt_child_option, txt_grand_child_option;
	Actions action = new Actions(driver);

	@When("^the user clicks on Shop By menu$")
	public void clickOnShopByMenu() throws Throwable {

		try {
			driver.findElement(By.cssSelector(Selectors.shopbymenu)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^the user is on family landing category options$")
	public void theUserIsOnFamilyLandingGrid() throws Throwable {
		try {
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.cssSelector(Selectors.container_shopbymenu_column)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^the user goes through family landing category options$")
	public void theUserSelectsOptions() throws Throwable {

		try {
			List<WebElement> parent_menu_options_list = driver
					.findElements(By.cssSelector(Selectors.parent_menu_options));
			Random randparent = new Random();
			int parent_option = randparent.nextInt(parent_menu_options_list.size());
			txt_parent_option = parent_menu_options_list.get(14).getText();
			parent_menu_options_list.get(parent_option).click();

			List<WebElement> child_menu_options_list = driver.findElements(By.xpath(Selectors.child_menu_options));
			Random randchild = new Random();
			int child_option = randchild.nextInt(child_menu_options_list.size() - 1) + 1;
			txt_child_option = child_menu_options_list.get(child_option).getText();

			if (child_menu_options_list.get(child_option).getAttribute("href").contains("#")) {
				child_menu_options_list.get(child_option).click();

				List<WebElement> grandchild_menu_options_list = driver
						.findElements(By.xpath(Selectors.grandchild_menu_options));
				Random rand_grandchild = new Random();
				int grandchild_option = rand_grandchild.nextInt(grandchild_menu_options_list.size() - 1) + 1;
				txt_grand_child_option = grandchild_menu_options_list.get(grandchild_option).getText();
				grandchild_menu_options_list.get(grandchild_option).click();
			} else {
				child_menu_options_list.get(child_option).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^items of selected option displays$")
	public void verifySelectedOptionItemsDisplayed() throws Throwable {
		// it depends on theUserSelectsSubCategoryOption() method's variable values
		try {
			String txt_category = driver.findElement(By.cssSelector(Selectors.plp_header)).getText();

			if (txt_grand_child_option != null) 
				Assert.assertEquals(true, txt_category.contains(txt_grand_child_option));	
			else 
				Assert.assertEquals(true, txt_category.contains(txt_child_option));

			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}