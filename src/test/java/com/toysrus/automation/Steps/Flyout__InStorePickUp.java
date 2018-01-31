package com.toysrus.automation.Steps;

import com.toysrus.automation.Steps.Decouple.Common_StepDefs;
import com.toysrus.automation.Steps.Decouple.GlobalHeader_StepDefs;
import com.toysrus.automation.Selectors.Selectors;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flyout__InStorePickUp extends AbstractPage_StepDefs {

  WebDriver driver = getDriver();
  Random rand = new Random();
  WebDriverWait wait = new WebDriverWait(driver, 20);
    Common_StepDefs common = new Common_StepDefs();
//  PLP_StepDefs plp = new PLP_StepDefs();
//  PDP_StepDefs pdp = new PDP_StepDefs();
  GlobalHeader_StepDefs header = new GlobalHeader_StepDefs();
  int n;
  Selectors selector = new Selectors();

  @When("^the user verifies a location is available in ISPU menu$")
  public Boolean ispuVerifyISPULocationAvailable() throws Throwable {
    Selectors selector = new Selectors();

    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.btn__ispu__pickup)));
      WebElement ispuPickupButton = driver.findElement(By.cssSelector(selector.btn__ispu__pickup));

      if (ispuPickupButton.isDisplayed()) {
        return true;
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
    return false;
  }


  @When("^the user verifies an ISPU location has been selected$")
  public Boolean ispuVerifySelected() throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector.overlay__add_to_cart)));
    WebElement overlay__add_to_cart = driver.findElement(By.cssSelector(selector.overlay__add_to_cart));

    if (overlay__add_to_cart.isDisplayed()){
      return true;
    }
    else{
      return false;
    }
  }

  @And("^the user selects store to pick up item$")
  public void theUserSelectsStoreToPickUpItem() throws Throwable {
    Boolean locationAvailable = true;
    Boolean ispuClicked = true;

    try {

      WebElement container__ispu = driver.findElement(By.cssSelector(selector.container__ispu));


      if (container__ispu.isDisplayed()) {

        List<WebElement> ispuDistanceOptions = driver.findElements(By.cssSelector(selector.dropdown__ispu__distance_option));
        List<String> ispuDistances = new ArrayList<String>();

        for (int i=0;i<ispuDistanceOptions.size();i++){
          String distanceOption = ispuDistanceOptions.get(i).getAttribute("value");
          ispuDistances.add(i,distanceOption);
        }

        WebElement ispuDistanceMenu = driver.findElement(By.cssSelector(selector.dropdown__ispu__distance));
        String ispuDefaultDistance = ispuDistanceMenu.getAttribute("value");

        int defaultIndex = ispuDistances.indexOf(ispuDefaultDistance);

        locationAvailable = ispuVerifyISPULocationAvailable();

        if (locationAvailable == true) {
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__ispu__pickup))).click();
        }
        else if (locationAvailable == false) {
          for (int x=defaultIndex+1;x<ispuDistanceOptions.size();x++)
          {

            try {
              String text = ispuDistanceOptions.get(x).getText();
              String ispuDistanceValue = text.replaceAll("[^0-9.]", "");

              String cssSelector = selector.dropdown__ispu__distance;
              String data = ispuDistanceValue;

              common.selectFromDropdownMenu(cssSelector, data);

              locationAvailable = ispuVerifyISPULocationAvailable();

              if (locationAvailable == true) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector.btn__ispu__pickup))).click();
              } else if (locationAvailable == false) {

                locationAvailable = ispuVerifyISPULocationAvailable();
              }
            }
            catch(Exception e){
              System.out.println(e);
            }
          }

        }
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }


}



