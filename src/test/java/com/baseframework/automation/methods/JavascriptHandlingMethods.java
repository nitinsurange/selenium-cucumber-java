package com.baseframework.automation.methods;

import org.openqa.selenium.WebDriver;

import com.baseframework.automation.utils.DriverUtil;

public class JavascriptHandlingMethods implements BaseTest {
	protected WebDriver driver = DriverUtil.getDefaultDriver();
	/**Method to handle alert
	 * @param decision : String : Accept or dismiss alert
	 */
	public void handleAlert(String decision)
	{
		if(decision.equals("accept"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}
}
