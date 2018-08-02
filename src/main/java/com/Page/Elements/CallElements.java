package com.Page.Elements;

import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;

public class CallElements extends Basepage {

	public WebElement casemenu() {
		WebElement Casemenu = Xpath("//a[@title=\"Call\"]");
		return Casemenu;
	}

	public WebElement newCasemenu() {
		WebElement NewCasemenu = Xpath("//a[@title=\"New Call\"]");
		return NewCasemenu;
	}

	public WebElement callSchedulechk() {
		WebElement callschedulechk = Name("scheduled_call");
		return callschedulechk;
	}

	public WebElement callScheduleDt() {
		WebElement callscheduledt = Id("fieldId_schedule");
		return callscheduledt;
	}

	public WebElement assignTo() {
		WebElement assignto = Name("user_id");
		return assignto;
	}

	public WebElement reminder() {
		WebElement reminder = Name("reminder_minutes");
		return reminder;
	}

	public WebElement reminderType() {
		WebElement remindertype = Name("reminder_type");
		return remindertype;
	}

	public WebElement reminderNote() {
		WebElement remindernote = Name("reminder_note");
		return remindernote;
	}

	public WebElement contactExist() {
		WebElement contactexist = Name("contactentrytype");
		return contactexist;
	}

	public WebElement calltoContact() {
		WebElement calltocontact = Name("contact_lookup");
		return calltocontact;
	}

	public WebElement calltoCompany() {
		WebElement calltocompany = Name("client_lookup");
		return calltocompany;
	}

	public WebElement calltoName() {
		WebElement calltoname = Name("name");
		return calltoname;
	}

	public WebElement calltoPhone() {
		WebElement calltophone = Name("phone_number");
		return calltophone;
	}

	public WebElement flagAs() {
		WebElement flagas = Name("flag");
		return flagas;
	}

	public WebElement saveBtn() {
		WebElement SaveBtn = Xpath("//*[@id=\"callForm\"]/table/tbody/tr[1]/td/input[1]");
		return SaveBtn;
	}

}
