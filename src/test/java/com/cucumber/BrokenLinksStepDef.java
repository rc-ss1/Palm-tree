package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class BrokenLinksStepDef extends Base {

        private WebDriver driver;
        private LoginPage loginPage;
        private List<WebElement> links;
        public BrokenLinksStepDef() {
            driver = Hooks.driver;
            loginPage = new LoginPage();
        }

        @Given("I am on the Kapruka login page")
        public void i_am_on_the_kapruka_login_page() {
            // Setup Chrome with options
            driver.navigate().to("https://www.kapruka.com/user_login.jsp");
        }

        @When("I collect all the links on the page")
        public void i_collect_all_the_links_on_the_page() {
            links = loginPage.getAllLinks();
            System.out.println("Total links found: " + links.size());
        }

        @Then("none of the links should be broken")
        public void none_of_the_links_should_be_broken() {
            for (WebElement link : links) {
                String url = link.getAttribute("href");

                if (url == null || url.isEmpty()) {
                    System.out.println("Skipping empty link: " + link.getText());
                    continue;
                }

                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD"); // faster than GET
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    System.out.println(url + " -> " + responseCode);

                    // Check if valid (200–399 range means not broken)
                    assertTrue("Broken link found: " + url, responseCode < 400);

                } catch (Exception e) {
                    fail("Exception for link: " + url + " -> " + e.getMessage());
                }
            }
            driver.quit();
        }
    }

