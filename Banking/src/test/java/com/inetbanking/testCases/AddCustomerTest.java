package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class AddCustomerTest extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("Username is provided");
		lp.setPassword(password);
		log.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		log.info("Adding New Customer Details !!!");
		
		addcust.custName("Pooja");
		addcust.custgender("female");
		addcust.custdob("08", "20", "1983");
		Thread.sleep(3000);
		addcust.custaddress("Ind");
		addcust.custcity("Bom");
		addcust.custstate("Mah");
		addcust.custpinno(400022);
		addcust.custtelephoneno("9820060080");
		
		String email = randomstring()+"@yahoo.com";
		addcust.custemailid(email);
		addcust.custpassword("qwerty");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		log.info("Test Case Validation !!!");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			
			Assert.assertTrue(true);
			log.info("Test Case Passed");
		}
		else {
			
			log.info("Test Case Failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	
	

}
