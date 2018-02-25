package com.toysrus.automation.steps.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.lib.RunTimeVariables;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class Page__MyProfile extends AbstractPage_StepDefs {
	
	public class Selectors {
		public static final String btn_myAccount = "#my-account-popover";
		
		public static final String text_welcomeback=".custmHeading";
		}
	

	WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Common_StepDefs common = new Common_StepDefs();
    Page__MyAccount myaccount = new Page__MyAccount();
    
    @Before
	public void setUp() {
		getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void breakDown() {
		closeDriver();
	}
	
	@Then("^user  see profile page$")
	public void user_see_profile_page()  {
		String welcomeBackText=driver.findElement(By.cssSelector(Selectors.text_welcomeback)).getText();
		Assert.assertTrue("welcomeback text is not matched with the actual emailid",welcomeBackText.contains(RunTimeVariables.emailId.split("@")[0]));
		common.waitForWebElement("div#my-account-popover");

	}

	
	
	
}