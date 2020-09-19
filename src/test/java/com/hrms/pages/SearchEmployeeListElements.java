package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class SearchEmployeeListElements extends BaseClass{
	
	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement searchEmpName;
	
	@FindBy(id = "empsearch_id")
	public WebElement searchEmpId;
	
	@FindBy(id = "searchBtn")
	public WebElement searchButton;
	
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td[1]")
	public WebElement searchResultId;
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td[2]")
	public WebElement searchResultFirstName;
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td[3]")
	public WebElement searchResultLastName;
	
	public SearchEmployeeListElements() {
		PageFactory.initElements(driver, this);
	}

}
