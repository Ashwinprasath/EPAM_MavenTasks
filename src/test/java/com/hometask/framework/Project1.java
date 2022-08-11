package com.hometask.framework;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.hometask.baseclass.BaseClass;
import com.hometask.pom.Pom1;
import com.hometask.pom.Pom2;

public class Project1 extends BaseClass {

	
	
	@BeforeClass
	public void browserLaunch() {
		openBrowser();
		getUrl("http://demo.guru99.com/V4/");
	}
	
	@Test(priority = 1)
	public void login() throws IOException {
		Pom1 p= new Pom1();
		enterText(p.getUserId(), getDataFromWorkbook(2, 0));
		enterText(p.getPassword(), getDataFromWorkbook(2, 1));
		click(p.getLoginBtn());
	}

	@Test(priority = 2)
	public void newCustomer() throws IOException {
		Pom2 p= new Pom2();
		
		//2. Add a new customer details
		click(p.getNewCustomer());
		implicitWait(5);
		enterText(p.getCustomerName(), getDataFromWorkbook(2, 2));
		click(p.getGender());
		enterText(p.getDob(), getDataFromWorkbook(2, 3));
		enterText(p.getAddress(), getDataFromWorkbook(2, 4));
		enterText(p.getCity(), getDataFromWorkbook(2, 5));
		enterText(p.getState(), getDataFromWorkbook(2, 6));
		enterText(p.getPinNo(), getDataFromWorkbook(2, 7));
		enterText(p.getTelephoneNo(), getDataFromWorkbook(2, 8));
		enterText(p.getEmailId(), getDataFromWorkbook(2, 9));
		enterText(p.getNewPassword(), getDataFromWorkbook(2, 10));
		click(p.getSubmitBtn());
	
		String customerId = p.getCustomerId().getText();
		System.out.println("Customer id: "+customerId);
		
	}
}
