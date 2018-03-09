package com.toysrus.automation.steps.clp;

import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Category_Common extends AbstractPage_StepDefs {

	public class Selectors {

		public String getCategoryLocator(String category) {
			return "//h1[text()='" + category + "']";
		}
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();

	@Then("^the user is on \"([^\"]*)\" page$")
	public void verifyShopByMenuButton(String categoryName) throws Exception {
		try {
			String categoryLocator = selector.getCategoryLocator(categoryName);

			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath(categoryLocator)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}