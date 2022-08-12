package com.hometask.bdd.stepdefinition;

import static org.testng.Assert.assertEquals;

import com.hometask.baseclass.BaseClass;
import com.hometask.pom.Account_Creation_Page;
import com.hometask.pom.Homepage;
import com.hometask.pom.Login_Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_Task2 extends BaseClass{

	Homepage h;
	Login_Page l;
	Account_Creation_Page a;
	
	@Given("Open the Webpage")
	public void open_the_webpage() {
	    openBrowser();
	    getUrl("http://automationpractice.com/");
	    implicitWait(30);
	}

	@Given("Click on Signin button")
	public void click_on_Signin_button() {
		h= new Homepage();
	    click(h.getSignIn());
	}

	@When("I enter email as {string}")
	public void i_enter_email_as(String string) {
		l= new Login_Page();
		implicitWait(20);
	    enterText(l.getEmailAddress(), "ashwinr@gmail.com");
	}

	@When("I click on Create an account button")
	public void i_click_on_Create_an_account_button() {
	    click(l.getCreateAnAccount());
	    implicitWait(20);
	}

	@Then("Automation Exercise Signup page should be displayed")
	public void Automation_Exercise_Signup_page_should_be_displayed() {
	    
	}

	@When("I click on MR")
	public void i_click_on_mr() {
		a = new Account_Creation_Page();
	   click(a.getTitle());
	   
	}

	@And("I enter First Name as {string}")
	public void i_enter_first_name_as(String string) {
	   enterText(a.getFirstName(), "Ashwin");
	}

	@And("I enter Last Name as {string}")
	public void i_enter_last_name_as(String string) {
		enterText(a.getLastName(), "M");
	}

	@And("I enter password as {string}")
	public void i_enter_password_as(String string) {
	    enterText(a.getPassword(), "12345");
	}

	@And("I select date as {string}")
	public void i_select_date_as(String string) {
	    click(a.getDays());
		selectByValue(a.getDays(), "29  ");
	}

	@And("I select month as {string}")
	public void i_select_month_as(String string) {
		click(a.getMonth());
	   selectByText(a.getMonth(), "March ");
	}

	@And("I select year as {string}")
	public void i_select_year_as(String string) {
		click(a.getYear());
	    selectByText(a.getYear(), "1996  ");
	}

	@And("I enter company as {string}")
	public void i_enter_company_as(String string) {
	    enterText(a.getCompany(), "EPAM");
	}

	@And("I enter Address as {string}")
	public void i_enter_address_as(String string) {
	    enterText(a.getAddress(), "No 4");
	}

	@And("I enter Address2 as {string}")
	public void i_enter_address2_as(String string) {
		 enterText(a.getAddresslin2(), "Asdf");
	}

	@And("I select State as {string}")
	public void i_select_state_as(String string) {
	    selectByText(a.getState(), "Utah");
	}

	@And("I enter city as {string}")
	public void i_enter_city_as(String string) {
	    enterText(a.getCity(), "Vandavasi");
	}

	@When("I enter zipcode as {string}")
	public void i_enter_zipcode_as(String string) {
		enterText(a.getZipCode(), "84095");
	}

	@And("I enter mobile number as {string}")
	public void i_enter_mobile_number_as(String string) {
	   enterText(a.getMobNo(), "9283746321");
	}
	
	@And("I click on Register button")
	public void i_click_on_register_button() {
	   click(a.getRegisterBtn());
	}

	@Then("Verify the page Automation Exercise Account Created")
	public void verify_the_page_automation_exercise_account_created() {
	    assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
	    System.out.println("Account created page verified");
	}
	
	
	@When("I enter login email as {string}")
	public void i_enter_login_email_as(String string) {
		l= new Login_Page();
	    enterText(l.getLogInMail(), "ashwinrockz@gmail.com");
	}
	@When("I enter login Passowrd as {string}")
	public void i_enter_login_passowrd_as(String string) {
	    enterText(l.getPassword(), "12345");
	}
	@When("I click on Login button")
	public void i_click_on_login_button() {
	    click(l.getSignInBtn());
	    implicitWait(10);
	}
	@Then("Automation Exercise page should be displayed")
	public void automation_exercise_page_should_be_displayed() {
	    assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
	    System.out.println("Automation Exercise page is displayed");
	}
	@When("Click on Logout button")
	public void click_on_logout_button() {
	    click(l.getSignOutBtn());
	    implicitWait(10);
	}
	@Then("Automation Exercise Homepage page should be displayed")
	public void automation_exercise_homepage_page_should_be_displayed() {
	    assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    System.out.println("Return back to Automation Exercise Login page");
	}



	
	
}
