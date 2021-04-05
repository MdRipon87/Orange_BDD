$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Login.feature");
formatter.feature({
  "line": 2,
  "name": "Varify on OrangHRM login Functionality",
  "description": "",
  "id": "varify-on-oranghrm-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "line": 7,
  "name": "User should be able to login with valid credentials",
  "description": "and open a new account",
  "id": "varify-on-oranghrm-login-functionality;user-should-be-able-to-login-with-valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "User enters the \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User should be able to see the dashboard",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "varify-on-oranghrm-login-functionality;user-should-be-able-to-login-with-valid-credentials;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 13,
      "id": "varify-on-oranghrm-login-functionality;user-should-be-able-to-login-with-valid-credentials;;1"
    },
    {
      "cells": [
        "admin",
        "admin123"
      ],
      "line": 14,
      "id": "varify-on-oranghrm-login-functionality;user-should-be-able-to-login-with-valid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4388185200,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User is on OrangHRM login page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.user_is_on_OrangHRM_login_page()"
});
formatter.result({
  "duration": 2857354100,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "User should be able to login with valid credentials",
  "description": "and open a new account",
  "id": "varify-on-oranghrm-login-functionality;user-should-be-able-to-login-with-valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User enters the \"admin\" and \"admin123\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User should be able to see the dashboard",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 17
    },
    {
      "val": "admin123",
      "offset": 29
    }
  ],
  "location": "StepsDefinition.user_enters_the_and(String,String)"
});
formatter.result({
  "duration": 293214300,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.user_clicks_on_login_button()"
});
formatter.result({
  "duration": 5052247100,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.user_should_be_able_to_see_the_dashboard()"
});
formatter.result({
  "duration": 8495300,
  "status": "passed"
});
formatter.after({
  "duration": 876878400,
  "status": "passed"
});
});