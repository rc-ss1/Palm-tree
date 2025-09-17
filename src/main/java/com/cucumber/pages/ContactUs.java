package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;

public class ContactUs extends Base {
    private final By createAccount = By.xpath("//button[text()='Create Account']");
    private final By phoneNumber = By.xpath("(//a[contains(text(),'+94117551111')])[1]");
    private final By headerName = By.xpath("//h3[normalize-space()='Colombo - Sri Lanka - Head Office']");
    private final By address = By.xpath("//div[@class='space-top space-botIn blockC']//strong[contains(text(),'Address:')]");
    private final By addressBlock = By.xpath("//span[normalize-space()='No 147,']");
    private final By addressState = By.xpath("//span[contains(text(),'Kottawa Road,')]");
    private final By orderStatusIcon = By.xpath("//*[@class='orderStatusIcon']");
    private final By emailAddress = By.xpath("//a[text()='colombo.office@kapruka.com']");

    public String getPhoneText() {

        return driver.findElement(phoneNumber).getText();
    }
    public void clickContactUs()
    {

        driver.findElement(orderStatusIcon).click();
    }
    public String getEmailText()
    {

        return driver.findElement(emailAddress).getText();
    }

}


