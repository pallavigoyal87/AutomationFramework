package com.inetbanking.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class LoginPage {
	
	WebDriver ldriver;     //ldriver = local driver
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;      // rdriver = remote driver
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	public void setUserName(String uname) {
		
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		
		btnLogin.click();
	}
}
