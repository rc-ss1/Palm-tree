package com.cucumber.commonservices;

import com.cucumber.commonbase.Base;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class CommonFunctions extends Base {

    /**
     * This function will use for delete folder
     */
    public void deleteFolder(String path) {
        File dir = new File(path);
        try {
            if (dir.exists()) {
                FileUtils.forceDelete(dir);
            }
        } catch (Exception e) {
            System.err.println("folder not deleted");
        }
    }

    /**
     * This function will use for creating folder
     */
    public void createFolder(String path) {
        File fileDirs = new File(path);
        try {
            if (!fileDirs.exists()) {
                fileDirs.mkdirs();
            }
        } catch (Exception e) {
            System.err.println("An error occurred while creating the directory: " + e.getMessage());
        }

        /**
         * This function used to get current date and time

         */

            /*public String getCurrentDateAndTime() {

                String currentDateAndTime = null;

                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");

                    Date date = new Date();

                    currentDateAndTime = dateFormat.format(date);

                    currentDateAndTime = currentDateAndTime.replace(" ", "_").replaceAll("/", "_").replaceAll(":", "");

                } catch (AssertionError | Exception e) {

                    ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());

                    //scenario.attach(this.screenshotService.getScreenshot(), CommonValidation.IMAGEPNG, scenario.getName());

                    softAssert.fail("There is an issue with generating date.");

                }

                //return currentDateAndTime;

            }
*/
/**
 * This function used to get future date

 */


        /**
         * This function will give name of the file without having extension
         */

    }
}
