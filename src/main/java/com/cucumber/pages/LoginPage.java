package com.cucumber.pages;


import com.cucumber.commonbase.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class LoginPage extends Base {



    private final By seeDetails = By.xpath("(//div[contains(text(),'See Details')])[1]");
    private final By email = By.id("exampleInputEmail1");

    private final By login = By.xpath("//input[@name='Login']");

    private final By message = By.xpath("//font[@color='red']");

    private final By errorMessage = By.xpath("//*[normalize-space(text())='Your password is wrong. Please try again.']");


    private final By noAccountMessage = By.xpath("//*[text()='Sorry, we did not find an account for that e-mail address.']");

    public void enterEmail(String username)
    {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(username);
        //dropdown.selectOptionByIndex(driver, By.xpath("//*[text()='Eng']"), 2);
        //driver.findElement(By.id("exampleInputEmail1")).sendTextToKeyBoardInput(driver,By.id("exampleInputEmail1")),"a","CONTROL");
    }

    public void clickYourAccount() throws InterruptedException {
//change this line to get error
        driver.findElement(By.xpath("//div[@class='orderStatusIcon']")).click();



    }

    public void selectDropdownByValue() throws InterruptedException {
        //dropdown.getOptions(driver,seeDetails );

        Select dropdown = new Select(driver.findElement(By.xpath("(//select)[1]")));
        dropdown.selectByValue("2");

    }

    public void selectDropdownByText() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("(//select)[1]")));
        dropdown.selectByVisibleText("Eng");


    }

    public String getTextOfTab() throws InterruptedException {
        //Thread.sleep(10000);
        return driver.findElement(By.xpath("//a[normalize-space()='Catalogs']")).getText();
    }


    public void enterPassword(String password)
    {
        driver.findElement(By.id("exampleInputPassword1")).clear();
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);


    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();

    }

    public String noAccountMessage()
    {
        return driver.findElement(noAccountMessage).getText();

    }

    public void clickLoginButton()
    {
        driver.findElement(login).click();
    }
    public String getTitle() throws InterruptedException {

        return driver.getTitle();
    }

    // Locator for all <a> tags
    private By allLinks = By.tagName("a");


    // Get all links from the page
    public List<WebElement> getAllLinks() {
        return driver.findElements(allLinks);
    }
}
