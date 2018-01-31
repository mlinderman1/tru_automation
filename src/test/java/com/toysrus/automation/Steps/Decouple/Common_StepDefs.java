package com.toysrus.automation.Steps.Decouple;

import com.toysrus.automation.Steps.AbstractPage_StepDefs;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import com.toysrus.automation.Selectors.Selectors;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Common_StepDefs extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  WebDriverWait wait = new WebDriverWait(driver, 30);
  URL siteURL;
  Random rand = new Random();
  int n;

  @Before
  public void setUp() {
    getDriver();
    driver.manage().window().maximize();
  }

  @After
  public void breakDown() {
    closeDriver();
  }


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

  @And("^the user navigates to \"([^\"]*)\" site in \"([^\"]*)\" environment$")
  public void iNavigateToSiteSite(String site, String environment) throws Throwable {

    Selectors selector = new Selectors();

    try
    {
      driver.navigate().to(site);
    }
    catch(InvalidArgumentException e)
    {
      System.out.println(e);
    }

    finally
    {
      try{
        if (site.toLowerCase().contains("toys") || site.toLowerCase().equals("tru")) {
          if (environment.toLowerCase().contains("prod") || environment.toLowerCase().contains("live")){
            siteURL = new URL("https://www.toysrus.com");
          }
          else if (environment.toLowerCase().equals("qa1")) {
            siteURL = new URL("https://webstoreqa1.toysrus.com");
          }
          else if (environment.toLowerCase().equals("qa2")) {
            siteURL = new URL("https://webstoreqa2.toysrus.com");
          }
          else if (environment.toLowerCase().equals("qa4")) {
            siteURL = new URL("https://webstoreqa4.toysrus.com");
          }
          else if (environment.toLowerCase().equals("staging")) {
            siteURL = new URL("https://webstorestaging.toysrus.com");
          }

        } else if (site.toLowerCase().contains("babies") || site.toLowerCase().equals("bru")) {
          if (environment.toLowerCase().contains("prod")){
            siteURL = new URL("https://www.babiesrus.com");
          }
          else if (environment.toLowerCase().equals("qa1")) {
            siteURL = new URL("https://webstoreqa1.babiesrus.com");
          }
          else if (environment.toLowerCase().equals("qa2")) {
            siteURL = new URL("https://webstoreqa2.babiesrus.com");
          }
          else if (environment.toLowerCase().equals("qa4")) {
            siteURL = new URL("https://webstoreqa4.babiesrus.com");
          }
          else if (environment.toLowerCase().equals("staging")) {
            siteURL = new URL("https://webstorestaging.babiesrus.com");
          }
        } else if (site.toLowerCase().contains("registry")) {
          if (environment.toLowerCase().contains("prod")){
            siteURL = new URL("https://babyregistry.toysrus.com");
          }
          else if (environment.toLowerCase().equals("qa1")) {
            siteURL = new URL("");
          }
          else if (environment.toLowerCase().equals("qa2")) {
            siteURL = new URL("");
          }
          else if (environment.toLowerCase().equals("staging")) {
            siteURL = new URL("https://babyregistryuat.toysrus.com");
          }
        } else if ((site.toLowerCase().equals("wishlist") || (site.toLowerCase().equals("wish list")))) {
          if (environment.toLowerCase().contains("prod")){
            siteURL = new URL("https://wishlist.toysrus.com");
          }
          else if (environment.toLowerCase().equals("qa1")) {
            siteURL = new URL("");
          }
          else if (environment.toLowerCase().equals("qa2")) {
            siteURL = new URL("");
          }
          else if (environment.toLowerCase().equals("staging")) {
            siteURL = new URL("https://wishlistuat.toysrus.com");
          }
        } else {
          siteURL = new URL(site);
        }
        driver.navigate().to(siteURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.page)));
      }
      catch (InvalidArgumentException e) {
        System.out.println(e);
      }

      try
      {
        WebElement btn__lightbox__close = driver.findElement(By.cssSelector(selector.btn__lightbox__close));
        if (btn__lightbox__close.isDisplayed())
        {
          btn__lightbox__close.click();
        }
      }
      catch (org.openqa.selenium.NoSuchElementException e) {
        System.out.println(e);
      }

      catch (TimeoutException e) {
        System.out.println(e);
      }

      finally
      {
        System.out.println("Navigated to " + driver.getCurrentUrl());
      }
    }
  }

  @When("^the user goes back one page$")
  public void iGoBackOnePage() throws Throwable
  {
    driver.navigate().back();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

}
