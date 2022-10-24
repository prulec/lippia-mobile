@Demo
Feature: As a potential client i want to interact with the mobile application

  Background:
    Given The app is loaded correctly

  @Register
  Scenario Outline: The user starts the application and registers a new user successfully
    When The user goes to the Sign Up page
    And The user registers a new user with: <username>, <email>, <password>
    Then Home page is displayed
    Examples:
      | username   | email                | password |
      | automation | automation@gmail.com | 123456   |

  @Logout
  Scenario Outline: The user starts the application, log in to the app, changes the language, and log out of the app successfully
    And The user logs in the application with: <email>, <password>
    When The user changes the language
    And The user log out of the app
    Then Login page is displayed
    Examples:
      | email                | password |
      | automation@gmail.com | 123456   |

  @Login
  Scenario Outline: The user starts the application and log in to the app successfully
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed
    Examples:
      | email                | password |
      | automation@gmail.com | 123456   |
