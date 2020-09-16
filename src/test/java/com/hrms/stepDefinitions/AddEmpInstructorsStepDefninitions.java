package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.Utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmpInstructorsStepDefninitions extends CommonMethods{
	
	@Then("navigate to add employee page")
	public void navigate_to_add_employee_page() {
		click(dashboard.pimLinkBtn);
		click(pim.addEmpButton);
	}

	@Then("enter first and last name")
	public void enter_first_and_last_name() {
		sendText(addEmp.firstName, "John");
		sendText(addEmp.lastName, "Wick");
	}

	@Then("click on save Button")
	public void click_on_save_Button() {
		click(addEmp.saveButton);
	}

	@Then("verify the employee is added successfully")
	public void verify_the_employee_is_added_successfully() {
		String profileName =employee.pictureText.getText();
		Assert.assertEquals("John Wick", profileName);
	}

	@When("enter first name as {string} middle name as {string} and last name as {string}")
	public void enter_first_name_as_middle_name_as_and_last_name_as(String firstName, String middleName,
			String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
	}
	
	@Then("verify that {string} is added successfully")
	public void verify_that_is_added_successfully(String fullName) {
		String profileName =employee.pictureText.getText();
		Assert.assertEquals(fullName, profileName);
	}

}
