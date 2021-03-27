package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDataProvider 
{
	
	
	public static File currentDir = new File("");
	
	public static String datafilepath ="\\resources\\testdata.xlsx";
	
	public static XSSFSheet getSheet(String sheetname) throws Exception
	{

		String url = currentDir.getAbsolutePath() + datafilepath;
		FileInputStream fis = new FileInputStream(url);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet(sheetname);
		return sheet;
						
	}
	
	public static Object syncPageData(Object obj, String sheetname)
	{
		try 
		{
			XSSFSheet sheet = getSheet(sheetname);
			
			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow dataRow = sheet.getRow(1);
			
			for (int i = 0; headerRow.getCell(i) != null; i++) 
			{
			    Field field = obj.getClass().
			    		getDeclaredField(headerRow.getCell(i).getStringCellValue());
			    field.setAccessible(true);
			    Cell cell = dataRow.getCell(i);
			    
			    switch(cell.getCellType()) 
			    {
			    case Cell.CELL_TYPE_BOOLEAN:
			    	field.set(obj, dataRow.getCell(i).getBooleanCellValue());
			     break;
			    case Cell.CELL_TYPE_NUMERIC:
			    	field.set(obj, dataRow.getCell(i).getNumericCellValue());
			     break;
			    case Cell.CELL_TYPE_STRING:
			    	field.set(obj, dataRow.getCell(i).getStringCellValue());
			     break;
			    case Cell.CELL_TYPE_BLANK:
			    	field.set(obj, "");
			     break;
			    }
			    
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	
	
	public static String[][] readTestData() throws IOException
	{
		String[][] returnData = null;
		
		String url = currentDir.getAbsolutePath() + datafilepath;
		FileInputStream fis = new FileInputStream(url);
		
		HSSFWorkbook workbook =  new HSSFWorkbook(fis);
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		int totalCols = 3;
		
		returnData = new String[totalRows][totalCols];

		int c = 0;
		int r = 0;
		
		for(int i = 0; i <= totalRows; i++)
		{
			if(i > 0)
			{
				Row row = sheet.getRow(i);
				
				for(int j = 0; j < totalCols; j++)
				{
					Cell cell = row.getCell(j);
					try
					{
						returnData[r][c] = cell.getStringCellValue();
					}
					catch(NullPointerException e)
					{
						returnData[r][c] = "";
					}
					c++;
				}
				c = 0;
				r++;
			}
		}
		
		fis.close();
		
		return returnData;
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			readTestData();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}