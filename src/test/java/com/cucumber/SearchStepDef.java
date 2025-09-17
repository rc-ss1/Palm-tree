package com.cucumber;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.commonbase.Base;
import com.cucumber.pages.CartPage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SearchPage;
import com.cucumber.commonservices.ScreenshotServices;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.cucumber.pages.HomePage;

import com.cucumber.commonvalidation.ComValidation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchStepDef extends Base {

    WebDriver driver;
    HomePage home;
    SearchPage search;
    SearchPage login;
    LoginPage loginPage;

    ScreenshotServices services;
    //ScreenshotService screenshot = new ScreenshotService();
    //variable declared globally.
    List<WebElement> results;

    public SearchStepDef() {
        driver = Hooks.driver;
        home = new HomePage();
        search = new SearchPage();
        services = new ScreenshotServices();
        loginPage = new LoginPage();


    }

    @When("I login with the website")
    public void iLoginWithTheWebsite() {
        try {
            home.openWebsite();
            //home.clickAccount();
        } catch (Exception e) {
            //if below line is not added you would get result as Pass always
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }

    }

    @Then("I should see dashboard")
    public void iShouldSeeDashboard() {

        try {
            System.out.println("Dashboard");
            String actualTitle = loginPage.getTitle();
            String expectedTitle = "New Account Creation";
            //Assert.assertEquals(actualTitle,"New Account Creation" );
            //home.clickAccount();
        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }
    }

    @And("Attach Screenshot")
    public void attachScreenshot() {
        try {
            //screenshot.takeScreenshots();
            //scenario.attach(ScreenshotService.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }
    }
//code to handle one product
    @Then("user should see Results")
    public void iShouldSeeResults() {

        try
        {

            String actualValue = search.getText();
            String expectedValue = "Stitch`s Enchanted Island Kid`s Happy Birthday Ribbon Cake For Girl Or Boy";


            //Assert.assert(actualValue,expectedValue);
            System.out.println(actualValue);


        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }
    }

    @When("user enter text to Search and click on Search button")
    public void iEnterTextToSearchAndClickOnSearchButton() {
        try {
            search.enterValidText();

           search.clickSearch();
//            search.clickfirstCake();
//            search.addToCart();

            System.out.println("Search completed");




        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());

        }
    }

    @When("I enter invalid text to Search and click on Search button")
    public void iEnterInvalidTextToSearchAndClickOnSearchButton() {
        try {
            search.enterInValidText();

            search.clickSearch();

        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());

        }
    }

    @Then("I should not see Results")
    public void iShouldNotSeeResults() {
        try {
            int i = search.getInvalidText();
            Assert.assertEquals(i,0 );
        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());

        }
    }

    @When("I click on Next")
    public void iClickOnNext() {
        try {
            search.clickNext();
        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
        }
    }

    @Then("I should see Results on Second Page")
    public void iShouldSeeResultsOnSecondPage() {
        try {

            String actualValue = search.getTextOnPage2();
            Assert.assertEquals(actualValue, "Java Love Filled Chocolate Box" );

        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());

        }
    }


    @Then("I should see list of delivery Products")
    public void iShouldSeeListOfDeliveryProducts() throws InterruptedException {
        search.clickSameDayDelivery();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(5000);
        search.scrolldown();
        //search.getSameDayDeliveryText();
        int i = 2;
        List<WebElement> list = search.getTableData();
        for (i = 2;i<=list.size(); i++)
        {
           String productName = search.getTableText(i).getText();
           System.out.println(productName);
        }


    }

    @When("I click on SameDayDelivery")
    public void iClickOnSameDayDelivery() throws InterruptedException {
        search.clickSameDayDelivery();
        Thread.sleep(5000);
        search.scrolldown();
    }

    @Then("I should see multiple Results")
    public void iShouldSeeMultipleResults() {
        //List of webelements as multiple product results displayed
        results = search.getDetailsOfProducts();
        softAssert = new SoftAssert();
        //enhanced for loop used - for each element
        for (WebElement element :results) {
            boolean flag = false;
        //sometime you might get product cake in uppercase or lowercase hence changed to lowercase to streamline it
            String actualResult = element.getText().toLowerCase();
            //Approach 1
           softAssert.assertTrue(actualResult.contains("cake"), "Assert failed - " + actualResult + " text is not matching with Cake");

           //Approach 2
            /*if (actualResult.contains("Cake"))
            {
                flag=true;
            }
            softAssert.assertTrue(flag);*/
        }
        softAssert.assertAll();


    }
    @When("user selects one product")
    public void userSelectsOneProduct()
    {
        home.clickProductButton();


    }

    @Then("product details display")
    public void productDetailsDisplay() {
        String actualResult = search.getSelectedProductText();
        String expectedResult = "Print your own image on the cake";
        //Assert.assertEquals(actualResult,expectedResult );

    }

    @When("page loads")
    public void pageLoads() {
        System.out.println("test");
    }

    @Then("verify all items displayed related to Search criteria")
    public void verifyAllItemsDisplayedRelatedToSearchCriteria() {

        // Get all cake elements
        List<WebElement> cakeElements = search.getAllCakeElements();

        ArrayList<String> cakeNames = new ArrayList<>();

        //We create an ArrayList to store the cake names.ArrayList is chosen because:
        //It dynamically grows as new items are added.
        //  It allows easy access to elements by index (cakeNames.get(0)), making future validations simpler.
        for (WebElement cakeElement : cakeElements) {
            cakeNames.add(cakeElement.getText().trim());
        }

        // Convert WebElements into ArrayList
        //This loop iterates through each cakeElement in cakeElements.
        //cakeElement.getText() retrieves the visible text of the WebElement (cake name).
        //trim() removes any unwanted spaces before or after the text.Each cake name is added to the cakeNames ArrayList.
        // Why This Approach?
        // Clean Data: Using trim() ensures no unwanted spaces in the cake names.
        // Simplifying Data Handling: Extracting the names into a String ArrayList makes it easier to apply assertions, sort items, or compare against expected results.

        // Print the cakes (all the cakes)
        System.out.println("Total Cakes Found: " + cakeNames.size());
        for (String cake : cakeNames) {
            System.out.println(cake);
        }


    }

    @Then("verify all items displayed for Cake")
    public void fetchAndPrintCakeDetails() {
        Map<String, String> cakeDetails = search.getCakeDetails();
        System.out.println("Total Cakes Found: " + cakeDetails.size());
        cakeDetails.forEach((cake, price) -> System.out.println(cake + " - " + price));
        for (Map.Entry<String, String> set : cakeDetails.entrySet())
        {
            System.out.println(set.getKey() + " = "
                    + set.getValue());
        }
    }
    }