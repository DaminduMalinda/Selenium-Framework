package com.test.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.base.BaseTest;
import com.test.automation.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(3000); 
		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		
		System.out.println("Title of the page is :" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
}
