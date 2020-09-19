package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.Constant;
import com.hrms.Utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmpInstructorsStepDefninitions extends CommonMethods {

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
		String profileName = employee.pictureText.getText();
		Assert.assertEquals("John Wick", profileName);
	}

//	@When("check login details checkbox")
//	public void check_login_details_checkbox() {
//	  click(addEmp.createLoginDetailsCheckbox);
//	}
//
//	@Then("enter login details")
//	public void enter_login_details() {
//	   sendText(addEmp.userName, "Jwick6328");
//	   sendText(addEmp.userPassword, "DontmesswithWicksdog0983!");
//	   sendText(addEmp.confirmPassword, "DontmesswithWicksdog0983!");
//	}

	@When("enter first name as {string} middle name as {string} and last name as {string}")
	public void enter_first_name_as_middle_name_as_and_last_name_as(String firstName, String middleName,
			String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
	}

	@Then("verify that {string} is added successfully")
	public void verify_that_is_added_successfully(String fullName) {
		String profileName = employee.pictureText.getText();
		Assert.assertEquals(fullName, profileName);
	}

	@When("enter employee {string}, {string}, and {string}")
	public void enter_employee_and(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
	}

	@Then("verify that {string}, {string}, and {string} is successfully added")
	public void verify_that_and_is_successfully_added(String firstName, String middleName, String lastName) {
		String fullName = firstName + " " + middleName + " " + lastName;
		String fullProfileName = employee.pictureText.getText();
		Assert.assertEquals(fullName, fullProfileName);
	}

	@When("add multiple employees and verify they are needed")
	public void add_multiple_employees_and_verify_they_are_needed(DataTable employees) throws InterruptedException {
		List<Map<String, String>> employeeNames = employees.asMaps();

		for (Map<String, String> employeeName : employeeNames) {
			String firstName = employeeName.get("First Name");
			String middleName = employeeName.get("Middle Name");
			String lastName = employeeName.get("Last Name");
			String empId = employeeName.get("Employee ID");

			sendText(addEmp.firstName, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastName, lastName);
			sendText(addEmp.empId, empId);

			click(addEmp.saveButton);

			String actualName = employee.pictureText.getText();
			String expectedName = firstName + " " + middleName + " " + lastName;
			Assert.assertEquals("Verifying employee names", expectedName, actualName);
			click(dashboard.addEmpButton);
			Thread.sleep(1000);

		}
	}

	@When("add multiple employees from {string} verify they are added successfully")
	public void add_multiple_employees_from_verify_they_are_added_successfully(String sheetName)
			throws InterruptedException {
		List<Map<String, String>> excelData = ExcelUtility.excelToListMap(Constant.TESTDATA_FILEPATH, sheetName);

		for (Map<String, String> excelEmpName : excelData) {
			String firstName = excelEmpName.get("FirstName");
			String middleName = excelEmpName.get("MiddleName");
			String lastName = excelEmpName.get("LastName");
			String empId = excelEmpName.get("Employee ID");

			sendText(addEmp.firstName, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastName, lastName);
			sendText(addEmp.empId, empId);

			click(addEmp.saveButton);

			String actualName = employee.pictureText.getText();
			String expectedName = firstName + " " + middleName + " " + lastName;
			Assert.assertEquals("Verifying employee names", expectedName, actualName);
			jsClick(dashboard.addEmpButton);

		}
	}

}
