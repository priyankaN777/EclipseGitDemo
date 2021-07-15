package com.Pages;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.objectrepository.UserObjectRepository;
import com.utilities.Log4jPage;
import com.utilities.ReadExcelDataWithPOI;
import com.utilities.ReadExcelDateWithJXL;

public class UserPage extends UserObjectRepository {
	WebDriver driver=null;
	
 	
	public UserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<Boolean> mobileLength() {
		boolean flag=false;
		ArrayList<Boolean> al = new ArrayList<Boolean>();
		List<WebElement> mobiles = driver.findElements(By.xpath("//td[4]"));
		
		for(WebElement mob :mobiles) {
			String text = mob.getText();
			if(text.length()==10) {
				//System.out.println("correct mobile number is :"+text);
				 Log4jPage.pageLogs().info("correct mobile number is :"+text);
				al.add(!flag);
			}
			else {
				//System.out.println("Incorrect mobile number is :"+text);
				 Log4jPage.pageLogs().info("correct mobile number is :"+text);
				al.add(flag);
			}
		}
		return al;
	}
	
	
	public HashMap verifyTableWithHashmap() {
		HashMap<String, List<String>> actData = new HashMap<String, List<String>>();
		String key=null;
		List<String> value = new ArrayList<String>();
		List<WebElement>headers =driver.findElements(By.tagName("th"));
		
		for(WebElement e :headers) {
			
			if(headers.indexOf(e)==0)
				 key = e.getText();
			else 
				value.add(e.getText());
		}
		actData.put(key, value);
		key=null;
		value=null;
		int rows=driver.findElements(By.tagName("tr")).size();
		for(int i=2;i<=rows;i++) {
			value = new ArrayList<String>();
			List<WebElement> rowData = driver.findElements(By.xpath("//tr["+i+"]/td"));
			for(WebElement row: rowData) {
				
				if(rowData.indexOf(row)==0)
					 key = row.getText();
				else 			
					value.add(row.getText());		
			}
			actData.put(key, value);
			
		}
		System.out.println("Act data with hashmap"+actData);
		return actData;
	}
	
	public HashMap verifyTableWithHashmapExcel() {
		HashMap<String , List<String>> expData = new HashMap<String , List<String>>();
		String expKey=null;
		ReadExcelDataWithPOI rd= new ReadExcelDataWithPOI();
		for(int i=0;i<5;i++) {
			ArrayList<String> expAl = new ArrayList<String>();
			expKey= rd.getData(i, 0,"ExcelSheet.xlsx","Sheet1");
			for(int j=1;j<8;j++) {
				expAl.add(rd.getData(i, j, "ExcelSheet.xlsx","Sheet1"));
			}
		expData.put(expKey, expAl);
		}
		
		//System.out.println("Exp data with hashmap"+expData);
	    Log4jPage.pageLogs().info("Exp data with hashmap"+expData);
		return expData;
	}
	
	
	
	public HashMap compareGender()
	{
			HashMap<Integer,ArrayList<String>> hm=new HashMap<Integer, ArrayList<String>>();
		//	WebElement col;
			for(WebElement row : rows)
		{
			
			   /*if (rows.indexOf(row)!=0)
			    {		int rowNum= rows.indexOf(row)+1;
			    	    col = row.findElement(By.xpath("//tr["+rowNum+"]/td[6]"));
			       	   System.out.print(col.getText()+ "***");
			    }*/
			
			if (rows.indexOf(row)!=0)
		    {
				 ArrayList<String> collist= new ArrayList<String>();    
				 List<WebElement> cols = row.findElements(By.tagName("td"));
						for(WebElement column : cols)
						{ 
							int colindex = cols.indexOf(column);
													
							if (colindex==1)
								 collist.add(column.getText());
							else if (colindex==5)
								 collist.add(column.getText());
						}
						 						
						int i =rows.indexOf(row);
						hm.put(i, collist);
		    }		
		}
		
		return hm;
	}
	
	
	public HashMap converExcelToHashMAp()
	 {
		HashMap<Integer,ArrayList<String>> hm=new HashMap<Integer, ArrayList<String>>();
			ReadExcelDataWithPOI read = new ReadExcelDataWithPOI();
			
			 Object[][] expecteddata=read.loginData("ExcelSheet.xlsx","Sheet1");
			 boolean flag=false;
			 
		 
			 for (int i=0; i<5; i++)
			{
				 ArrayList<String> collist= new ArrayList<String>();    
				 if (i!=0)
				 {
					for (int j=0; j<7; j++)
					{
						if (j==1)
						{
							String s=  (String) expecteddata[i][j];
							collist.add(s);
						}
						else if (j==5)
						{
							String s= (String) expecteddata[i][j];
							collist.add(s);
						}
					}
					
					hm.put(i, collist);
				 }
			}
			 
			 return hm;
	 }	 
	
	
	public void hashMapIterator(HashMap hm)
	{
		System.out.println("====== By using Map.Entry ======");
		   // Get a set of the entries 
		   Set set = hm.entrySet();
		   // Get an iterator
		   Iterator it = set.iterator();

		   // Display elements 
			   while(it.hasNext()) 
			   { 
			        Map.Entry me = (Map.Entry) it.next();   
			        System.out.print(me.getKey()+ ": " );
			        ArrayList<String> actuallist = (ArrayList<String>) me.getValue();
			        for(String s : actuallist)
			        {
			        	System.out.print(s+ " ");
			        }
			        System.out.println(" ");
		     		    		      
		      }
	}
	
	
	
	
	
	

	
	public Object[][] getData()
	{
		
		int colsize=8;
		int rowsize=6;
		WebElement col= null;
		String s;
		Object[][] dataArr=new String[5][7];
		
        String rowbeforexpath = "//table[@class ='table table-hover']/tbody/tr[";
       
		
		String headerbeforexpath = "/th[";
		String colbeforexpath = "/td[";
		String afterxpath = "]";
		String actualrowxpath;
		String actualxpath;
	

		
				for (int i=1; i<rowsize;i++ )
				{	
					 actualrowxpath = rowbeforexpath+i+afterxpath;
									
					for (int j=1; j<colsize;j++)
					{
					   		   
						if (i==1)
							actualxpath=actualrowxpath+headerbeforexpath+j+afterxpath;
							
						else
							actualxpath=actualrowxpath+colbeforexpath+j+afterxpath;
							  
						      s = driver.findElement(By.xpath(actualxpath)).getText();
						      System.out.print(s+" ");
						      dataArr[i-1][j-1] = s;			     								
					}
						
					System.out.println();
				}
				
				return dataArr;
	}
	
	
	 public boolean compare()
	 {
		 ReadExcelDataWithPOI read = new ReadExcelDataWithPOI();
			 Object[][] actualdata=getData();
			 Object[][] expecteddata=read.loginData( "ExcelSheet.xlsx","Sheet1");
			 boolean flag=false;
			 
			 System.out.println("Act"+actualdata);
			 System.out.println("Exp"+expecteddata);
			 
		    Outerloop :
			 for (int i=0; i<5; i++)
			{
				for (int j=0; j<7; j++)
				{
					if (actualdata[i][j].equals(expecteddata[i][j]))
					{
						flag=true;
						//System.out.println("Values : " +i+ " " +j+  flag);
						Log4jPage.pageLogs().info("Values : " +i+ " " +j+  flag);
						
					}
					
					else
					{
						flag=false;
						//System.out.println("Values : " +i+ " " +j+  flag);
						Log4jPage.pageLogs().info("Values : " +i+ " " +j+  flag);
						break Outerloop;
					}
				}
			}
			
		 return flag;
			
		}
	
	
}
		






	


