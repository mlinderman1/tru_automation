package com.toysrus.config;

import cucumber.api.java.After;

public class Hooks {

	@After
	public void afterScenario() {
		System.out.println("Closing Driver");
		BrowserConfiguration.driver.quit();
	}
}