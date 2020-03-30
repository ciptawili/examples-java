Feature: Test case id reporting

  Scenario: Test case id from code reference
    Given Test case id should be generated based on code reference

  Scenario Outline: Test case id from code reference and parameters
    Given Test case id should be generated based on code reference and <parameter>
    Examples:
      | parameter |
      | 1         |
      | 2         |

  Scenario: Test case id from annotation
    Given Test case id should be generated based on annotation value

  Scenario Outline: Test case id from annotation value(parametrized)
    Given Test case id should be generated based on annotated parameter <parameter>
    Examples:
      | parameter |
      | id001     |
      | id002     |
