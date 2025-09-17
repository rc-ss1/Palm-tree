package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.OnlineBrandsPage;
import com.cucumber.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OnlineBrandsStepDef extends Base {

    WebDriver driver;
    HomePage home;
    SearchPage search;
    SearchPage login;
    ScreenshotServices services;
    //ScreenshotService screenshot = new ScreenshotService();
    //variable declared globally.
    List<WebElement> results;
    OnlineBrandsPage online;
    String clickedProduct;

    public OnlineBrandsStepDef() {
        driver = Hooks.driver;
        home = new HomePage();
        search = new SearchPage();
        services = new ScreenshotServices();
        online = new OnlineBrandsPage();


    }

    @When("user click on product")
    public void clickAndCheckResultIsDisplayed() {
        List<WebElement> elements = online.getAllProductListElements();
        //WebElement - return type, String - return type)
        for (WebElement element : elements) {
            clickedProduct = element.getText().trim();
            element.click();
//            Thread.sleep(2000);
            if (online.checkCategoryListElements()) {
                driver.navigate().back();
            } else {
               //clickedProduct = element.getText().trim();
                break;
            }
        }

    }


    @Then("results display")
    public void resultsDisplay()
    {
        //Assert.assertEquals(online.getProductHeaderText(), clickedProduct, "Assert failed for product not verified");

    }
}
