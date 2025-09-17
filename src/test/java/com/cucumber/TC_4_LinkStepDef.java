package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC_4_LinkStepDef extends Base {

    private List<WebElement> allLinks;
    WebDriver driver;
    HomePage home;
    SearchPage search;
    SearchPage login;
    LoginPage loginPage;

    ScreenshotServices services;

    public TC_4_LinkStepDef()
    {
        driver = Hooks.driver;
        home = new HomePage();
        search = new SearchPage();
        services = new ScreenshotServices();
        loginPage = new LoginPage();
    }


    @Given("I open the Kapruka product page {string}")
    public void iOpenTheKaprukaProductPage(String arg0) {
    }

    @When("I collect all social media links")
    public void collectAllLinks() {
        allLinks = driver.findElements(By.tagName("a"));
    }

    @Then("I should print Facebook and Twitter links if available")
    public void printFacebookAndTwitterLinks() {
        boolean found = false;

        for (WebElement link : allLinks) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                if (href.contains("facebook.com")) {
                    System.out.println("Facebook Link: " + href);
                    found = true;
                } else if (href.contains("twitter.com")) {
                    System.out.println("Twitter Link: " + href);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No Facebook or Twitter links found on this page.");
        }

    }
}