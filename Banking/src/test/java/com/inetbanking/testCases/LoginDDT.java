package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class LoginDDT extends BaseClass {       //Data Driven Test
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		log.info("Username provided");
		lp.setPassword(pwd);
		log.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			
			driver.switchTo().alert().accept(); //close alert
			captureScreen(driver, "loginDDT");
			driver.switchTo().defaultContent(); // Focus on current browser - LoginPage
			Assert.assertTrue(false); // If alert present then invalid login details
			log.warn("Login Failed");
		}
		else {
			
			Assert.assertTrue(true);
			log.info("Login Passed");
			Thread.sleep(3000);
			lp.clickLogout();
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	//user define method created to check whether alert is present or not
	public boolean isAlertPresent() {   
		
		try {
			
			driver.switchTo().alert();   
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException {
		
		String path = "C:\\Users\\vishal\\eclipse-workspace\\Banking\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++) {   // i=1 because we are not using row =0 as it is a header row
			
			for(int j=0; j<colcount; j++) {
				
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);  
//the above statement i-1 is because we are avoiding header row, we will have to make row=0 as in the for loop we are starting with row=1
			}
		}
		
		return logindata;
		
	}

}
