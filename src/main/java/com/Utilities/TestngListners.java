package com.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BasePage.Basepage;

public class TestngListners extends Basepage implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test Started + " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully Executed + " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed + " + result.getName());
		Screenshot(driver);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped + " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Percentage is + " + result.getName());

	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test will Starting " + result.getName());

	}

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Test Completed Successfully " + result.getName());

	}
}