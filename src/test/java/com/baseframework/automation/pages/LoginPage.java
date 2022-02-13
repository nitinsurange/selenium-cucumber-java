package com.baseframework.automation.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseframework.automation.utils.ConfigReader;

import junit.framework.Assert;


public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[text()='What can I assist you with today?']")
	private WebElement assist_today_msg;
	
	@FindBy(id = "userNameInput")
	private WebElement user_name; 
	
	@FindBy(id = "passwordInput")
	private WebElement password; 
	
	@FindBy(id = "submitButton")
	private WebElement sign_in;
	
	

	public void launchURL() throws IOException, InterruptedException {
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
		String urlName = prop.getProperty("RegressionURL");
		System.out.println("url:::"+urlName);
		driver.get(urlName);
		System.out.println("launched:::"+urlName);
		
	}



	public void verifyAssistTodayMsg() throws InterruptedException {
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Assert.assertTrue(assist_today_msg.isDisplayed());
		System.out.println(assist_today_msg.getText()+" ::is Displayed");
	}
	
	
	

}
