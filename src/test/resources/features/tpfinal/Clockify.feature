@TPFinal
Feature: As a potential client i want to interact with the mobile application

  Background:
    Given The app is loaded correctly

  @Login @Success @Smoke
  Scenario Outline: (1) The user log in to the app successfully
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed
    Examples:
      | email                  | password   |
      | mofola6180@cadolls.com | Example321 |

  @AddTimeEntry @Success @Smoke
  Scenario Outline: (2) The user add new time successfully
    And The user logs in the application with: mofola6180@cadolls.com, Example321
    And Home page is displayed
    When The user taps on the 'Add time entry' button
    And The user chooses <hours> hours and <minutes> minutes
    And The user inputs the title '<title>' in 'What are you working on' field
    And The user selects the project field and picks the project '<project>'
    And The user saves the time entry
    Then The time entry with <hours> hours, <minutes> minutes, project '<project>' and title '<title>, plus a timestamp' is created and displayed on Home page
    Examples:
      | hours | minutes | title           | project |
      | 3     | 5       | Time entry Test | Tests   |

  @AddTimeEntryWithDates @Smoke
  Scenario Outline: (3) The user add new time with date successfully and date must be less or equals to the current date
    And The user logs in the application with: mofola6180@cadolls.com, Example321
    And Home page is displayed
    And The user taps on the 'Add time entry' button
    And The user chooses <hours> hours and <minutes> minutes
    And The user inputs the title '<title>' in 'What are you working on' field
    And The user selects the project field and picks the project '<project>'
    When The user selects the start date '<start>' in date picker
    And The user saves the time entry
    Then The time entry with <hours> hours <minutes> minutes duration, start date '<start>', and title '<title>, plus a timestamp' is displayed at Home page and the start date is less or equals to the current date
    @Success
    Examples:
      | start      | hours | minutes | title           | project |
      | 2021-12-15 | 2     | 4       | Time entry Test | Tests   |
    @Failed
    Examples:
      | start      | hours | minutes | title           | project |
      | 2023-08-15 | 5     | 3       | Time entry Test | Tests   |

  @CancelAddTimeEntry @Success @Smoke
  Scenario Outline: (4) The user starts adding a new time entry and aborts the process, resulting in no entries being added
    And The user logs in the application with: mofola6180@cadolls.com, Example321
    And Home page is displayed
    And The user taps on the 'Add time entry' button
    And The user chooses <hours> hours and <minutes> minutes
    And The user inputs the title '<title>' in 'What are you working on' field
    And The user selects the project field and picks the project '<project>'
    When The user discards the addition of the new time entry
    Then The time entry is not saved and doesn't appear in the entries list
    Examples:
      | hours | minutes | title           | project |
      | 2     | 6       | Time entry Test | Tests   |

  @EnableDarkMode @Success @Smoke
  Scenario: (5) The user changes the dark mode status in settings
    And The user logs in the application with: mofola6180@cadolls.com, Example321
    And Home page is displayed
    When The user enters in settings and checks the current dark mode status
    And The user taps on the 'Enable dark mode' toggle
    Then The dark mode status is now the opposite of the initial one

  @Logout @Success @Smoke @Now
  Scenario: (6) The user log in then logs out
    And The user logs in the application with: mofola6180@cadolls.com, Example321
    And Home page is displayed
    When The user logs out
    Then Login page is displayed
