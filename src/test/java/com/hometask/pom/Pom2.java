package com.hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hometask.baseclass.BaseClass;

public class Pom2 extends BaseClass {
	public Pom2() {
		PageFactory.initElements(driver, this);
	}

	// b.Create customer

	@FindBy(xpath= "//a[text()='New Customer']")
	private WebElement newCustomer;
	
	@FindBy(xpath= "//input[@name='name']")
	private WebElement customerName;
	
	@FindBy(xpath= "//input[@value='f']")
	private WebElement gender;
	
	@FindBy(id= "dob")
	private WebElement dob;
	
	@FindBy(name= "addr")
	private WebElement address;
	
	@FindBy(name= "city")
	private WebElement city;
	
	@FindBy(name= "state")
	private WebElement state;
	
	@FindBy(name= "pinno")
	private WebElement pinNo;
	
	@FindBy(name= "telephoneno")
	private WebElement telephoneNo;
	
	@FindBy(name= "emailid")
	private WebElement emailId;
	
	@FindBy(name= "password")
	private WebElement newPassword;
	
	@FindBy(name= "sub")
	private WebElement submitBtn;
	
	@FindBy(xpath= "//table[@id='customer']/tbody/tr[4]/td[2]")
	private WebElement customerId;
	
	@FindBy(xpath= "//a[text()='Edit Customer']")
	private WebElement editCustomer;
	
	@FindBy(name= "cusid")
	private WebElement cusId;
	
	@FindBy(name= "AccSubmit")
	private WebElement accSubmitBtn;
	
	@FindBy(name= "telephoneno")
	private WebElement newTelephoneNo;
	
	@FindBy(name= "sub")
	private WebElement subBtn;
	
	public WebElement getNewCustomer() {
		return newCustomer;
	}

	public WebElement getCustomerName() {
		return customerName;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPinNo() {
		return pinNo;
	}

	public WebElement getTelephoneNo() {
		return telephoneNo;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCustomerId() {
		return customerId;
	}

	public WebElement getEditCustomer() {
		return editCustomer;
	}

	public WebElement getCusId() {
		return cusId;
	}

	public WebElement getAccSubmitBtn() {
		return accSubmitBtn;
	}

	public WebElement getNewTelephoneNo() {
		return newTelephoneNo;
	}

	public WebElement getSubBtn() {
		return subBtn;
	}
}
