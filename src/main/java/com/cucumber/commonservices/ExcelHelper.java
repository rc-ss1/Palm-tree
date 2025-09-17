package com.cucumber.commonservices;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ExcelHelper

{
    //read an excel file
    public FileInputStream getFileInputStreamPath (String filePath) throws FileNotFoundException {
        FileInputStream fis =new FileInputStream(filePath.toString());
        System.out.println("File path" +fis);
        return fis;
    }

    //generate an output file
    public FileOutputStream getFileOutputStreamPath (String filePath) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream (filePath.toString());
        System.out.println("File path" +fos);
        return fos;
    }

    public XSSFSheet getExcelSheetTabData(String filePath, String excelName, String sheetName) throws IOException {
        try {

            FileInputStream fis = getFileInputStreamPath(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int lastColNum = sheet.getRow(0).getLastCellNum();
            DataFormatter dataFormatter = new DataFormatter();

            for (Row nextRow : sheet) {
                for (int colNum = 1; colNum < lastColNum; colNum++) {
                    Cell cell = nextRow.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (Objects.requireNonNull(cell.getCellType()) == CellType.BLANK) {
                        cell.setCellValue("");
                    } else if(Objects.requireNonNull(cell.getCellType()) == CellType.NUMERIC) {
                        String numericAsString = dataFormatter.formatCellValue(cell);
                        cell.setCellValue(numericAsString);
                    }
                }
            }
            workbook.close();
            fis.close();
            return sheet;
        } catch (IOException ex) {
            return null;
        }
    }

    public void WriteDataInOutputFile(Object[] outputValues, XSSFRow OutputValueRow) {
        for (int counter = 0; counter < outputValues.length; counter++) {
            XSSFCell cell = OutputValueRow.createCell(counter);
            cell.setCellValue(outputValues[counter].toString());
        }
    }

}
