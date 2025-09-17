package com.cucumber;

import com.cucumber.commonbase.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC_10StepDef extends Base {
    WebDriver driver;

    @Given("I launch the browser with SSL handling enabled")
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);  // ✅ Ignore SSL issues
        driver = new ChromeDriver(options);
    }

    @When("I open the URL {string}")
    public void openUrl(String url) {
        driver.get(url);
    }

    @Then("I should be able to see the page title")
    public void verifyTitle() {
        System.out.println("Page Title is: " + driver.getTitle());
        driver.quit();
    }
}
