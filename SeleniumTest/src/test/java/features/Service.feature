Feature: Test Background Feature

Background: User logged in
          Given Initialize the browser with chrome
        And Navigate to the Site
        When User enters username and password and logs in
        Then Click Flat Icon
       And Select service





Scenario Outline: Successful clicks arround tabs
	When User Navigate arround tabs and press new and cancell buttons 
	And close the driver
	
	Scenario Outline: Create a New Account
	Given User clicks on Account Tab 
	And click New Account
	When Create a New Account with <name>, <phone>, <fax>, <account>, <Website>, <Site>
	Then Click Save and New
	And close the driver
	
	Examples: 
	 | name | phone  |fax  | account     | Website      | Site   |
	 | Jorge| doscuera|faax|ahroge@hs.com|Www.george.com|georgius|
	 
	
	Scenario Outline: Create a failed account record
	Given User clicks on Account Tab 
	And click New Account
	When fills only one place
	Then Click Save and New
	And it takes an error
	And close the driver
	
	Scenario Outline: Create a new Contact record
	Given User clicks on contact record Tab and open a new window 
	And switch to the new Window
	When clicks to create a new contact record
	And fill the contact record
	Then Saves the contact record
	And switch to original window
	And quit the driver
	
	Scenario Outline: Edit account record
	Given User clicks on Account Tab
	And click edit account
	When user edits some records
	Then verify if it is saved
	And change the number of employees
	And click save and verify if the mistake is correct
	And close the driver
	
	Scenario Outline: Create 3 different accounts
	Given User clicks on Account Tab 
	And click New Account
	When Create a New Account with <name>, <phone>, <fax>, <account>, <Website>, <Site>
	Then Click Save and New
	And close the driver
	
	Examples: 
	 | name   | phone  |fax  | account     | Website     | Site   |
	 | Maurito| 2345982|23004|mconti@mconti|mauritus.com |Mauritus|
	 | Jose   | 289567 |10001| joseph@jp   |josephnye.com| Joseeph|
	 | Diana  | 4357890|23056|queenD@la    |dianaM.com   |Diana   |
	
	
	
	
	
	