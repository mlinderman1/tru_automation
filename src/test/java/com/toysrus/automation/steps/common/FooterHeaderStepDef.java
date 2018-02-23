package com.toysrus.automation.steps.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;

public class FooterHeaderStepDef extends AbstractPage_StepDefs {
	public class Selectors {
		public static final String page = ".page-layout";
		public static final String t2page = ".navbar-top";

		public static final String findStoreTxt = "//span[text()='find a store']";
		public static final String weeklyAdTxt = "//span[text()='weekly ad']";
		public static final String giftCardTxt = "//a[@class='top-line-header__menu__item__link']/span[text()='gift cards']";
		public static final String yourOrderTxt = "//a[text()='your order']";
		public static final String giftServicesTxt = "//a[text()='gift services']";
		public static final String abtUsTxt = "//a[text()='about us']";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();

	@Then("^Verify Homepage Header body content$")
	public void verifyHomepageHeaderBody() {

		String actualFindAStore = "find a store";
		String actualWeeklyAd = "weekly ad";
		String actualGiftCards = "gift cards";

		String expectedFindAStore = driver.findElement(
				By.xpath(selector.findStoreTxt)).getText();
		if (expectedFindAStore.equalsIgnoreCase(actualFindAStore)) {
			Assert.assertEquals(actualFindAStore, expectedFindAStore);
		}

		String expectedWeeklyAd = driver.findElement(
				By.xpath(selector.weeklyAdTxt)).getText();
		if (expectedWeeklyAd.equalsIgnoreCase(actualWeeklyAd)) {
			Assert.assertEquals(actualWeeklyAd, expectedWeeklyAd);
		}

		String expectedGiftCards = driver.findElement(
				By.xpath(selector.giftCardTxt)).getText();

		if (expectedGiftCards.equalsIgnoreCase(actualGiftCards)) {
			Assert.assertEquals(actualGiftCards, expectedGiftCards);
		}

	}

	@Then("^Verify Homepage Footer body content$")
	public void verifyHomepageFooterBody() {

		String actualYourOrder = "your order";
		String actualGiftServices = "gift services";
		String actualAboutUs = "about us";

		String expectedYourOrder = driver.findElement(
				By.xpath(selector.yourOrderTxt)).getText();

		if (expectedYourOrder.equalsIgnoreCase(actualYourOrder)) {

			Assert.assertEquals(actualYourOrder, expectedYourOrder);
		}

		String expectedGiftServices = driver.findElement(
				By.xpath(selector.giftServicesTxt)).getText();

		if (expectedGiftServices.equalsIgnoreCase(actualGiftServices)) {

			Assert.assertEquals(actualGiftServices, expectedGiftServices);
		}

		String expectedAboutUs = driver
				.findElement(By.xpath(selector.abtUsTxt)).getText();

		if (expectedAboutUs.equalsIgnoreCase(actualAboutUs)) {

			Assert.assertEquals(actualAboutUs, expectedAboutUs);

		}

	}

}
