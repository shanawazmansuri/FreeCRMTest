package com.Tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.RegistrationElements;
import com.Utilities.ExcelDataConfig;
import com.Utilities.ScreenShot;

@Listeners(com.Utilities.ExtentReporterNG.class)
public class RegistrationTest extends Basepage {
	RegistrationElements ele = new RegistrationElements(driver);

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
		CloseBrowser();
	}

	@Test(priority = 1, enabled = false)
	public void FieldMessageValidate() {

		Click(ele.SignUpBtn());
		Click(ele.FirstName());
		enterText(ele.FirstName(), "A");
		ele.FirstName().sendKeys(Keys.BACK_SPACE);
		Click(ele.LastName());
		enterText(ele.LastName(), "B");
		ele.LastName().sendKeys(Keys.BACK_SPACE);
		enterText(ele.Email(), "shanawaz");
		enterText(ele.EmailConfirm(), "mansuri");
		enterText(ele.Username(), "12345");
		enterText(ele.Password(), "aaaaa");
		enterText(ele.PasswordConfirm(), "11111");
		IsEnabled(ele.SubmitBtn());
		ScreenShot.CaptureScreenshot(driver);
		AssertEquals(ele.MsgFirstName(), "Please enter your first name");
		AssertEquals(ele.MsgLastName(), "Please enter your surname");
		AssertEquals(ele.MsgmEail(), "Invalid Email Address");
		AssertEquals(ele.MsgConfEmail(), "The mail and its confirm must be the same");
		AssertEquals(ele.MsgUsername(), "Username must be at least 6 characters long");
		AssertEquals(ele.MsgConfPassword(), "The password and its confirm must be the same");
		AssertEquals(ele.MsgPassword(), "Password must be at least 6 characters long");

	}

	@Test(priority = 2, enabled = false)
	public void ValidateSubmitBtnAgreeEditionMsg() {

		Click(ele.SignUpBtn());
		enterText(ele.FirstName(), "Shanawaz");
		enterText(ele.LastName(), "Usman");
		enterText(ele.Email(), "shanawaz@gmail.com");
		enterText(ele.EmailConfirm(), "shanawaz@gmail.com");
		enterText(ele.Username(), "nawazmansuri");
		enterText(ele.Password(), "Aalahazrat@1");
		enterText(ele.PasswordConfirm(), "Aalahazrat@1");
		IsEnabled(ele.SubmitBtn());
		Click(ele.SubmitBtn());
		ScreenShot.CaptureScreenshot(driver);
		AssertEquals(ele.MsgEdition(), "Please select one Edition mode");
		AssertEquals(ele.MsgAgree(), "You must agree to the Terms and Conditions before continuing");
	}

	@Test(dataProvider = "DataEntry", priority = 3, enabled = true)
	public void CreateRegistration(String Edition, String Firstname, String Lastname, String Email, String ConEmail,
			String Usrname, String Pwd, String ConfPwd, String Agree) {
		Click(ele.SignUpBtn());
		Dropbyvisibletext(ele.Edition(), Edition);
		enterText(ele.FirstName(), Firstname);
		enterText(ele.LastName(), Lastname);
		enterText(ele.Email(), Email);
		enterText(ele.EmailConfirm(), ConEmail);
		enterText(ele.Username(), Usrname);
		enterText(ele.Password(), Pwd);
		enterText(ele.PasswordConfirm(), ConfPwd);
		Checkboxes(ele.AgreeTerms(), Agree);
		ScreenShot.CaptureScreenshot(driver);

	}

	@DataProvider(name = "DataEntry")
	public Object[][] passData() {
		String xlPath = this.getClass().getClassLoader().getResource("RegistrationTest.xlsx").getPath();
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);

		Object[][] data = new Object[rows][9];
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

		}
		return data;

	}

	@Test(priority = 4, enabled = false)
	public void EditionValues() {
		Click(ele.SignUpBtn());
		DropDownValues(ele.Edition());
		DropFirstselectedValues(ele.Edition());
		DropSelectedValues(ele.Edition());
	}

	@Test(priority = 5, enabled = false)
	public void ValiadteIAgreeSelected() {
		Click(ele.SignUpBtn());
		boolean AgreeStatus = ele.AgreeTerms().get(0).isSelected();
		if (AgreeStatus == true) {
			System.out.println("I Agree field is selected");
		} else {
			System.out.println("I Agree field is not selected");
		}

	}

}
