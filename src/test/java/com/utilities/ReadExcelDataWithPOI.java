package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelDataWithPOI
{
	
	static FileInputStream fis=null;
	static FileOutputStream fos;
	static File file;
	static XSSFWorkbook w;
	static XSSFSheet sheet;
	static Row row;
	static Cell cell;
	
	@Test
	public static void openfile(String fileName, String sheetName)
	{
		//String inputData[][]=null;
		
		int rowcount = sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
		String inputData[][] = new String[rowcount][colcount];
		
		for(int i=0; i<rowcount ; i++)
		{
			for(int j=0; i<rowcount ; j++)
			{
				row=sheet.getRow(i);
				cell=row.getCell(j);
				
				CellType[] s=cell.getCellType().values();
				System.out.println(s.toString());
				
				/*if(cell.getCellType()==XSSFCell.CELL_TYPE_STRING)
				{
					
				}*/
			}
		}
	}
	

}
