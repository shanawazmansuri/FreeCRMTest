package com.Page.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;
import com.Utilities.PropertiesFile;

public class ForgotPwdElements extends Basepage {

	PropertiesFile pro = new PropertiesFile();

	public ForgotPwdElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement FrgPwdLnk() {

		WebElement FrgPwdLnk = PartialLinkText(pro.Loginprop.getProperty("FrgPwdLnk"));
		return FrgPwdLnk;
	}

	public WebElement FrgPwdUsrname() {

		WebElement FrgPwdUsrname = Xpath(pro.Loginprop.getProperty("Usrname_FrgPwd"));
		return FrgPwdUsrname;
	}

	public WebElement GetPwdBtn() {

		WebElement GetPwdBtn = Xpath(pro.Loginprop.getProperty("GetPwdBtn"));
		return GetPwdBtn;
	}

	public WebElement GetPwdMsg() {

		WebElement GetPwdMsg = Xpath(pro.Loginprop.getProperty("GetPwdMsg"));
		return GetPwdMsg;
	}

}
