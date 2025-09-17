package com.cucumber;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import com.cucumber.pages.CreateAccountPage;

import static org.junit.Assert.assertTrue;

public class CreateAccountStepDef extends Base {
    CreateAccountPage accountPage;

    public CreateAccountStepDef() {
        accountPage = new CreateAccountPage();
    }

    @When("user enters invalid details for account creation")
    public void user_enters_invalid_details_for_account_creation() {
        accountPage.clickCreateAccount();
        accountPage.enterFirstName("Test");
        accountPage.enterLastName("User");
        accountPage.enterEmail("3"); // invalid email
        accountPage.enterPassword("test123");
        accountPage.enterConfirmPassword("test321"); // mismatched password
        accountPage.clickCreateAccount();
    }

    @Then("user should see error messages for invalid email and mismatched password")
    public void user_should_see_error_messages_for_invalid_email_and_mismatched_password() {
        String alertText = accountPage.getAlertText();
        assertTrue(alertText.contains("Your e-mail address appears to be invalid"));
        assertTrue(alertText.contains("The password you re-typed do not match"));
        accountPage.acceptAlert();
        System.out.println(alertText);
    }
}
