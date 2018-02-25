package com.toysrus.automation.steps.common;

import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Common_StepDefs extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String page = ".page-layout";
        public static final String t2page = ".navbar-top";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    URL siteURL;
    Random rand = new Random();
    int n;
    Overlay__LightBox lightBox = new Overlay__LightBox();
    Selectors selector = new Selectors();

    public void typeIntoInputField(String cssSelector, String input){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        String val = input;

        element.clear();

        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }

    public void inputField(String cssSelector, String userData){
        try {
            String selector = cssSelector;
            String data = userData;

            WebElement element = driver.findElement(By.cssSelector(selector));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));

            do {
                typeIntoInputField(selector,data);
                element.sendKeys(Keys.TAB);
            }
            while(!element.getAttribute("value").contains(data));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void selectFromDropdownMenu(String cssSelector, String selection){
        try{
            String selector = cssSelector;
            String data = selection;

            Select cssSelection = new Select(driver.findElement(By.cssSelector(selector)));
            WebElement element = driver.findElement(By.cssSelector(selector));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector)));

            do {
                cssSelection.selectByValue(data);
            }
            while(!element.getAttribute("value").equals(data));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Boolean verifyT2Page() throws Throwable {
        Boolean isT2Page = driver.findElements(By.cssSelector(selector.t2page)).size() > 0;
        return isT2Page;
    }

    @When("^the user goes back one page$")
    public void iGoBackOnePage() throws Throwable
    {
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^the user refreshes the page$")
    public void theUserRefreshesThePage() throws Throwable {
        driver.navigate().refresh();
    }
    
    /**
     * This method enters the given text in the specific webelement
     * @param cssSelector
     *  cssselector of the webelement
     * @param text
     * Required text to be entered
     */
	public void typeInto(String cssSelector, String text) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))).sendKeys(text);
	}

    /*
     * click on the element
     */

	public void clickOn(String cssSelector) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))).click();
	}
	
	/**
	 * 
	 * @param cssSelector
	 * @return
	 */

	public String getText(String cssSelector) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))).getText().trim();
	}
	
	public void waitduration(long duration) throws InterruptedException {
		Thread.sleep(duration);
	}
    
    /**
	 * Generate an email based on current UNIX timestamp
	 * 
	 * @return Returns the generated email
	 */
	public String generateEmail() {
		// Create Random object
		Random r = new Random();
		// Returns randomly generated email id
		return "toysrus" + Integer.toString(r.nextInt(32000)) + Integer.toString(r.nextInt(999)) + "@aol.com";
	}
	
	public void waitForWebElement(String cssselector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssselector)));
	}
	
	public boolean isElementPresent(String cssselector) {
	return driver.findElement(By.cssSelector(cssselector)).isDisplayed();	
	}
	
	public void javascriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("arguments[0].click();", element);

	}


}
