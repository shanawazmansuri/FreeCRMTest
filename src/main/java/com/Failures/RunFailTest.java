package com.Failures;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunFailTest {

	public static void main(String[] args) {
		TestNG runner = new TestNG();
		List<String> list = new ArrayList<String>();
		list.add("D:\\Selenium\\Codes\\FreeCRM\\test-output\\testng-failed.xml");

		runner.setTestSuites(list);
		runner.run();
	}
}