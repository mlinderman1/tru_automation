package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page__GiftCards extends AbstractPage_StepDefs {


    public class Selectors {
    	public static final String Giftcard=".twd_blue.twd_h1";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();

@Then("^The user in  Gift Cards page$")
public void theuserinGiftCardspage()  {
	try {
	    WebElement Giftcardtext=driver.findElement(By.cssSelector(selector.Giftcard));
	    wait.until(ExpectedConditions.visibilityOf(Giftcardtext));
	    System.out.println("The user is in:" +Giftcardtext.getText() );
		} catch (NoSuchElementException e) {
	        System.out.println(e);
	    }
    
}
}
