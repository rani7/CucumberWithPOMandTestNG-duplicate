package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.Testbase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class FreeCRMLoginStepDefinition extends Testbase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Given("^user opens browser$")
	public void user_opens_browser()  {
		Testbase.initialization();
	    
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page()  {
		loginpage= new LoginPage();
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	    
	}

	@Then("^user logs into the app$")
	public void user_enters_the_username_and_password() throws InterruptedException  {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    
	}

	@Then("^validate home page title$")
	public void validate_home_page_title()  {
		
		String homepagetitle=homepage.validateHomePageTitle();
		Assert.assertEquals("CRMPRO", homepagetitle);
	    
	}

	@Then("^validate logged in username$")
	public void validate_logged_in_username()  {
		boolean flag=homepage.validateUserNameLabel();
		Assert.assertTrue(flag);
	   
	}	

}
