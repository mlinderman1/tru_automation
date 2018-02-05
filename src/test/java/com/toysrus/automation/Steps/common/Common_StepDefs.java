package com.toysrus.automation.Steps.common;

import com.toysrus.automation.Steps.overlays.Overlay__LightBox;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Common_StepDefs extends AbstractPage_StepDefs {

    public class Selectors {
    public static final String page = ".page-layout";
  }

  WebDriver driver = getDriver();
  WebDriverWait wait = new WebDriverWait(driver, 30);
  URL siteURL;
  Random rand = new Random();
  int n;
  Overlay__LightBox lightBox = new Overlay__LightBox();

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

  @When("^the user goes back one page$")
  public void iGoBackOnePage() throws Throwable
  {
    driver.navigate().back();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

    @Then("^the user refreshes the page$")
    public void theUserRefreshesThePage() throws Throwable {
        driver.navigate().refresh();
    }

}
