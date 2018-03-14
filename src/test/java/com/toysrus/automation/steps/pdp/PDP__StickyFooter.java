package com.toysrus.automation.steps.pdp;

import com.toysrus.automation.steps.common.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PDP__StickyFooter extends AbstractPage_StepDefs{
    public class Selectors {
        public static final String page__footer = ".footer-group.footer-sitemap";
        public static final String sticky__footer = ".pdp-sticky-footer";
        public static final String btn__add_to_cart__sticky_footer = ".pdp-cta-primary-button";
        public static final String cont__product_actions_sec = ".tru-product-actions__secondary-actions";
        public static final String btn__add_to_registry = ".btn-secondary-orange:nth-child(1)";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    JavascriptExecutor je = (JavascriptExecutor) driver;
    Common_StepDefs common = new Common_StepDefs();
    
    @When("^the user scrolls down the page so sticky footer shows up$")
    public void the_user_scrolls_down_the_page_so_sticky_footer_shows_up() throws Throwable {
    	
    	String cssSelector = selector.page__footer;
    	common.scrollToWebElement(cssSelector);
   	 	
       }
    
    @When("^the user adds PDP item to cart from sticky footer$")
    public void the_user_adds_PDP_item_to_cart_from_sticky_footer() throws Throwable {
    	try {
    		WebElement stickyFooter = driver.findElement(By.cssSelector(selector.sticky__footer));
    		WebElement btn__add_to_cart__stickyFooter = stickyFooter.findElement(By.cssSelector(selector.btn__add_to_cart__sticky_footer));
    		wait.until(ExpectedConditions.elementToBeClickable(btn__add_to_cart__stickyFooter));
    		btn__add_to_cart__stickyFooter.click();
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}	      	
    	

	}  
    
    @When("^the user scrolls down the page till commerce zone is not visible$")
    public void the_user_scrolls_down_the_page_till_commerce_zone_is_not_visible() throws Throwable {
    	
    	try {
    		WebElement productActionsContainer = driver.findElement(By.cssSelector(selector.cont__product_actions_sec));
    		WebElement btn__addToRegistry = productActionsContainer.findElement(By.cssSelector(selector.btn__add_to_registry));
    	
    		Dimension weD = btn__addToRegistry.getSize();
    		Point weP = btn__addToRegistry.getLocation();
	    
    		int yPos = weD.getHeight() + weP.getY();
    		yPos++;
	    
    		for(int x=0; x < yPos; x++) {
    			je.executeScript("window.scrollBy(0,1)","");
    		}
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}	      	
    	
    }

    @Then("^sticky footer is displayed on the bottom of the PDP page$")
    public void sticky_footer_is_displayed_on_the_bottom_of_the_PDP_page() throws Throwable {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.sticky__footer)));
    	
        
    }

    @When("^the user scrolls back up the page so commerce zone is visible$")
    public void the_user_scrolls_cak_up_the_page_so_commerce_zone_is_visible() throws Throwable {
    	je.executeScript("window.scrollBy(0,-1)","");
        
    }

    @Then("^sticky footer is not displayed any where on the page$")
    public void sticky_footer_is_not_displayed_any_where_on_the_page() throws Throwable {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector.sticky__footer)));

        
    }
    
    

}
