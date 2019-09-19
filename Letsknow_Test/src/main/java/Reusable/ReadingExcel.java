package Reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadingExcel {

	public static void getCellData(int columnIndex, String path) {
		ArrayList<String> columndata = null;

		try {
			File file = new File(path);
			FileInputStream ifile = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(ifile);
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			workbook.close();
			Iterator<Row> rowIterator = sheet.iterator();
			columndata = new ArrayList<String>();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (row.getRowNum() >= 0) { // To filter column headings
						if (cell.getColumnIndex() == columnIndex) {// To match
																	// column
																	// index
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								columndata.add(cell.getNumericCellValue() + "");
								break;
							case Cell.CELL_TYPE_STRING:
								columndata.add(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								columndata.add(cell.getBooleanCellValue() + "");
							}
						}
					}
				}
			}
			ifile.close();
			System.out.println(columndata);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// getCellData(3,"D:\\selivecorporateactivity\\branches\\Letsknow_Test\\src\\test\\resources\\SELiveCorporateActivity_WebService_AutomationSuite.xls");
		getCellData(3, "D:/selivecorporateactivity/branches/Letsknow_Test/src/main/resources/readexcel.xls");

	}

}
