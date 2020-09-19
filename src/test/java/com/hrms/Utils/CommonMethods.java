package com.hrms.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.hrms.testbase.PageInitializer;

import io.cucumber.core.options.Constants;

public class CommonMethods extends PageInitializer{
	
	/**
	 * Method that sends text to any given element
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * Method return object of JavaScript Executor type
	 * @return js object
	 */
	public static JavascriptExecutor getJsExecutor() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js;
	}
	
	/**
	 * Method performs click using JavaScript executor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJsExecutor().executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Method used to scroll upusing JavaScript Executor
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJsExecutor().executeScript("window.scrollBy(0, -"+pixel+")");
	}
	
	/**]
	 * Method used to scroll down using JavaScript Executor
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJsExecutor().executeScript("window.scrollBy(0, "+pixel+")");
	}
	
	/**
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constant.EXPLICIT_WAIT_TIME);
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void waitForClickAbility(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickAbility(element);
		element.click();
	}
	
	/**
	 * Method that will take a screenshot and store with name in specified location with .png extension
	 * @param fileName
	 */
	public static byte[] takeScreenShot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(Constant.SCREENSHOT_FILEPATH + fileName +getTimeStamp()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bytes;
		
	}
	
	/**
	 * This method will generate timeStamp
	 * @return
	 */
	public static String getTimeStamp() {
		
		Date date=new Date();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		
		return sdf.format(date);
	}
	
	/**
	 * this method will click on checbox or radio button by the given list of Webelements and the value	 
	 * @param radioOrCheckBoxes
	 * @param value
	 */
	public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value) {
		String actualValue;
		for (WebElement radioOrCheckBox: radioOrCheckBoxes) {
			actualValue = radioOrCheckBox.getAttribute("value").trim();
			if(radioOrCheckBox.isEnabled() && actualValue.equals(value)){
				jsClick(radioOrCheckBox);
				break;
			}
			
		}
	}
	/**
	 * this method will select an option from the dropdown by the given webelement and visible text value 
	 * @param dd
	 * @param visibleTextOrValue
	 */
	public static void selectDDValue(WebElement dd, String visibleTextOrValue) {
		Select select = new Select(dd);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			if(option.getText().equals(visibleTextOrValue)) {
				select.selectByVisibleText(visibleTextOrValue);
			}
		}
	}
	
	/**
	 * this method will select an option from the dropdown by the given webelement and index
	 * @param dd
	 * @param index
	 */
	public static void selectDDValue(WebElement dd, int index) {
		Select select = new Select(dd);
		List<WebElement> options = select.getOptions();
		
		int size = options.size();
		if(size > index) {
			select.selectByIndex(index);
		}
	}
	
	

}
