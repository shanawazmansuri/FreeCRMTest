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

	@Test
	public void ClickonNewEventMenu() {
		login.Login();
		FramebyName("mainpanel");
		Mousehover(nee.CalendarMenu());
		Click(nee.NewEventSubmenu());

	}

	@Test(dataProvider = "NewEventAdd1")
	public void NewEventAdd1(String title, String frmDt, String toDt, String categ, String cnf, String emailAlt,
			String emailCnt, String remMin, String remType, String remnote, String intRem, String ownerusr,
			String contact, String company, String deal, String task, String cases, String tags, String location,
			String notes, String minutes) {
		enterText(nee.title(), title);
		DateEnter(driver, nee.fromdate(), frmDt);
		DateEnter(driver, nee.todate(), toDt);
		Dropbyvisibletext(nee.category(), categ);
		Click(nee.assignuseridfrom());
		Click(nee.addbtn());
		Radiobuttons(nee.confirmedchkbx(), cnf);
		Checkboxes(nee.emailalert(), emailAlt);
		Checkboxes(nee.emailalert(), emailCnt);
		Dropbyvisibletext(nee.reminderminutes(), remMin);
		Dropbyvisibletext(nee.reminderminutes(), remType);
		enterText(nee.notes(), remnote);
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
		String xlPath = this.getClass().getClassLoader().getResource("LoginTest.xlsx").getPath();
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(1);

		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {

			data[i][0] = excl.getData(1, i + 1, 0);
			data[i][1] = excl.getData(1, i + 1, 1);

		}
		return data;

	}

}
