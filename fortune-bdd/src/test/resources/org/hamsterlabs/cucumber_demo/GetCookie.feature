Feature: Get a cookie from the cookie jar

  Scenario: Get a cookie
    When I get a cookie
    Then the http status is 200
    And I have a cookie