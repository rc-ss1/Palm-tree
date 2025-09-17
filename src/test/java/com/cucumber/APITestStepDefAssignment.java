package com.cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;

import static org.junit.Assert.*;


public class APITestStepDefAssignment {


        Response response;
        SoftAssert softAssert = new SoftAssert();

        @Given("I set the base URI for JSONPlaceholder API")
        public void set_base_uri() {
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        }

        @When("I send a GET request to {string}")
        public void send_get_request(String endpoint) {
            response = RestAssured
                    .given()
                    .when()
                    .get(endpoint);


        }

        @Then("the response status code should be {int}")
        public void validate_status_code(int expectedStatusCode) {
            int actualStatusCode = response.getStatusCode();

            assertEquals(expectedStatusCode, response.getStatusCode());
            System.out.println("Checking Status Code -> Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
            softAssert.assertEquals(actualStatusCode, expectedStatusCode, " Status Code mismatch!");
        }

        @Then("the response should contain userId as {int}")
        public void validate_user_id(int expectedUserId) {
            int actualUserId = response.jsonPath().getInt("userId");
            System.out.println("Checking userId -> Expected: " + expectedUserId + ", Actual: " + actualUserId);
            softAssert.assertEquals(actualUserId, expectedUserId, " userId mismatch!");

            // Important: call assertAll at the end
            softAssert.assertAll();
        }
    }