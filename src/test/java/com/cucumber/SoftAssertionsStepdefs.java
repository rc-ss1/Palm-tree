package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SamedayDeliveryPage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsStepdefs extends Base {

    LoginPage login;
    SoftAssert softAssert;


    String actual;
    SamedayDeliveryPage sameDayPage;

    public SoftAssertionsStepdefs()
    {
        sameDayPage = new SamedayDeliveryPage();
        softAssert = new SoftAssert();   // Initialize SoftAssert
    }

    @Then("I should see the correct page title using soft assertions")
    public void iShouldSeeTheCorrectPageTitleUsingSoftAssertions() {
        softAssert.assertTrue(sameDayPage.getPageTitle().contains("Same Day"), "Page title does not contain 'Same Day'");
        
    }

    @Then("I should be on the correct page URL using soft assertions")
    public void iShouldBeOnTheCorrectPageURLUsingSoftAssertions() {
        softAssert.assertTrue(sameDayPage.getCurrentUrl().contains("/samedaydelivery"), "Page URL does not contain '/samedaydelivery'");
        
    }

    @Then("at least one product should be listed using soft assertions")
    public void atLeastOneProductShouldBeListedUsingSoftAssertions() {
        softAssert.assertTrue(sameDayPage.getProductCount() > 0, "No products found on Same Day Delivery page");
    }

    @Then("the search box should be present using soft assertions")
    public void theSearchBoxShouldBePresentUsingSoftAssertions() {
        softAssert.assertTrue(sameDayPage.isSearchBoxPresent(), "Search box is not present on Same Day Delivery page");
        
    }

    @Then("the Text should be available using soft assertions")
    public void theTextShouldBeAvailableUsingSoftAssertions() {
        softAssert.assertTrue(sameDayPage.isTextDisplayed(), "Expected text is not displayed on the page");

        // Important: call assertAll() once at the end
        softAssert.assertAll();
    }


    }