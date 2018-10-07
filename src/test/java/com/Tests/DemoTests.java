package com.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.LoginPageElements;
import com.Utilities.ExcelDataConfig2;
import com.Utilities.PropertiesFile;

public class DemoTests extends Basepage {

	LoginPageElements Logele = new LoginPageElements();
	PropertiesFile lp = new PropertiesFile();

	@BeforeMethod
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = ExcelDataConfig2.getDataFromSheet("Login");
		return data;

	}

	@Test(dataProvider = "getData")
	public void LoginTest(String Username, String Password) throws IOException {
		enterText(Logele.UsrId(), Username);
		enterText(Logele.Pwd(), Password);
		Click(Logele.LgnBtn());
		Wait(3000);

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
