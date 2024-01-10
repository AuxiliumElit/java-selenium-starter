@Regression
Feature: Send message via Contact Us Form

  @DemoTest
  Scenario Outline: Positive Test of Submitting contact form

    Given Open Home Page
    When User navigate to Contact Us Page
    And Submit Contact Form with <name> and <phoneNumber>
    Then Form Submission alert message is displayed

    Examples:
      | name  	  | phoneNumber |
      | BddTest1 | 2674157777  |
      | BddTest2 | 2674158888  |
      | BddTest3 | 2674159999  |
