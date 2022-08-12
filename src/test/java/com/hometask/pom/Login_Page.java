package com.hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hometask.baseclass.BaseClass;

public class Login_Page extends BaseClass {

	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@id='email_create']")
	private WebElement emailAddress;
	
	@FindBy(xpath= "//i[@class='icon-user left']")
	private WebElement createAnAccount;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement logInMail;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;
	
	@FindBy(xpath = "//i[@class='icon-lock left']")
	private WebElement signInBtn;

	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement signOutBtn;
	
	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getCreateAnAccount() {
		return createAnAccount;
	}

	public WebElement getLogInMail() {
		return logInMail;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
}
