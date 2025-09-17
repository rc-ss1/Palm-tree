package com.cucumber;
import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.API;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class APIStepPlaceholder extends Base {

        public int response;

    public APIStepPlaceholder() {
        driver = Base.driver;
        softAssert = new SoftAssert();
    }

        @Given("the API base URL is {string}")
        public void theAPIBaseURLIs(String baseURL) {

            RestAssured.baseURI = baseURL;

        }






    }