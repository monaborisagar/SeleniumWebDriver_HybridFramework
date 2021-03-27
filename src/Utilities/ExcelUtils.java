package Utilities;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
//
//	static FileInputStream file = null;
//
//	//Get the workbook instance for XLS file 
//	static XSSFWorkbook workbook = null;
//
//	//Get first sheet from the workbook
//	static XSSFSheet sheet = null;
//
//	static Object[][] dataArray = null;
//
//	public static Object[][] getExcelData(String excelName, String sheetName) 
//	{
//
//		try 
//		{
//			file = new FileInputStream(new File(excelName));
//			workbook = new XSSFWorkbook (file);
//
//			if(StringUtils.isNotEmpty(sheetName))
//			{
//				sheet = workbook.getSheet(sheetName);
//			}
//			else
//			{
//				sheet = workbook.getSheetAt(0);
//			}
//
//			int totalRows = sheet.getPhysicalNumberOfRows()-1;
//			int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
//
//			dataArray = new Object[totalRows][totalCols];
//
//
//			for( int i =1 ; i <= totalRows ; i++ ) 
//			{
//
//				for( int j=0 ; j < totalCols ; j++ ) 
//				{
//					try 
//					{
//						dataArray[i-1][j]=getCellData(i , j);
//					} 
//					catch (Exception e) 
//					{
//						e.printStackTrace();
//					}
//				}
//			}
//
//
//		} 
//		catch (FileNotFoundException e) 
//		{
//			e.printStackTrace();
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
//		return dataArray;
//
//	}
//
//	private static Object getCellData(int RowNum, int ColNum) throws Exception
//	{
//
//		try
//		{
//
//			Cell cell= sheet.getRow(RowNum).getCell(ColNum);
//			Object cellData = null ;
//
//			switch(cell.getCellType()) 
//			{
//			case Cell.CELL_TYPE_BOOLEAN:
//				cellData = cell.getBooleanCellValue();
//				break;
//			case Cell.CELL_TYPE_NUMERIC:
//				cellData = cell.getNumericCellValue();
//				break;
//			case Cell.CELL_TYPE_STRING:
//				cellData = cell.getStringCellValue();
//				break;
//			case Cell.CELL_TYPE_BLANK:
//				cellData = "" ;
//				break;
//			}
//			return cellData;
//
//		}
//		catch (Exception e)
//		{
//			return "";
//		}
//
//	}
}