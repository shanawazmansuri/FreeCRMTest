package com.Page.Elements;

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

}
