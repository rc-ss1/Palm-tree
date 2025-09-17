Feature: Login Page Validation

@Login
Scenario Outline: Customer Account Login
When I login with the website
Then I should see dashboard
When I enter "<username>" on Login screen

Examples:
| username    |
| a@gmail.com |
| b@gmail.com |
| c@gmail.com |