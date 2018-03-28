package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.CasesElements;
import com.Page.Elements.NewEventElements;
import com.Utilities.ExcelDataConfig;

public class CasesTest extends Basepage {

	CasesElements caseele = new CasesElements();
	LoginPageTest login = new LoginPageTest();

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

	@Test(dataProvider = "AddCases", priority = 1, enabled = true)
	public void NewEventAdd1(String type, String title, String priority, String status, String deadline, String state,
			String identifier, String contact, String owner, String keycompany, String tags, String description) {

		login.Login();
		Mousehover(caseele.caseMenu());
		Click(caseele.caseSubMenu());
		Dropbyvisibletext(caseele.type(), type);
		enterText(caseele.title(), title);
		Dropbyvisibletext(caseele.priority(), priority);
		Dropbyvisibletext(caseele.status(), status);
		DateEnter(driver, caseele.deadLine(), deadline);
		Radiobuttons(caseele.state(), state);

		Click(nee.savebtn());

	}

	@DataProvider(name = "NewEventAdd1")
	public Object[][] passData() {
		String xlPath = this.getClass().getClassLoader().getResource("NewEventTest.xlsx").getPath();
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);

		Object[][] data = new Object[rows][22];
		for (int i = 0; i < rows; i++) {
			data[i][0] = excl.getData(0, i + 1, 0);
			data[i][1] = excl.getData(0, i + 1, 1);
			data[i][2] = excl.getData(0, i + 1, 2);
			data[i][3] = excl.getData(0, i + 1, 3);
			data[i][4] = excl.getData(0, i + 1, 4);
			data[i][5] = excl.getData(0, i + 1, 5);
			data[i][6] = excl.getData(0, i + 1, 6);
			data[i][7] = excl.getData(0, i + 1, 7);
			data[i][8] = excl.getData(0, i + 1, 8);
			data[i][9] = excl.getData(0, i + 1, 9);
			data[i][10] = excl.getData(0, i + 1, 10);
			data[i][11] = excl.getData(0, i + 1, 11);
			data[i][12] = excl.getData(0, i + 1, 12);
			data[i][13] = excl.getData(0, i + 1, 13);
			data[i][14] = excl.getData(0, i + 1, 14);
			data[i][15] = excl.getData(0, i + 1, 15);
			data[i][16] = excl.getData(0, i + 1, 16);
			data[i][17] = excl.getData(0, i + 1, 17);
			data[i][18] = excl.getData(0, i + 1, 18);
			data[i][19] = excl.getData(0, i + 1, 19);
			data[i][20] = excl.getData(0, i + 1, 20);
			data[i][21] = excl.getData(0, i + 1, 21);
		}
		return data;

	}