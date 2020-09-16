$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Dashboard.feature");
formatter.feature({
  "name": "Dashboard Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dashboard tab verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@dash"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the following dashboard tabs",
  "rows": [
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.DashboardStepDefinitions.verify_the_following_dashboard_tabs(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Dashboard tab verification");
formatter.after({
  "status": "passed"
});
});