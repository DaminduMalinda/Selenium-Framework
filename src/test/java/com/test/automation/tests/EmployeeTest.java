package com.test.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.base.BaseTest;
import com.test.automation.pages.EmployeePage;
import com.test.automation.pages.LoginPage;
import com.test.automation.utils.ConfigReader;

public class EmployeeTest extends BaseTest{
	
	@Test
	public void addEmployeeTest() {
		
		LoginPage loginPage= new LoginPage(driver);
		
		String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
		
		EmployeePage empPage = new EmployeePage(driver);
		empPage.goToAddEmployee();
		empPage.addEmployee("Damith", "Kasun", "Perera");
		
		Assert.assertTrue(empPage.isEmployeeAdded(), "Empolyee not added successfully");
		
	}
	
	
	
	

}
