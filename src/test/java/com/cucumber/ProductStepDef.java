package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.ProductDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductStepDef extends Base {
    LoginPage login;
    ScreenshotServices services;
    ExcelHelper excelHelper;
    HomePage homePage;
    CartPage cartPage;

    ProductDetailsPage productPage;

    String actual;


    public ProductStepDef() {
        driver = Base.driver;
        login = new LoginPage();
        services = new ScreenshotServices();
        excelHelper = new ExcelHelper();
        homePage = new HomePage();
        cartPage = new CartPage();
        productPage = new ProductDetailsPage();
    }




    @When("user click on choose a file button")
    public void userClickOnChooseAFileButton() {
        productPage.uploadfile();

    }

    @Then("file is getting uploaded.")
    public void fileIsGettingUploaded() {
                String expectedResult = "1728887803107.png";
                String actualResult = productPage.getImageDetails();
                Assert.assertEquals(actualResult, expectedResult);
    }


    public static class TestNGDemo {
        @Test
        public void sampleTest() {
            System.out.println("TestNG is successfully set up in IntelliJ!");
        }
    }
}
