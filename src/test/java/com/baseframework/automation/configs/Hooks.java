package com.baseframework.automation.configs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.baseframework.automation.utils.ConfigReader;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.cucumber.java.Scenario;

public class Hooks {
	
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	private ConfigReader configReader;
	Properties prop;
	
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	
	
	@BeforeMethod
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@BeforeMethod
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		
		driver = init_driver(browserName);
		
		
		
	}

	@AfterMethod
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@AfterMethod
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		
		String browserName = prop.getProperty("browser");
		
		String timeStamp;
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		String screenshotName = (timeStamp + scenario.getName().replaceAll(" ", "_"));

		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destinationDir = new File("./target/cucumber-reports/extent-report/");
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
		Reporter.setSystemInfo("Browser", browserName);
	}
	

}
