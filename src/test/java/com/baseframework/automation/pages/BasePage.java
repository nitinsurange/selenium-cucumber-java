package com.baseframework.automation.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseframework.automation.configs.Hooks;
import com.cucumber.listener.Reporter;




public class BasePage {

	Hooks hooks = new Hooks();
	@SuppressWarnings("static-access")
	WebDriver driver = hooks.getDriver();
	WebElement ele;

	public void inputText(String inputText, WebElement webElement) {
		//webElement.clear();
		webElement.sendKeys(inputText);
	}

	public void clickButton(WebElement webElement) {
		waitForVisibilityOf(webElement);
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	   
	    if(!browserName.equalsIgnoreCase("chrome")) {
	    	 System.out.println("Browser Name:::"+browserName);
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	webElement.click();
	    }else {
	    	webElement.click();
	    }
		
	}
	
	
	public String getText(WebElement webElement) {
		return webElement.getText();
	}

	protected void waitForVisibilityOf(WebElement webElement) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	protected void waitForEleClickable(WebElement webElement) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	protected void waitForVisibilityOfShort(WebElement webElement) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	protected void waitForVisibility(WebElement webElement) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.textToBePresentInElement(webElement, webElement.getText()));
	}

	public void getScreenShot() throws IOException {

		String timeStamp;
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		// String screenshotName = (timeStamp + scenario.getName().replaceAll(" ",
		// "_"));

		String screenshotName = timeStamp + "testScreenshot";

		@SuppressWarnings("static-access")
		File sourcePath = ((TakesScreenshot) hooks.getDriver()).getScreenshotAs(OutputType.FILE);

		File destinationDir = new File("./target/cucumber-reports/extent-report");
		if (!destinationDir.exists()) {
			destinationDir.mkdir();
		}
		File destinationPath = new File(destinationDir + "/" + screenshotName + ".png");

		try {
			FileUtils.copyFile(sourcePath, new File(destinationPath + "/"));
			Reporter.addScreenCaptureFromPath(screenshotName + ".png");
		} catch (IOException e) {
		}

	}
	


}
