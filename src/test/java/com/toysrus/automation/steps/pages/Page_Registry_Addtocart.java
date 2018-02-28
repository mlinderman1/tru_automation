package com.toysrus.automation.steps.pages;

import com.sun.jna.platform.win32.WinDef;
import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class Page_Registry_Addtocart extends AbstractPage_StepDefs {
    public static class Selectors {
        public static final String Find_btn = "input[id='findbutton']";
        public static final String FirstnameinSearch = "input[id='newsearch_firstname']";
        public static final String LastnamenameinSearch = "input[id='newsearch_lastname']";
        public static final String RegistryNumberinSearch = "input[id='newsearch_registry']";
        public static final String SearchReg = "input[id='searchinitbtn']";
        public static final String firstrowregnumber = "//*[@id='example']/tbody/tr[1]/td[2]//p[@class='tab_reg_num']";
        public static final String Daytogo_Myreg_Txt = "text[class='days-to-go-banner-text']";
        public static final String Addtocart_Myreg_btn = "(//SPAN[text()='add to cart'][text()='add to cart'])[4]";
        public static final String Minicart_Myreg_btn = "a[class='cart-product-title']";
        public static final String Minicart_Count = "span[class='header-fat__tile__count']";
        public static final String Registry_addtocart_popup = "div[class='tru-modal-dialog__header atc-overlay__header']";

        public static WebElement Registry_addtocart_btn(WebDriver driver, WebElement product) {
            return product.findElement(By.cssSelector("button[data-at='btn__add-to-cart']"));
        }

        public static WebElement findProduct(WebDriver driver, String ItemSkn) {
            return driver.findElement(By.cssSelector("div[data-at^='product__" + ItemSkn + "']"));
        }
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 40);
    Page_Registry_Create.Selectors selector = new Page_Registry_Create.Selectors();
    Overlay__LightBox lightBox = new Overlay__LightBox();
    URL siteURL;

    @When("^the user clicks find on the registry home page$")
    public void theUserClicksFindOnTheRegistryHomePage() {
        driver.findElement(By.cssSelector(Page_Registry_Addtocart.Selectors.Find_btn)).click();

    }

    @And("^lands on the registry search page$")
    public void landsOnTheRegistrySearchPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Page_Registry_Addtocart.Selectors.FirstnameinSearch)));

    }

    @When("^the user searches for a \"([^\"]*)\" RegistryNumber$")
    public void theUserSearchesForARegistryNumber(String reg_number) {
        driver.findElement(By.cssSelector(Page_Registry_Addtocart.Selectors.RegistryNumberinSearch)).sendKeys(reg_number);
        driver.findElement(By.cssSelector(Page_Registry_Addtocart.Selectors.SearchReg)).click();
    }

    @And("^lands on the registry search results page displaying registry \"([^\"]*)\"$")
    public void landsOnTheRegistrySearchResultsPage(String reg_number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page_Registry_Addtocart.Selectors.firstrowregnumber)));
        String strregno = driver.findElement(By.xpath(Page_Registry_Addtocart.Selectors.firstrowregnumber)).getText();
        strregno.toString();
        if (reg_number.equals("0"+strregno+"")){
            System.out.println("Search Results for registry number" +reg_number+  "is displayed");
        }
        else
        {
            System.out.println("Search Results for registry number" +reg_number+ " is not displayed");
        }
        }


    @When("^the user clicks on the corresponding registry \"([^\"]*)\" result title$")
    public void theUserClicksOnTheCorrespondingRegistryResultTitle(String reg_number) throws InterruptedException {
        driver.findElement(By.xpath(Page_Registry_Addtocart.Selectors.firstrowregnumber)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Page_Registry_Addtocart.Selectors.Daytogo_Myreg_Txt)));
        System.out.println(" User Clicked the Registry#" +reg_number+ "from the search result sucessfully");
        Thread.sleep(1000);
    }

    @And("^lands on the registry gift giver list page$")
    public void landsOnTheRegistryGiftGiverListPage() {
        if (driver.findElement(By.cssSelector(Page_Registry_Addtocart.Selectors.Daytogo_Myreg_Txt)).isDisplayed())
        {
            System.out.println("User Landed on MyRegistry Gift Giver Page sucessfully");
        }
            else
        {
            System.out.println("User failed to Land on MyRegistry Gift Giver Page");
        }
    }

    /*@When("^the user sets the quantity to \"([^\"]*)\" for \"([^\"]*)\"$")
    public void theUserSetsTheQuantityToFor(String qty, String item_number) {
        // Write code here that turns the phrase above into concrete actions

    }*/

   @And("^clicks add to cart for item \"([^\"]*)\"$")
    public void clicksAddToCartForItem(String arg0) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Page_Registry_Addtocart.Selectors.Addtocart_Myreg_btn)));
        driver.findElement(By.xpath(Page_Registry_Addtocart.Selectors.Addtocart_Myreg_btn)).click();

    }

    @When("^clicks add to cart for item# \"([^\"]*)\"$")
    public void addItemToCartFromMyRegistry(String ItemSkn) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(Selectors.findProduct(driver,ItemSkn)));
        WebElement Item=Selectors.findProduct(driver,ItemSkn);
        if(Item.isDisplayed())
        {
            System.out.println("Item is available on My registry");
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", Selectors.Registry_addtocart_btn(driver,Item));
        }
        else
        {
            System.out.println("Item is not available on the my registry");
        }

    }

    @And("^the Add to Cart overlay is displayed with item \"([^\"]*)\"$")
    public void theAddToCartOverlayIsDisplayedWithItem(String item_number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.Registry_addtocart_popup)));
        if (driver.findElement(By.cssSelector(Selectors.Registry_addtocart_popup)).isDisplayed())
        {
            System.out.println("User added Item to cart sucessfully from MyRegistry Page");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Selectors.Registry_addtocart_popup)));
        }
        else
        {
            System.out.println("User failed to  add Item to cart from MyRegistry Page\"");
        }

    }

    @And("^the minicart displays the total quantity carted along with any additional quantity \"([^\"]*)\" carted within this scenario$")
    public void theMinicartDisplaysTheTotalQuantityCartedAlongWithAnyAdditionalQuantityCartedWithinThisScenario(String CartQty) {
        // Write code here that turns the phrase above into concrete actions
        if(driver.findElement(By.cssSelector(Selectors.Minicart_Count)).getText().contentEquals(CartQty))
        {
            System.out.println("Mini cart Quantity is equal to the specified Quantity");
        }
        else
        {
            System.out.println("Mini cart Quantity is not equal to the specified Quantity");
        }

    }

    @And("^the user lands on the cart page$")
    public void theUserLandsOnTheCartPage() {
        // Write code here that turns the phrase above into concrete actions
        //if(driver.getTitle().contentEquals("Shopping Cart"))
            if(driver.getTitle().contentEquals("shopping cart"))
        {
            System.out.println("Cart page is successfully loaded");
        }
        else
        {
            System.out.println("Cart page is not loaded");
        }

    }

    @Then("^the item \"([^\"]*)\" with quantity \"([^\"]*)\" is displayed$")
    public void theItemWithQuantityIsDisplayed(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions

    }
}