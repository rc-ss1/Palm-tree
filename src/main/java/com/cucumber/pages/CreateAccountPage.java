package com.cucumber.pages;

import com.cucumber.commonbase.Base;

import org.openqa.selenium.By;

public class CreateAccountPage extends Base {

    private final By createAccount = By.xpath("//button[text()='Create Account']");
    private final By firstName = By.xpath("//input[@name='firstName']");
    private final By lastName = By.xpath("//input[@name='lastName']");
    private final By emailAddress = By.xpath("//input[@name='email']");
    private final By password = By.xpath("//input[@name='password']");
    private final By confirmPassword = By.xpath("//input[@name='passwordReConfirm']");

    public void clickCreateAccount() {
        driver.findElement(createAccount).click();
    }
    public void enterFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterEmail(String emailId) {
        driver.findElement(emailAddress).sendKeys(emailId);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String confirmPwd) {
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }

    // Method to get Alert text
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
