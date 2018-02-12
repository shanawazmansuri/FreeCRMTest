package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.NewEventElements;
import com.Utilities.ExcelDataConfig;

public class NewEventTest extends Basepage {

	NewEventElements nee = new NewEventElements();
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

	@Test(dataProvider = "NewEventAdd1", priority = 1, enabled = true)
	public void NewEventAdd1(String title, String frmDt, String toDt, String categ, String assTo, String cnf,
			String emailAlt, String emailCnt, String remMin, String remType, String remnote, String intRem,
			String ownerusr, String contact, String company, String deal, String task, String cases, String tags,
			String location, String notes, String minutes) {

		login.Login();
		Mousehover(nee.CalendarMenu());
		Click(nee.NewEventSubmenu());
		enterText(nee.title(), title);
		DateEnter(driver, nee.fromdate(), frmDt);
		DateEnter(driver, nee.todate(), toDt);
		Dropbyvisibletext(nee.category(), categ);
		MultiSelect(nee.assignuseridfrom(), assTo);
		Click(nee.assignuseridfrom());
		Click(nee.addbtn());
		Radiobuttons(nee.confirmedchkbx(), cnf);
		Checkboxes(nee.emailalert(), emailAlt);
		Checkboxes(nee.emailaltcontact(), emailCnt);
		Dropbyvisibletext(nee.reminderminutes(), remMin);
		Wait(2000);
		Dropbyvisibletext(nee.remindertype(), remType);
		enterText(nee.remindernote(), remnote);
		Checkboxes(nee.internalreminder(), intRem);
		Dropbyvisibletext(nee.owneruserid(), ownerusr);
		enterText(nee.contact(), contact);
		enterText(nee.company(), company);
		enterText(nee.deal(), deal);
		enterText(nee.task(), task);
		enterText(nee.cases(), cases);
		enterText(nee.tags(), tags);
		enterText(nee.location(), location);
		enterText(nee.notes(), notes);
		enterText(nee.minutes(), minutes);
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

	// @Test(enabled = false)
	// public void date() {
	// login.Login();
	// Mousehover(nee.CalendarMenu());
	// Click(nee.NewEventSubmenu());
	// DateEnter(driver, nee.fromdate(), "21-Feb-2018 23:47");
	// DateEnter(driver, nee.todate(), "22-Feb-2018 23:47");
	// Wait(5000);
	//
	// }

}
