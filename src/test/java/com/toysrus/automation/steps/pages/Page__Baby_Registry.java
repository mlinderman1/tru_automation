package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page__Baby_Registry extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String babyregistry_findbutton = "input[id=findbutton]";
		public static final String babyregistry_managebutton = "#signinbtn";
		public static final String babyregistry_createbutton = ".btn-bru.hidden-xs";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Selectors selector = new Selectors();

	@Then("^The user verifies the 'Find' link$")
	public void theuserverifiestheFindlink() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector.babyregistry_findbutton)));
		WebElement findbutton = driver.findElement(By.cssSelector(selector.babyregistry_findbutton));
		System.out.println("Find button displayed : " + findbutton.isEnabled());

	}

	@Then("^The user verifies the 'Create' link$")
	public void theuserverifiestheCreatelink() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector.babyregistry_createbutton)));
		WebElement createbutton = driver.findElement(By.cssSelector(selector.babyregistry_createbutton));
		System.out.println("create button displayed : " + createbutton.isEnabled());

	}

	@Then("^The user verifies the 'Manage' Link$")
	public void theuserverifiestheManageLink() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector.babyregistry_managebutton)));
		WebElement managebutton = driver.findElement(By.cssSelector(selector.babyregistry_managebutton));
		System.out.println("Manage button displayed : " + managebutton.isEnabled());

	}

}
