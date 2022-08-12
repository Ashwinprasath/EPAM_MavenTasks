package com.hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hometask.baseclass.BaseClass;

public class Account_Creation_Page extends BaseClass{

	public Account_Creation_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@id='uniform-id_gender1']")
	private WebElement title;
	
	@FindBy(xpath= "//input[@id='customer_firstname']")
	private WebElement firstName;

	@FindBy(xpath= "//input[@id='customer_lastname']")
	private WebElement lastName;
	
	@FindBy(xpath= "//input[@id='passwd']")
	private WebElement password;

	@FindBy(xpath= "//select[@id='days']")
	private WebElement days;
	
//	@FindBy(xpath= "//input[@id='email_create']")
//	private WebElement selectDay;
	
	@FindBy(xpath= "//select[@id='months']")
	private WebElement month;
	
//	@FindBy(xpath= "//input[@id='email_create']")
//	private WebElement selectMonth;
	
	@FindBy(xpath= "//select[@id='years']")
	private WebElement year;
	
//	@FindBy(xpath= "//input[@id='email_create']")
//	private WebElement selectYear;
	
	@FindBy(xpath= "//input[@id='company']")
	private WebElement company;

	@FindBy(xpath= "//input[@id='address1']")
	private WebElement address;
	
	@FindBy(xpath= "//input[@id='address2']")
	private WebElement addresslin2;

	@FindBy(xpath= "//input[@id='city']")
	private WebElement city;

	@FindBy(xpath= "//select[@id='id_state']")
	private WebElement state;
	
	@FindBy(xpath= "//input[@id='postcode']")
	private WebElement zipCode;
	
	@FindBy(xpath= "//input[@id='phone_mobile']")
	private WebElement mobNo;
	
	@FindBy(xpath= "//span[text()='Register']")
	private WebElement registerBtn;

	public WebElement getTitle() {
		return title;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getDays() {
		return days;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getAddresslin2() {
		return addresslin2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getMobNo() {
		return mobNo;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	
}
