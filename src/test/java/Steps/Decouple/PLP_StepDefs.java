package Steps.Decouple;

import Steps.AbstractPage_StepDefs;
import Steps.Flyout__InStorePickUp;
import cucumber.api.java.en.When;
import lib.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PLP_StepDefs extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  Selectors selector = new Selectors();
  Random rand = new Random();
  WebDriverWait wait = new WebDriverWait(driver, 30);
  int n;
  Flyout__InStorePickUp ispu = new Flyout__InStorePickUp();


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

        System.out.println("");
      System.out.println("//////"+atcButtonsList.get(n).getAttribute("class"));
        atcButtonsList.get(n).click();
      } else if (buttonType.toLowerCase().equals("ispu") || buttonType.toLowerCase().contains("store") || buttonType.toLowerCase().contains("pickup")) {

        n = rand.nextInt(ispuButtonsList.size());
        System.out.println("");
        System.out.println("//////"+ispuButtonsList.get(n).getAttribute("class"));
        ispuButtonsList.get(n).click();

        try {
          WebElement container__ispu = driver.findElement(By.cssSelector(selector.container__ispu));

          if (container__ispu.isDisplayed()) {
            ispu.theUserSelectsStoreToPickUpItem();
          }
        } catch (Exception e) {
          driver.findElement(By.cssSelector(selector.btn__flyout__close)).click();
          driver.navigate().refresh();
          addToCart(buttonType);
        }
      }

      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
    } catch (StaleElementReferenceException e) {
      System.out.println(e);
    }

  }

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

    System.out.println("> > > > > > > "+inStockISPUList.get(0));

    Random rand = new Random();
    n = rand.nextInt(inStockISPUList.size());

    inStockISPUList.get(n).click();
    return inStockISPUList;
  }

}


