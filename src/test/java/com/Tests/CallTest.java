package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.CallElements;
import com.Utilities.ExcelDataConfig;

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

	@Test(dataProvider = "AddCall", priority = 1, enabled = true)
	public void newCalladding(String callsch, String callschdt, String remmin, String remtype, String remnotes) {

		login.Login();
		Mousehover(callele.casemenu());
		Click(callele.newCasemenu());
		Checkboxes(callele.callSchedulechk(), callsch);
		DateEnter(driver, callele.callScheduleDt(), callschdt);
		Dropbyvisibletext(callele.reminder(), remmin);
		Dropbyvisibletext(callele.reminderType(), remtype);
		enterText(callele.reminderNote(), remnotes);
		Click(callele.saveBtn());
	}

	@DataProvider(name = "AddCall")
	public Object[][] createCall() {
		String xlPath = this.getClass().getClassLoader().getResource("NewCallTest.xlsx").getPath();
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);

		Object[][] data = new Object[rows][5];
		for (int i = 0; i < rows; i++) {
			data[i][0] = excl.getData(0, i + 1, 0);
			data[i][1] = excl.getData(0, i + 1, 1);
			data[i][2] = excl.getData(0, i + 1, 2);
			data[i][3] = excl.getData(0, i + 1, 3);
			data[i][4] = excl.getData(0, i + 1, 4);

		}
		return data;
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}