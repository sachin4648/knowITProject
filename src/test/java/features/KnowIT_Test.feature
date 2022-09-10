Feature: Knowit QSS candidate evaluation
  I want to use this template for my feature file

Background:
	Given User navigated to knowIT website
	
  @knowitSuite
  Scenario Outline: KnowIT search Testing
    Given User click on search button and print default value
    When User entered <searchString> and hit enter key
    Then Verify search result
		Examples:
		      | searchString 	|
					|  automation   |
	
	@knowitSuite
  Scenario Outline: KnowIT scroll Testing
  Given User scroll to botton page and clicks on facebook logo
  When User navigate to new window and close it
  Then User scroll to top into Parent Window