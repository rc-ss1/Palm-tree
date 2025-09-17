package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlineBrandsPage extends Base {

    private final By Groviva = By.xpath("//div[text()='Groviva']");

    private final By Head_Shoulders = By.xpath("//div[text()='Head And Shoulders']");

    private final By Indus_Pharma = By.xpath("//div[text()='Indus Pharma']");

    private final By Axe = By.xpath("//div[text()='Axe']");

    private final By Nutri_Master = By.xpath("//div[text()='Nutri Master']");

    private final By allProductNames = By.xpath("//h2[@class='card-title']");

    private final By allCategoryList = By.xpath("//div[@class='catalogueV2Repeater ']");

    private final By productHeaderText = By.xpath("//h3//span");


    public void clickOnAnyProductOnOnlineBrandsScreen(String productName) {
        By product = By.xpath("//h2[@class='card-title'][text()='" + productName + "']");

    }

    public List<WebElement> getAllProductListElements() {
        return driver.findElements(allProductNames);
    }

    public boolean checkCategoryListElements() {
        return driver.findElements(allCategoryList).isEmpty();
    }

    public String getProductHeaderText() {
        return driver.findElement(productHeaderText).getText().trim().toUpperCase();
    }

}
