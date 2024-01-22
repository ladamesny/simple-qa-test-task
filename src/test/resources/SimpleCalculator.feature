Feature: Simple calculator
  Scenario Outline: Adding two numbers
    Given the numbers <number1> and <number2>
    When I add them
    Then I should get <expected>

    Examples:
      | number1 | number2 | expected |
      | 5       | 3       | 8        |
      | -5      | -3      | -8       |
      | 5       | 0       | 5        |
      | 0       | -3      | -3       |
      | 5       | -3      | 2        |

  Scenario Outline: Multiplying two numbers
    Given the numbers <number1> and <number2>
    When I multiply them
    Then I should get <expected>

    Examples:
      | number1 | number2 | expected |
      | 5.0     | 3.0     | 15.0     |
      | -5.0    | -3.0    | 15.0     |
      | 5.0     | 0.0     | 0.0      |
      | 0.0     | -3.0    | 0.0      |
      | 5.0     | -3.0    | -15.0    |

  Scenario Outline: Sum of all even numbers in an array
    Given an array of numbers
      """
      <numbers>
      """
    When I calculate the sum of even numbers
    Then I should get an int result of <sum>

    Examples:
      | numbers         | sum |
      | 1,2,3,4,5       | 6   |
      | 2,4,6,8,10      | 30  |
      | -1,-2,-3,-4,-5  | -6  |
      | -2,-4,-6,-8,-10 | -30 |