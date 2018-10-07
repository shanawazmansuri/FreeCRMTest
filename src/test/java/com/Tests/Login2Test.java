package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.LoginPageElements;
import com.Utilities.ExcelDataConfig3;
import com.Utilities.PropertiesFile;
import com.Utilities.ScreenShot;

@Listeners(com.Utilities.ExtentReporterNG.class)
public class Login2Test extends Basepage {
	LoginPageElements Logele = new LoginPageElements();
	PropertiesFile lp = new PropertiesFile();
	String sheetname = "contacts";
	// static String excelpath =
	// "D:\\Selenium\\Codes\\FreeCRM\\TestData\\LoginTest2.xlsx";

	public Login2Test() {
		super();

	}

	@BeforeMethod
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test(priority = 1, enabled = false)
	public void Logoverify() {

		IsDisplayed(Logele.Logo());
		ScreenShot.CaptureScreenshot(driver, "/ScreenShots/LoginPage/", "Login");
	}

	@Test(dataProvider = "LoginTest", priority = 2, enabled = true)
	public void LoginTest(String Username, String Password) throws IOException {
		enterText(Logele.UsrId(), Username);
		enterText(Logele.Pwd(), Password);
		Click(Logele.LgnBtn());
		Wait(3000);

	}

	@DataProvider
	public Object[][] LoginTest() {
		Object data[][] = ExcelDataConfig3.getTestData(sheetname);
		return data;
	}

	@Test(priority = 3, enabled = false)
	public void Login() {
		enterText(Logele.UsrId(), lp.prop.getProperty("usrname"));
		enterText(Logele.Pwd(), lp.prop.getProperty("pwd"));
		Click(Logele.LgnBtn());
		FramebyName("mainpanel");
		// AssertTrueContains("User: Shanawaz Mansuri", Logele.UserHeader());
	}

}