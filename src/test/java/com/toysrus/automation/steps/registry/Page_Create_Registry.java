package com.toysrus.automation.steps.registry;

import com.toysrus.automation.steps.common.*;
import com.toysrus.automation.steps.overlays.*;
import com.toysrus.automation.utils.LocatorProps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Page_Create_Registry extends AbstractPage_StepDefs {


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

}
