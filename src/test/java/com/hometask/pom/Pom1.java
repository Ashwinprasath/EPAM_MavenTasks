package com.hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hometask.baseclass.BaseClass;

public class Pom1 extends BaseClass{

	public Pom1() {
		PageFactory.initElements(driver, this);
	}
	
	// a. create customer,edit customer
	
	@FindBy(xpath= "//input[@name='uid']")
	private WebElement userId;
	
	@FindBy(xpath= "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath= "//input[@name='btnLogin']")
	private WebElement loginBtn;
	
	

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
}
