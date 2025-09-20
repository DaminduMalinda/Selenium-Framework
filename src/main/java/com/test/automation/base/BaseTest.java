package com.test.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.test.automation.utils.ConfigReader;
import com.test.automation.utils.DriverFactory;

public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
    	//
    	String browser = ConfigReader.getProperty("browser");
    	DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //
        
        
    }
    
    @AfterMethod
    public void tearDown() {
    	if (driver != null) {
    		driver.quit();
    	}
    }
}
