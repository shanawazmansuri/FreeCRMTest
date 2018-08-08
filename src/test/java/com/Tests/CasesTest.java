package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.CasesElements;
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
	public void NewCasesAdding(String type, String title, String priority, String status, String deadline, String state,
			String identifier, String contact, String owner, String keycompany, String tags, String description) {

		login.Login();
		Wait(2000);
		Mousehover(caseele.caseMenu());
		Click(caseele.caseSubMenu());
		Dropbyvisibletext(caseele.type(), type);
		enterText(caseele.title(), title);
		Dropbyvisibletext(caseele.priority(), priority);
		Dropbyvisibletext(caseele.status(), status);
		DateEnter(driver, caseele.deadLine(), deadline);
		Radiobuttons(caseele.state(), state, "name");
		enterText(caseele.identifier(), identifier);
		enterText(caseele.contact(), contact);
		Dropbyvisibletext(caseele.ownerUid(), owner);
		enterText(caseele.keyCompany(), keycompany);
		enterText(caseele.tags(), tags);
		enterText(caseele.description(), description);
		Wait(2000);
		Click(caseele.saveBtn());
		Wait(2000);

	}

	@DataProvider(name = "AddCases")
	public Object[][] passData() {
		String xlPath = this.getClass().getClassLoader().getResource("NewCases.xlsx").getPath();
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);

		Object[][] data = new Object[rows][12];
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
		}
		return data;

	}

}