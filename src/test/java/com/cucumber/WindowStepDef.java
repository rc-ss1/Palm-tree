package com.cucumber;


import com.cucumber.commonbase.Base;
import com.cucumber.pages.SamplePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowStepDef extends Base {


    SamplePage samplePage;
    private String parentWindowHandle;

    public WindowStepDef()
    {
        samplePage = new SamplePage();
    }

    @Given("I open the sample page that opens new windows")
    public void openSamplePage() {
        samplePage = new SamplePage();
        samplePage.open("https://the-internet.herokuapp.com/windows"); // replace with your real URL
        // store parent window handle immediately after opening page
        parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent handle = " + parentWindowHandle);
    }

    @When("I click the link that opens a new window")
    public void clickLinkOpensNewWindow() {
        samplePage.clickOpenNewWindowLink();
    }

    @Then("a new window should open")
    public void a_new_window_should_open() {
        // Wait until number of windows becomes greater than 1
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean numberOfWindowsIsTwo = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Assert.assertTrue("Expected a second window to open", numberOfWindowsIsTwo);
    }

    @Then("I switch to the new window and verify the title contains {string}")
    public void switchToNewWindowAndVerifyTitle(String titleFragment) {
        String newWindowHandle = switchToChildWindow(parentWindowHandle);
        String title = driver.getTitle();
        System.out.println("Switched to window: " + newWindowHandle + " with title: " + title);
        Assert.assertTrue("Title does not contain expected text", title.contains(titleFragment));
    }

    @When("I close the child window and switch back")
    public void closeChildWindowAndSwitchBack() {
        // close current (child) window
        driver.close();
        // switch back to parent
        driver.switchTo().window(parentWindowHandle);
        System.out.println("Switched back to parent: " + parentWindowHandle);
    }

    @Then("only the parent window should remain")
    public void only_parent_window_should_remain() {
        Set<String> handles = driver.getWindowHandles();
        Assert.assertEquals("There should be only one window open", 1, handles.size());
        Assert.assertTrue(handles.contains(parentWindowHandle));
    }

    /**
     * Helper: find and switch to the first window handle that is NOT parent
     */
    private String switchToChildWindow(String parentHandle) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                return handle;
            }
        }
        throw new RuntimeException("No child window found");
    }
}
