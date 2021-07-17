package com.utilities;

import java.io.FileInputStream;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class ReadExcelDateWithJXL 
{
	
	FileInputStream fis;
	Workbook wb=null;
	Object[][] dataArr;
	
	
	public  Object[][] loginData()
	{
		//File file;
		
				try 
		{
			fis = new FileInputStream("ExcelSheet.xls");
			wb= Workbook.getWorkbook(fis);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Sheet sh=wb.getSheet("Sheet1");
		int rows =sh.getRows();
		int cols = sh.getColumns();
		dataArr =  new String[rows][cols];
	
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				Cell c=sh.getCell(j, i);
				String data = c.getContents();
				
			System.out.print(data+" ");
				
				dataArr[i][j] = data;
			}
			System.out.println(" ");
		}
				
		return dataArr;
	}
	
	
	public String getData(int rowno, int colno, String filename, String sheetname)
	{
		String data=null;
		
		try 
		{
			fis = new FileInputStream(filename);
			wb= Workbook.getWorkbook(fis);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Sheet sh=wb.getSheet(sheetname);
	//	System.out.println(sh.getName());
		int rows =sh.getRows();
		int cols = sh.getColumns();
		dataArr =  new String[rows][cols];
		
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				if (i==rowno && j==colno)
				{
				Cell c=sh.getCell(j, i);
				data = c.getContents();
				}
			}
		}
		
		return data;
	}
	

	
	
	

}
