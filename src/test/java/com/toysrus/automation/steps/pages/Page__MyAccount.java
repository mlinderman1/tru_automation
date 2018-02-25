package com.toysrus.automation.steps.pages;

import com.toysrus.automation.lib.RunTimeVariables;
import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.pages.Page__MyAccount.Selectors;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page__MyAccount extends AbstractPage_StepDefs {


    public class Selectors {
    	public static final String tb_email_createAccount = "#loginEmail";
		public static final String tb_password_createAccount = "#passwordInput";
		public static final String tb_confirmPassword = "#ConfirmPassword";
		public static final String btn_SignUp = "#createAccountSubmitBtn";
		public static final String page_validation = "div.my-account-email span.userName";
		public static final String tb_email_signIn = "#email";
		public static final String tb_password_signIn = ".sigInPassword";
		public static final String btn_signIn = "#loginSubmitBtn";
		public static final String btn__global_nav__welcomeback = "div#my-account-popover";
	}

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Common_StepDefs common = new Common_StepDefs();

	@Before
	public void setUp() {
		getDriver();
		driver.manage().window().maximize();
	}

	@After
	public void breakDown() {
		closeDriver();
	}

	@And("the user creates account in \"([^\"]*)\"")
	public void createAccount(String site) {
		if (site.equalsIgnoreCase("toysrus")) {
			String email = common.generateEmail();
			RunTimeVariables.emailId = email;
			String password="Passw0rd";
			RunTimeVariables.general_password=password;
			common.typeInto(Selectors.tb_email_createAccount, email);
			common.typeInto(Selectors.tb_password_createAccount, password);
			common.typeInto(Selectors.tb_confirmPassword,password);
			common.clickOn(Selectors.btn_SignUp);
			Assert.assertEquals(email, common.getText(Selectors.page_validation));
		}
	}
}
