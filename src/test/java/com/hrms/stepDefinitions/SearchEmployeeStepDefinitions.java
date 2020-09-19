package com.hrms.stepDefinitions;

import com.hrms.Utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeStepDefinitions extends CommonMethods{
	

@Then("navigate to Employee list page")
public void navigate_to_Employee_list_page() {
   click(dashboard.pimLinkBtn);
   click(pim.searchEmpList);
}

@When("enter name {string}")
public void enter_name(String employeeName) {
 waitForClickAbility(search.searchEmpName);
  sendText(search.searchEmpName, employeeName);
}

@Then("click search Button")
public void click_search_Button() {
 click(search.searchButton);
}

@When("enter {string}")
public void enter(String empId) {
	 waitForClickAbility(search.searchEmpId);
	  sendText(search.searchEmpId, empId);
}


}
