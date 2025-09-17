package com.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;

public class CreatePostAPIStepDefinitions {

    private Response response;
    private String requestBody;

    @Given("I send a POST request to {string} with the following JSON data:")
    public void i_send_a_post_request_to_with_json_data(String url, String jsonData) {
        requestBody = jsonData; // Store JSON data

        response = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .when()
                .post(url)
                .then()
                .extract().response();
    }



    @Then("the response should contain the title {string}")
    public void the_response_should_contain_the_title(String title) {
        response.then().body("title", equalTo(title));
    }

    @Then("the response should contain the body {string}")
    public void the_response_should_contain_the_body(String body) {
        response.then().body("body", equalTo(body));

    }

    @Then("the response should contain userId {int}")
    public void the_response_should_contain_userId(Integer userId) {
        response.then().body("userId", equalTo(userId));
    }

    @Then("the response should contain a new id")
    public void the_response_should_contain_a_new_id() {
        response.then().body("id", notNullValue());
    }
}