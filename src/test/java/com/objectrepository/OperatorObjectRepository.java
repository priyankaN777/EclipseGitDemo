package com.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorObjectRepository {
	
	 @FindBy(xpath="//tr")
	   public List< WebElement > rows;
	 
	
}
