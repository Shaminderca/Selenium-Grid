package com.carbonite.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.pages.BusinessBackupPage;
import com.carbonite.qa.pages.HomeBackupPage;
import com.carbonite.qa.utils.DriverFactory;
import com.carbonite.qa.utils.Utils;

public class BusinessBackupPageTest extends TestBase {
	

	BusinessBackupPage bbp;
	HomeBackupPage hbp;

	@BeforeMethod
	void setUp() {

		initialisation();
		hbp = new HomeBackupPage();
		bbp = hbp.clickBusinessBackupPageField();
		System.out.println("Buisness Backup Page class intialised");

	}
	@Test
	public void clickOnComparePlansTest() {
		System.out.println("Thread id" + Thread.currentThread().getId());
		System.out.println("Buisness Backup Page class- clickOnComparePlansTest execution started....");
		bbp.clickOnComparePlans();
		String titleofPage = driver.getTitle();
		Assert.assertEquals("Personal Cloud Backup Pricing, Plans & Features | Carbonite", titleofPage);
	}
	@Test
	public void clickOnBusinessTrialTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println("Buisness Backup Page class- clickOnBusinessTrialTest execution started....");
		bbp.clickOnBusinessTrial();
		String titleofPage = driver.getTitle();
		Assert.assertEquals("Try Carbonite Business Backup Free For 30 Days | Carbonite", titleofPage );
	}
	
	@Test
	public void laptopLogoIsDisplayedTest()
	{   System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println("Buisness Backup Page class-  laptopLogoIsDisplayedTest execution started....");
		boolean flag =bbp.laptopLogoIsDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void verifyColorTest() {
		System.out.println("Thread id " + Thread.currentThread().getId());
		System.out.println("Buisness Backup Page class- verifyColorTest execution started....");
		String color =bbp.verifyColor();
		Assert.assertEquals(prop.getProperty("Social_Media_Icon_Color_Hex_Code"), color);
		
	}

	@AfterMethod
	void teraDown() {
		System.out.println("Web Browser Is Quit#######################");
        DriverFactory.getObject().removeDriver();
	}
}
