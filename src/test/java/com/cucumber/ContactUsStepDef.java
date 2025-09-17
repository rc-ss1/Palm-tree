package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import com.cucumber.pages.ContactUs;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactUsStepDef extends Base {
    LoginPage login;
    ScreenshotServices services;
    ExcelHelper excelHelper;
    HomePage homePage;
    String actual;
    ContactUs contactUs;


    public ContactUsStepDef() {
        driver = Base.driver;
        login = new LoginPage();
        services = new ScreenshotServices();
        excelHelper = new ExcelHelper();
        homePage = new HomePage();
        contactUs = new ContactUs();
    }


        @When("I check the details")
        public void iCheckTheDetails() {
            System.out.println("checkthedetails");
        }

        @Then("the page details should be correct")
        public void thePageDetailsShouldBeCorrect() {
            String expectedPhoneText = "+94117551111";
            String actualPhoneText = contactUs.getPhoneText();
            String expectedEmailText = "colombo.office@kapruka.com";
            String actualEmailText = contactUs.getEmailText();
            System.out.println(actualPhoneText);
            System.out.println(actualEmailText);
            Assert.assertEquals(actualPhoneText, expectedPhoneText);
            Assert.assertEquals(actualEmailText, expectedEmailText);

        }

    @When("I click on ContactUs Page")
    public void iClickOnContactUsPage() {
        contactUs.clickContactUs();

    }
}