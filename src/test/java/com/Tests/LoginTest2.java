package com.Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasePage.Basepage;
import com.Page.Elements.LoginPageElements;
import com.Utilities.PropertiesFile;

@Listeners(com.Utilities.ExtentReporterNG.class)
public class LoginTest2 extends Basepage {
	LoginPageElements Logele;
	PropertiesFile Pro;
	// Logger log = Logger.getLogger(LoginTest2.class);

	@BeforeMethod
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		// log.info("browser is launching");
		MaximizeBrowser();
		// log.fatal("Its Fatal Maximizing Browser");
		DeleteCookies();
		// log.warn("Warn its Deleting Cookies");
		WaitPageLoadTimeout(20);
		Implicitwait(20);
	}

	@Test
	public void Login() {

		WebElement FrgPwdLnk = PartialLinkText("Forgot Password?");
		FrgPwdLnk.click();
		WebElement Usrname = Xpath("//input[@name='username'and@size='25']");
		enterText(Usrname, "shanawazmansuri1");
		WebElement GetPwdBtn = Xpath("//input[@value='Get Password']");
		Click(GetPwdBtn);
		WebElement msg = Xpath("//div[@id='message']");
		String message = Gettext(msg);
		System.out.println(message);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}