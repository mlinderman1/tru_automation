package com.toysrus.automation.steps.header;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Header__GlobalNav__Help extends AbstractPage_StepDefs {

	public class Selectors {
		public static final String btn__global_nav__help = ".tru-dropdown.help-tile";
		public static final String btn__global_nav__help_icon = ".tru-dropdown__handler.help-tile__dropdown-handler";
		public static final String btn__global_nav__live_chat = "//span[@class='help-tile__text'][text()='live chat']";
		public static final String btn__global_nav__help_center = "//span[@class='help-tile__text'][text()='help center']";
		public static final String link__global_nav__help__help_center = ".help-tile__submenu-item-link";
		public static final String btn__global_nav__help__moxie_online = ".help-tile__submenu-item--moxie";
		public static final String btn__global_nav__help__moxie_offline = ".help-tile__submenu-item--moxie--disabled";
	}

	public class t2Selectors {
		public static final String btn__global_nav__help = ".global-nav-help";
		public static final String btn__global_nav__help__moxie_online = "chatLive";
		public static final String btn__global_nav__help__moxie_offline = "chatOff";
	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Random rand = new Random();
	int n;
	Common_StepDefs common = new Common_StepDefs();
	Selectors selector = new Selectors();
	t2Selectors t2selector = new t2Selectors();
	StringBuffer verificationErrors = new StringBuffer();

	@And("^the user clicks 'Help' from the global navbar$")
	public WebElement theUserClicksHelpFromTheGlobalNavbar() throws Throwable {
		WebElement btn__global_nav__help = null;

		try {
			btn__global_nav__help = driver.findElement(By.cssSelector(selector.btn__global_nav__help));
			return btn__global_nav__help;
		} catch (Exception e) {

			btn__global_nav__help = driver.findElement(By.cssSelector(t2selector.btn__global_nav__help));
			return btn__global_nav__help;
		} finally {
			btn__global_nav__help.click();
		}
	}

	@Then("^the user verify 'Help Option' in the global navbar$")
	public void theUserVerifyliveChatfromtheGlobalGavbar() throws Throwable {
		try {
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.btn__global_nav__help_icon)));
			WebElement HelpOption = driver.findElement(By.cssSelector(selector.btn__global_nav__help_icon));
			System.out.println(HelpOption.getText() + " : Option Available");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^the user verify 'live chat' in the Help Option$")
	public void theUserVerifyLiveChatintheHelpOption() throws Throwable {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.btn__global_nav__live_chat)));
			WebElement LiveChat = driver.findElement(By.xpath(selector.btn__global_nav__live_chat));
			System.out.println(LiveChat.getText() + " : Button Available");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^the user verify 'help center' in the Help Option$")
	public void theUserVerifyHelpCenterintheHelpOption() throws Throwable {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.btn__global_nav__help_center)));
			WebElement HelpCenter = driver.findElement(By.xpath(selector.btn__global_nav__help_center));
			System.out.println(HelpCenter.getText() + " : Button Available");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
