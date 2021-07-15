package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataWithPOI
{
	
	static FileInputStream fis;
	static FileOutputStream fos;
	static File file;
	//static XSSFWorkbook w;
	//static XSSFSheet sheet;
	static Row row;
	static Cell cell;
	Object[][] dataArr;
	Workbook wb=null;
	
	
	
	public  Object[][] loginData(String filepath, String sheetName) {
	
		DataFormatter df = new DataFormatter();
		try {
			 fis= new FileInputStream(filepath);
			 wb= WorkbookFactory.create(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
	
		Sheet sh= wb.getSheet(sheetName);
		
		int rows = sh.getPhysicalNumberOfRows();//3
		String data= null;
		int col = sh.getRow(0).getLastCellNum();
		dataArr =  new String[rows][col];
		
		
		for(int i=0;i<rows;i++) 
		{
		//	int col = sh.getRow(i).getLastCellNum();// i==0--2, i==1--3
			
			//System.out.println("columns in rownum:"+ i+" are "+col +"firstcol" + sh.getRow(i).getFirstCellNum());
			for(int j=0;j<col;j++) 
			{
				//System.out.println("col no "+j);
				Cell c= sh.getRow(i).getCell(j);
			  data = df.formatCellValue(c);
				
				System.out.print(data+"  ");
				dataArr[i][j] = data;
			}
			System.out.println();
		}
		
		return dataArr;
	}
	

	public String getData(int rowno, int colno, String filename, String sheetname)
	{
		String data=null;
		
		DataFormatter df = new DataFormatter();
		try {
			 fis= new FileInputStream(filename);
			 wb= WorkbookFactory.create(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
	
		Sheet sh= wb.getSheet(sheetname);
		
		int rows = sh.getPhysicalNumberOfRows();//3
		
		for(int i=0;i<rows;i++) {
			int col = sh.getRow(i).getLastCellNum();// i==0--2, i==1--3
			//System.out.println("columns in rownum:"+ i+" are "+col);
			for(int j=0;j<col;j++) {
				
				if (i==rowno && j==colno)
				{
				Cell c= sh.getRow(i).getCell(j);
				data = df.formatCellValue(c);
				//System.out.print(data+"  ");
				}
				
			}
			//System.out.println();
		}
		
		return data;
	}

}
