package com.toysrus.automation.steps.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;

import cucumber.api.java.en.Then;


public class Page__WishList extends AbstractPage_StepDefs {

	
	
    public class Selectors {
    	
    	public static final String page =".col-md-12.col-no-padding>h1";

    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();

@Then("^The user in Wishlist page$")
public void theuserinWishlistpage() throws Throwable {
	try {
    WebElement wishlisttext=driver.findElement(By.cssSelector(selector.page));
    wait.until(ExpectedConditions.visibilityOf(wishlisttext));
    System.out.println("The user is in:" +wishlisttext.getText() );
	} catch (NoSuchElementException e) {
        System.out.println(e);
    }
    
}

}




