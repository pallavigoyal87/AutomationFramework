package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;


public class LoginTest extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("Username entered");
		lp.setPassword(password);
		log.info("Password entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("This test is passed");
		}
		else {
			
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			log.info("This test is failed");
		}
		
	}

}
