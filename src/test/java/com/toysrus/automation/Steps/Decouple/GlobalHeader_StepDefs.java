package com.toysrus.automation.Steps.Decouple;

import com.toysrus.automation.Steps.AbstractPage_StepDefs;
import com.toysrus.automation.Selectors.Data;
import com.toysrus.automation.Selectors.t2Selectors;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import com.toysrus.automation.Selectors.Selectors;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class GlobalHeader_StepDefs extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  WebDriverWait wait = new WebDriverWait(driver, 30);
  URL siteURL;
  Random rand = new Random();
  int n;
  Common_StepDefs common = new Common_StepDefs();

  @Before
  public void setUp() {
    getDriver();
    driver.manage().window().maximize();
  }

  @After
  public void breakDown() {
    closeDriver();
  }

  @When("^the user clicks \"([^\"]*)\" from global header$")
  public void iClick(String element) throws Throwable
  {
    Boolean isT2Page = driver.findElements(By.cssSelector(".navbar")).size() > 0;
    if (isT2Page.equals(true))
    {
      t2Selectors selector = new t2Selectors();
      try
      {
        if (element.toLowerCase().contains("cart"))
        {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn_global_nav__minicart)));
            driver.findElement(By.cssSelector(selector.btn_global_nav__minicart)).click();
          }
        }

        else if ((element.toLowerCase().contains("toys") && element.toLowerCase().contains("logo")) || (element.toLowerCase().contains("tru") && element.toLowerCase().contains("logo")))
        {
          if (!driver.findElements(By.cssSelector(selector.btn__topline__logo__TRU)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.btn__topline__logo__TRU)).click();
          }
          else if (driver.findElements(By.cssSelector(selector.btn__topline__logo__TRU)).isEmpty())
          {
            if (!driver.findElements(By.cssSelector(selector.btn__main__TRU_logo1)).isEmpty())
            {
              driver.findElement(By.cssSelector(selector.btn__main__TRU_logo1)).click();
            }

            if (!driver.findElements(By.cssSelector(selector.btn__main__TRU_logo2)).isEmpty())
            {
              driver.findElement(By.cssSelector(selector.btn__main__TRU_logo2)).click();
            }

          }
        }

        else if ((element.toLowerCase().contains("babies") && element.toLowerCase().contains("logo")) || (element.toLowerCase().contains("bru") && element.toLowerCase().contains("logo"))) {
          if (!driver.findElements(By.cssSelector(selector.btn__topline__logo__BRU)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.btn__topline__logo__BRU)).click();
          }
          else if (driver.findElements(By.cssSelector(selector.btn__topline__logo__BRU)).isEmpty())
          {
            if (!driver.findElements(By.cssSelector(selector.btn__main__BRU__logo1)).isEmpty())
            {
              driver.findElement(By.cssSelector(selector.btn__main__BRU__logo1)).click();
            }
            else if (!driver.findElements(By.cssSelector(selector.btn__main__BRU__logo2)).isEmpty())
            {
              driver.findElement(By.cssSelector(selector.btn__main__BRU__logo2)).click();
            }
          }
        }

        else if (element.toLowerCase().contains("account")) {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__global_nav__my_account)));
            driver.findElement(By.cssSelector(selector.btn__global_nav__my_account)).click();
          }
        }
        else if (element.toLowerCase().contains("help")) {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__global_nav__help)));
            driver.findElement(By.cssSelector(selector.btn__global_nav__help)).click();
          }
        }

        else if (element.toLowerCase().contains("registry"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__registry1)).isEmpty())
          {
            WebElement headerElement = driver.findElement(By.cssSelector(selector.link__topline__registry1));
            headerElement.click();
          }

          else if (!driver.findElements(By.cssSelector(selector.link__topline__registry2)).isEmpty())
          {
            WebElement headerElement = driver.findElement(By.cssSelector(selector.link__topline__registry2));
            headerElement.click();
          }

        }

        else if (element.toLowerCase().contains("wish"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__wishlist1)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__wishlist1)).click();
          }

          if (!driver.findElements(By.cssSelector(selector.link__topline__wishlist2)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__wishlist2)).click();
          }
        }

        else if (element.toLowerCase().contains("find"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__find_a_store1)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__find_a_store1)).click();
          }

          if (!driver.findElements(By.cssSelector(selector.link__topline__find_a_store2)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__find_a_store2)).click();
          }
        }

        else if (element.toLowerCase().contains("weekly")||element.toLowerCase().contains("ad"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__weekly_ad1)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__weekly_ad1)).click();
          }

          if (!driver.findElements(By.cssSelector(selector.link__topline__weekly_ad2)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__weekly_ad2)).click();
          }
        }

        else if (element.toLowerCase().contains("giftcard")||element.toLowerCase().contains("gift card"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__gift_card1)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__gift_card1)).click();
          }

          if (!driver.findElements(By.cssSelector(selector.link__topline__gift_card2)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__gift_card2)).click();
          }
        }

      }

      catch (NoSuchElementException e) {
        System.out.println(e);
      }
    }

    else if (isT2Page.equals(false)) {
      Selectors selector = new Selectors();

      try {
        if (element.toLowerCase().contains("cart")) {
          {
            WebElement cart = driver.findElement(By.cssSelector(selector.btn_global_nav__minicart));
            wait.until(ExpectedConditions.visibilityOf(cart));
            cart.click();
          }
        }

        else if ((element.toLowerCase().contains("toys") && element.toLowerCase().contains("logo")) || (element.toLowerCase().contains("tru") && element.toLowerCase().contains("logo")))
        {
          if (!driver.findElements(By.cssSelector(selector.btn__topline__logo__TRU)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.btn__topline__logo__TRU)).click();
          }
          else if (driver.findElements(By.cssSelector(selector.btn__topline__logo__TRU)).isEmpty())
          {
            if (!driver.findElements(By.cssSelector(selector.btn__main__TRU_logo)).isEmpty())
            {
              driver.findElement(By.cssSelector(selector.btn__main__TRU_logo)).click();
            }
          }
        }

        else if ((element.toLowerCase().contains("babies") && element.toLowerCase().contains("logo")) || (element.toLowerCase().contains("bru") && element.toLowerCase().contains("logo"))) {
          if (!driver.findElements(By.cssSelector(selector.btn__topline__logo__BRU)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.btn__topline__logo__BRU)).click();
          }
          else if (driver.findElements(By.cssSelector(selector.btn__topline__logo__BRU)).isEmpty())
          {
            if (!driver.findElements(By.cssSelector(selector.btn__main__BRU__logo)).isEmpty())
            {
              driver.findElement(By.cssSelector(selector.btn__main__BRU__logo)).click();
            }
          }
        }

        else if (element.toLowerCase().contains("account")) {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__global_nav__my_account)));
            driver.findElement(By.cssSelector(selector.btn__global_nav__my_account)).click();
          }
        }
        else if (element.toLowerCase().contains("help")) {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__global_nav__help)));
            driver.findElement(By.cssSelector(selector.btn__global_nav__help)).click();
          }
        }

        else if (element.toLowerCase().contains("registry"))
        {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.link__topline__registry)));
            driver.findElement(By.cssSelector(selector.link__topline__registry)).click();
          }
        }

        else if (element.toLowerCase().contains("wish"))
        {
          {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.link__topline__wishlist)));
            driver.findElement(By.cssSelector(selector.link__topline__wishlist)).click();
          }
        }

        else if (element.toLowerCase().contains("find"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__find_a_store)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__find_a_store)).click();
          }
        }

        else if (element.toLowerCase().contains("weekly")||element.toLowerCase().contains("ad"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__weekly_ad)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__weekly_ad)).click();
          }
        }

        else if (element.toLowerCase().contains("giftcard")||element.toLowerCase().contains("gift card"))
        {
          if (!driver.findElements(By.cssSelector(selector.link__topline__gift_card)).isEmpty())
          {
            driver.findElement(By.cssSelector(selector.link__topline__gift_card)).click();
          }
        }
      }
      catch (NoSuchElementException e) {
        System.out.println(e);
      }
    }
    else
    {
      try
      {
        driver.findElement(By.cssSelector(element.toLowerCase()));
      }
      catch (NoSuchElementException e) {
        System.out.println(e);
      }
    }
  }

  @When("^the user searches for \"([^\"]*)\"$")
  public void iSearchForKeyword(String keyword) throws Throwable {
    Boolean isT2Page = driver.findElements(By.cssSelector(".navbar")).size() > 0;


    if (isT2Page.equals(true)) {
      t2Selectors selector = new t2Selectors();

      WebElement header = driver.findElement(By.cssSelector(selector.input__global_nav__search_field));
      wait.until(ExpectedConditions.visibilityOf(header));

      WebElement input__global_nav__search_field = driver.findElement(By.cssSelector(selector.input__global_nav__search_field));

      if (keyword.contains("random") || keyword.contains("any")) {
        iSearchForARandomItem();
      } else {
        String cssSelector = selector.input__global_nav__search_field;
        String data = keyword;

        common.inputField(cssSelector, data);
        input__global_nav__search_field.sendKeys(Keys.RETURN);

      }


    } else if (isT2Page.equals(false)) {
      Selectors selector = new Selectors();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.input__global_nav__search_field)));

      WebElement input__global_nav__search_field = driver.findElement(By.cssSelector(selector.input__global_nav__search_field));

      if (keyword.contains("random") || keyword.contains("any")) {
        iSearchForARandomItem();
      } else {
        String cssSelector = selector.input__global_nav__search_field;
        String data = keyword;

        common.inputField(cssSelector, data);
        input__global_nav__search_field.sendKeys(Keys.RETURN);
      }

    }
  }

  @When("^the user searches for a random item$")
  public void iSearchForARandomItem() throws Throwable {
    Selectors selector = new Selectors();

    ArrayList searchItems = Data.search_Items();

    int i=0;

    n = rand.nextInt(searchItems.size());
    String item = searchItems.get(n).toString();

    try{
      new GlobalHeader_StepDefs().iSearchForKeyword(item);
    }

    catch (IllegalArgumentException e){
      System.out.println(e);

    }
    catch (StaleElementReferenceException e){
      System.out.println(e);
    }

  }


}
