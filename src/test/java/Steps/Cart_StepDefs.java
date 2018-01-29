package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.Selectors;
import lib.t2Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Cart_StepDefs extends AbstractPage_StepDefs {

    WebDriver driver = getDriver();
    Random rand = new Random();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();
    int n;

  @And("^the user proceeds to \"([^\"]*)\" checkout$")
  public void iProceedToCheckout(String checkoutType) throws Throwable {
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector.container__page__cart)));

    if (checkoutType.toLowerCase().equals("standard")){
      WebElement topcheckout = driver.findElement(By.cssSelector(selector.btn__checkout_standard__top));
      topcheckout.click();
    }

    else if (checkoutType.toLowerCase().equals("paypal")||checkoutType.toLowerCase().contains("pay")){
      WebElement payPalBtn = driver.findElement(By.cssSelector(selector.btn__checkout_PayPal));
      payPalBtn.click();
    }
  }

    @Then("^the user selects gift option on cart page$")
    public void iSelectGiftOptionOnCartPage() throws Throwable {

        List<WebElement> gift_option = driver.findElements(By.cssSelector(selector.radiobtn__gift));

        n = rand.nextInt(gift_option.size());

        wait.until(ExpectedConditions.elementToBeClickable(gift_option.get(n)));
        gift_option.get(n).click();

        wait.until(ExpectedConditions.visibilityOf(gift_option.get(n))).findElement(By.cssSelector(selector.radiobtn__gift_checked));

//        gift_option.get(n).findElement(By.cssSelector(selector.radiobtn__gift_checked));

        System.out.println("Number of giftable products "+gift_option.size());
        System.out.println("");
//        wait.until(ExpectedConditions.)

    }

  @When("^the user navigates to cart page$")
  public void theUserNavigatesToCartPage() throws Throwable {
    Boolean isT2Page = driver.findElements(By.cssSelector(".navbar")).size() > 0;
    if (isT2Page.equals(true)) {
      t2Selectors selector = new t2Selectors();
      try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn_global_nav__minicart)));
        driver.findElement(By.cssSelector(selector.btn_global_nav__minicart)).click();
      } catch (NoSuchElementException e) {
          System.out.println(e);
      }
    } else if (isT2Page.equals(false)) {
      Selectors selector = new Selectors();

      try {
        WebElement cart = driver.findElement(By.cssSelector(selector.btn_global_nav__minicart));
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
      } catch (NoSuchElementException e) {
          System.out.println(e);
      }
    }
  }

}


