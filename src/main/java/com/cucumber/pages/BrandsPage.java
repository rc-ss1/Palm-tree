package com.cucumber.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BrandsPage {
    WebDriver driver;



    // Locator for all brand names
    By brandNames = By.xpath("//div[@class='col-sm-12']//a");

    // Method to get all brand names
    public List<WebElement> getBrandNames() {
        return driver.findElements(brandNames);
    }

    // Open brands page
    public void openPage() {
        driver.get("https://www.kapruka.com/online_brands.jsp");
    }
}