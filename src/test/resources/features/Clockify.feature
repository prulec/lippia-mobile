@TP8
Feature: As a potential client i want to interact with the mobile application

  Background:
    Given The app is loaded correctly

  @Login @Success
  Scenario Outline: The user log in to the app successfully
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed
    Examples:
      | email                  | password   |
      | mofola6180@cadolls.com | Example321 |

  @AddTimeEntry @Success
  Scenario Outline: The user add new time successfully
    And The user logs in the application with: <email>, <password>
    And Home page is displayed
    When The user select the 'Add time entry' button
    And The 'Add entry' page is displayed
    And The user puts <hours> hours and <minutes> minutes
    And The user inserts the title '<title>' in 'What are you working on' field
    And The user selects the project field and picks the project <project>
    And The user saves the time entry
    Then Home page is displayed
    And The time entry with <hours> hours, <minutes> minutes, title '<title>', and project '<project>' was created successfully
    Examples:
      | email                  | password   | hours | minutes | title           | project |
      | mofola6180@cadolls.com | Example321 | 3     | 5       | Time entry Test | Tests   |