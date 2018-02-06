package com.toysrus.automation.steps.plp;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.flyouts.*;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PLP__GridList_Item extends AbstractPage_StepDefs {

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
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Random rand = new Random();
    Selectors selector = new Selectors();
    Flyout__PickupInStore ispu = new Flyout__PickupInStore();
    int n;

    @When("^the user navigates to PDP of in-stock \"([^\"]*)\" item$")
    public void theUserNavigatesToPDPOfInStockItem(String shipType) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__plp_grid)));

        List<WebElement> nonOOS_ProdsList = driver.findElements(By.cssSelector(selector.container__plp_item__non_OOS));
        List<WebElement> plp_ProdsList = driver.findElements(By.cssSelector(selector.container__plp_grid_item+" "+selector.container__plp_grid_item_image));

        List<WebElement> inStockShipToList = new ArrayList<WebElement>();
        List<WebElement> inStockISPUList = new ArrayList<WebElement>();

        List<WebElement> viewDetailsList = new ArrayList<WebElement>();

        for (int i = 0; i < plp_ProdsList.size(); i++) {
            String img_url = plp_ProdsList.get(i).getAttribute("innerHTML");
            String img_url_clean_prefix = img_url.replaceAll(".*images/", "");
            String sku = img_url_clean_prefix.replaceAll(".zoom.*","");
            System.out.println("////// "+img_url);
            System.out.println("////// "+sku);
        }

        for (int i = 0; i < nonOOS_ProdsList.size(); i++) {
            if (nonOOS_ProdsList.get(i).getText().toLowerCase().contains("add")) {
                inStockShipToList.add(nonOOS_ProdsList.get(i));
            } else if (nonOOS_ProdsList.get(i).getText().toLowerCase().contains("pickup today")) {
                inStockISPUList.add(nonOOS_ProdsList.get(i));
            }
        }

        try {
            if (shipType.toLowerCase().contains("ship")) {
                Random rand = new Random();
                n = rand.nextInt(inStockShipToList.size());

                inStockShipToList.get(n).click();
            }
            else if (shipType.toLowerCase().equals("ispu")||shipType.toLowerCase().contains("store")||shipType.toLowerCase().contains("pick")){
                Random rand = new Random();
                n = rand.nextInt(inStockISPUList.size());

                inStockISPUList.get(n).click();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }



    @When("^the user click to PDP of in-stock item from PLP page$")
    public List clickToInStockPdp() throws Throwable {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__plp_grid)));

        List<WebElement> nonOOS_ProdsList = driver.findElements(By.cssSelector(selector.container__plp_item__non_OOS));

        List<WebElement> inStockList = new ArrayList<WebElement>();
        List<WebElement> viewDetailsList = new ArrayList<WebElement>();

        for (int i = 0; i < nonOOS_ProdsList.size(); i++) {
            if (!nonOOS_ProdsList.get(i).getText().toLowerCase().contains("view details")) {
                inStockList.add(nonOOS_ProdsList.get(i));
            } else if (nonOOS_ProdsList.get(i).getText().toLowerCase().contains("view details")) {
                viewDetailsList.add(nonOOS_ProdsList.get(i));
            }
        }

        Random rand = new Random();
        n = rand.nextInt(inStockList.size());

        inStockList.get(n).click();
        return inStockList;
    }


    @When("^the user clicks to PDP of in-stock Ship-to item from PLP page$")
    public List clickToInStockShipToPdp() throws Throwable {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__plp_grid)));

        List<WebElement> nonOOS_ProdsList = driver.findElements(By.cssSelector(selector.container__plp_item__non_OOS));

        List<WebElement> inStockShipToList = new ArrayList<WebElement>();
        List<WebElement> viewDetailsList = new ArrayList<WebElement>();

        for (int i = 0; i < nonOOS_ProdsList.size(); i++) {
            if (nonOOS_ProdsList.get(i).getText().toLowerCase().contains("add")) {
                inStockShipToList.add(nonOOS_ProdsList.get(i));
            }
        }

        Random rand = new Random();
        n = rand.nextInt(inStockShipToList.size());

        inStockShipToList.get(n).click();
        return inStockShipToList;
    }


    @When("^the user clicks to PDP of in-stock ISPU item from PLP page$")
    public List clickToInStockISPUPdp() throws Throwable {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__plp_grid)));

        List<WebElement> nonOOS_ProdsList = driver.findElements(By.cssSelector(selector.container__plp_item__non_OOS));

        List<WebElement> inStockISPUList = new ArrayList<WebElement>();
        List<WebElement> viewDetailsList = new ArrayList<WebElement>();

        for (int i = 0; i < nonOOS_ProdsList.size(); i++) {
            if (nonOOS_ProdsList.get(i).getText().toLowerCase().contains("pickup today")) {
                inStockISPUList.add(nonOOS_ProdsList.get(i));
            }
        }

        Random rand = new Random();
        n = rand.nextInt(inStockISPUList.size());

        inStockISPUList.get(n).click();
        return inStockISPUList;
    }
}