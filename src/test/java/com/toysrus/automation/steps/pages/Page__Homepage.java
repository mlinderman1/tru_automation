package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.overlays.*;
import com.toysrus.automation.utils.LocatorProps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.List;
import java.net.URL;
import java.util.Iterator;

public class Page__Homepage extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String page = ".page-layout";
        public static final String page__homepage__tru = ".page-wrapper--tru";
        public static final String page__homepage__bru = ".page-wrapper--bru";
        public static final String toy__box__rightarrow = "(//button[@type='button'])[9]";
        public static final String toy__box__leftarrow = "(//button[@type='button'])[8]";
        public static final String toy__box = "//*[contains(text(),'toy box favorites')]";
        public static final String toy__name = "//span[contains(text(),'Hasbro Gaming Monopoly Game: Ultimate Banking..')]";
        public static final String sponsored__content = "//*[contains(text(),'SPONSORED CONTENT')]";
        public static final String sponsored__banner__id=".//*[@id='oas_x101']";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 40);
    Selectors selector = new Selectors();
    Overlay__LightBox lightBox = new Overlay__LightBox();
    String siteURL = null;

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @Given("^the user navigates to \"([^\"]*)\" site in \"([^\"]*)\" environment$")
    public void iNavigateToSiteSite(String site, String environment) throws Throwable {
    	
    	 String siteURL = LocatorProps.getProperty(environment.toLowerCase()+"."+site.toLowerCase());

        try{
            driver.navigate().to(siteURL);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try
        {
            lightBox.theUserClosesTheLightbox();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("^the user is on \"([^\"]*)\" homepage$")
    public void theUserIsOnHomepage(String site) throws Throwable {
        if (site.toLowerCase().contains("toys") || site.toLowerCase().equals("tru")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__tru)));
        }
        else if (site.toLowerCase().contains("babies") || site.toLowerCase().equals("bru")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__bru)));
        }
    }

    @And("^the user is on ToysRUs homepage$")
    public void theUserIsOnToysRUsHomepage() throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__tru)));
    }

    @And("^the user is on BabiesRUs homepage$")
    public void theUserIsOnBabiesRUsHomepage() throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.page__homepage__bru)));
    }
    @Then("^the user in toy box favorites$")
    public void the_user_in_toy_box_favorites() {
    try{
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.toy__box)));
     WebElement toy_box=driver.findElement(By.xpath(selector.toy__box));
     System.out.println("the user in " +toy_box.getText());
    }
    catch(Exception e){
    	
    }
     
    }
        
    @Then("^the user clicks on rightarrow$")
    public void theuserclicksonrightarrow() throws InterruptedException  {
       try{
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.toy__box__rightarrow)));
        WebElement rightarrow=driver.findElement(By.xpath(selector.toy__box__rightarrow));
        rightarrow.click();
        Thread.sleep(3000);
        rightarrow.click();
        Thread.sleep(3000);
        rightarrow.click();
       }
       catch(Exception e){
              
    }
    }
    @Then("^the user clicks on leftarrow$")
    public void theuserclicksonleftarrow() throws InterruptedException  {
    	try{
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.toy__box__leftarrow)));
    	WebElement leftarrow=driver.findElement(By.xpath(selector.toy__box__leftarrow));
        leftarrow.click();
        Thread.sleep(3000);
        leftarrow.click();
        Thread.sleep(3000);
        leftarrow.click();
    	}
    	catch(Exception e){
    		
    	}
              
    }
    
    @Then("^the user clicks on product$")
    public void theuserclicksonproduct()  {
     try{
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.toy__name)));
    WebElement toy_name=driver.findElement(By.xpath(selector.toy__name));
            toy_name.click();	 
     Thread.sleep(3000);
     }
     catch(Exception e)
     {
     System.out.println(e);
     }
     }

    @Then("^the user in Sponsored Content$")
    public void theuserinSponsoredContent()  {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.sponsored__content)));
    	try{
    		WebElement sponsoredcontent=driver.findElement(By.xpath(selector.sponsored__content));
    		System.out.println("The user in:  " +sponsoredcontent.getText());
    		}
    	catch(Exception e){
    		System.out.println(e);		
    	}
    }
    
    @Then("^the user clicks on Sponsored product$")
    public void theuserclicksonSponsoredproduct() throws InterruptedException  {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector.sponsored__banner__id)));
        try{
    	WebElement test=driver.findElement(By.xpath(selector.sponsored__banner__id));
        Thread.sleep(8000);
        test.click();
        Thread.sleep(10000);
        }
        
        catch(Exception e){
    		System.out.println(e);		
    	}
        
    }
    
}

