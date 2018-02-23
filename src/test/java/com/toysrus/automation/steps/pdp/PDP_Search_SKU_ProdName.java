package com.toysrus.automation.steps.pdp;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.steps.overlays.Overlay__LightBox;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PDP_Search_SKU_ProdName extends AbstractPage_StepDefs{
	
	public class Selectors {
        public static final String search = "//*[@id='search-input']";
        public static final String pdp_sku_id = "//*[contains(text(),'SKU:')]";
        public static final String pdp_product_title = "//h1[@class='product-item__product-title pdp-header__title']/span";
        public static final String plp_all_items_text="//div[@class='product-item__product-title']/span";
        public static final String plp_select_item="(//*[@class='product-item__product-title']/span)[1]";
        public static final String plp_category_filter="//span[@class='filter-container__dropdown__header-title'][text()='category']";
        public static final String container__page__plp1 = ".webstore-plp-page";
        public static final String container__page__plp2 = ".webstore-search-page__product-grid";
    }
    
	WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    Overlay__LightBox lightBox = new Overlay__LightBox();
    String siteURL = null;
    
    String search_sku, search_prd_nm,search_txt;
	String[] expected_sku_id;
	String[] actual_sku_id;
	@Given("^the user is on the PLP page and store search text info$")
	public void userOnPlpPage() throws Throwable{ 
    	search_txt = driver.findElement(By.xpath(Selectors.search)).getText();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.container__page__plp1)));
        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selectors.container__page__plp2)));
        }
        finally{
            try
            {
                lightBox.theUserClosesTheLightbox();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
	@When("^get the SKU Id$")
	public void get_the_SKU_Id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		search_sku = driver.findElement(By.xpath(Selectors.pdp_sku_id)).getText();
		expected_sku_id = search_sku.split(":", 2);
		System.out.println("SKU id is" + " " + expected_sku_id[1] );
	}

	@When("^get the Product Name$")
	public void getProductTitle() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		search_prd_nm = driver.findElement(By.xpath(Selectors.pdp_product_title)).getText();
		System.out.println("Product name is" + " " + search_prd_nm);
	}

	@Then("^search by Product Name$")
	public void searchByProductTitle() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actual_prd_nm;
		driver.findElement(By.xpath(Selectors.search)).sendKeys(search_prd_nm);
		driver.findElement(By.xpath(Selectors.search)).sendKeys(Keys.ENTER);
		try {
		if((driver.findElement(By.xpath(Selectors.plp_category_filter)))!=null)
		{
			List<WebElement> element= driver.findElements(By.xpath(Selectors.plp_all_items_text));
			for(int i=0; i<element.size(); i++)
			{
				actual_prd_nm = element.get(i).getText();
				Assert.assertTrue(actual_prd_nm.contains(search_txt));
			}
		}
		else
		{
			actual_prd_nm = driver.findElement(By.xpath(Selectors.pdp_product_title)).getText();
			Assert.assertEquals(search_prd_nm, actual_prd_nm);	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		System.out.println("Search by Prod name is Sucessfull");
	}

	@Then("^search by SKU Id$")
	public void searchBySkuId() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath(Selectors.search)).clear();
		driver.findElement(By.xpath(Selectors.search)).sendKeys(expected_sku_id[1]);
		driver.findElement(By.xpath(Selectors.search)).sendKeys(Keys.ENTER);
		actual_sku_id = (driver.findElement(By.xpath(Selectors.pdp_sku_id)).getText()).split(":", 2);
		Assert.assertTrue(actual_sku_id[1].equals(expected_sku_id[1]));
		System.out.println("Search by SKU Id is Sucessfull");
	}
}