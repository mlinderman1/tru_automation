package com.toysrus.automation.Steps.header;

import com.toysrus.automation.Steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.Steps.common.Common_StepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Header__GlobalNav__Common extends AbstractPage_StepDefs {

    public class Selectors {
        public static final String btn__main__TRU_logo = ".header-fat__logo.header-fat__logo-tru";
        public static final String btn__main__BRU__logo = ".header-fat__logo.header-fat__logo-bru";
        public static final String btn__main_logo = ".header-fat__logo-img";
    }

    public class t2Selectors {
        public static final String btn__main__TRU_logo1 = "#logo-swap-lg-tru";
        public static final String btn__main__TRU_logo2 = ".headerspritetoysruslogolarge";
        public static final String btn__main__BRU__logo1 = ".logo-swap";
        public static final String btn__main__BRU__logo2 = "#logo-swap-lg-bru";
    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Random rand = new Random();
    int n;
    Common_StepDefs common = new Common_StepDefs();
    Selectors selector = new Selectors();
    t2Selectors t2selector = new t2Selectors();

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @When("^the user clicks main \"([^\"]*)\" logo from the global navbar$")
    public void theUserClicksMainLogoFromTheGlobalNavbar(String logo) throws Throwable {
        if (logo.toLowerCase().equals("tru")||logo.toLowerCase().equals("toys")){
            try{
                driver.findElement(By.cssSelector(selector.btn__main__TRU_logo)).click();
            }
            catch(Exception e){
                try {
                    driver.findElement(By.cssSelector(t2selector.btn__main__TRU_logo1)).click();
                }
                catch(Exception a){
                    try {
                        driver.findElement(By.cssSelector(t2selector.btn__main__TRU_logo2)).click();
                    }
                    catch(Exception b){
                        driver.findElement(By.cssSelector(selector.btn__main_logo)).click();
                        }
                    }
                }
            }

        else if (logo.toLowerCase().equals("bru")||logo.toLowerCase().equals("babies")){
            try{
                driver.findElement(By.cssSelector(selector.btn__main__BRU__logo)).click();
            }
            catch(Exception e){
                try {
                    driver.findElement(By.cssSelector(t2selector.btn__main__BRU__logo2)).click();
                }
                catch(Exception a){
                    try {
                        driver.findElement(By.cssSelector(t2selector.btn__main__BRU__logo2)).click();
                    }
                    catch(Exception b){
                        driver.findElement(By.cssSelector(selector.btn__main_logo)).click();
                    }
                }
            }
        }
    }

    @When("^the user clicks main ToysRUs logo from the global navbar$")
    public WebElement theUserClicksMainToysRUsLogoFromTheGlobalNavbar() throws Throwable {
        WebElement btn__main__TRU_logo = null;

        try {
            btn__main__TRU_logo = driver.findElement(By.cssSelector(selector.btn__main__TRU_logo));
            return btn__main__TRU_logo;
        }
        catch (Exception e) {
            try {
                btn__main__TRU_logo = driver.findElement(By.cssSelector(t2selector.btn__main__TRU_logo1));
                return btn__main__TRU_logo;
            }
            catch (Exception a){
                try {
                    btn__main__TRU_logo = driver.findElement(By.cssSelector(t2selector.btn__main__TRU_logo2));
                    return btn__main__TRU_logo;
                }
                catch (Exception b)
                {
                    btn__main__TRU_logo = driver.findElement(By.cssSelector(selector.btn__main_logo));
                    return btn__main__TRU_logo;
                }
            }
        }
        finally {
            btn__main__TRU_logo.click();
        }
    }

    @When("^the user clicks main BabiesRUs logo from the global navbar$")
    public WebElement theUserClicksMainBabiesRUsLogoFromTheGlobalNavbar() throws Throwable {
        WebElement btn__main__BRU_logo = null;

        try {
            btn__main__BRU_logo = driver.findElement(By.cssSelector(selector.btn__main__BRU__logo));
            return btn__main__BRU_logo;
        } catch (Exception e) {
            try {
                btn__main__BRU_logo = driver.findElement(By.cssSelector(t2selector.btn__main__BRU__logo1));
                return btn__main__BRU_logo;
            } catch (Exception a) {
                try {
                    btn__main__BRU_logo = driver.findElement(By.cssSelector(t2selector.btn__main__BRU__logo2));
                    return btn__main__BRU_logo;
                } catch (Exception b) {
                    btn__main__BRU_logo = driver.findElement(By.cssSelector(selector.btn__main_logo));
                    return btn__main__BRU_logo;
                }
            }
        } finally {
            btn__main__BRU_logo.click();
        }
    }
}
