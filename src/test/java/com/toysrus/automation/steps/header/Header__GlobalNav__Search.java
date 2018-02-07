package com.toysrus.automation.steps.header;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.*;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Random;

public class Header__GlobalNav__Search extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String input__global_nav__search_field = "#search-input";
    }

    public class t2Selectors {
        public static final String input__global_nav__search_field = "#searchText";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Random rand = new Random();
    int n;
    Common_StepDefs common = new Common_StepDefs();
    Selectors selector = new Selectors();
    t2Selectors t2selector = new t2Selectors();
    Boolean isT2Page = driver.findElements(By.cssSelector(".navbar")).size() > 0;

    @When("^the user searches for \"([^\"]*)\"$")
    public void iSearchForKeyword(String keyword) throws Throwable {
        try {
            WebElement header = driver.findElement(By.cssSelector(selector.input__global_nav__search_field));
            wait.until(ExpectedConditions.visibilityOf(header));

            WebElement input__global_nav__search_field = driver.findElement(By.cssSelector(selector.input__global_nav__search_field));

            String cssSelector = selector.input__global_nav__search_field;
            String data = keyword;

            common.inputField(cssSelector, data);
            input__global_nav__search_field.sendKeys(Keys.RETURN);
        }
        catch (Exception e) {
            WebElement header = driver.findElement(By.cssSelector(t2selector.input__global_nav__search_field));
            wait.until(ExpectedConditions.visibilityOf(header));

            WebElement input__global_nav__search_field = driver.findElement(By.cssSelector(t2selector.input__global_nav__search_field));

            String cssSelector = t2selector.input__global_nav__search_field;
            String data = keyword;

            common.inputField(cssSelector, data);
            input__global_nav__search_field.sendKeys(Keys.RETURN);
        }
    }

    @When("^the user searches for a random item$")
    public void iSearchForARandomItem() throws Throwable {
        ArrayList searchItems = Data.search_Items();

        int i=0;

        n = rand.nextInt(searchItems.size());
        String item = searchItems.get(n).toString();

        try{
            iSearchForKeyword(item);
        }

        catch (IllegalArgumentException e){
            System.out.println(e);

        }
        catch (StaleElementReferenceException e){
            System.out.println(e);
        }

    }
}
