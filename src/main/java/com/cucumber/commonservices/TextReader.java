package com.cucumber.commonservices;

import java.io.File;
import java.util.Scanner;

public class TextReader
{
    /**
     * this function will read text file data
     **/
    public String readTextFile(String filePath, String dataName, int indexNumber) {
        String value = null;

        try {
            //mention filepath of the file to be read
            File myObj = new File(filePath);
            Scanner FileReader = new Scanner(myObj);
            while (FileReader.hasNextLine()) {
                String data = FileReader.nextLine();
                if (data.contains(dataName)) {
                    String[] values = data.split("\\s+");
                    //it starts reading from 0 index, space is also counted as one of the index
                    value = values[indexNumber];
                    System.out.println("Text file value is:" + value);
                    break;
                }
            }
            FileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
