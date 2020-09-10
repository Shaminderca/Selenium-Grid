package com.carbonite.qa.testcases;

import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.pages.DownloadPage;
import com.carbonite.qa.pages.HomeBackupPage;
import com.carbonite.qa.utils.DriverFactory;
import com.carbonite.qa.utils.Utils;

public class HomeBackupPageTest extends TestBase {
	HomeBackupPage hbp;
	DownloadPage dp;
	WebDriverWait wait;
	JavascriptExecutor js;

	static String email = Utils.randomEmailGenerator();
	static String password = Utils.randomPasswordGenerator();

	@BeforeMethod()
	void setUp() {
		System.out.println(" HomeBackupPageTest class intialised");
		initialisation();
		wait = new WebDriverWait(driver, 20);
		hbp = new HomeBackupPage();
		// dp = hbp.clickSubmitButton();
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void signUpFunctionalityTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());

		hbp.inputValuesInTheField(email, email, password, password);
		hbp.selectDropDown();
		hbp.clickSubmitButton();
		System.out.println(" HomeBackupPageTest class intialised and signUpFunctionalityTest()");
		// wait.until(ExpectedConditions.visibilityOf(dp.downloadPageImage));

		String titleofDownloadPage = driver.getTitle();
		System.out.println("Title of the page" + titleofDownloadPage);
		Assert.assertEquals("Download", titleofDownloadPage);

	}

	@AfterMethod
	void tearDown() {
		System.out.println("Web Browser Is Quit#######################");
        DriverFactory.getObject().removeDriver();
	}

}
