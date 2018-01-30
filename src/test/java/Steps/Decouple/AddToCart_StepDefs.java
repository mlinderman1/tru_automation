package Steps.Decouple;

import Steps.AbstractPage_StepDefs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.Data;
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

public class AddToCart_StepDefs extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  Random rand = new Random();
  WebDriverWait wait = new WebDriverWait(driver, 20);
  Common_StepDefs common = new Common_StepDefs();
  PLP_StepDefs plp = new PLP_StepDefs();
  PDP_StepDefs pdp = new PDP_StepDefs();
  GlobalHeader_StepDefs header = new GlobalHeader_StepDefs();
  int n;

  @When("^the user adds a random gift-eligible item to cart$")
  public void iAddAGiftEligibleItemToCart() throws Throwable {
    Selectors selector = new Selectors();
    Boolean giftable = false;


    List<WebElement> atcButtonsList = driver.findElements(By.xpath(selector.btn__add_to_cart));

    ArrayList searchItems = Data.search_Items();


    int i = 0;

    n = rand.nextInt(searchItems.size());
    String item = searchItems.get(n).toString();

    System.out.println("");
    System.out.println("Size of search Items Array: " + searchItems.size());
    for (int x = 0; x < searchItems.size(); x++) {
      System.out.println(x + ") " + searchItems.get(x).toString());
    }
    System.out.println("Random number: " + n);
    System.out.println("");

    try {
      while (!giftable) {
        do {
          new GlobalHeader_StepDefs().iSearchForKeyword(item);
          wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__plp_grid)));

          new PLP_StepDefs().clickToInStockShipToPdp();
          giftable = new PDP_StepDefs().pdpVerifyGiftable();
          if (giftable) {
            new PDP_StepDefs().iAddPDPItemToCart();
            break;
          }
          System.out.println("");
          System.out.println("?????????? " + item + " item " + i + " is giftable? " + giftable);
          i++;

        }
        while (i < 2);  // Searches same keyword 2 times for gift-eligible item, then changes keyword until gift-eligible item found.

        String previousItem = item;

        if (!giftable) {
          do {
            searchItems.remove(n);

            System.out.println("");
            System.out.println("Size of search Items Array: " + searchItems.size());
            for (int x = 0; x < searchItems.size(); x++) {
              System.out.println(x + ") " + searchItems.get(x).toString());
            }
            System.out.println("Random number: " + n);

            n = rand.nextInt(searchItems.size());
            System.out.println("Random number: " + n);
            item = searchItems.get(n).toString();
          }
          while (item == previousItem);
          i = 0;
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    } catch (StaleElementReferenceException e) {
      System.out.println(e);
    }


  }


  @When("^the user adds \"([^\"]*)\" item to cart from \"([^\"]*)\" for \"([^\"]*)\"$")
  public void theUserAddsItemToCartFromPageInEnvironment(String itemType, String pageType, String shipType) throws Throwable {
    try {
      header.iSearchForKeyword(itemType);
    } catch (Exception e) {
      return;
    } finally {
      try {
        if (pageType.toLowerCase().equals("plp")) {
          plp.addToCart(shipType);
        } else if (pageType.toLowerCase().equals("pdp")) {
          plp.theUserNavigatesToPDPOfInStockItem(shipType);
          pdp.theUserAddsItemFromPDPPage(shipType);
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }

  @And("^I add \"([^\"]*)\" of \"([^\"]*)\" item\\(s\\) to my cart from \"([^\"]*)\" page$")
  public void i_add_of_item_s_to_my_cart_from_page(String number, String buttonType, String page) throws Throwable {

    int numberOfItems = Integer.parseInt(number);

    for (int i = 1; i <= numberOfItems; i++) {
      if (page.equals("plp")){
        plp.addToCart(buttonType);
      }
      else if (page.equals("pdp")){
        pdp.iAddPDPItemToCart();
      }
    }
  }



}



