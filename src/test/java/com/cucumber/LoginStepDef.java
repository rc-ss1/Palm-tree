package com.cucumber;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.commonbase.Base;
import com.cucumber.commonservices.PDFReader;
import com.cucumber.commonvalidation.ComValidation;
import com.cucumber.pages.HomePage;
import com.cucumber.commonservices.ExcelHelper;
import com.cucumber.commonservices.ScreenshotServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.cucumber.pages.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class LoginStepDef extends Base {
    LoginPage login;
    ScreenshotServices services;
    ExcelHelper excelHelper;
    HomePage homePage;
    String actual;
    PDFReader pdfReader;



    public LoginStepDef() {
        driver = Base.driver;
        login = new LoginPage();
        services = new ScreenshotServices();
        excelHelper = new ExcelHelper();
        homePage = new HomePage();
        pdfReader = new PDFReader();


    }

    @When("I click on YourAccount")
    public void iClickOnYourAccount() throws InterruptedException {
        login.clickYourAccount();


    }


    @Then("I should see location dropdown")
    public void iShouldSeeLocationDropdown() throws InterruptedException {
        //login.selectDropdownByValue();
        login.selectDropdownByText();
        try {

            /*String actualValueCat
            Assert.assertEquals(actualValueCatalog, "Catalogs");
            softAssert.assertNotEquals(actualValueCatalog, "Catalogs");
            softAssert.assertAll();*/
            //softAssert.assertAll();

        } catch (Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            scenario.attach(services.getScreenshot(), ComValidation.IMAGEPNG, scenario.getName());

        }
    }


    @When("read from excel")
    public void readFromExcel() throws IOException {
        XSSFSheet sheet = excelHelper.getExcelSheetTabData("C:\\KDF\\Test.xlsx", "Test.xlsx", "Sheet2");
        actual = sheet.getRow(2).getCell(2).getStringCellValue();

        int rowsCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowsCount);
        String email;
        String password;
        for (int i = 1; i < rowsCount; i++) {
            email = sheet.getRow(i).getCell(1).getStringCellValue();

            login.enterEmail(email);
            password = sheet.getRow(i).getCell(4).getStringCellValue();
            login.enterPassword(password);
        }

    }

    @Then("data should display from excel")
    public void dataShouldDisplayFromExcel() {
        Assert.assertEquals(actual, "Vadodara");
    }

    @When("write to excel")
    public void writeToExcel() throws IOException {
        // create workbook for output result

        XSSFWorkbook outputworkbook;
        //to generate excel file, workbook
        outputworkbook = new XSSFWorkbook();
        //to generate sheet in excel
        XSSFSheet output = outputworkbook.createSheet("Output File");

// Create row for Output//this is hardcoded can be kept in loop
        XSSFRow outputValueRow = output.createRow(1);


// WRITE RESULT VALUE INTO OUTPUT RESULT FILE
        //as per 82nd line it would create row as per array of an object
        Object[] outputValues = {"1", "Baroda", "Test", "Pass"};
        excelHelper.WriteDataInOutputFile(outputValues, outputValueRow);
        FileOutputStream fos = excelHelper.getFileOutputStreamPath("D:\\Outputfile.xlsx");
        outputworkbook.write(fos);
        System.out.println("Excel generated Successfully");
        fos.close();
    }




    @When("user navigate to homepage")
    public void userNavigateToHomepage() {
        System.out.println("home is displayed");
    }

    @When("I enter {string} on Login screen")
    public void iEnterOnLoginScreen(String username) {

        login.enterEmail(username);
    }

    @When("I login with the website with excel data")
    public void iLoginWithTheWebsiteWithExcelData() {
        driver.navigate().to("https://www.kapruka.com/shops/customerAccounts/accountLogin.jsp");
    }

    @Then("data should display")
    public void dataShouldDisplay() {
        System.out.println("test");
    }

    @When("read pdf")
    public void readPdf() throws IOException {

        System.out.println(pdfReader.getPdfContent("C:\\1img\\BjrwFsn8n2.pdf"));
    }







    @Then("verify text in pdf")
    public void verifyTextInPdf() throws IOException {
        try {
            List<String> pdf = pdfReader.getPdfContent("C:\\1img\\BjrwFsn8n2.pdf");
            boolean flag = false;
            String extractedLine = ""; // Variable to store the extracted line

            for (String str : pdf) {
                if (str.contains("12345678")) {
                    flag = true;
                    extractedLine = str; // Save the matched line
                    System.out.println("Matched Line: " + extractedLine);
                    //No point of adding assertion in loop
                    //Assert.assertTrue(true);
                    System.out.println("Text found");
                    //break;
                }
//                else {
//                    Assert.fail("Assert failed - Text is not found");
//                }
            }
            Assert.assertTrue(flag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    @When("I logout with the website")
    public void iLogoutWithTheWebsite() {
        
    }

    @Then("I should not see dashboard")
    public void iShouldNotSeeDashboard() {

    }

    @Then("Join button should be visible")
    public void joinButtonShouldBeVisible() throws InterruptedException {

        //homePage.clickJoinOption();
    }

    @When("user click on Join option")
    public void userClickOnJoinOption() {
        //homePage.clickWhatsAppOption();
        System.out.println("whatsapp");
    }



        @When("User enters {string} and {string}")
        public void user_enters_credentials(String email, String password) {
            login.enterEmail(email);
            login.enterPassword(password);

        }


        //getText for all messages for all scenarios


        @Then("User should see {string}")

        public void user_should_see(String expectedResult) {
            String actualMessage = "";

            if (expectedResult.equals("Home page is displayed")) {
                actualMessage = driver.getTitle();
                assertEquals("Kapruka - Home", actualMessage);

            } else if (expectedResult.equals("Invalid credentials message")) {
                actualMessage = login.getErrorMessage();
                assertEquals("Invalid username or password.", actualMessage);

            } else if (expectedResult.equals("Email field validation message")) {
                actualMessage = login.noAccountMessage();
                assertEquals("Please enter your email.", actualMessage);

            } else if (expectedResult.equals("Password field validation message")) {
                actualMessage = login.getErrorMessage();
                assertEquals("Please enter your password.", actualMessage);

            }

            driver.quit();
        }

    @Then("user Clicks on the login button")
    public void userClicksOnTheLoginButton() throws InterruptedException {
        login.clickLoginButton();
    }


    @When("User enters username {string} and password {string}")
        public void user_enters_username_and_password(String username, String password) {
           login.enterEmail(username);
           login.enterPassword(password);

        }

    @When("User clicks on the Login button")
    public void user_clicks_on_the_login_button() {
        login.clickLoginButton();
    }

    @Then("Login attempt should be processed")
    public void login_attempt_should_be_processed() {
        try {
            Thread.sleep(2000); // Wait for page response (not ideal; prefer WebDriverWait in real projects)

            // Check if error message is displayed
            if (driver.getPageSource().contains("Your email address or password is incorrect.")) {
                System.out.println("❌ Login failed: Error message displayed.");
            } else if (driver.getTitle().contains("Kapruka.com")) {
                System.out.println("✅ Login success: Possibly redirected to homepage or dashboard.");
            } else {
                System.out.println("⚠️ Login outcome unclear: Check manually.");
            }
        } catch (Exception e) {
            System.out.println("❗ Exception occurred: " + e.getMessage());
        } finally {

        }
    }

}