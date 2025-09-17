package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.API;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.HomePage;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.cucumber.pages.LoginPage;
import org.testng.Assert;

public class APIStepDef extends Base {
    LoginPage login;
    ScreenshotServices services;
    ExcelHelper excelHelper;
    HomePage homePage;
    CartPage cartPage;

    String actual;
    API api;


    public APIStepDef() {
        driver = Base.driver;
        login = new LoginPage();
        services = new ScreenshotServices();
        excelHelper = new ExcelHelper();
        homePage = new HomePage();
        cartPage = new CartPage();
        api = new API();
    }

    @Then("Codes and loads data updated successfully")
    public void codesAndLoadsDataUpdatedSuccessfully()
    {

    }


    @When("Get the codes and loads data for design load")
    public void getTheCodesAndLoadsDataForDesignLoad() {
        api.getWindData("snow","asce7-16","","",36.1201561,-77.37552389999999);
    }
}