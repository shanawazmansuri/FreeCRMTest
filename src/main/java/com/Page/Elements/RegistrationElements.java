package com.Page.Elements;

import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;
import com.Utilities.PropertiesFile;

public class RegistrationElements extends Basepage {
	PropertiesFile pro = new PropertiesFile();

	public WebElement SignUpBtn() {
		WebElement SignUpBtn = Xpath(pro.prop.getProperty("SignUp_Xpath"));
		return SignUpBtn;
	}

	public WebElement FirstName() {
		WebElement FirstName = Name(pro.prop.getProperty("FirstName_Name"));
		return FirstName;
	}

	public WebElement LastName() {
		WebElement LastName = Name(pro.prop.getProperty("LastName_Name"));
		return LastName;
	}

	public WebElement Email() {
		WebElement Email = Name(pro.prop.getProperty("Email_Name"));
		return Email;
	}

	public WebElement EmailConfirm() {
		WebElement EmailConfirm = Name(pro.prop.getProperty("EmailConfirm_Name"));
		return EmailConfirm;
	}

	public WebElement Username() {
		WebElement Username = Name(pro.prop.getProperty("Username_Name"));
		return Username;
	}

	public WebElement Password() {
		WebElement Password = Name(pro.prop.getProperty("Password_Name"));
		return Password;
	}

	public WebElement PasswordConfirm() {
		WebElement PasswordConfirm = Name(pro.prop.getProperty("PasswordConfirm_Name"));
		return PasswordConfirm;
	}

	public WebElement AgreeTerms() {
		WebElement AgreeTerms = Name(pro.prop.getProperty("AgreeTerms_Name"));
		return AgreeTerms;
	}

	public WebElement SubmitBtn() {
		WebElement SubmitBtn = Name(pro.prop.getProperty("SubmitBtn_Name"));
		return SubmitBtn;
	}

}
