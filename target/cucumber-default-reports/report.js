$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "go to HRMS login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.go_to_hrms_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login with invalid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_invalid_credentials()"
});
