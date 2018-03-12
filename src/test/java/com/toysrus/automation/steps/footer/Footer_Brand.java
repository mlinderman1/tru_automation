package com.toysrus.automation.steps.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.footer.Footer_Gray.Selectors;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class Footer_Brand extends AbstractPage_StepDefs {
	public class Selectors {

		public static final String brandline_footer = ".//*[@class='row footer-bottom']";
		public static final String brandline_flag = ".//div[1]/a[@class='footer-select-country__btn footer-select-country__flag footer-select-country__flag--usa']";
		public static final String country_header = ".//div[@class='tru-modal-dialog__header']";
		public static final String country_header_closer = ".//button[@class='tru-modal-dialog__close-btn']";

	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Selectors selector = new Selectors();
	Common_StepDefs common = new Common_StepDefs();

	@Then("^the user in Brand footer$")
	public void theuserinBrandfooter() throws Throwable {

		try {

			String cssSelector = selector.brandline_footer;
			common.scrollToWebElement(cssSelector);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.brandline_footer)));
			WebElement brandfooter = driver.findElement(By.xpath(selector.brandline_footer));
			wait.until(ExpectedConditions.elementToBeClickable(brandfooter));

			System.out.println("The user in:  " + brandfooter.getText());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("^the user clicks on 'countryflag'$")
	public void theuserclicksoncountryflag() throws Throwable {
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.brandline_flag)));
			WebElement brandfooter = driver.findElement(By.xpath(selector.brandline_flag));
			brandfooter.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("^the user verifies select your region popup$")
	public void theuserverifiesselectyourregionpopup() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.country_header)));
			WebElement countriesheader = driver.findElement(By.xpath(selector.country_header));

			System.out.println("select your country/region verified :" + countriesheader.isDisplayed());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("^the user closes dialogbox$")
	public void theuserclosesdialogbox() throws Throwable {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.country_header_closer)));
		WebElement countriesheader_closer = driver.findElement(By.xpath(selector.country_header_closer));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector.country_header_closer)));
		countriesheader_closer.click();

	}

}
