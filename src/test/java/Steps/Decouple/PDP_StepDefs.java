package Steps.Decouple;

import Steps.AbstractPage_StepDefs;
import Steps.Flyout__InStorePickUp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class PDP_StepDefs extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  Random rand = new Random();
  WebDriverWait wait = new WebDriverWait(driver, 20);
  int n;
  Selectors selector = new Selectors();
  Flyout__InStorePickUp ispu = new Flyout__InStorePickUp();
  Common_StepDefs common = new Common_StepDefs();

  @When("^the user verify in PDP if item is gift-eligible$")
  public Boolean pdpVerifyGiftable() throws Throwable {
    Selectors selector = new Selectors();

    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__page__pdp)));
    WebElement pdpSection = driver.findElement(By.cssSelector(".pdp-details"));

    if (pdpSection.getText().toLowerCase().contains("gift wrap available")) {
      System.out.println("//////// GIFT WRAP ELIGIBLE");
      return true;
    } else {
      System.out.println("//////// GIFT WRAP NOT ELIGIBLE");
      return false;
    }
  }


  @Then("^the user adds PDP item to cart$")
  public void iAddPDPItemToCart() throws Throwable {
    Selectors selector = new Selectors();
    WebElement btn__add_to_cart = driver.findElement(By.cssSelector(selector.btn__pdp__add_to_cart));

    wait.until(ExpectedConditions.elementToBeClickable(btn__add_to_cart));

    btn__add_to_cart.click();

    try {
      WebElement container__ispu = driver.findElement(By.cssSelector(selector.container__ispu));

      if (container__ispu.isDisplayed()) {
        ispu.theUserSelectsStoreToPickUpItem();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
  }

  @And("^the user clicks ISPU link$")
  public void theUserClicksISPULink() throws Throwable {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.link__pdp__ispu)));

    WebElement ispuLink = driver.findElement(By.cssSelector(selector.link__pdp__ispu));

    ispuLink.click();
  }

  @And("^the user adds ISPU item to cart from pdp page$")
  public void theUserAddsISPUItemToCartFromPdpPage() throws Throwable {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.container__page__pdp)));
    theUserClicksISPULink();
    ispu.theUserSelectsStoreToPickUpItem();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
  }

  @And("^the user adds \"([^\"]*)\" item from PDP page$")
  public void theUserAddsItemFromPDPPage(String shipType) throws Throwable {
    if (shipType.toLowerCase().equals("ispu")||shipType.toLowerCase().contains("store")||shipType.toLowerCase().contains("pick")){
      theUserAddsISPUItemToCartFromPdpPage();
    }
    else {
      iAddPDPItemToCart();
    }
  }


}

