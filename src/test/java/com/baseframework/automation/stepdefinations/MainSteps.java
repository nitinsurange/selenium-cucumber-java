package com.baseframework.automation.stepdefinations;

import com.baseframework.automation.configs.Hooks;
import com.baseframework.automation.pages.LoginPage;

import cucumber.api.java.en.Given;


public class MainSteps {

	private LoginPage loginPage = new LoginPage(Hooks.getDriver());
	
	@Given("^User launch url and navigates to login screen$")
	public void user_launch_url_and_navigates_to_login_screen() throws Throwable {
		loginPage.launchURL();
	}

	
	



}
