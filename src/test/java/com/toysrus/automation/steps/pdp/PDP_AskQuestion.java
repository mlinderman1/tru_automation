package com.toysrus.automation.steps.pdp;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import com.toysrus.automation.steps.pdp.PDP_WriteaReview.Selectors;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDP_AskQuestion extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String btn_ask_q = "//span[contains(text(), 'ask a question')]";
		public static final String option_compatibility = "//*[contains(text(),'Compatibility')]";
		public static final String txt_question = "//*[@id='questionText']";
		public static final String txt_email = "//*[@id='authorEmail-input']";
		public static final String txt_name = "//*[@id='authorName-input']";
		public static final String txt_loc = "//*[@id='authorLocation-input']";
		public static final String btn_submit = "//*[contains(text(),'Submit')]";
		public static final String txt_acknowledge = "//*[contains(text(),'Thank you for submitting your question')]";
		public static final String header = "//*[@id='pr-waqwaa-header']";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Overlay__LightBox lightBox = new Overlay__LightBox();
	String siteURL = null;

	@When("^click on Ask a Question button$")
	public void Search_a_Product_and_Click_on_Ask_a_Question_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(Selectors.btn_ask_q)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^New Ask a Question window opens$")
	public void New_Ask_a_Question_window_opens() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			Set<String> windows = driver.getWindowHandles();
			for (String string : windows) {
				driver.switchTo().window(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Enter Query and Submit$")
	public void Enter_Query_and_Submit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(8000);
			WebElement page = driver.findElement(By.xpath(Selectors.header));
			System.out.println(page.getText() + " **Window Available**");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Selectors.option_compatibility)).click();
			driver.findElement(By.xpath(Selectors.txt_question)).sendKeys("How to use");
			driver.findElement(By.xpath(Selectors.txt_email)).sendKeys("test123@123.com");
			driver.findElement(By.xpath(Selectors.txt_name)).sendKeys("Tom");
			driver.findElement(By.xpath(Selectors.txt_loc)).sendKeys("New York");

			driver.findElement(By.xpath(Selectors.btn_submit)).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			org.junit.Assert.assertEquals(true, driver.findElement(By.xpath(Selectors.txt_acknowledge)).isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}