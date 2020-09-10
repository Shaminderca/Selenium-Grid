package com.carbonite.qa.retryFailedTestCaseLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.carbonite.qa.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
//two things
	// max limit
	// counter

	int maxCount = 2;
	int counter = 0;

	@Override
	public boolean retry(ITestResult result) {

		while (counter != maxCount) {
			counter++;
			return true;
		}

		return false;
	}

}
