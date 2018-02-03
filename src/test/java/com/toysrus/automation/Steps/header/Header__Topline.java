package com.toysrus.automation.Steps.header;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Header__Topline extends AbstractPage_StepDefs {


    public class Selectors {
        public static final String btn__topline__logo__TRU = ".top-line-header__logo.top-line-header__logo-bru";
        public static final String btn__topline__logo__BRU = ".top-line-header__logo.top-line-header__logo-tru";
        public static final String link__topline__registry = ".top-line-header__menu__item.menu__baby-registry";
        public static final String link__topline__find_a_store = ".top-line-header__menu__item.menu__find-a-store";
        public static final String link__topline__weekly_ad = ".top-line-header__menu__item.menu__weekly-ad";
        public static final String link__topline__wishlist = ".top-line-header__menu__item.menu__wish-list";
        public static final String link__topline__gift_card = ".top-line-header__menu__item.menu__gift-cards";
    }

    public class t2Selectors {
        public static final String btn__topline__logo__TRU = ".tru-logo-sm";
        public static final String btn__topline__logo__BRU = ".bru-logo-sm";

        public static final String link__topline__registry1 = "#my-baby-reg";
        public static final String link__topline__registry2 = ".babyreg";

        public static final String link__topline__find_a_store1 = ".storeloc";
        public static final String link__topline__find_a_store2 = ".store-locator-tooltip";

        public static final String link__topline__weekly_ad1 = ".weeklyad";
        public static final String link__topline__weekly_ad2 = ".sprite-weekly-ad";

        public static final String link__topline__wishlist1 = ".wishlist";
        public static final String link__topline__wishlist2 = ".sprite-wish-list";

        public static final String link__topline__gift_card1 = ".giftcard";
        public static final String link__topline__gift_card2 = ".sprite-gift-card";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Random rand = new Random();
    int n;
    Common_StepDefs common = new Common_StepDefs();
    Selectors selector = new Selectors();
    t2Selectors t2selector = new t2Selectors();

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @When("^the user clicks mini \"([^\"]*)\" logo from topline header$")
    public void theUserClicksMiniLogoFromToplineHeader(String logo) throws Throwable {
        if (logo.toLowerCase().equals("tru")||logo.toLowerCase().equals("toys")){
            try{
                driver.findElement(By.cssSelector(selector.btn__topline__logo__TRU)).click();
            }
            catch(Exception e){
                driver.findElement(By.cssSelector(t2selector.btn__topline__logo__TRU)).click();

            }
        }
        else if (logo.toLowerCase().equals("bru")||logo.toLowerCase().equals("babies")){
            try{
                driver.findElement(By.cssSelector(selector.btn__topline__logo__BRU)).click();
            }
            catch(Exception e){
                driver.findElement(By.cssSelector(t2selector.btn__topline__logo__BRU)).click();

            }
        }
    }


    @When("^the user clicks mini ToysRUs logo from topline header$")
    public WebElement theUserClicksToysRUsMiniLogoFromToplineHeader() throws Throwable {
        WebElement btn__topline__logo__TRU = null;

        try{
            btn__topline__logo__TRU = driver.findElement(By.cssSelector(selector.btn__topline__logo__TRU));
            return btn__topline__logo__TRU;
        }
        catch(Exception e){
            btn__topline__logo__TRU = driver.findElement(By.cssSelector(t2selector.btn__topline__logo__TRU));
            return btn__topline__logo__TRU;
        }
        finally{
            btn__topline__logo__TRU.click();
        }
    }

    @When("^the user clicks mini BabiesRUs logo from topline header$")
    public WebElement theUserClicksBabiesRUsMiniLogoFromToplineHeader() throws Throwable {
        WebElement btn__topline__logo__BRU = null;

        try {
            btn__topline__logo__BRU = driver.findElement(By.cssSelector(selector.btn__topline__logo__BRU));
            return btn__topline__logo__BRU;
        } catch (Exception e) {
            btn__topline__logo__BRU = driver.findElement(By.cssSelector(t2selector.btn__topline__logo__BRU));
            return btn__topline__logo__BRU;
        } finally {
            btn__topline__logo__BRU.click();
        }
    }

    @When("^the user clicks Find a Store link from topline header$")
    public WebElement theUserClicksFindAStoreLinkFromToplineHeader() throws Throwable {
        WebElement link__topline__find_a_store = null;

        try {
            link__topline__find_a_store = driver.findElement(By.cssSelector(selector.link__topline__find_a_store));
            return link__topline__find_a_store;
        } catch (Exception e) {
            try {
                link__topline__find_a_store = driver.findElement(By.cssSelector(t2selector.link__topline__find_a_store1));
                return link__topline__find_a_store;
            }
            catch (Exception a){
                link__topline__find_a_store = driver.findElement(By.cssSelector(t2selector.link__topline__find_a_store2));
                return link__topline__find_a_store;
            }
        } finally {
            link__topline__find_a_store.click();
        }
    }

    @When("^the user clicks Baby Registry link from topline header$")
    public WebElement theUserClicksBabyRegistryLinkFromToplineHeader() throws Throwable {
        WebElement link__topline__registry = null;

        try {
            link__topline__registry = driver.findElement(By.cssSelector(selector.link__topline__registry));
            return link__topline__registry;
        } catch (Exception e) {
            try {
                link__topline__registry = driver.findElement(By.cssSelector(t2selector.link__topline__registry1));
                return link__topline__registry;
            }
            catch (Exception a){
                link__topline__registry = driver.findElement(By.cssSelector(t2selector.link__topline__registry2));
                return link__topline__registry;
            }
        } finally {
            link__topline__registry.click();
        }
    }

    @When("^the user clicks Weekly Ad link from topline header$")
    public WebElement theUserClicksWeeklyAdLinkFromToplineHeader() throws Throwable {
        WebElement link__topline__weekly_ad = null;

        try {
            link__topline__weekly_ad = driver.findElement(By.cssSelector(selector.link__topline__weekly_ad));
            return link__topline__weekly_ad;
        } catch (Exception e) {
            try {
                link__topline__weekly_ad = driver.findElement(By.cssSelector(t2selector.link__topline__weekly_ad1));
                return link__topline__weekly_ad;
            }
            catch (Exception a){
                link__topline__weekly_ad = driver.findElement(By.cssSelector(t2selector.link__topline__weekly_ad2));
                return link__topline__weekly_ad;
            }
        } finally {
            link__topline__weekly_ad.click();
        }
    }

    @When("^the user clicks Wishlist link from topline header$")
    public WebElement theUserClicksWishlistLinkFromToplineHeader() throws Throwable {
        WebElement link__topline__wishlist = null;

        try {
            link__topline__wishlist = driver.findElement(By.cssSelector(selector.link__topline__wishlist));
            return link__topline__wishlist;
        } catch (Exception e) {
            try {
                link__topline__wishlist = driver.findElement(By.cssSelector(t2selector.link__topline__wishlist1));
                return link__topline__wishlist;
            }
            catch (Exception a){
                link__topline__wishlist = driver.findElement(By.cssSelector(t2selector.link__topline__wishlist2));
                return link__topline__wishlist;
            }
        } finally {
            link__topline__wishlist.click();
        }
    }

    @When("^the user clicks Gift Cards link from topline header$")
    public WebElement theUserClicksGiftCardsLinkFromToplineHeader() throws Throwable {
        WebElement link__topline__gift_card = null;

        try {
            link__topline__gift_card = driver.findElement(By.cssSelector(selector.link__topline__gift_card));
            return link__topline__gift_card;
        } catch (Exception e) {
            try {
                link__topline__gift_card = driver.findElement(By.cssSelector(t2selector.link__topline__gift_card1));
                return link__topline__gift_card;
            }
            catch (Exception a){
                link__topline__gift_card = driver.findElement(By.cssSelector(t2selector.link__topline__gift_card2));
                return link__topline__gift_card;
            }
        } finally {
            link__topline__gift_card.click();
        }
    }

}
