package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.CallElements;

public class CallTest extends Basepage {

	LoginPageTest login = new LoginPageTest();
	CallElements callele = new CallElements();

	@BeforeMethod
	public void startUp() {
		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@Test(description = "Add with no values", priority = 1, enabled = false)
	public void addWithNovalues() {

		login.Login();
		Mousehover(callele.casemenu());
		Click(callele.newCasemenu());
		Click(callele.saveBtn());
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
