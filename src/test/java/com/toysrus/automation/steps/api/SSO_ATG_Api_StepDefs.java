package com.toysrus.automation.steps.api;

import java.io.FileNotFoundException;

import com.toysrus.automation.lib.RunTimeVariables;
import com.toysrus.automation.steps.common.AbstractPage_StepDefs;
import com.toysrus.automation.utils.ApiHelper;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class SSO_ATG_Api_StepDefs extends AbstractPage_StepDefs {

	ApiHelper apiHelper = new ApiHelper();

	@Then("^user should be linked$")
	public void user_should_be_linked() throws FileNotFoundException  {
		String body = apiHelper.updateJsonFileAndReturnStringForBody("src\\test\\resources\\JsonBody\\body.json",RunTimeVariables.emailId);
		String response = apiHelper.post("https://tru-sso-perf.digital-dev.toysrus.com/api/auth/login", body);
		System.out.println(response);
		if (response.contains("login_successful")) {
			System.out.println("Created user "+RunTimeVariables.emailId+" is linked in CLS");
		} else {
			System.out.println("Creater user is not linked in CLS");

		}
		
	}
}
