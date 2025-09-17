package com.cucumber;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserSteps {

    private String baseUrl;
    private Response response;
    private Map<String, Object> requestBody;

    @Given("I set the Pet Store user creation endpoint")
    public void i_set_the_pet_store_user_creation_endpoint() {
        baseUrl = "https://petstore.swagger.io/v2/user";
    }

    @When("I create a user with the following details")
    public void i_create_a_user_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        requestBody = new HashMap<>();
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        requestBody.put("id", Integer.parseInt(data.get("id")));
        requestBody.put("username", data.get("username"));
        requestBody.put("firstName", data.get("firstName"));
        requestBody.put("lastName", data.get("lastName"));
        requestBody.put("email", data.get("email"));
        requestBody.put("password", data.get("password"));
        requestBody.put("phone", data.get("phone"));
        requestBody.put("userStatus", Integer.parseInt(data.get("userStatus")));

        response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(baseUrl);
    }

    @Then("I should receive status code {int}")
    public void i_should_receive_status_code(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
        System.out.println("Response Body:\n" + response.asPrettyString());
    }
}
