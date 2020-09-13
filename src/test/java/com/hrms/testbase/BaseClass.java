package com.hrms.testbase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import com.hrms.Utils.ConfigReading;
import com.hrms.Utils.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public void setUp() {
		
		ConfigReading.readProperties(Constant.CODING_FILEPATH);
		
		switch (ConfigReading.getPropValue("browser").toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "safari":
			System.setProperty("webdriver.safari.driver", Constant.SAFARI_FILEPATH);
			driver = new SafariDriver();
			break;
			
		default:
			throw new RuntimeException("Browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT_TIME,  TimeUnit.SECONDS);
		driver.get(ConfigReading.getPropValue("applicationUrl"));
		PageInitializer.initializePageObject();
			
	}
	
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
