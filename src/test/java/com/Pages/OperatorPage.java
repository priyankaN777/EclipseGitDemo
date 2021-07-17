package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.objectrepository.OperatorObjectRepository;
import com.utilities.ReadExcelDateWithJXL;

public class OperatorPage extends OperatorObjectRepository
{
	WebDriver driver=null;
	
	public OperatorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyUnameforTechnical( ) {
		
		
	}
	
   public void verifyUnameforWhatsapp( ) {
		
		
	}
   
  
   public List<String> verifyUnameforEnquiry(String search ) {
		   List<String> actdata=new ArrayList<String>();
		   for (WebElement row: rows)
		   {
			   List<WebElement> cols = row.findElements(By.tagName("td"));
				for(WebElement column : cols)
				{ 
					int colindex = cols.indexOf(column);
					if (colindex==2)
					{
						if (column.getText().contains(search))
						{
							WebElement name= cols.get(1);
							actdata.add(name.getText());
							System.out.println(name.getText());
						}
						
					}
				}
	        }
		   
		   return actdata;
	   
	}
   
   
   public List<String> verifyUnameforEnquiry_Exp(String search ) {
			   List<String> expdata=new ArrayList<String>();
			   String data=null;
			   ReadExcelDateWithJXL excel=new ReadExcelDateWithJXL();
			   for (int i=0;i<6;i++)
			   {
				   for (int j=0;j<6;j++)
				   {
					   if (j==2)
					   {
						   data = excel.getData(i, j, "ExcelSheet.xls", "Sheet2");
						   System.out.println(data);
						   
						   if(data.contains(search))
						   {
							   data = excel.getData(i, j-1, "ExcelSheet.xls", "Sheet2");
						       expdata.add(data);
						   }
					   }
				   }
			   }
			   
			   return expdata;
		   }
   



}
