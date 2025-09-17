package com.cucumber.commonservices;

import com.cucumber.commonbase.Base;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotServices extends Base {


    public static Scenario scenario;


    public byte[] getScreenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        return screenshotBytes ;
    }

}
