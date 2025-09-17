package com.cucumber.commonservices;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class PDFReader {
    /**
     * This function will return list of String with some line by line pattern from all pdf content

     */
    public List<String> getPdfContent(String path) throws IOException{
        //create object
        File file = new File(path);
        //loading file
        PDDocument pdDocument = PDDocument.load(file);
        //pre defined class
        PDFTextStripper strip = new PDFTextStripper();
        //getText
        String stripText = strip.getText(pdDocument);
        //interface - Stream collection
        Stream<String> lines = stripText.lines();
        pdDocument.close();
        return lines.toList();
    }
}



//try{
// List<String> pdf = pdfReader.getPDFContent("D:\\test.pdf")
//for(String str: pdf)//This is a for each loop iterates over each line
// {
//if(str.contains("tom"))
//{ flag = true;
// SOP("text found");
//
//else
// Assert.fail("Assert failed - text not found"}
//catch(Exception e)
//{SOP(e.getMessage);

  //      }
