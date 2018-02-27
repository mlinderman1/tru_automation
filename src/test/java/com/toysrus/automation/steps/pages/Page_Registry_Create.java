package com.toysrus.automation.steps.pages;
import com.sun.jna.platform.win32.WinDef;
import com.toysrus.automation.lib.Data;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class Page_Registry_Create extends AbstractPage_StepDefs {


    public static class Selectors {
        public static final String Email = "input[id='email']";
        public static final String CR_Email = "input[id='fconnectEmailID']";
        public static final String password = "input[id='password']";
        public static final String CR_password = "input[id='fcconectPwd']";
        public static final String CR_Conf_password = "input[id='fcconectvPwd']";
        public static final String Create_btn = "//input[@class='btn-bru hidden-xs']";
        public static final String Co_Reg_radiobtn = "input[id='co-reg-check']";
        public static final String Co_Reg_First_Name = "input[id='coregFirstName']";
        public static final String Co_Reg_Last_Name = "input[id='coregLastName']";
        public static final String Manage_btn = "input[id='signinbtn']";
        public static final String Signin_btn = "div[class='baby-registry-submit'] input[value='sign in']";
        public static final String MyAccount_Registries = "button[class='buttonUI']";
        public static final String Myregistry_dropdown = "input[id='my-registry-main']";
        public static final String myRegistry_Btn = "//div[@class='cate_heading']/a[@id='myregistrylink']";
        public static final String Dashboard_RegistryNumber = "font[class='information_text_bold_regNo']";
        public static final String Registry_SweepStakes_Window = "div[id='bruBabysFirstBdayLightboxContent']";
        public static final String Registry_SweepStakes_close = "a[id='bruBabysFirstBdayLightboxClose']";
        public static final String Registry_addtocart_popup = "div[class='tru-modal-dialog__header atc-overlay__header']";
        public static final String Minicart_Count = "span[class='header-fat__tile__count']";
        public static final String HomePage_SearchBtn = "findbutton";
        public static final String New_Searchfield = "firstlastregfield";
        public static final String Old_Searchfield = "newsearch_registry";
        public static final String FindBtn = "//input[@id='searchinitbtn']";
        public static final String SingleSearch_Result = "//*[@id='example']/tbody/tr[1]/td[1]";
        public static final String SearchResults = "//table[@id='example']/tbody/tr";
        public static final String Old_SingleSearch_Result = "//*[@id='example']/tbody/tr[1]/td[2]//p[@class='tab_reg_num']";
        public static final String GiftGiver_RegistryNumber = "div[class='information_text_Registryid'] span";
        public static final String GiftGiver_ListView = "div[data-at='btn__list-view']";
        public static final String FirstName = "input[id='firstName']";
        public static final String LastName = "input[id='lastName']";
        public static final String StreetAddress_Line1 = "input[id='address1']";
        public static final String StreetAddress_Line2 = "input[id='address2']";
        public static final String zipcode = "input[id='zipCode']";
        public static final String cityname = "input[id='cityname']";
        public static final String state = "select[id='state_opt']";
        public static final String contactNo = "input[id='contactNo']";
        public static final String babyDueMonth = "select[id='babyDueMonth']";
        public static final String babyDuedate = "select[id='babyDueDay']";
        public static final String create_registry_btn = "input[id='create_registry']";
        public static final String Suggested_address_radiobtn = "input[id='billingSuggOption1']";
        public static final String Usethis_address_btn = "button[id='useThisAddress']";
        public static final String Checklist_tab = "a[id='checklistlink']";
        public static final String myregistry_lnk = "//div[@class='cate_heading']/a[@id='myregistrylink']";
        public static final String myregistry_tab = "a[id='my-registry-main']";
        public static final String Registry_number = "font[class='information_text_bold_regNo']";
        public static final String Registry_number_Prod = "//div[@class='general_textNew dashheadpadd pull-left visible-lg visible-md visible-sm hidden-xs']//span";
        public static final String See_Publicview_lnk ="a[data-at='link__gift-giver-preview']";

        public static final String page = ".page-layout";
        public static final String page__homepage__tru = ".page-wrapper--tru";
        public static final String page__homepage__bru = ".page-wrapper--bru";

        public static WebElement Registry_addtocart_btn(WebDriver driver, WebElement product) {
            return product.findElement(By.cssSelector("button[data-at='btn__add-to-cart']"));
        }

        public static WebElement findProduct(WebDriver driver, String ItemSkn) {
            return driver.findElement(By.cssSelector("div[data-at^='product__" + ItemSkn + "']"));
        }

    }
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Selectors selector = new Selectors();
    Overlay__LightBox lightBox = new Overlay__LightBox();
    URL siteURL;

    @Before
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void breakDown() {
        closeDriver();
    }

    @Given("^the user navigates to \"([^\"]*)\" sites in \"([^\"]*)\" environment$")
    public void iNavigateToSiteSites(String site,String environment) throws Throwable {

        try {
            if (site.toLowerCase().contains("toys") || site.toLowerCase().equals("tru")) {
                if (environment.toLowerCase().contains("prod") || environment.toLowerCase().contains("live")) {
                    siteURL = new URL("https://www.toysrus.com");
                } else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("https://webstoreqa1.toysrus.com");
                } else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("https://webstoreqa2.toysrus.com");
                } else if (environment.toLowerCase().equals("qa4")) {
                    siteURL = new URL("https://webstoreqa4.toysrus.com");
                } else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://webstorestaging.toysrus.com");
                }

            } else if (site.toLowerCase().contains("babies") || site.toLowerCase().equals("bru")) {
                if (environment.toLowerCase().contains("prod")) {
                    siteURL = new URL("https://www.babiesrus.com");
                } else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("https://webstoreqa1.babiesrus.com");
                } else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("https://webstoreqa2.babiesrus.com");
                } else if (environment.toLowerCase().equals("qa4")) {
                    siteURL = new URL("https://webstoreqa4.babiesrus.com");
                } else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://webstorestaging.babiesrus.com");
                }
            } else if (site.toLowerCase().contains("registry")) {
                if (environment.toLowerCase().contains("prod")) {
                    siteURL = new URL("https://babyregistry.toysrus.com");
                } else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("https://babyregistryqa1.toysrus.com");
                } else if (environment.toLowerCase().equals("test")) {
                    siteURL = new URL("https://babyregistrytest.toysrus.com");
                } else if (environment.toLowerCase().equals("uat")) {
                    siteURL = new URL("https://babyregistryuat.toysrus.com");
                }
            } else if ((site.toLowerCase().equals("wishlist") || (site.toLowerCase().equals("wish list")))) {
                if (environment.toLowerCase().contains("prod")) {
                    siteURL = new URL("https://wishlist.toysrus.com");
                } else if (environment.toLowerCase().equals("qa1")) {
                    siteURL = new URL("");
                } else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("");
                } else if (environment.toLowerCase().equals("staging")) {
                    siteURL = new URL("https://wishlistuat.toysrus.com");
                }
            }
            driver.navigate().to(siteURL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Common_StepDefs.Selectors.t2page)));
        } catch (InvalidArgumentException e) {
            System.out.println(e);
        }

        try {
            lightBox.theUserClosesTheLightbox();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println(e);
        } catch (TimeoutException e) {
            System.out.println(e);
        }

    }


    @When("^the user clicks the create button on the registry home page$")
    public void theUserClicksTheCreateButtonOnTheRegistryHomePage() {
        driver.findElement(By.xpath(Selectors.Create_btn)).click();

    }

    @And("^the user lands on the registry create page$")
    public void theUserLandsOnTheRegistryCreatePage()  {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Selectors.FirstName)));
        System.out.println("User landed on Create Rsgisty page Sucessfully");

    }

    @And("^the user enters their \"([^\"]*)\" FirstName$")
    public void theUserEntersTheirFN(String fn) {
        driver.findElement(By.cssSelector(Selectors.FirstName)).sendKeys(fn);

    }

    @Then("^the user enters their \"([^\"]*)\" LastName$")
    public void theUserEntersTheirLN(String ln) {
        driver.findElement(By.cssSelector(Selectors.LastName)).sendKeys(ln);

    }


    @And("^the user enters their UserName$")
    public void theUserEntersTheirUserName() {
        if (driver.findElement(By.cssSelector(Selectors.CR_Email)).isDisplayed()) {

            String uid = UUID.randomUUID().toString();
            uid = uid.substring(0, Math.min(uid.length(), 6));
            final String randomEmail = "reg-" + uid + "@tru.com";
            randomEmail.toString();
            System.out.println(randomEmail);
            driver.findElement(By.cssSelector(Selectors.CR_Email)).sendKeys(randomEmail);
        }
    }

    private String randomEmail() {
        return "reg-" + UUID.randomUUID().toString() + "@tru.com";
    }

    @And("^the user enters their \"([^\"]*)\" Password$")
    public void theUserEntersTheirPassword(String password) {
        driver.findElement(By.cssSelector(Selectors.CR_password)).sendKeys(password);

    }

    @And("^the user enters their \"([^\"]*)\" Confirm Password$")
    public void theUserEntersTheirConfirmPassword(String password_confirm) {
        driver.findElement(By.cssSelector(Selectors.CR_Conf_password)).sendKeys(password_confirm);
    }

    @And("^the user clicks the add co-registrant option$")
    public void theUserClicksTheAddCoRegistrantOption() {
        driver.findElement(By.cssSelector(Selectors.Co_Reg_radiobtn)).click();

    }

    @And("^the user enters their \"([^\"]*)\" Co_Reg_First_Name$")
    public void theUserEntersTheirCo_Reg_First_Name(String co_reg_first_name) {
        if (driver.findElement(By.cssSelector(Selectors.Co_Reg_First_Name)).isDisplayed()) {
            driver.findElement(By.cssSelector(Selectors.Co_Reg_First_Name)).sendKeys(co_reg_first_name);
        }

    }

    @And("^the user enters their \"([^\"]*)\" Co_Reg Last_Name$")
    public void theUserEntersTheirCo_RegLast_Name(String co_reg_last_name) {
        driver.findElement(By.cssSelector(Selectors.Co_Reg_Last_Name)).sendKeys(co_reg_last_name);

    }

    @And("^the user enters their \"([^\"]*)\" Street Address Line1$")
    public void theUserEntersTheirStreetAddressLine1(String address_line1) {

        driver.findElement(By.cssSelector(Selectors.StreetAddress_Line1)).sendKeys(address_line1);
        driver.findElement(By.cssSelector(Selectors.StreetAddress_Line1)).sendKeys(Keys.TAB);

    }

    @And("^the user enters their \"([^\"]*)\" Street Address Line2$")
    public void theUserEntersTheirStreetAddressLine2(String address_line2) {
        driver.findElement(By.cssSelector(Selectors.StreetAddress_Line2)).sendKeys(address_line2);
        driver.findElement(By.cssSelector(Selectors.StreetAddress_Line2)).sendKeys(Keys.TAB);

    }

    @And("^the user enters their \"([^\"]*)\" Zip code$")
    public void theUserEntersTheirZipCode(String zip_code) {
        driver.findElement(By.cssSelector(Selectors.zipcode)).sendKeys(zip_code);
        driver.findElement(By.cssSelector(Selectors.StreetAddress_Line1)).sendKeys(Keys.TAB);

    }

    @And("^the user enters their \"([^\"]*)\" City$")
    public void theUserEntersTheirCity(String city) {
        driver.findElement(By.cssSelector(Selectors.cityname)).clear();
        driver.findElement(By.cssSelector(Selectors.cityname)).sendKeys(city);
        driver.findElement(By.cssSelector(Selectors.StreetAddress_Line1)).sendKeys(Keys.TAB);

    }

    @And("^the user enters their \"([^\"]*)\" State$")

    public void theUserEntersTheirState(String state) throws InterruptedException {
        Select s = new Select(driver.findElement(By.cssSelector(Selectors.state)));
        s.selectByVisibleText(state);


    }

    @And("^the user enters their \"([^\"]*)\" Phonenumber$")
    public void theUserEntersTheirPhonenumber(String phone_number) {
        driver.findElement(By.cssSelector(Selectors.contactNo)).sendKeys(phone_number);
        driver.findElement(By.cssSelector(Selectors.contactNo)).sendKeys(Keys.TAB);

    }

    @And("^the user enters their \"([^\"]*)\" Eventmonth and \"([^\"]*)\" EventDate$")
    public void theUserEntersTheirEventmonthAndEventDate(String event_month, String event_date) throws InterruptedException {

        Select s = new Select(driver.findElement(By.cssSelector(Selectors.babyDueMonth)));
        s.selectByVisibleText(event_month);

        Select s1 = new Select(driver.findElement(By.cssSelector(Selectors.babyDuedate)));
        s1.selectByVisibleText(event_date);
    }

    @And("^the user clicks the create registry button$")
    public void theUserClicksTheCreateRegistryButton() throws InterruptedException {
        driver.findElement(By.cssSelector(Selectors.create_registry_btn)).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Selectors.Usethis_address_btn)));
        driver.findElement(By.cssSelector(Selectors.Suggested_address_radiobtn)).click();
        driver.findElement(By.cssSelector(Selectors.Usethis_address_btn)).click();

    }

    @Then("^the user lands on the my checklist page and has successfully created a registry account$")
    public void theUserLandsOnTheMyChecklistPageAndHasSuccessfullyCreatedARegistryAccount() throws Exception {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Selectors.Checklist_tab)));
        System.out.println("User landed on Checklist page Sucessfully after Registry Creation");
        driver.findElement(By.cssSelector(Selectors.myregistry_tab)).click();
        driver.findElement(By.xpath(Selectors.myregistry_lnk)).click();
        Thread.sleep(10000);

        try {

            if (driver.findElement(By.cssSelector(Selectors.Registry_number)).isDisplayed())
            {

                String strregno = driver.findElement(By.cssSelector(Selectors.Registry_number)).getText();
                strregno.toString();
                System.out.println("User Sucessfully Created Registry#" + strregno + " and landed in My Registry page");
            }

        }
        catch (Exception e) {

            String strregno1 = driver.findElement(By.xpath(Selectors.Registry_number_Prod)).getText();
            strregno1.toString();
            System.out.println("User Sucessfully Created Registry#" + strregno1 + " and landed in My Registry page");
        }
    }
}