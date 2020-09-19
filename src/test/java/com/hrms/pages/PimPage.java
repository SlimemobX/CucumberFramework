package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PimPage extends BaseClass{
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement searchEmpList;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmpButton;
	
	@FindBy(id = "menu_core_viewDefinedPredefinedReports")
	public WebElement empReports;
	
	public PimPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
