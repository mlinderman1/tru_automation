package com.toysrus.automation.steps.pages;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.common.Common_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

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
        public static final String MyAccount_Email = "//*[@id='myregistries']/div[1]/div/div/div/div[2]/p";
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
        public static final String myregistry_lnk = "//div[@class='cate_heading']/a[@id='myregistrylink']";
        public static final String myregistry_tab = "a[id='my-registry-main']";
        public static final String Registry_number = "font[class='information_text_bold_regNo']";
        public static final String Registry_number_Prod = "//div[@class='general_textNew dashheadpadd pull-left visible-lg visible-md visible-sm hidden-xs']//span";


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


    @When("^the user clicks the manage button on the registry home page$")
    public void theUserClicksTheManageButtonOnTheRegistryHomePage()  {
        driver.findElement(By.cssSelector(Selectors.Manage_btn)).click();

    }

    @And("^the user lands on the registry sign-in page$")
    public void theUserLandOnTheRegistrySignInPage()  {
        driver.findElement(By.cssSelector(Selectors.Signin_btn)).isDisplayed();

    }

    @When("^the user enters their \"([^\"]*)\" UserName$")
    public void theUserEntersTheirUserName(String user_name)  {
        driver.findElement(By.cssSelector(Selectors.Email)).sendKeys(user_name);

    }
    @And("^the user enters their \"([^\"]*)\" ValidPassword$")
    public void theUserEntersTheirPassword(String password)  {
        driver.findElement(By.cssSelector(Selectors.password)).sendKeys(password);

    }

    @And("^the user clicks the sign-in button$")
    public void theUserClicksTheSignInButton() {
        driver.findElement(By.cssSelector(Selectors.Signin_btn)).click();

    }

    @Then("^the user lands on the my registry list page for the \"([^\"]*)\"$")
    public void theUserLandsOnTheMyRegistryListPageForRegNumber(String reg_number) throws Exception {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Selectors.MyAccount_Registries)));
        System.out.println("User landed on my registry list page Sucessfully after Registry login ");
        String pagetittle = driver.getTitle();
        if (pagetittle.contentEquals("My Registry")) {
            /*//registrysweepstakesmyreg_close();
            try {
                //registrysweepstakes_close("bruBabysFirstBdayLightboxContent","bruBabysFirstBdayLightboxClose");
            } catch (Exception e) {
                System.out.print("Registry Sweep stakes  not loaded");
            }*/
            String strRegistrynum = driver.findElement(By.cssSelector(Selectors.Dashboard_RegistryNumber)).getText();
            System.out.println(strRegistrynum);
            Assert.assertTrue(strRegistrynum == reg_number);
        }else {

        }
    }
    @Then("^the user lands on the my registries list myaccount page with \"([^\"]*)\" listed")
    public void theUserLandsOnTheMyMyRegistriesListAccountPageWithRegListed(String reg_number) throws Exception {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Selectors.MyAccount_Registries)));
        String pagetittle1 = driver.getTitle();
        // if the registry account has multiple registries
        if (pagetittle1.contentEquals("My Account")) {

            //to select the specific registry from the account page
            reg_number = reg_number.charAt(0)=='0' ? reg_number.substring(1) : reg_number;
            System.out.println(reg_number);
            List<WebElement> registrylist = driver.findElements(By.cssSelector(Selectors.MyAccount_Registries));
            System.out.println(registrylist.size());
            for(WebElement ele:registrylist){
                String registrynumber_fromweb = ele.getAttribute("onclick");
                System.out.println(registrynumber_fromweb);

                if (registrynumber_fromweb.contains(reg_number)){
                    ele.sendKeys(Keys.ENTER);
                    break;
                }
            }
        }else{

        }
    }
}