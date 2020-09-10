package com.carbonite.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.pages.FreeTrialPage;
import com.carbonite.qa.pages.HomeBackupPage;
import com.carbonite.qa.utils.DriverFactory;

public class FreeTrialPageTest extends TestBase {
	HomeBackupPage hbp;
	FreeTrialPage ftp;
	WebDriverWait wait;
    
	@BeforeMethod
	void setUp() {
		initialisation();
		hbp = new HomeBackupPage();
		ftp = hbp.clickFreeTrialPageField();
		System.out.println(" FreeTrialPageTest class intialised");
		//wait = new WebDriverWait(driver, 10);
	}
		
	@Test
	void clickOnStartFreeTrialButtonTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println(" FreeTrialPageTest class and clickOnStartFreeTrialButtonTest");
		ftp.clickOnStartFreeTrialButton();
		String pageTitle =driver.getTitle();
		Assert.assertEquals("Try Carbonite Computer Backup Free For 15 Days | Carbonite", pageTitle);
		
	}
	
	@Test
	void clickOnLearnMoreButtonTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println(" FreeTrialPageTest class and clickOnLearnMoreButtonTest");
		ftp.clickOnLearnMoreButton();
		String pageTitle =driver.getTitle();
		Assert.assertEquals("Back up and protect files with Carbonite Safe | Carbonite", pageTitle);
	}

	@Test
	void headingDispalyMethodTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println(" FreeTrialPageTest class and headingDispalyMethodTest()  ");
		boolean flag =ftp.headingDispalyMethod();
		Assert.assertTrue(flag);
		
	}
	
	@Test
	void headingComparsisonTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
	   System.out.println(" FreeTrialPageTest class and headingComparsisonTest()  ");
	   String textFromElement=ftp.headingComaprision();
	   Assert.assertEquals("15 day trial", textFromElement);
	}
	
	
	@AfterMethod
	void tearDown() {
		System.out.println("Web Browser Is Quit#######################");
        DriverFactory.getObject().removeDriver();
		
	}
}
