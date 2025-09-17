package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageWithScenario extends Base {
    // This class represents the login page and contains methods to interact with the login form.


    private final By usernameField = By.xpath("//*[@id='exampleInputEmail1']");
    private final By passwordField = By.xpath("//*[@id='exampleInputPassword1']");
    private final By loginButton = By.id("loginButton");
    private final By errorMessage = By.xpath("//*[normalize-space(text())='Your password is wrong. Please try again.']");




        public void enterUsername(String username) {
            driver.findElement(usernameField).sendKeys(username);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        public void clickLogin() {
            driver.findElement(loginButton).click();
        }



    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();

    }
}
