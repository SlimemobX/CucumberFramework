package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.Utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmpStepDefinitions extends CommonMethods{
	
	@Then("navigate to add employye page")
	public void navigate_to_add_employee_page() {
	    click(dashboard.pimLinkBtn);
	    click(pim.addEmpButton);
	}

	@When("add employee without login details")
	public void add_employee_without_login_details() {
	   sendText(addEmp.firstName, "Dwyane");
	   sendText(addEmp.lastName, "Wade");
	   click(addEmp.saveButton);
	}

	@Then("verify employee was added")
	public void verify_employee_was_added() {
	 Assert.assertEquals("Dwyane Wade", employee.pictureText.getText());
		
	}

	@When("add employee with login details")
	public void add_employee_with_login_details() {
	   sendText(addEmp.firstName, "Dwyane");
	   sendText(addEmp.lastName, "Wade");
	   
	   click(addEmp.createLoginDetailsCheckbox);
	   
	   sendText(addEmp.userName, "Dwade6328");
	   sendText(addEmp.userPassword, "Thefla$hDwade0983");
	   sendText(addEmp.confirmPassword, "Thefla$hDwade0983");
	   click(addEmp.saveButton);
	}

}
