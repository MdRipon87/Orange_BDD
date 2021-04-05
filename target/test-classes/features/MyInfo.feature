@MyInfo
Feature: Varify on OrangHRM personal form info 

Background: 
	Given User is on OrangHRM login page 
	
Scenario Outline: User should be able to fill up personal info form 
	When User enters the "<username>" and "<password>" 
	And  User clicks on login button 
	Then User should be able to see the dashboard 
	When User clicks on Myinfo
	Then User clicks on edit
	Then User enters "<FirstName>" and "<MiddleName>" and "<LastName>" and "<EmployeeID>" and "<OtherID>" and "<DriverLicenseNumber>" and "<LicenseExpireMonth>" and "<LicenseExpireYear>" and "<ssnNumber>" and "<sinNumber>" and "<MaritalStatus>" and "<Nationality>" and "<dobMonth>" and "<dobYear>"
	Then User clicks on save 
	Examples:
	|username|password|FirstName|MiddleName|LastName|EmployeeID|OtherID|DriverLicenseNumber|LicenseExpireMonth|LicenseExpireYear|ssnNumber|sinNumber|MaritalStatus|Nationality|dobMonth|dobYear|
	|admin   |admin123|     Md  |A         |Ripon   |501       |101    |4560               |Feb               |    2020         |303064040|500      |Married      |American   |Mar     |1985   |
	
	