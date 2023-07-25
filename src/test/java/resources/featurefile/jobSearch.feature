Feature: Job Search Test
  As a user I want to verify job search result using different data set

  @smoke, @regression
  Scenario Outline: Verify job search result using different data set
    Given I am on homepage
    When I click on accept cookies
    And I enter the job title "<job title>"
    And I enter location "<location>"
    And I select distance "<distance>"
    And I click on more search options link
    And  I enter minimum salary "<salary min>"
    And  I enter maximum salary "<salary max>"
    And I select salary type "<salary type>"
    And I select job type "<job type>"
    And I click on find jobs button
    Then I verify the result "<result>"
    Examples:
      | job title       | location                | distance | salary min | salary max | salary type | job type  | result                                    |
      | Tester          | Harrow, Greater London  | 5 miles  | 30000      | 500000     | Per annum   | Permanent | Permanent Tester jobs in Harrow           |
      | Developer       | Manchester              | 7 miles  | 40000      | 80000      | Per annum   | Contract  | Contract Developer jobs in Manchester     |
      | QA              | London                  | 2 miles  | 3000       | 5000       | Per month   | Permanent | Permanent Qa jobs in London               |
      | Software Tester | Edgware, Greater London | 7 miles  | 400        | 1000       | Per day     | Permanent | Permanent Software Tester jobs in Edgware |
      | Developer       | London                  | 5 miles  | 60000      | 100000     | Per annum   | Temporary | Temporary Developer jobs in London        |
      | software tester | Hendon, Greater London  | 5 miles  | 40000      | 60000      | Per annum   | Permanent | Permanent Software Tester jobs in Hendon  |
