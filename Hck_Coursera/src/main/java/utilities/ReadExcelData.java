package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	String path = null;
	FileInputStream fis = null;
	XSSFWorkbook wb = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;

	public  ReadExcelData(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getColoumnCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(0);
		int coloumnNum = row.getLastCellNum();
		return coloumnNum;
	}
	@SuppressWarnings("unlikely-arg-type")
	public String[] getDataFromRow(String sheetName, int rowNum) {
		int coloumnCount = getColoumnCount(sheetName);
		sheet = wb.getSheet(sheetName);
		String[] data = new String[coloumnCount];
		for (int i = 0; i < coloumnCount; i++) {
			CellType type = sheet.getRow(rowNum).getCell(i).getCellTypeEnum();
			if (type.equals("NUMERIC"))
				data[i] = String.valueOf(sheet.getRow(rowNum).getCell(i).getNumericCellValue());
			else
				data[i] = String.valueOf(sheet.getRow(rowNum).getCell(i));
		}
		return data;
	}
}

