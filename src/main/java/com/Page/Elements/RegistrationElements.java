package com.Page.Elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;
import com.Utilities.PropertiesFile;

public class RegistrationElements extends Basepage {
	PropertiesFile pro = new PropertiesFile();

	public RegistrationElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement SignUpBtn() {
		WebElement SignUpBtn = Xpath(pro.prop.getProperty("SignUpBtn_Xpath"));
		return SignUpBtn;
	}

	public WebElement Edition() {
		WebElement Edition = Id(pro.prop.getProperty("Edition_Id"));
		return Edition;
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

	public List<WebElement> AgreeTerms() {
		List<WebElement> AgreeTerms = Elements(pro.prop.getProperty("AgreeTerms_Xpath"));
		return AgreeTerms;
	}

	public WebElement SubmitBtn() {
		WebElement SubmitBtn = Name(pro.prop.getProperty("SubmitBtn_Name"));
		return SubmitBtn;
	}

	public WebElement MsgEdition() {
		WebElement MsgEdition = Xpath(pro.prop.getProperty("MsgEdition_Xpath"));
		return MsgEdition;
	}

	public WebElement MsgFirstName() {
		WebElement MsgFirstName = Xpath(pro.prop.getProperty("MsgFirstName_Xpath"));
		return MsgFirstName;
	}

	public WebElement MsgLastName() {
		WebElement MsgLastName = Xpath(pro.prop.getProperty("MsgLastName_Xpath"));
		return MsgLastName;
	}

	public WebElement MsgmEail() {
		WebElement Msgmail = Xpath(pro.prop.getProperty("MsgEmail_Xpath"));
		return Msgmail;
	}

	public WebElement MsgConfEmail() {
		WebElement MsgConfEmail = Xpath(pro.prop.getProperty("MsgConfEmail_Xpath"));
		return MsgConfEmail;
	}

	public WebElement MsgUsername() {
		WebElement MsgUsername = Xpath(pro.prop.getProperty("MsgUsername_Xpath"));
		return MsgUsername;
	}

	public WebElement MsgPassword() {
		WebElement MsgPassword = Xpath(pro.prop.getProperty("MsgPassword_Xpath"));
		return MsgPassword;
	}

	public WebElement MsgConfPassword() {
		WebElement MsgConfPassword = Xpath(pro.prop.getProperty("MsgConfPassword_Xpath"));
		return MsgConfPassword;
	}

	public WebElement MsgAgree() {
		WebElement MsgAgree = Xpath(pro.prop.getProperty("MsgAgree_Xpath"));
		return MsgAgree;
	}

}
//