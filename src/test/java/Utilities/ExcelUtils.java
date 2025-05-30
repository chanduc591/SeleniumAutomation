package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static List<Map<String,String>> getExcelRead(String filename,String sheet) {
		
		List<Map<String,String>> data=new ArrayList<Map<String,String>>();
		
		try {
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+filename);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			 XSSFSheet sh1= wb.getSheet("Sheet1");
			 
			 int rows =sh1.getPhysicalNumberOfRows();
			 
			int columns = sh1.getRow(1).getPhysicalNumberOfCells();
			
			for(int r=1;r<rows;r++) {
				
				Map<String, String> rowData = new HashMap<String, String>();

				for(int c=0;r<columns;c++) {
					
					
					 String columnname=sh1.getRow(1).getCell(0).getStringCellValue();
						
					 String columnValue = sh1.getRow(r).getCell(c).getStringCellValue();

					
					 rowData.put(columnname, columnValue);
				}
				
				
			data.add(rowData);	
			}
			
			
			
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return data;
		
		
		
	}

}
