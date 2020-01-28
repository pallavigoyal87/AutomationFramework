package com.inetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {
	
	public String baseURL = "http://demo.guru99.com/v4/";
	public String username = "mngr206306";
	public String password = "abcd@1234";
	public static WebDriver driver;
	public static Logger log;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal\\eclipse-workspace\\InetBanking\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
