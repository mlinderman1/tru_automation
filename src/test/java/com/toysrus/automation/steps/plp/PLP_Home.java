package com.toysrus.automation.steps.plp;

import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import com.toysrus.automation.steps.pages.Page__Homepage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PLP_Home extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String shopByLabel = ".header-fat__tile.header-fat__tile-shop-by";
		public static final String bruLogImg = "//span[contains(@class,'logo-img')]";
		public static final String feedBackTxt = "//*[contains(text(),'Feedback')]";
		public static final String overRdBtn = "//*[@id='overall-5' and @name='overall']";
		public static final String cmtTxtBox = "//*[@id='comment-textarea' and @name='comments']";
		public static final String subBtn = "//input[@type='submit'][@value='Submit']";
		public static final String feedBackStatusTxt = "//*[contains(text(),'Thank you for your feedback')]";

		public static final String findStroreBtn = "//span[contains(text(),'find a store')]";
		public static final String findStroreAutoCmplInp = "//div[@id='PlacesAutocomplete__root']/input";
		public static final String findStroreMakeMyStroreTxt = "//a[contains(text(),'make my store')]";

		public static final String searchBox = "//*[@placeholder='search for something fun!']";

		public static final String addCartBtn = "//button/span[contains(text(),'add to cart')]";
		public static final String viewcartCheckoutBtn = "//*[contains(text(),'view cart & checkout')]";
		public static final String yourCartTxt = "//*[contains(text(),'Your cart subtotal')]";
		public static final String secondPickupBtn = "(//*[contains(text(),'pick up here')])[2]";
		public static final String enterZipCodeCityNameLabel = "//input[@placeholder='Enter a zip code, city or state name']";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();
	Overlay__LightBox lightBox = new Overlay__LightBox();
	String siteURL = null;

	@Then("^verify Shop By menu button$")
	public void verifyShopByMenuButton() throws Exception {
		boolean sMenuStatus = false;
		Thread.sleep(5000);
		if (driver.findElement(By.cssSelector(Selectors.shopByLabel))
				.isDisplayed()) {
			driver.findElement(By.cssSelector(Selectors.shopByLabel)).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			sMenuStatus = driver.findElement(By.xpath("//*[text()='Baby, ']"))
					.isDisplayed();

		}
		Assert.assertEquals(true, sMenuStatus);

	}

	@Given("^the user Verifies domain name$")
	public void verifyDomain() throws Exception {
		String env = "";
		Page__Homepage pgHomePage = new Page__Homepage();
		if (pgHomePage.envName.equals("qa"))
			env = "qa2";
		else if (pgHomePage.envName.equals("prod")) {
			// prod env
			env = "prod";
		}
		Properties prop = new Properties();
		prop.load(new FileReader("./" + env + ".properties"));

		String truUrl = driver.getCurrentUrl();

		String expDomainTru = truUrl.split(":")[0];

		Assert.assertEquals("https", expDomainTru);
		driver.get(prop.getProperty("bru"));
		String bruUrl = driver.getCurrentUrl();
		String expDomainBru = bruUrl.split(":")[0];

		Assert.assertEquals("https", expDomainBru);
	}

	@Given("^the user click on Babiesrus Logo$")
	public void clickOnBabiesrus_Logo() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement babiesruslogo = driver.findElement(By
				.xpath(selector.bruLogImg));
		babiesruslogo.click();

	}

	@Then("^The Message should display$")
	public void messageShouldDisplay() {
		String env = "";
		Page__Homepage pgHomePage = new Page__Homepage();
		if (pgHomePage.envName.equals("qa"))
			env = "qa2";
		else if (pgHomePage.envName.equals("prod")) {
			// prod env
			env = "";
		}

		Assert.assertEquals(
				true,
				driver.getCurrentUrl().contains(
						"babiesrus" + env + ".toysrus.com"));
	}

	// Bhanu
	@When("^the user clicked on feedback button$")
	public void clickedOnFeedback() throws Throwable {
		try {
			Actions feedAct = new Actions(driver);
			feedAct.click(driver.findElement(By.xpath(selector.feedBackTxt)))
					.build().perform();

			Set<String> windows = driver.getWindowHandles();
			for (String string : windows) {
				driver.switchTo().window(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	@Then("^New window opens$")
	public void windowOpens() throws Throwable {
		try {
			WebElement page = driver.findElement(By.id("comment-heading"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^Enter Feedback and Submit$")
	public void enterFeedbackAndSubmit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(By.xpath(selector.overRdBtn)).click();
		driver.findElement(By.xpath(selector.cmtTxtBox)).sendKeys("Good");
		driver.findElement(By.xpath(selector.subBtn)).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,
				driver.findElement(By.xpath(selector.feedBackStatusTxt))
						.isDisplayed());

	}

	@Given("^the user click on Findastore$")
	public void clickonFindastore() {
		try {
			WebElement findastore = driver.findElement(By
					.xpath(selector.findStroreBtn));
			findastore.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^the user Search zipcode$")
	public void searchZipcode() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			WebElement inputzipcode = driver.findElement(By
					.xpath(selector.findStroreAutoCmplInp));
			inputzipcode.sendKeys("75020");
			inputzipcode.sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(selector.findStroreMakeMyStroreTxt))
					.click();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Raja

	@Then("^Enter (.*) then search$")
	public void enterProduct(String product) throws Exception {

		try {
			driver.findElement(By.xpath(selector.searchBox)).sendKeys(product);
			driver.findElement(By.xpath(selector.searchBox)).sendKeys(
					Keys.ENTER);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Click on AddToCart and click on View cart and Checkout$")
	public void clickOnAddToCartAndViewCartAndCheckout() {

		try {
			driver.findElement(By.xpath(selector.addCartBtn)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(selector.viewcartCheckoutBtn)).click();
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^Verify product details in shopping cart \"([^\"]*)\"$")
	public void verifyWarrantyReturnType(String orderDetails) throws Exception {

		String details = driver.findElement(By.xpath(selector.yourCartTxt))
				.getText();
		if (details.contains(orderDetails)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	@Then("^Click on find a store and enter (.*)$")
	public void clickOnFindaStoreEnterZipCode(String product) throws Exception {

		driver.findElement(By.xpath(selector.findStroreBtn)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(selector.enterZipCodeCityNameLabel))
				.sendKeys(product);
		driver.findElement(By.xpath(selector.enterZipCodeCityNameLabel))
				.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	@Then("^Click on pick up here button$")
	public void clickOnPickUpButton() throws Exception {

		driver.findElement(By.xpath(selector.secondPickupBtn)).click();

		Thread.sleep(5000);
	}

	@Then("^Click on view cart and checkout button$")
	public void clickOnViewCartAndCheckout() {

		try {
			driver.findElement(By.xpath(selector.viewcartCheckoutBtn)).click();
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
