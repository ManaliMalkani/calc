Feature: Calculator Operations
  In order to use a calculator for basic arithmetic operations
  As a user
  I want to ensure the calculator correctly performs various mathematical operations

  @arithmetic_operations
  Scenario Outline: Perform arithmetic operations
    Given the calculator app is open
    When I input <first_number> "<operation>" <second_number>
    And I press "="
    Then the result should be "<expected_result>"

    Examples:
      | first_number | operation | second_number | expected_result |
      | 5            | +         | 3             | 8               |
      | 8            | -         | 4             | 4               |
      | 6            | *         | 7             | 42              |
      | 8            | /         | 2             | 4               |
      | 3            | -         | 1             | 2               |
      | 5            | +         | 7             | 12              |
      | 9            | *         | 3             | 27              |
      | 2            | /         | 2             | 1               |


  @division_by_zero
  Scenario Outline: Division by Zero
    Given the calculator app is open
    When I input <first_number> / <second_number>
    And I press "="
    Then the result should be an error message "Can't divide by 0"

    Examples:
      | first_number | second_number |
      | 8            | 0             |
      | 6            | 0             |