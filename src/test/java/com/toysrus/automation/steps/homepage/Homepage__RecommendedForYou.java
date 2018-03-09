package com.toysrus.automation.steps.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Homepage__RecommendedForYou extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String homepage__RecommendedForYou = "//*[@class='tru-section-title tru-section-title--with-underline'][contains(text(),'recommended for you')]";
		public static final String homepage__RecommendedForYouItem1 = "(//*[contains(text(),'recommended for you')]/ancestor::div[1]//a[@class='product-item'])[1]";
		public static final String RecommendedForYou__rightarrow = "(//*[contains(text(),'recommended for you')])/following-sibling::div/descendant::button[2]";
		public static final String RecommendedForYou__leftarrow = "(//*[contains(text(),'recommended for you')])/following-sibling::div/descendant::button[1]";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Selectors selector = new Selectors();

	@Before
	public void setUp() {
		getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void breakDown() {
		closeDriver();
	}

	@And("^the user is on RecommendedForYou$")
	public void theUserIsOnRecommendedForYou() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.homepage__RecommendedForYou)));
		WebElement RecommendedForYou = driver.findElement(By.xpath(selector.homepage__RecommendedForYou));
		System.out.println("The user is in: " + RecommendedForYou.getText());

		if (driver.findElements(By.xpath(selector.homepage__RecommendedForYouItem1)).size() != 0) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}
	}

	@Then("^the user clicks on rightarrow$")
	public void theUserClicksOnRightArrow() throws Throwable {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.RecommendedForYou__rightarrow)));
			WebElement rightarrow = driver.findElement(By.xpath(selector.RecommendedForYou__rightarrow));
			Thread.sleep(3000);
			rightarrow.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^the user clicks on leftarrow$")
	public void theUserClicksOnLeftArrow() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.RecommendedForYou__leftarrow)));
			WebElement leftarrow = driver.findElement(By.xpath(selector.RecommendedForYou__leftarrow));
			leftarrow.click();
			Thread.sleep(3000);
			leftarrow.click();
			Thread.sleep(3000);
			leftarrow.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^the user clicks on product$")
	public void theUserClicksOnProduct() throws InterruptedException {
		try {
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(selector.homepage__RecommendedForYouItem1)));
			WebElement RecommendedForYouItem1 = driver.findElement(By.xpath(selector.homepage__RecommendedForYouItem1));
			Thread.sleep(3000);
			RecommendedForYouItem1.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
