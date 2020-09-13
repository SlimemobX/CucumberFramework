package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.ConfigReading;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends CommonMethods{
	
	@Given("go to HRMS login page")
	public void go_to_hrms_login_page() {
		setUp();
	}

	@When("login with valid credentials")
	public void login_with_valid_credentials() {
		sendText(login.userNameTextBox, ConfigReading.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigReading.getPropValue("password"));
		click(login.loginBtn);
	}

	@Then("verify the dashboard logo is displayed")
	public void verify_the_dashboard_logo_is_displayed() {
	    Assert.assertTrue(dashboard.welcomeAdmin.isDisplayed());
	}

	@Then("quit the browser")
	public void quit_the_browser() {
	    tearDown();
	}
	
	@When("login with invalid credentials")
	public void login_with_invalid_credentials() {
		login.loginToHrms("Admin11", "Syntax");
	}

	@Then("verify the error message")
	public void verify_the_error_message() {
		Assert.assertTrue(login.spanMessage.isDisplayed());
	}
	
	@When("login with empty username")
	public void login_with_empty_username() {
	   sendText(login.passwordTextBox, ConfigReading.getPropValue("password"));
	   click(login.loginBtn);
	}

	@Then("verify the empty username error message")
	public void verify_the_empty_username_error_message() {
	  Assert.assertEquals(login.spanMessage.getText(), "Username cannot be empty");
	}
	
	@When("login with empty password")
	public void login_with_empty_password() {
		sendText(login.userNameTextBox, ConfigReading.getPropValue("username"));
		click(login.loginBtn);
	}

	@Then("verify the empty password error message")
	public void verify_the_empty_password_error_message() {
		 Assert.assertEquals(login.spanMessage.getText(), "Password cannot be empty");
	}
	

}
