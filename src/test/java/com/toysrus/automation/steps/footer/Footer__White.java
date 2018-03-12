package com.toysrus.automation.steps.footer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;

public class Footer__White extends AbstractPage_StepDefs {
	public class Selectors {

	}

	WebDriver driver = getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	Selectors selector = new Selectors();
	Random rand = new Random();
}