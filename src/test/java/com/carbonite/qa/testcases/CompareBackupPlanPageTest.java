package com.carbonite.qa.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.pages.CompareBackupPlanPage;
import com.carbonite.qa.pages.HomeBackupPage;
import com.carbonite.qa.utils.DriverFactory;

public class CompareBackupPlanPageTest extends TestBase {
	HomeBackupPage hbp;
	CompareBackupPlanPage cbp;
	WebDriverWait wait;

	@BeforeMethod
	void setUp() {
		System.out.println("CompareBackupPlanPageTest  intialised");
		initialisation();
		hbp = new HomeBackupPage();
		cbp = hbp.clickCompareBackupPlanPageField();
		wait = new WebDriverWait(driver, 10);
	
	}

	@Test
	public void clickStartHomeTrialButton() {
		System.out.println("CompareBackupPlanPageTest and clickStartHomeTrialButton Method");
		cbp.clickStartHomeTrialButton();
		String titleofPage = driver.getTitle();
		Assert.assertEquals("Try Carbonite Computer Backup Free For 15 Days | Carbonite", titleofPage);

	}

	@Test
	public void clickOnIconsTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println("CompareBackupPlanPageTest and clickOnIconsTest() Method");
		boolean flag = cbp.clickOnIcons();
		Assert.assertTrue(flag);

	}

	@AfterMethod
	void tearDown() {
		System.out.println("Web Browser Is Quit#######################");
        DriverFactory.getObject().removeDriver();
		

	}
}
