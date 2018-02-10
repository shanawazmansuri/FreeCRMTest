package com.Page.Elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;
import com.Utilities.PropertiesFile;

public class NewEventElements extends Basepage {

	PropertiesFile ne = new PropertiesFile();

	public WebElement CalendarMenu()

	{
		WebElement CalendarMenu = Xpath(ne.prop.getProperty("CalendarMenu_Xpath"));
		return CalendarMenu;
	}

	public WebElement NewEventSubmenu() {
		WebElement NewEventSubmenu = Xpath(ne.prop.getProperty("NewEventMenu_Xpath"));
		return NewEventSubmenu;
	}

	public WebElement title() {
		WebElement title = Id("title");
		return title;
	}

	public WebElement fromdate() {
		WebElement fromdate = Id("fieldId_start");
		return fromdate;
	}

	public WebElement todate() {
		WebElement todate = Id("fieldId_end");
		return todate;
	}

	public WebElement alldayevent() {
		WebElement alldayevent = Id("all_day_event");
		return alldayevent;
	}

	public WebElement validateavail() {
		WebElement validateavail = Id("validate_availability");
		return validateavail;
	}

	public WebElement category() {
		WebElement category = Name("category");
		return category;
	}

	public WebElement assignuseridfrom() {
		WebElement assignuseridfrom = Name("assigned_to_user_id_src");
		return assignuseridfrom;
	}

	public WebElement addbtn() {
		WebElement addbtn = Xpath("//input[@value='==ADD==>']");
		return addbtn;
	}

	public WebElement removebtn() {
		WebElement addbtn = Xpath("<=REMOVE=");
		return addbtn;
	}

	public WebElement assignuseridto() {
		WebElement assignuseridto = Name("assigned_to_user_id");
		return assignuseridto;
	}

	public WebElement checkavailbyreg() {
		WebElement checkavailbyreg = Xpath("//input[@value='Check availability by region']");
		return checkavailbyreg;
	}

	public List<WebElement> confirmedchkbx() {
		List<WebElement> conf = Elements("//input[@name='confirmed']");
		return conf;
	}

	public List<WebElement> emailalert() {
		List<WebElement> emailalert = Elements("//input[@name='email_alert']");
		return emailalert;
	}

	public List<WebElement> emailaltcontact() {
		List<WebElement> emailaltcontact = Elements("//input[@name='email_alert_contact']");
		return emailaltcontact;
	}

	public WebElement reminderminutes() {
		WebElement reminderminutes = Name("reminder_minutes");
		return reminderminutes;
	}

	public WebElement remindertype() {
		WebElement remindertype = Name("reminder_type");
		return remindertype;
	}

	public WebElement remindernote() {
		WebElement remindernote = Name("reminder_note");
		return remindernote;
	}

	public List<WebElement> internalreminder() {
		List<WebElement> internalreminder = Elements("//input[@name='internal_reminder']");
		return internalreminder;
	}

	public WebElement owneruserid() {
		WebElement owneruserid = Id("owner_user_id");
		return owneruserid;
	}

	public WebElement contact() {
		WebElement contact = Name("contact_lookup");
		return contact;
	}

	public WebElement company() {
		WebElement company = Name("client_lookup");
		return company;
	}

	public WebElement deal() {
		WebElement deal = Name("prospect_lookup");
		return deal;
	}

	public WebElement task() {
		WebElement task = Name("task_lookup");
		return task;
	}

	public WebElement cases() {
		WebElement cases = Name("case_lookup");
		return cases;
	}

	public WebElement tags() {
		WebElement tags = Id("tags");
		return tags;
	}

	public WebElement location() {
		WebElement location = Name("location");
		return location;
	}

	public WebElement notes() {
		WebElement notes = Id("notes");
		return notes;
	}

	public WebElement minutes() {
		WebElement minutes = Id("meeting_notes");
		return minutes;
	}

	public WebElement savebtn() {
		WebElement savebtn = Xpath("//*[@id=\"appForm\"]/table/tbody/tr[21]/td[2]/input");
		return savebtn;
	}

}
