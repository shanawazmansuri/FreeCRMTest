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

		WebElement FrgPwdLnk = PartialLinkText(pro.prop.getProperty("FrgPwdLnk"));
		return FrgPwdLnk;
	}

	public WebElement FrgPwdUsrname() {

		WebElement FrgPwdUsrname = Xpath(pro.prop.getProperty("Usrname_FrgPwd"));
		return FrgPwdUsrname;
	}

	public WebElement GetPwdBtn() {

		WebElement GetPwdBtn = Xpath(pro.prop.getProperty("GetPwdBtn"));
		return GetPwdBtn;
	}

	public WebElement GetPwdMsg() {

		WebElement GetPwdMsg = Xpath(pro.prop.getProperty("GetPwdMsg"));
		return GetPwdMsg;
	}

}
