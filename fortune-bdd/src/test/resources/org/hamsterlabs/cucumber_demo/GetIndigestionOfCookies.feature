Feature: Indigestion of Cookies
  As a fan of cookies
  when I get all the cookies
  I can get indigestion

  Scenario: Eat all the cookies
    When I get all the cookies
    Then the http status is 200
    And I receive 13953 cookies