Feature: Adding Employee


@regression
Scenario: Add employee without login details
When login with valid credentials
Then navigate to add employye page
When add employee without login details
Then verify employee was added


@regression
Scenario: Add employee with login details
When login with valid credentials
Then navigate to add employye page
When add employee with login details
Then verify employee was added