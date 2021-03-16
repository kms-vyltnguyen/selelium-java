package data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ExcelHelper {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public ExcelHelper(String excelPath, String sheetName) {
        try {
            File excelFile = new File(excelPath);
            workbook = new XSSFWorkbook(excelFile.getAbsolutePath());
            sheet = workbook.getSheet(sheetName);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static int getRowCount() {
        int rowCount = 0;

        try {
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of rows : " + rowCount);

        } catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;

    }

    public static int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("No of columns : "+ colCount);
        } catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;

    }

    public static int getColNumber(String colName) {
        int colCount = 0;
        int colNumber = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int i = 0; i < colCount; i++) {
                if (getCellDataString(0, i) == colName) {
                    colNumber = colCount;
                    return colNumber;
                }
            }

            System.out.println("column number: " + colCount + "with name: " + colName);
        } catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colNumber;

    }

    public static String getCellDataString(int rowNum, int colNum) {
        String cellData = null;
        try {
            if (sheet.getRow(rowNum).getCell(colNum).getRawValue() == null) {
                cellData = "";
            }
            else {
                cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            }

            System.out.println(cellData);
        } catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }


    public static void getCellDataNumber(int rowNum, int colNum) {
        try {
            double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellData);
        } catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public Object[][] testData(String excelPath, String sheetName) {

        ExcelHelper excel = new ExcelHelper(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];

        for(int i = 1; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {

                String cellData = excel.getCellDataString(i, j);
                System.out.print("jjjj: "+cellData+" | ");

                data[i-1][j] = cellData;

            }
            System.out.println(data.toString());
        }
        return data;
    }
}
