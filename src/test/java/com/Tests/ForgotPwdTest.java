package com.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.ForgotPwdElements;
import com.Utilities.PropertiesFile;
import com.Utilities.ScreenShot;

public class ForgotPwdTest extends Basepage {

	ForgotPwdElements FrgPwd = new ForgotPwdElements(driver);
	PropertiesFile pro = new PropertiesFile();

	@BeforeMethod
	public void Startup() {
		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@Test(priority = 1, description = "Verify forgot pwd wih valid login Id")
	public void ValidUsrFrgtPwd() {

		Click(FrgPwd.FrgPwdLnk());
		enterText(FrgPwd.FrgPwdUsrname(), pro.prop.getProperty("usrname"));
		ScreenShot.CaptureScreenshot(driver);
		Click(FrgPwd.GetPwdBtn());
		ScreenShot.CaptureScreenshot(driver);
		String message = Gettext(FrgPwd.GetPwdMsg());
		AssertEquals(FrgPwd.GetPwdMsg(), "Your login detail have been sent to the email address on file.");

	}

	@Test(priority = 2, description = "Verify forgot pwd wih Invalid login Id")
	public void InValidUsrFrgtPwd() {

		Click(FrgPwd.FrgPwdLnk());
		enterText(FrgPwd.FrgPwdUsrname(), "shanawaz.mansuri1");
		ScreenShot.CaptureScreenshot(driver);
		Click(FrgPwd.GetPwdBtn());
		ScreenShot.CaptureScreenshot(driver);
		String message = Gettext(FrgPwd.GetPwdMsg());
		AssertTrueContains("We could not retrieve your login details. Please contact us at info@crmpro.com.",
				FrgPwd.GetPwdMsg());

	}

	@AfterMethod
	public void TearDown() {
		CloseBrowser();

	}
}
