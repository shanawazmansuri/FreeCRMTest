package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.LoginPageElements;
import com.Utilities.PropertiesFile;

@Listeners(com.Utilities.ExtentReporterNG.class)
public class LoginTest2 extends Basepage {
	LoginPageElements Logele;
	PropertiesFile Pro;
	// Logger log = Logger.getLogger(LoginTest2.class);

	@BeforeMethod
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		// log.info("browser is launching");
		MaximizeBrowser();
		// log.fatal("Its Fatal Maximizing Browser");
		DeleteCookies();
		// log.warn("Warn its Deleting Cookies");
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@Test
	public void Login() {
		// log.info("***************Starting Test Case***********************");
		Logele = new LoginPageElements(driver);
		Pro = new PropertiesFile();
		enterText(Logele.UsrId(), Pro.prop.getProperty("usrname"));
		enterText(Logele.Pwd(), Pro.prop.getProperty("pwd"));
		Wait(2000);
		Click(Logele.LgnBtn());
		Wait(3000);
		// log.info("***************Ending Test Case***********************");
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}