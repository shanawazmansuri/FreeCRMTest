package com.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BasePage.Basepage;

public class ContactCases extends Basepage {

	LoginPageTest login = new LoginPageTest();

	@BeforeMethod()
	public void StartUp() {

		Browser("chrome", "https://www.freecrm.com/index.html");
		MaximizeBrowser();
		DeleteCookies();
		WaitPageLoadTimeout(50);
		Implicitwait(50);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void selectCheckboxGrid() {

		login.Login();
		driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).click();
		String before_Xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String after_Xpath = "]/td[2]/a";

		for (int i = 4; i <= 8; i++) {

			String names = driver.findElement(By.xpath(before_Xpath + i + after_Xpath)).getText();
			System.out.println(names);
			if (names.equalsIgnoreCase("Nawaz")) {
				driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[" + i + "]/td[1]/input"))
						.click();
				Wait(2000);
			}
		}

	}

	@Test(priority = 2)
	public void selectCheckboxGridbyxpath() {

		login.Login();
		driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).click();
		driver.findElement(
				By.xpath("//a[contains(text(),1.1)]/parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();
		Wait(2000);

	}
}