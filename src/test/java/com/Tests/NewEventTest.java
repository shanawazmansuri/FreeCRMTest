package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.NewEventElements;

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

}
