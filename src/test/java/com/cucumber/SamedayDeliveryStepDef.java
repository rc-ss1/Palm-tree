package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SamedayDeliveryStepDef extends Base {

    LoginPage login;


    String actual;
    SamedayDeliveryPage sameDayPage;

    public SamedayDeliveryStepDef()
    {
        sameDayPage = new SamedayDeliveryPage();
    }


    @Given("I open the Kapruka Same Day Delivery page")
    public void openSameDayPage() {

        driver.get("https://www.kapruka.com/online/samedaydelivery");

    }

    @Then("I should see the correct page title")
    public void checkPageTitle() {
        Assert.assertTrue(sameDayPage.getPageTitle().contains("Same Day"));

    }

    @Then("I should be on the correct page URL")
    public void checkPageUrl() {
        Assert.assertTrue(sameDayPage.getCurrentUrl().contains("/samedaydelivery"));
    }



    @Then("at least one product should be listed")
    public void checkProducts() {
        Assert.assertTrue(sameDayPage.getProductCount() > 0);
    }

    @Then("the search box should be present")
    public void checkSearchBox() {
        Assert.assertTrue(sameDayPage.isSearchBoxPresent());
    }

    @Then("the Text should be available")
    public void checkText() {
        Assert.assertTrue(sameDayPage.isTextDisplayed());

    }
}
