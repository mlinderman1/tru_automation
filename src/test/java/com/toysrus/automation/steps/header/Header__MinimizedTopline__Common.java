package com.toysrus.automation.steps.header;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;


import cucumber.api.java.en.When;


public class Header__MinimizedTopline__Common extends AbstractPage_StepDefs {
	
	    public static class Selectors {
	    	public static final String btn__minimized_topline__logo__TRU = ".top-line-header__logo.top-line-header__logo-bru";
	        public static final String btn__minimized_topline__logo__BRU = ".top-line-header__logo.top-line-header__logo-tru";
	        public static final String link__minimized_topline__find_a_store = ".top-line-header__menu__item.menu__find-a-store";
	    }

	    public static class t2Selectors {
	    	public static final String btn__minimized_topline__logo__TRU = ".tru-logo-sm";
	        public static final String btn__minimized_topline__logo__BRU = ".bru-logo-sm";
	        public static final String link__minimized_topline__find_a_store = ".storeloc";
	        
	    }

	    
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    Random rand = new Random();
	    int n;
	    Common_StepDefs common;
	    //    String selector = null;
	  	    


	    public void pageVersion() throws Throwable {
	        if (common.verifyT2Page().equals(true)) {
//	            t2Selectors selector = new t2Selectors();
//	            return selector;
	            System.out.println("/////// T2 Page");
	        } else if (common.verifyT2Page().equals(false)) {
//	        Selectors selector = new Selectors();
//	        return selector;
	            System.out.println("/////// NOT T2 Page");
	        }
	    }
	    
	     
	    @When("^the user clicks mini \"([^\"]*)\" logo from minimized topline header$")
	    public void theUserClicksMiniLogoFromMinimizedToplineHeader(String logo) throws Throwable {
	    	if (logo.toLowerCase().equals("tru")||logo.toLowerCase().equals("toys")){
	    		if (common.verifyT2Page().equals(true)){
	    			driver.findElement(By.cssSelector(t2Selectors.btn__minimized_topline__logo__TRU)).click();
	    		}else{
	    			driver.findElement(By.cssSelector(Selectors.btn__minimized_topline__logo__TRU)).click();

	    		}
	    	}
	    	else if (logo.toLowerCase().equals("bru")||logo.toLowerCase().equals("babies")){
	    		if (common.verifyT2Page().equals(true)){
	    			driver.findElement(By.cssSelector(t2Selectors.btn__minimized_topline__logo__BRU)).click();
	    		}
	    		else{
	    			driver.findElement(By.cssSelector(Selectors.btn__minimized_topline__logo__BRU)).click();
	    		}
	    	}
	    }


	    @When("^the user clicks mini ToysRUs logo from minimized topline header$")
	    public void theUserClicksToysRUsMiniLogoFromMinimizedToplineHeader() throws Throwable {
	    	WebElement btn__topline__logo__TRU = null;

	    	if (common.verifyT2Page().equals(true)){
	    		btn__topline__logo__TRU = driver.findElement(By.cssSelector(t2Selectors.btn__minimized_topline__logo__TRU));
	    		btn__topline__logo__TRU.click();
	    	}
	    	else{
	    		btn__topline__logo__TRU = driver.findElement(By.cssSelector(Selectors.btn__minimized_topline__logo__TRU));
	    		btn__topline__logo__TRU.click();
	    	}

	    }

	   
	   @When("^the user clicks mini BabiesRUs logo from minimized topline header$")
	   public void theUserClicksBabiesRUsMiniLogoFromMinimizedToplineHeader() throws Throwable {
		   WebElement btn__topline__logo__BRU = null;

		   if (common.verifyT2Page().equals(true)){
			   btn__topline__logo__BRU = driver.findElement(By.cssSelector(t2Selectors.btn__minimized_topline__logo__BRU));
			   btn__topline__logo__BRU.click();
		   } else {
			   btn__topline__logo__BRU = driver.findElement(By.cssSelector(Selectors.btn__minimized_topline__logo__BRU));
			   btn__topline__logo__BRU.click();
		   }
	   }

	    
	    @When("^the user clicks Find a Store link from minimized topline header$")
	    public void theUserClicksFindAStoreLinkFromMinimizedToplineHeader() throws Throwable {
	    	WebElement link__topline__find_a_store = null;

	    	if (common.verifyT2Page().equals(true)){
	    		link__topline__find_a_store = driver.findElement(By.cssSelector(t2Selectors.link__minimized_topline__find_a_store));
	    		link__topline__find_a_store.click();


	    	} else {
	    		link__topline__find_a_store = driver.findElement(By.cssSelector(Selectors.link__minimized_topline__find_a_store));
	    		link__topline__find_a_store.click();
	    	}
	    } 
}
 