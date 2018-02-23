package com.toysrus.automation.steps.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;

import cucumber.api.java.en.And;

public class PDP_SocialLinks extends AbstractPage_StepDefs {
	public static final String socialLinks[] = { "twitter", "facebook",
			"pinterest", "instagram", "youtube" };

	public class Selectors {
		public static final String socilLnk = "//*[@id='root']//a[@class='footer-socials__item footer-socials__item--";

	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();

	public List<String> getWindows() {
		Set<String> wds = driver.getWindowHandles();
		List<String> addWds = new ArrayList<String>();
		for (String idWindow : wds) {
			addWds.add(idWindow);
		}
		System.out.println(addWds + "  " + wds);
		return addWds;

	}

	int count = 0;

	@And("^verify user is able to click on all mail link's$")
	public void verifySocialLinks() throws Exception {

		for (String socialLNK : socialLinks) {
			count++;
			String lXpath = selector.socilLnk + socialLNK + "']";
			System.out.println(socialLNK);
			driver.findElement(By.xpath(lXpath)).click();
			if (count == 2) {
				WebElement ele = driver.findElement(By.xpath(lXpath));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
				

			}
			List<String> lst = getWindows();
			driver.switchTo().window(lst.get(1));
			Assert.assertEquals(true, driver.getCurrentUrl()
					.contains(socialLNK));
			driver.close();
			driver.switchTo().window(lst.get(0));
			Thread.sleep(2000);
		}
	}
}
