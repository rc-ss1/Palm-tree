package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.BrandsPage;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC_11BrandStepDef extends Base {

    WebDriver driver;
    HomePage home;
    SearchPage search;
    SearchPage login;
    LoginPage loginPage;
    BrandsPage brandsPage;
    List<WebElement> brandList;

    public TC_11BrandStepDef() {
        brandsPage = new BrandsPage();

    }

        @Given("I open the Kapruka brands page")
        public void i_open_the_kapruka_brands_page() {

            driver.get("https://www.kapruka.com/online_brands.jsp");
        }

        @When("I extract all brand names")
        public void i_extract_all_brand_names() {
            brandList = brandsPage.getBrandNames();
            System.out.println("Total brands found: " + brandList.size());
            for (WebElement brand : brandList) {
                System.out.println(brand.getText());
            }
        }

        @Then("I should see at least one brand displayed")
        public void i_should_see_at_least_one_brand_displayed() {
            Assert.assertTrue("No brands found on the page!", brandList.size() > 0);
            driver.quit();
        }
    }