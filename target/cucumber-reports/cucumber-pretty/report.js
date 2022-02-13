$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PricingBotExchngingRates.feature");
formatter.feature({
  "line": 2,
  "name": "Pricing Bot Exchangin Rates Functionality",
  "description": "",
  "id": "pricing-bot-exchangin-rates-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@suite2"
    }
  ]
});
formatter.before({
  "duration": 658391,
  "status": "passed"
});
formatter.before({
  "duration": 8381056246,
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
  "name": "User launch url and navigates to login screen",
  "keyword": "Given "
});
formatter.match({
  "location": "MainSteps.user_launch_url_and_navigates_to_login_screen()"
});
formatter.result({
  "duration": 18019394885,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Verify From Country is asking by bot on entering Second Time Invalid From Country",
  "description": "",
  "id": "pricing-bot-exchangin-rates-functionality;verify-from-country-is-asking-by-bot-on-entering-second-time-invalid-from-country",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 32,
      "name": "@FirstTimeInvalidCountry"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "verify the Remitlys virtual assistant message",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "verify To Country by entering \"tell me exchange rates\"",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "enter country name \"germany\" which country are you sending from",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "enter First Time Invalid country name \"beni\" which country are you sending to",
  "keyword": "Then "
});
formatter.match({
  "location": "MainSteps.verify_the_Remitlys_virtual_assistant_message()"
});
