package generic_utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getExcelData(String SheetName,int RowNum,int CellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(RowNum);
		Cell cell = row.getCell(CellNum);
		String value = cell.getStringCellValue();
		return value;
	}

}
