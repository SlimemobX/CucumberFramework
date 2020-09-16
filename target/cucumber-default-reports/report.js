$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployeeInstructorsWay.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@addEmployee"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "navigate to add employee page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmpInstructorsStepDefninitions.navigate_to_add_employee_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Add employee without login details but with middle name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addEmployee"
    },
    {
      "name": "@parameter"
    }
  ]
});
formatter.step({
  "name": "enter first name as \"Ahmet\" middle name as \"Can\" and last name as \"Bicer\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmpInstructorsStepDefninitions.enter_first_name_as_middle_name_as_and_last_name_as(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on save Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmpInstructorsStepDefninitions.click_on_save_Button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify that \"Ahmet Can Bicer\" is added successfully",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmpInstructorsStepDefninitions.verify_that_is_added_successfully(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "skipped"
});
});