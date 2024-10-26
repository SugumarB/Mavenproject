package com.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenFrameWork {
public static void main(String[] args) throws IOException{
	File file = new File("C:\\Users\\kanch\\eclipse-workspace\\MavenProject\\Excel\\test.xlsx");
	FileInputStream stream= new FileInputStream(file);
	Workbook workbook = new  XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet("Sheet1");
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		Row row = sheet.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			//System.out.println(cell);
			CellType type = cell.getCellType();
			//System.out.println(type);
	switch (type) {
	case STRING:
		String value = cell.getStringCellValue();
		System.out.print(value);
		break;
	case NUMERIC:
		if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
			String format = dateformat.format(dateCellValue);
			System.out.print(format);
		}else {
		double numericCellValue = cell.getNumericCellValue();
		BigDecimal b = BigDecimal.valueOf(numericCellValue);
		String number = b.toString();
		System.out.println(number);
		}
		break;
	default:
		break;
	}
}
}
}
}
