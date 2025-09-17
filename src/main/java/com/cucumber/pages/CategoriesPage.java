package com.cucumber.pages;


import com.cucumber.commonbase.Base;

import com.cucumber.commonservices.WaitHelper;
import org.openqa.selenium.By;

public class CategoriesPage extends Base {

    WaitHelper waitHelper;

    public CategoriesPage() {
        driver = Base.driver;
        waitHelper = new WaitHelper();

    }
    private final By AllCategories = By.xpath("//*[normalize-space(text())='All Categories']");
    private final By FlowerShop = By.xpath("//*[normalize-space(text())='Flower Shop']");
    private final By Product = By.xpath("//div[@class='CatalogueV2Design']//div[2]/div");
    private final By AddToCart = By.xpath("//button[@id='addtocartbutton']");
    private final By ContinueShopping = By.xpath("//a[@id='continue_shopping_popup']");
    private final By CartLink = By.xpath(("//a[@id='cartlinkId']"));
    private final By DeleteButton = By.xpath("//button[@class='delete-btn']");




    public void openWebsite(){

        driver.get("https://www.kapruka.com/shops/customerAccounts/accountLogin.jsp");

    }
    public void clickFlowerShops() {
       waitHelper.waitForElementToBeVisiblewithparameter(FlowerShop,60);

    }
    public void clickProduct() throws InterruptedException {

        //mouse.singleClick(driver, Product); //using Selenium click button method
    }


}



