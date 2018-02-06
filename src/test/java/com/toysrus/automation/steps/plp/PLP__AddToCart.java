package com.toysrus.automation.steps.plp;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.flyouts.*;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PLP__AddToCart extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String container__page__plp = ".webstore-plp-page";
        public static final String container__plp_grid = ".tru-product-grid__list";
        public static final String container__plp_grid_item = ".tru-product-grid__list-item";
        public static final String container__plp_grid_item_image = ".product-item__product-image-primary";
        public static final String container__plp_item = ".product-item";
        public static final String container__plp_item__non_OOS = ".product-item__btn-group";
        public static final String container__plp_item__OOS = ".product-item--out";
        public static final String btn__plp__item = ".product-item__product-button";
        public static final String btn__plp_item__OOS = ".product-item__out-of-stock";
        public static final String btn__add_to_cart = "//button/span[text()='add to cart']";
        public static final String btn__ispu = ".product-item__button-ispu";
        public static final String btn__view_details = "//button/span[text()='view details']";
        public static final String btn__ship_to_store = "//button/span[text()='ship free to store']";
        public static final String btn__preorder = "//button/span[text()='pre-order now']";
        public static final String btn__add_to_registry = "//button/span[text()='add to registry'][0]";
        public static final String btn__add_to_wishlist = "//button/span[text()='add to wish list'][0]";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Random rand = new Random();
    Selectors selector = new Selectors();
    Flyout__PickupInStore ispu = new Flyout__PickupInStore();
    int n;

    @When("^the user adds \"([^\"]*)\" item to cart from plp page$")
    public void addToCart(String buttonType) throws Throwable {


        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__plp_grid)));

            List<WebElement> plpItems = driver.findElements(By.cssSelector(selector.container__plp_item));
            List<WebElement> plpButtonsList = driver.findElements(By.cssSelector(selector.btn__plp__item));
            List<WebElement> atcButtonsList = driver.findElements(By.xpath(selector.btn__add_to_cart));
            List<WebElement> ispuButtonsList = driver.findElements(By.cssSelector(selector.btn__ispu));
            List<WebElement> viewDetailsButtonsList = driver.findElements(By.xpath(selector.btn__view_details));
            List<WebElement> s2sButtonsList = driver.findElements(By.xpath(selector.btn__ship_to_store));

            if (buttonType.toLowerCase().contains("s2h") || buttonType.toLowerCase().contains("ship")) {
                n = rand.nextInt(atcButtonsList.size());

                atcButtonsList.get(n).click();
            } else if (buttonType.toLowerCase().equals("ispu") || buttonType.toLowerCase().contains("store") || buttonType.toLowerCase().contains("pickup")) {

                n = rand.nextInt(ispuButtonsList.size());
                ispuButtonsList.get(n).click();

                try {
                    ispu.theUserSelectsStoreToPickUpItem();
                } catch (Exception e) {
                    new Flyout__Common().theUserClosesTheFlyout();
                    new Common_StepDefs().theUserRefreshesThePage();
                    addToCart(buttonType);
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println(e);
        }

    }


}