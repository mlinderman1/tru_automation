package com.toysrus.automation.steps.header;

	
	import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
	import com.toysrus.automation.steps.common.Common_StepDefs;

	import java.util.Random;

	public class Header__MinimizedGlobalNav__Common  extends AbstractPage_StepDefs {

	    public class Selectors {
	        public static final String btn__minimized_global_nav__help = ".tru-dropdown.help-tile";
	        public static final String link__minimized_global_nav__help__help_center = ".help-tile__submenu-item-link";
	        public static final String btn__minimized_global_nav__help__moxie_online = ".help-tile__submenu-item--moxie";
	        public static final String btn__minimized_global_nav__help__moxie_offline = ".help-tile__submenu-item--moxie--disabled";
	        public static final String btn_minimized_global_nav_signIn =".sign-in-tile__button";
	        public static final String link__minimized_global_nav__signedIn = ".sign-in-tile__user-info-text";
	    }

	    public class t2Selectors {
	        public static final String btn__minimized_global_nav__help = ".global-nav-help";
	        public static final String btn__minimized_global_nav__help__moxie_online = "chatLive";
	        public static final String btn__minimized_global_nav__help__moxie_offline = "chatOff";
	        public static final String link__minimized_global_nav__help__help_center = ".help-tile__submenu-item-link";
	    }

	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    Random rand = new Random();
	    int n;
	    Common_StepDefs common = new Common_StepDefs();
	    Selectors selector = new Selectors();
	    t2Selectors t2selector = new t2Selectors();

	    @And("^the user clicks 'Help' from the minimized global navbar$")
	    public WebElement theUserClicksHelpFromTheMinimizedGlobalNavbar() throws Throwable {
	        WebElement btn__minimized_global_nav__help = null;

	        try {
	            btn__minimized_global_nav__help = driver.findElement(By.cssSelector(selector.btn__minimized_global_nav__help));
	            return btn__minimized_global_nav__help;
	        }
	        catch (Exception e) {

	            btn__minimized_global_nav__help = driver.findElement(By.cssSelector(t2selector.btn__minimized_global_nav__help));
	            return btn__minimized_global_nav__help;
	        }
	        finally {
	            btn__minimized_global_nav__help.click();
	        }
	    }
	    
	    @Then("^the user clicks 'Help Center' from the minimized global navbar 'help'$")
	    public WebElement theUserClicksHelpCenterFromTheMinimizedGlobalNavbarHelp() throws Throwable {
	        WebElement link__minimized_global_nav__help__help_center = null;

	        try {
	        	link__minimized_global_nav__help__help_center = driver.findElement(By.cssSelector(selector.link__minimized_global_nav__help__help_center));
	            return link__minimized_global_nav__help__help_center;
	        }
	        catch (Exception e) {

	        	link__minimized_global_nav__help__help_center = driver.findElement(By.cssSelector(t2selector.link__minimized_global_nav__help__help_center));
	            return link__minimized_global_nav__help__help_center;
	        }
	        finally {
	        	link__minimized_global_nav__help__help_center.click();
	        }
	    }
	    
	    @Then("^the user clicks 'live chat' from the minimized global navbar 'help'$")
	    public WebElement theUserClicksLiveChatFromTheMinimizedGlobalNavbarHelp() throws Throwable {
	        WebElement link__minimized_global_nav__help__help_center = null;

	        try {
	        	link__minimized_global_nav__help__help_center = driver.findElement(By.cssSelector(selector.link__minimized_global_nav__help__help_center));
	            return link__minimized_global_nav__help__help_center;
	        }
	        catch (Exception e) {

	        	link__minimized_global_nav__help__help_center = driver.findElement(By.cssSelector(t2selector.link__minimized_global_nav__help__help_center));
	            return link__minimized_global_nav__help__help_center;
	        }
	        finally {
	        	link__minimized_global_nav__help__help_center.click();
	        }
	    }
	    
	    @And("^the user clicks 'signIn' button from the  minimized global navbar$")
	    public void the_user_clicks_signIn_button_from_the_minimized_global_navbar() throws Throwable {
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn_minimized_global_nav_signIn)));
				driver.findElement(By.cssSelector(selector.btn_minimized_global_nav_signIn)).click();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	    
	    
	    
	    @Then("^the user is \"([^\"]*)\" SignedIn Successfully from the  minimized global navbar$")
	    public void the_user_is_SignedIn_Successfully_from_the_minimized_global_navbar(String email) throws Throwable {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.link__minimized_global_nav__signedIn)));

				WebElement signIn_check_minicart_navbar = driver.findElement(By.cssSelector(selector.link__minimized_global_nav__signedIn));
				if(signIn_check_minicart_navbar.isDisplayed()){
					String emailText = driver.findElement(By.cssSelector(selector.link__minimized_global_nav__signedIn)).getText();
					String[] splt = emailText.split("\\s");
					String str = splt[1];
					if(email.toLowerCase().contains(str)){
						System.out.println("The User SignedIn In Successfully");

					}else
						System.out.println("The User not SignedIn In Successfully");
				}  

			}catch(Exception e){
				System.out.println(e);
			}
		}
	}


