package com.hometask.bdd.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	@Given("I have a balance of $100 in my account")
	public void i_have_a_balance_of_$100_in_my_account() {
	    System.out.println("I have a balance of $100 in my account");
	}

	@When("I request $20")
	public void i_request_$() {
	   System.out.println("I request $20");
	    
	}

	@Then("$20 should be dispensed")
	public void $_should_be_dispensed() {
	    System.out.println("$20 should be dispensed");
	}

}
