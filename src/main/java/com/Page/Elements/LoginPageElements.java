package com.Page.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;
import com.Utilities.PropertiesFile;

public class LoginPageElements extends Basepage {

	PropertiesFile pro = new PropertiesFile();

	public LoginPageElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement UsrId() {

		WebElement UsrId = Name(pro.Loginprop.getProperty("UsrId_Name"));
		return UsrId;
	}

	public WebElement Pwd() {
		WebElement Pwd = Name(pro.Loginprop.getProperty("Pwd_Name"));
		return Pwd;
	}

	public WebElement LgnBtn() {
		WebElement LgnBtn = Xpath(pro.Loginprop.getProperty("LgnBtn_Xpath"));
		return LgnBtn;
	}

	public WebElement Frgtpwd() {
		WebElement Frgtpwd = Xpath(pro.Loginprop.getProperty("Frgtpwd_Xpath"));
		return Frgtpwd;
	}

	public WebElement Signup() {
		WebElement Signup = Xpath(pro.Loginprop.getProperty("Signup_Xpath"));
		return Signup;
	}

	public WebElement Logo() {
		WebElement Logo = Xpath(pro.Loginprop.getProperty("Logo_Xpath"));
		return Logo;
	}

}
