package com.cucumber;

import com.cucumber.commonbase.Base;
import com.cucumber.pages.ZigzagHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ZigzagStepdef extends Base {

    ZigzagHomePage zigzagHomePage;
    WebDriver driver;
    public ZigzagStepdef() {
        driver = Base.driver;
        zigzagHomePage = new ZigzagHomePage();
    }

    @When("I login with the zigzag ecommerce website")
    public void iLoginWithTheZigzagEcommerceWebsite() {
        driver.get("https://int.zigzag.lk/collections/work-wear-1");

    }


    @Then("I should be able to select size and get the color displayed")
    public void iShouldBeAbleToSelectSizeAndGetTheColorDisplayed() throws InterruptedException {
        Thread.sleep(15000);
        zigzagHomePage.check();
        System.out.println(zigzagHomePage.getColor());
    }
}

