package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BasePage.Basepage;

public class DemoTests extends Basepage {
	@BeforeMethod
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@Test
	public void title() {
		String title = GetTitle();
		System.out.println("title is "+title );
		
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
