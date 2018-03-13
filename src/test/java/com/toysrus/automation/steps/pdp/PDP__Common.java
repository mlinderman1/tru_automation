package com.toysrus.automation.steps.pdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDP__Common extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String container__page__pdp = ".pdp-page-container";
		public static final String link__pdp__ispu = ".product-ship-to-store__status-ispu a";
		public static final String page__footer = ".footer-group.footer-sitemap";
		public static final String product__name = ".line";
		public static final String product__price = ".pdp-header__price";
		public static final String product__qty = ".quantity-selector__inner";
		public static final String product__desc = ".//div[1]/div[1]/h3[@class='tru-section-title tru-section-title--with-lines'] ";
		public static final String product__feature = ".//div[2]/div[1]/h3[@class='tru-section-title tru-section-title--with-lines']";
		public static final String product_goodtoknow = ".//div[1]/div[2]/h3[@class='tru-section-title tru-section-title--with-lines']";
		public static final String additional_info = ".//div[2]/div[2]/h3[@class='tru-section-title tru-section-title--with-lines']";
		public static final String product_questions = ".//div[3]/div[1]/h3[@class='tru-section-title tru-section-title--with-lines']";
		public static final String product_customerreviewsummery = ".//div[3]/div[2]/h3[@class='tru-section-title tru-section-title--with-lines']";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Selectors selector = new Selectors();
	Overlay__LightBox lightBox = new Overlay__LightBox();

	@Given("^the user is on the PDP page$")
	public void theUserIsOnThePDPPage() throws Throwable {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__pdp)));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				lightBox.theUserClosesTheLightbox();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@When("^the user verifies in PDP if item is gift-eligible$")
	public Boolean pdpVerifyGiftable() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__page__pdp)));
		WebElement pdpSection = driver.findElement(By.cssSelector(".pdp-details"));

		if (pdpSection.getText().toLowerCase().contains("gift wrap available")) {
			System.out.println("//////// GIFT WRAP ELIGIBLE");
			return true;
		} else {
			System.out.println("//////// GIFT WRAP NOT ELIGIBLE");
			return false;
		}
	}

	@And("^the user clicks 'Find in Store' link$")
	public void theUserClicksISPULink() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.link__pdp__ispu)));

		WebElement ispuLink = driver.findElement(By.cssSelector(selector.link__pdp__ispu));

		ispuLink.click();
	}

	@Then("^the user verifies 'Productname'$")
	public void theUserVerifiesProductname() {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.product__name)));
			WebElement Productname = driver.findElement(By.cssSelector(selector.product__name));
			System.out.println(("Product name : " + Productname.isDisplayed()));

		} catch (Exception e) {

		}

	}

	@Then("^the user verifies 'Productprice'$")
	public void theUserVerifiesPrdoctprice() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.product__price)));
			WebElement Productprice = driver.findElement(By.cssSelector(selector.product__price));

			System.out.println(("\n Product price : " + Productprice.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Then("^the user verifies 'Quantity'$")
	public void theUserVerifiesQuantity() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.product__qty)));
			WebElement Productqty = driver.findElement(By.cssSelector(selector.product__qty));

			System.out.println(("\n Product quantity : " + Productqty.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Then("^the user verifies 'Product description'$")
	public void theUserVerifiesProductDescription() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.product__desc)));
			WebElement Productdesc = driver.findElement(By.xpath(selector.product__desc));

			System.out.println(("\n Product Description : " + Productdesc.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	@Then("^the user verifies 'Product features'$")
	public void theUserVerifiesProductfeatures() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.product__feature)));
			WebElement Productfeature = driver.findElement(By.xpath(selector.product__feature));

			System.out.println(("\n Product Feature : " + Productfeature.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Then("^the user verifies 'good to know'$")
	public void theUserVerifiesGoodtoknow() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.product_goodtoknow)));
			WebElement Productgotoknow = driver.findElement(By.xpath(selector.product_goodtoknow));

			System.out.println(("\n Product Goodtoknow : " + Productgotoknow.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Then("^the user verifies 'additional info'$")
	public void theUserVerifiesAdditionalInfo() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.additional_info)));
			WebElement Productadditionalinfo = driver.findElement(By.xpath(selector.additional_info));

			System.out.println(("\n Product AdditionalInfo : " + Productadditionalinfo.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Then("^the user verifies 'product questions'$")
	public void theUserVerifiesProductquestions() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.product_questions)));
			WebElement Productquestions = driver.findElement(By.xpath(selector.product_questions));

			System.out.println(("\n Product Questions : " + Productquestions.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Then("^the user verifies 'customer reivew summery'$")
	public void theUserVerifiesCustomerReivewsummery() {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.product_customerreviewsummery)));
			WebElement Productcustreview = driver.findElement(By.xpath(selector.product_customerreviewsummery));

			System.out.println(("\n Product Customer Review : " + Productcustreview.isDisplayed()));

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
