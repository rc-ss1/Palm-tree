package com.cucumber.pages;


import com.cucumber.commonbase.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class HomePage extends Base {

    //MouseOperations mouse = new MouseOperations();
    private final By yourAccount = By.xpath("//div[@class='myaccountblock']");
    private final By catalog = By.xpath("//a[text()='Catalogs']");


    private final By brands = By.xpath("//a[text()='Brands']");
    private final By productOption = By.xpath("(//div[contains(text(),'Kapruka Chocolate Covered 6 Pcs Assortment')])[1]");
    private final By about = By.xpath("//a[normalize-space()='About Kapruka']");

    private final By whatsAppWeb = By.xpath("(//a[@title='Use WhatsApp Web'])[1]");
    private final By contact = By.xpath("//a[@href='https://www.kapruka.com/contactUs/officeLocations.jsp'][normalize-space()='Contact Us']");

    //WebPageElement webPageElement = new WebPageElement();
    public void openWebsite() {

        driver.get("https://www.kapruka.com/online/samedaydelivery");

    }


    public void clickProductButton() {

        driver.findElement(productOption).click();
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Neu bei Bonify']")).click();
    }

    public void acceptCokkies() {
        WebElement acceptCookiesBtn = driver.findElement(By.id("uc-btn-accept-banner"));
        acceptCookiesBtn.click();
    }

    public void insertUsername() {
        driver.findElement(By.xpath("//a[normalize-space()='Your Account']")).click(); //using Selenium click button method
    }


    void clickJoinOption() throws InterruptedException {

        // Assuming 'driver' is your WebDriver instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Assuming 'subscribeOption' is the WebElement you want to scroll to
        WebElement subscribeOption = driver.findElement(By.xpath("//span[normalize-space()='Join Our Whatsapp Channel']"));
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView(true);", subscribeOption);

        Thread.sleep(5000);


        subscribeOption.click();

    }

    public void clickWhatsAppOption() {
        driver.findElement(whatsAppWeb).click();
    }

    public void clickContactOption() {
        driver.findElement(contact).click();
    }
}