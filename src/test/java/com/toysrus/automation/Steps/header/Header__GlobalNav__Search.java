package com.toysrus.automation.Steps.header;

import com.toysrus.automation.lib.Data;
import com.toysrus.automation.Steps.common.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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
    WebDriverWait wait = new WebDriverWait(driver, 30);
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
