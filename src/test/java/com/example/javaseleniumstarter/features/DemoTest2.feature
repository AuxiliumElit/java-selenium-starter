@Regression
Feature: Send message via Contact Us Form

  @DemoTest2
  Scenario Outline: Positive Test of Submitting contact form

    Given Open Home Page
    When User navigate to Contact Us Page
    And Submit Contact Form with <name> and <phoneNumber>
    Then Look for random element

    Examples:
      | name  	  | phoneNumber |
      | BddTest4 | 2674154444  |
      | BddTest5 | 2674155555  |
      | BddTest6 | 2674156666  |
