package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.LoginPageElements;
import com.Utilities.PropertiesFile;

public class LoginTest2 extends Basepage {
	LoginPageElements Logele;
	PropertiesFile Pro;

	@BeforeMethod
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@Test
	public void Login() {
		Logele = new LoginPageElements(driver);
		Pro = new PropertiesFile();
		enterText(Logele.UsrId(), Pro.prop.getProperty("usrname"));
		enterText(Logele.Pwd(), Pro.prop.getProperty("pwd"));
		Wait(2000);
		Click(Logele.LgnBtn());
		Wait(3000);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}