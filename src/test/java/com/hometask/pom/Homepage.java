package com.hometask.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hometask.baseclass.BaseClass;

public class Homepage extends BaseClass{

	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[@class='login']")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}
}
