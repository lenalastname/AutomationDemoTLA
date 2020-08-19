package utils;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\olena\\Desktop\\userData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet 1");

//        Row row = sheet.getRow(0);                                ( 0 is an index: 1st row has index 0)
//        Cell cell = row.getCell(0);        --------- 1st option ( 0 is an index: 1st cell has index 0)

//        for(int i = 0; i < 2; i++){        ---------- 2nd option ( hardcode: 2 is a number of rows, 5 cells)
//            Row row = sheet.getRow(i);
//            for(int j = 0; j < 5; j++){
//                System.out.print(row.getCell(j) + " | ");
//            }
//            System.out.println();
//        }


//      int rowNum = sheet.getPhysicalNumberOfRows();       //------------ 3rd option
//        for (int i = 0; i < rowNum; i++){
//            Row row = sheet.getRow(i);
//            int cellCount = row.getPhysicalNumberOfCells();
//            for(int j = 0; j < cellCount; j++){
//                System.out.print(row.getCell(j) + " | ");
//            }
//            System.out.println();
//        }


//      Sheet sheet1 = workbook.createSheet("loginUsers");
//        Sheet sheet1 = workbook.getSheet("loginUsers");
//        Row row = sheet1.createRow(0);
//        Cell cell = row.createCell(0);
//        cell.setCellValue("First name");
//
//        row.createCell(1).setCellValue("Last Name");
//        row.createCell(2).setCellValue("Phone number");
//
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\olena\\Desktop\\userData.xls");
//        workbook.write(fileOutputStream);




//        Sheet myGroupSheet = workbook.createSheet( "My Group");
//
//        String[] header = {"First name", "email", "group name"};
//
//        Row row = myGroupSheet.createRow(0);
//        for(int i = 0; i < header.length; i++) {
//            row.createCell(i).setCellValue(header[i]);
//        }
//        Row row1 = myGroupSheet.createRow(1);
//        row1.createCell(0).setCellValue("Kuba");
//        row1.createCell(1).setCellValue("kuba@gmail.com");
//        row1.createCell(2).setCellValue("TLA");
//
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\olena\\Desktop\\userData.xlsx");
//        workbook.write(fileOutputStream);

        Sheet myGroupSheet = workbook.createSheet( "users");
        String[] header = {"First name", "Last name", "Phone num"};

        Row row = myGroupSheet.createRow(0);
        for(int i = 0; i < header.length; i++) {
            row.createCell(i).setCellValue(header[i]);
        }
        Row row1 = myGroupSheet.createRow(1);
        Faker faker = new Faker();
        row1.createCell(0).setCellValue(faker.name().firstName());
        row1.createCell(1).setCellValue(faker.name().lastName());
        row1.createCell(2).setCellValue(faker.phoneNumber().phoneNumber());
        row1.createCell(2).setCellValue(faker.internet().emailAddress());


        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\olena\\Desktop\\userData.xlsx");
        workbook.write(fileOutputStream);


       }
    }
