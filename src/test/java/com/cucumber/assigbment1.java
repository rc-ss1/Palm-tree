package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class assigbment1 extends Base {

    WebDriver driver;
    HomePage home;
    SearchPage search;
    SearchPage login;
    LoginPage loginPage;

    ScreenshotServices services;
    //ScreenshotService screenshot = new ScreenshotService();
    //variable declared globally.
    List<WebElement> results;

    public assigbment1() {
        driver = Hooks.driver;
        home = new HomePage();
        search = new SearchPage();
        services = new ScreenshotServices();
        loginPage = new LoginPage();


    }

    @When("I login with the website for registration")
    public void iLoginWithTheWebsiteForRegistration() {
        home.openWebsite();
        home.clickLoginButton();
        // bonify.de cookie button ID
        home.acceptCokkies();
    }

    @Then("Registration Page should display")
    public void registrationPageShouldDisplay() {
        System.out.println("testing");
    }
}
