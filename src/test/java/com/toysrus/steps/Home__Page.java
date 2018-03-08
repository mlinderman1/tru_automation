package com.toysrus.steps;

import org.openqa.selenium.WebDriver;

import com.toysrus.config.BrowserConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Home__Page extends BrowserConfiguration {

	private WebDriver driver;

	@When("^user open \"([^\"]*)\" broswer$")
	public void openBrowsers(String browserName) {
		try {
			driver = BrowserConfiguration.openBrowser(browserName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^the user navigates to \"([^\"]*)\" site$")
	public void navigateUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
