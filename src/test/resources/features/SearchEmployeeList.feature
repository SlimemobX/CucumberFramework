@searchEmp
Feature: Search Employee

	Background:
		When login with valid credentials
		Then navigate to Employee list page
	
	@EmpName
	Scenario Outline: Search Employee By name
	When enter name "<Employee Name>"
	Then click search Button
    
    Examples:
    	|Employee Name|
    	|Albertini|
    	|Ann|
    	|Y|
    	|Wilson|
    	|Kennedy|
    
    
     @EmpId
  Scenario Outline: Search Employee By ID
    When enter "<Employee ID>"
    Then click search Button
    
    Examples:
      | Employee ID |
      | 06376A      |
      |        7552 |
      | 18976A      |
      | 14855A      |
      |        7534 |