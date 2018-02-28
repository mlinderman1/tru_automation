package com.toysrus.automation.steps.cart;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	    public class Cart__EmptyCart extends AbstractPage_StepDefs {

	    public static class Selectors {
	    	
	    	public static final String lnk__empty_mincart__signIn = "//a[contains(text(),'Sign in')]";
	    	public static final String lnk__empty_mincart__create_one = ".empty-cart__content > a:nth-child(2)";
	    	public static final String btn__empty_mincart__take_me_home = "a.btn > span:nth-child(1)";
	    }

	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    Overlay__LightBox lightBox = new Overlay__LightBox();
	   
	
	    
	    
	    
	    @And("^the user clicks 'signIn' link from the  empty cart$")
	    public void the_user_clicks_signIn_button_from_the_minimized_global_navbar() throws Throwable {
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Selectors.lnk__empty_mincart__signIn)));
				driver.findElement(By.xpath(Selectors.lnk__empty_mincart__signIn)).click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	    
	    
	    @And("^the user clicks 'its time to create one' link from the  empty cart$")
        public void the_user_clicks_its_time_to_create_one_link_from_the_empty_cart() throws Throwable {
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.lnk__empty_mincart__create_one)));
				driver.findElement(By.cssSelector(Selectors.lnk__empty_mincart__create_one)).click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	    
	    
	    @And("^the user clicks 'take me home' button from the  empty cart$")
        public void the_user_clicks_take_me_home_button_from_the_empty_cart() throws Throwable {
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.btn__empty_mincart__take_me_home)));
				driver.findElement(By.cssSelector(Selectors.btn__empty_mincart__take_me_home)).click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	    
}
