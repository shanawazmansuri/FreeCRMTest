package com.Page.Elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.BasePage.Basepage;

public class CasesElements extends Basepage {

	public WebElement caseMenu() {
		WebElement caseMenu = Xpath("//a[@title='Cases']");
		return caseMenu;
	}

	public WebElement caseSubMenu() {
		WebElement caseSubMenu = Xpath("//a[@title='New Case']");
		return caseSubMenu;
	}

	public WebElement casesNo() {
		WebElement casesNo = Name("sequence");
		return casesNo;
	}

	public WebElement type() {
		WebElement type = Name("type");
		return type;
	}

	public WebElement title() {
		WebElement title = Id("title");
		return title;
	}

	public WebElement priority() {
		WebElement priority = Name("priority");
		return priority;
	}

	public WebElement status() {
		WebElement status = Name("status");
		return status;
	}

	public WebElement owner() {
		WebElement owner = Xpath("//td[@valign='middle'][contains(text(),'Shanawaz Mansuri')]");
		return owner;
	}

	public WebElement deadLine() {
		WebElement deadLine = Id("fieldId_deadline");
		return deadLine;
	}

	public List<WebElement> state() {
		List<WebElement> state = Elements("//input[@type='radio'][@name='closed']");
		return state;
	}

	public WebElement identifier() {
		WebElement identifier = Name("identifier");
		return identifier;
	}

	public WebElement contact() {
		WebElement contact = Name("contact_lookup");
		return contact;
	}

	public WebElement ownerUid() {
		WebElement ownerUid = Id("owner_user_id");
		return ownerUid;
	}

	public WebElement keyCompany() {
		WebElement keyCompany = Name("client_lookup");
		return keyCompany;
	}

	public WebElement tags() {
		WebElement tags = Id("tags");
		return tags;
	}

	public WebElement description() {
		WebElement description = Name("description");
		return description;
	}

	public WebElement saveBtn() {
		WebElement saveBtn = Xpath("//input[@value='Save']");
		return saveBtn;
	}

}
