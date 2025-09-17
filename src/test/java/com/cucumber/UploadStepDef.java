package com.cucumber;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.commonbase.Base;

import com.cucumber.commonservices.WaitHelper;
import com.cucumber.commonvalidation.ComValidation;
import com.cucumber.pages.UploadFile;
import com.cucumber.commonservices.ScreenshotServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UploadStepDef extends Base {
    WebDriver driver;
    UploadFile uploadFile;
    ScreenshotServices services;
    WaitHelper wait;



    public UploadStepDef() {
        driver = Hooks.driver;
        uploadFile = new UploadFile();
        services = new ScreenshotServices();
        wait = new WaitHelper();



    }

    @When("I launch uploadfile website")
    public void iLaunchUploadFileWebsite() {
        try {
            uploadFile.launchWebsite();

            //uploadFile.takescreenshot();

        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }
    }

    /*@Then("I should see uploadfile option and click on Radio Option")
    public void iShouldSeeUploadfileOptionAndClickOnRadioOption()
    {
        try {
            uploadFile.clickRadioOptionImage();
            uploadFile.clickChooseFile();


        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }
    }*/


    @Then("I should see and click frame")
    public void iShouldSeeAndClickFrame()
    {
        //uploadFile.switchToFrame();
        uploadFile.selectOptionInSameFrame();
        uploadFile.selectOptionInDifferentFrame();

    }

    @When("user click on choose file button")
    public void userClickOnChooseFileButton() {
        try{

            uploadFile.clickChooseFile();
            Thread.sleep(20000);
        }catch (Exception e){
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG,scenario.getName());
        }

    }
}