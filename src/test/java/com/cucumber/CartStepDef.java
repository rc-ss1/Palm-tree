package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.HomePage;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.cucumber.pages.LoginPage;
import org.testng.Assert;

public class CartStepDef extends Base {
    LoginPage login;
    ScreenshotServices services;
    ExcelHelper excelHelper;
    HomePage homePage;
    CartPage cartPage;
    
    String actual;


    public CartStepDef() {
        driver = Base.driver;
        login = new LoginPage();
        services = new ScreenshotServices();
        excelHelper = new ExcelHelper();
        homePage = new HomePage();
        cartPage = new CartPage();
    }
 

    @Then("I should see addToCart button")
    public void iShouldSeeAddToCartButton() 
    {
        cartPage.checkCartButton();
    }

    @When("I click on addToCart button")
    public void iClickOnAddToCartButton()
    {

        cartPage.clickCartButton();
    }

    @Then("Cart details should display")
    public void cartDetailsShouldDisplay()
    {
        String actualPrice = cartPage.getCartPrice();
        String expectedPrice = "US$ 0.00";
        Assert.assertEquals(actualPrice,expectedPrice, "Assert failed - price is not matched when cart is empty");
    }


    @Then("click on AddToCart button")
    public void clickOnAddToCartButton() {
        cartPage.clickCartButton();
    }
}
