package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.UUID;

public class Page_Login_Registry extends AbstractPage_StepDefs {

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


        public static WebElement Registry_addtocart_btn(WebDriver driver, WebElement product) {
            return product.findElement(By.cssSelector("button[data-at='btn__add-to-cart']"));
        }

        public static WebElement findProduct(WebDriver driver, String ItemSkn) {
            return driver.findElement(By.cssSelector("div[data-at^='product__" + ItemSkn + "']"));
        }

    }

    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Selectors selector = new Selectors();
    URL siteURL;
    Overlay__LightBox lightBox = new Overlay__LightBox();

    @Before
    public void setUp() {

        getDriver();
        driver.manage().window().maximize();
    }
    @Given("^the user navigates to the \"([^\"]*)\" site in \"([^\"]*)\" environment$")
    public void iNavigateToSiteSites(String site, String environment) throws Throwable {

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
                    siteURL = new URL("https://babyregistryqa3.toysrus.com");
                } else if (environment.toLowerCase().equals("qa2")) {
                    siteURL = new URL("https://babyregistrytest.toysrus.com");
                } else if (environment.toLowerCase().equals("staging")) {
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

    @When("^the user clicks the manage button on the registry home page$")
    public void theUserClicksTheManageButtonOnTheRegistryHomePage()  {
        driver.findElement(By.cssSelector(Selectors.Manage_btn)).click();

    }

    @And("^the user lands on the registry sign-in page$")
    public void theUserLandOnTheRegistrySignInPage(String fn)  {
        driver.findElement(By.cssSelector(Selectors.FirstName)).sendKeys(fn);

    }

    @When("^the user enters their \"([^\"]*)\" UserName$")
    public void theUserEntersTheirUserName(String user_name$)  {
        driver.findElement(By.cssSelector(Selectors.Email)).sendKeys();

    }
    /*@And("^the user enters their \"([^\"]*)\" Password$")
    public void theUserEntersTheirPassword(String password)  {
        driver.findElement(By.cssSelector(Selectors.password)).sendKeys(password);

    }*/

    @And("^the user clicks the sign-in button$")
    public void theUserClicksTheSignInButton() {
        driver.findElement(By.cssSelector(Selectors.Co_Reg_radiobtn)).click();

    }
    @Then("^the user lands on the my registry list page for  \"([^\"]*)\" reg_number$")
    public void theUserLandsOnTheMyRegistryListPageForRegNumber() {
        // Write code here that turns the phrase above into concrete actions

    }

}