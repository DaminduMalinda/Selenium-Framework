package com.test.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By pimMenu = By.xpath("//span[text()='PIM']");
	private By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
	private By employeeFName = By.xpath("//input[@name='firstName']");
	private By employeeMName = By.xpath("//input[@name='middleName']");
	private By employeeLName = By.xpath("//input[@name='lastName']");
	private By saveButton = By.xpath("//button[@type='submit']");
	private By successMessage = By.xpath("//h6[text()='Personal Details']");
	
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void goToAddEmployee() {
		
		WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
        pim.click();
        WebElement addEmpBtn = wait.until(ExpectedConditions.elementToBeClickable(addEmployeeBtn));
        addEmpBtn.click();
		
		
	}
	
	public void addEmployee(String firstname, String middlename ,String lastname) {
		
		driver.findElement(employeeFName).clear();
		driver.findElement(employeeFName).sendKeys(firstname);
		
		driver.findElement(employeeMName).clear();
		driver.findElement(employeeMName).sendKeys(middlename);
		
		driver.findElement(employeeLName).clear();
		driver.findElement(employeeLName).sendKeys(lastname);
		
		driver.findElement(saveButton).click();
	}
	
	

	public boolean isEmployeeAdded() {
		return driver.findElement(successMessage).isDisplayed();
	}

	
	
	
	

}
