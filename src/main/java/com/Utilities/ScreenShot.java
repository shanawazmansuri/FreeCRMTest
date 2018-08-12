package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.BasePage.Basepage;

public class ScreenShot extends Basepage {

	public static void CaptureScreenshot(WebDriver driver, String scrPath, String scrPrefix) {
		String path = System.getProperty("user.dir");
		String sourcePath = path + scrPath;
		String prefix = scrPrefix;

		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd-HHmmss");
		final String timeStamp = date.format(Calendar.getInstance().getTime());

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(sourcePath + prefix + timeStamp + ".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
