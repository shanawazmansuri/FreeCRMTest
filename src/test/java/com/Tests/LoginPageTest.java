package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.LoginPageElements;
import com.Utilities.ExcelDataConfig;
import com.Utilities.PropertiesFile;
import com.Utilities.ScreenShot;

@Listeners(com.Utilities.ExtentReporterNG.class)
public class LoginPageTest extends Basepage {
	LoginPageElements Logele = new LoginPageElements(driver);
	PropertiesFile lp = new PropertiesFile();

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

	@Test(priority = 1)
	public void Logoverify() {

		IsDisplayed(Logele.Logo());
		ScreenShot.CaptureScreenshot(driver);
	}

	@Test(dataProvider = "LoginTest", priority = 2)
	public void LoginTest(String Username, String Password) throws IOException {
		enterText(Logele.UsrId(), Username);
		enterText(Logele.Pwd(), Password);
		Click(Logele.LgnBtn());
		Wait(3000);

	}

	@DataProvider(name = "LoginTest")
	public Object[][] passData() {
		String xlPath = "D:\\Selenium\\Codes\\FreeCRM\\TestData\\LoginTest.xlsx";
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(1);

		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {

			data[i][0] = excl.getData(1, i + 1, 0);
			data[i][1] = excl.getData(1, i + 1, 1);

		}
		return data;

	}

	public void Login() {
		enterText(Logele.UsrId(), lp.prop.getProperty("usrname"));
		enterText(Logele.Pwd(), lp.prop.getProperty("pwd"));
		Click(Logele.LgnBtn());
	}

}