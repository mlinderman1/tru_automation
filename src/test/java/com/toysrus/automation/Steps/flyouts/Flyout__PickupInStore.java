package com.toysrus.automation.Steps.flyouts;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
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

public class Flyout__PickupInStore extends AbstractPage_StepDefs {


    public class Selectors {
        public static final String container__ispu = ".ispu-modal";
        public static final String btn__ispu__pickup = ".pickup-btn";
        public static final String btn__ispu__make_store = ".ispu-stores-list__item-link";
        public static final String dropdown__ispu__distance = ".ispu-find-store-form__distance-select";
        public static final String dropdown__ispu__distance_option = ".ispu-find-store-form__distance-select option";
    }

    WebDriver driver = getDriver();
    Random rand = new Random();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Common_StepDefs common = new Common_StepDefs();
    int n;
    Selectors selector = new Selectors();

    @When("^the user verifies a location is available in ISPU menu$")
    public Boolean ispuVerifyISPULocationAvailable() throws Throwable {
        Selectors selector = new Selectors();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.btn__ispu__pickup)));
            WebElement ispuPickupButton = driver.findElement(By.cssSelector(Selectors.btn__ispu__pickup));

            if (ispuPickupButton.isDisplayed()) {
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @And("^the user selects store to pick up item$")
    public void theUserSelectsStoreToPickUpItem() throws Throwable {
        Boolean locationAvailable = true;
        Boolean ispuClicked = true;

        try {

            WebElement container__ispu = driver.findElement(By.cssSelector(Selectors.container__ispu));


            if (container__ispu.isDisplayed()) {

                List<WebElement> ispuDistanceOptions = driver.findElements(By.cssSelector(Selectors.dropdown__ispu__distance_option));
                List<String> ispuDistances = new ArrayList<String>();

                for (int i=0;i<ispuDistanceOptions.size();i++){
                    String distanceOption = ispuDistanceOptions.get(i).getAttribute("value");
                    ispuDistances.add(i,distanceOption);
                }

                WebElement ispuDistanceMenu = driver.findElement(By.cssSelector(Selectors.dropdown__ispu__distance));
                String ispuDefaultDistance = ispuDistanceMenu.getAttribute("value");

                int defaultIndex = ispuDistances.indexOf(ispuDefaultDistance);

                locationAvailable = ispuVerifyISPULocationAvailable();

                if (locationAvailable == true) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.btn__ispu__pickup))).click();
                }
                else if (locationAvailable == false) {
                    for (int x=defaultIndex+1;x<ispuDistanceOptions.size();x++)
                    {

                        try {
                            String text = ispuDistanceOptions.get(x).getText();
                            String ispuDistanceValue = text.replaceAll("[^0-9.]", "");

                            String cssSelector = Selectors.dropdown__ispu__distance;
                            String data = ispuDistanceValue;

                            common.selectFromDropdownMenu(cssSelector, data);

                            locationAvailable = ispuVerifyISPULocationAvailable();

                            if (locationAvailable == true) {
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.btn__ispu__pickup))).click();
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




