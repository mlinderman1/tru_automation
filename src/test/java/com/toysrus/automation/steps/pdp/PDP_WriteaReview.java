package com.toysrus.automation.steps.pdp;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PDP_WriteaReview extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String btn_write_review = "//span[contains(text(), 'write a review')]";
		public static final String rating = "//*[@id='pr-rating']/div/div[5]";
		public static final String txt_review_headline = "//*[@id='pr-headline-input']";
		public static final String txt_name = "//*[@id='pr-name-input']";
		public static final String txt_loc = "//*[@id='pr-location-input']";
		public static final String txt_comments = "//*[@id='pr-comments']";
		public static final String btn_submit_review = "//*[contains(text(),'Submit Review')]";
		public static final String txt_acknowledge = "//h1[contains(text(),'Thank you')]";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Overlay__LightBox lightBox = new Overlay__LightBox();
	String siteURL = null;

	@When("^write a Review button$")
	public void writeReview() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(10000);
		driver.findElement(By.xpath(Selectors.btn_write_review)).click();
	}

	@Then("^New Review window opens$")
	public void newReviewWindow() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Set<String> windows = driver.getWindowHandles();
		for (String string : windows) {
			driver.switchTo().window(string);
			System.out.println(string);
		}
	}

	@Then("^Enter Review and Submit$")
	public void submitReview() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(8000);
		WebElement page = driver.findElement(By
				.xpath("//*[@class='pr-header-required']"));
		System.out.println(page.getText() + " **Window Available** ");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Selectors.rating)).click();
		driver.findElement(By.xpath(Selectors.txt_review_headline)).sendKeys(
				"I would buy this product over again and again");
		driver.findElement(By.xpath(Selectors.txt_name)).sendKeys(
				"Toys R US test user");
		driver.findElement(By.xpath(Selectors.txt_loc)).sendKeys("New York");
		driver.findElement(By.xpath(Selectors.txt_comments)).sendKeys(
				"Its a GREAT product");

		driver.findElement(By.xpath(Selectors.btn_submit_review)).click();
		org.junit.Assert.assertEquals(true,
				driver.findElement(By.xpath(Selectors.txt_acknowledge))
						.isDisplayed());
		System.out.println("Review Submitted Sucessfully");

	}

}