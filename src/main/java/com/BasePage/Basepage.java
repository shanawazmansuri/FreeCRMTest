package com.BasePage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Basepage {

	public static WebDriver driver;

	public WebDriver Browser(String BrowserName, String url) {

		if (BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Setup\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Setup\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\Setup\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.get(url);
		return driver;

	}

	// Quiting the Browser//
	public void QuitBrowser() {

		driver.quit();
	}

	// Closing the Browser Tab//
	public void CloseBrowser() {
		driver.close();

	}

	// Maximize Browser//
	public void MaximizeBrowser() {
		driver.manage().window().maximize();
	}

	// Minimize Browser//
	public void MinimizeBrowser() {
		driver.manage().window().setPosition(new Point(-2000, 0));
	}

	// ResizeBrowser Browser//
	public void ResizeBrowser() {
		Dimension d = new Dimension(800, 480);
		driver.manage().window().setSize(d);
	}

	// Full Screen//
	public void FullScreen() {
		driver.manage().window().fullscreen();
	}

	// Delete Cookies//
	public void DeleteCookies() {
		driver.manage().deleteAllCookies();
	}

	// Back//
	public void Back() {
		driver.navigate().back();
	}

	// Forward//
	public void Forward() {
		driver.navigate().forward();
	}

	// Open Tab in Browser//
	public void OpenTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

	}

	// SwitchtoNextTab//
	public void SwitchtoNextTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

	}

	// Open New Window//
	public void OpenNewwindow() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");

	}

	// Accept Alert//
	public void AlertAccept() {
		driver.switchTo().alert().accept();

	}

	// Dismiss Alert//
	public void AlertDismiss() {
		driver.switchTo().alert().dismiss();

	}

	// Alert getText//
	public String AlertGetText() {
		String Alerttext = driver.switchTo().alert().getText();
		return Alerttext;

	}

	// Alert EnterText //
	public void AlertEnterText(String Values) {
		driver.switchTo().alert().sendKeys(Values);

	}

	// Refresing Browser

	public void Refresh() {
		driver.navigate().refresh();
	}

	// ClearText Browser//

	public void ClearText(WebElement Element) {
		Element.clear();
	}

	// Enter Key//
	public void EnterKey(WebElement Element) {
		Element.sendKeys(Keys.ENTER);

	}

	// Enter Key//
	public void Submit(WebElement Element) {
		Element.submit();

	}

	// click on Element//
	public void Click(WebElement Element) {
		Element.click();
	}

	// Element Displayed//
	public void IsDisplayed(WebElement Element) {
		if (Element.isDisplayed()) {
			System.out.println("Element is Displayed");
		} else {
			System.out.println("Element is not Available");
		}

	}

	// Element Enabled//
	public void IsEnabled(WebElement Element) {
		if (Element.isEnabled()) {
			System.out.println("Element is enabled");
		} else {
			System.out.println("Element is disabled");
		}
	}

	// Element Selected//
	public void IsSelected(WebElement Element) {
		if (Element.isSelected()) {
			System.out.println("Element is selected");
		} else {
			System.out.println("Element is not selected");
		}
	}

	// Locators 1 //
	public WebElement Id(String Locator) {
		WebElement element = driver.findElement(By.id(Locator));
		return element;
	}

	public WebElement CssSelector(String Locator) {
		WebElement element = driver.findElement(By.cssSelector(Locator));
		return element;
	}

	public WebElement TagName(String Locator) {
		WebElement element = driver.findElement(By.tagName(Locator));
		return element;
	}

	public WebElement Name(String Locator) {
		WebElement element = driver.findElement(By.name(Locator));
		return element;
	}

	public WebElement PartialLinkText(String Locator) {
		WebElement element = driver.findElement(By.partialLinkText(Locator));
		return element;
	}

	public WebElement Xpath(String Locator) {
		WebElement element = driver.findElement(By.xpath(Locator));
		return element;
	}

	public WebElement className(String Locator) {
		WebElement element = driver.findElement(By.className(Locator));
		return element;
	}

	public List<WebElement> Elements(String Xpath) {

		List<WebElement> elements = driver.findElements(By.xpath(Xpath));
		return elements;
	}

	// Locator 2 ///
	public WebElement Locator(String locatorTpye, String value) {
		By by;
		WebElement element;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			element = driver.findElement(by);

			break;
		case "name":
			by = By.name(value);
			element = driver.findElement(by);

			break;
		case "xpath":
			by = By.xpath(value);
			element = driver.findElement(by);
			break;
		case "css":
			by = By.cssSelector(value);
			element = driver.findElement(by);
			break;
		case "linkText":
			by = By.linkText(value);
			element = driver.findElement(by);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			element = driver.findElement(by);
			break;
		case "tagName":
			by = By.tagName(value);
			element = driver.findElement(by);
			break;
		default:
			by = null;
			element = null;
			break;
		}
		return element;

	}

	// GetTitle///
	public String GetTitle() {

		String title = driver.getTitle();
		return title;

	}

	// Get Current URL///
	public String GetCurrentURL() {

		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;

	}

	// Gettext//

	public String Gettext(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	// Implicit Wait///
	public void Implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// Explicit Wait//
	public void WaitToClick(WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void WaitTovisibleElement(WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void WaitAlertPresent(int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void WaitcontainTitle(int time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));

	}

	public void WaitcontaTitleIs(int time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleIs(title));

	}

	public void WaitPageLoadTimeout(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

	}

	// Thread. Sleep///
	public void Wait(long wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Screenshot(WebDriver driver) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File src = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(src, new File("D:\\Selenium\\Screenshots\\" + System.currentTimeMillis() + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

	// Highlight Elements///
	public void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}

	// Enter text//

	public void enterText(WebElement ele, String values) {
		ele.sendKeys(values);

	}

	// /Mouse Hover///
	public void MouseOver(WebElement ele) {
		Actions actObj = new Actions(driver);
		actObj.moveToElement(ele).build().perform();
	}

	public void AssertEquals(WebElement actual, String Expected) {
		String act = actual.getText();
		Assert.assertEquals(act, Expected);

	}

	public void AssertTrueContains(String Expected, WebElement Act) {
		String Actual = Act.getText();
		Assert.assertTrue(Actual.contains(Expected), "Text not matched");
	}

	public void AssertTrueEquals(String Expected, WebElement Actual) {
		String Act = Actual.getText();
		Assert.assertTrue(Act.equals(Expected), "Text not matched");
	}

	public void AssertTrueEqualsIgnoreCase(String Expected, WebElement Actual) {
		String Act = Actual.getText();
		Assert.assertTrue(Act.equalsIgnoreCase(Expected), "Text not matched");
	}

	// select the dropdown using "select by visible text"//
	public void Dropbyvisibletext(WebElement ele, String VisibleText) {
		Select selObj = new Select(ele);
		selObj.selectByVisibleText(VisibleText);
	}

	// select the dropdown using "select by index"//
	public void DropbyIndex(WebElement ele, int IndexValue) {
		Select selObj = new Select(ele);
		selObj.selectByIndex(IndexValue);
	}

	// select the dropdown using "select by value", //
	public void Dropbyvalue(WebElement ele, String Value) {
		Select selObj = new Select(ele);
		selObj.selectByValue(Value);

	}

	// DropDown values
	public void DropDownValues(WebElement element) {
		Select selObj = new Select(element);
		List<WebElement> AllValues = selObj.getOptions();
		for (WebElement ele : AllValues) {
			String AllDropValues = ele.getText();
			System.out.println("Drop Down values are " + AllDropValues);
		}

	}

	// DropDown First Values
	public void DropFirstselectedValues(WebElement element) {

		Select DropValues = new Select(element);
		WebElement FirstValue = DropValues.getFirstSelectedOption();
		System.out.println("First Value selected is " + FirstValue.getText());

	}

	// DropDown Selected Values
	public void DropSelectedValues(WebElement element) {
		Select DropValues = new Select(element);
		List<WebElement> AllValueSelected = DropValues.getAllSelectedOptions();
		for (WebElement ele : AllValueSelected) {
			System.out.println("Selected Values in Drop Down are " + ele.getText());
		}

	}

	// Enter Date
	public void DateEnter(WebElement ele, String value) {
		ele.sendKeys(value);
		ele.sendKeys(Keys.TAB);

	}

	// Mouse Hover //
	public void Mousehover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	// DragandDrop//
	public void DragandDrop(WebElement WE_Src, WebElement WE_Trg) {
		Actions act = new Actions(driver);
		act.dragAndDrop(WE_Src, WE_Trg).build().perform();
	}

	// Radio button//
	public void Radiobuttons(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			String Radios = element.getAttribute("value");
			if (Radios.equalsIgnoreCase(value)) {
				element.click();
			}
		}
	}

	// Radio Button values
	public void RadioButtonValues(List<WebElement> elements) {
		for (WebElement eachele : elements) {
			String RadioValues = eachele.getAttribute("value");
			System.out.println("Radio buttons values are " + RadioValues);
		}
	}

	// check boxes//
	public void Checkboxes(List<WebElement> element, String value) {
		List<String> list = new ArrayList<String>(Arrays.asList(value.split(",")));
		for (String check : list) {
			for (WebElement chk : element) {
				if (chk.getAttribute("name").equalsIgnoreCase(check))
					chk.click();
			}
		}
	}

	// check boxes//
	public void CheckboxeSelectAll(List<WebElement> elements) {

		for (WebElement check : elements) {
			check.click();
		}

	}

	// Checkboxes values
	public void CheckboxesValues(List<WebElement> elements) {
		for (WebElement eachele : elements) {
			String CheckValues = eachele.getAttribute("value");
			System.out.println("Checkboxes values are " + CheckValues);
		}
	}

	// Multi select dropndown//
	public void MultiSelect(WebElement element, String Values) {
		Select slct = new Select(element);
		List<WebElement> allopt = slct.getOptions();

		List<String> list = new ArrayList<String>(Arrays.asList(Values.split(",")));
		for (String check : list) {
			slct.selectByVisibleText(check);
		}
	}

	// Multi select All Valuesdropndown//
	public void MultiSelectAllValues(WebElement element) {
		Select slct = new Select(element);
		List<WebElement> allopt = slct.getOptions();
		for (WebElement check : allopt) {
			check.click();
		}
	}

	// MultiSelect values

	public void MultiSelectValues(WebElement element) {

		Select selObj = new Select(element);
		List<WebElement> AllValues = selObj.getOptions();
		for (WebElement ele : AllValues) {
			String AllMultiValues = ele.getText();
			System.out.println("Multi Select values are " + AllMultiValues);
		}
	}

	// MultiSelect Selected Values
	public void MultiSelectedValues(WebElement element) {
		Select DropValues = new Select(element);
		List<WebElement> AllValueSelected = DropValues.getAllSelectedOptions();
		for (WebElement ele : AllValueSelected) {
			System.out.println("Multi Selected Values in Drop Down are " + ele.getText());
		}

	}

	// AutoComplete//
	public void AutoComplete(List<WebElement> elements, String ExpectedValue) {
		for (WebElement ele : elements) {
			String Eachelement = ele.getAttribute("innerHTML");
			if (Eachelement.equalsIgnoreCase(ExpectedValue)) {
				ele.click();
				break;
			}
		}

	}

	// AutoComplete values
	public void AutoCompleteValues(List<WebElement> elements) {
		for (WebElement eachele : elements) {
			String AutoValues = eachele.getAttribute("innerHTML");
			System.out.println("Values of Radio buttons are " + AutoValues);
		}
	}

	// UploadFile//
	public void UploadFile(WebElement ele, String Values) {
		ele.sendKeys(Values);

	}

	// Frames by name
	public void FramebyName(String Value) {
		driver.switchTo().frame(Value);
	}

	// Frames by Index
	public void FramebyIndex(int Value) {
		driver.switchTo().frame(Value);
	}

	// Frames by WebElement
	public void FramebyWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	// Frames Parent
	public void FrameParent() {
		driver.switchTo().parentFrame();
	}

	// Click and Hold
	public void ClickandHold(WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element);
	}

	// Double Click
	public void DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	// Release
	public void ReleaseClick(WebElement element) {
		Actions action = new Actions(driver);
		action.release(element);
	}

	// Right Click
	public void RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	// Move to Element
	public void MovetoElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

}