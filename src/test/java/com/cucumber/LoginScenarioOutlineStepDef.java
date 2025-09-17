package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.LoginPageWithScenario;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class LoginScenarioOutlineStepDef extends Base {
    LoginPageWithScenario loginPage;

    @When("I login with the website1")
    public void i_login_with_the_website1() {
        driver.navigate().to("https://www.kapruka.com/shops/customerAccounts/accountLogin.jsp");
        driver.manage().window().maximize();

        loginPage = new LoginPageWithScenario();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should see the appropriate login result")
    public void i_should_see_the_appropriate_login_result() {
        // Add assertion logic here
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("dashboard")) {
            Assert.assertTrue(true, "Login successful: redirected to dashboard.");
        } else if (currentUrl.contains("accountLogin")) {
            String errorMsg = loginPage.getErrorMessage();
            Assert.assertTrue(errorMsg.contains("wrong") || errorMsg.contains("did not find an account"),
                    "Login failed: error message displayed.");
        } else {
            Assert.fail("Unexpected login result. URL: " + currentUrl);
        }
    }
}