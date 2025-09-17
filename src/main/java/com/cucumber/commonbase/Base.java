package com.cucumber.commonbase;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;


import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class Base {
    //initialize driver


    public static WebDriver driver;



    protected SoftAssert softAssert;

    public static Scenario scenario;


    public WebDriver browserLaunch(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

    public String readPropertiesFile(String property) throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/config.properties");

        Properties prop = new Properties();
        prop.load(fileReader);
        return prop.getProperty(property);
    }
}


