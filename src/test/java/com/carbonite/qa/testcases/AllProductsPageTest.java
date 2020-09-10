package com.carbonite.qa.testcases;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.pages.AllProductsPage;
import com.carbonite.qa.pages.HomeBackupPage;
import com.carbonite.qa.utils.DriverFactory;

public class AllProductsPageTest extends TestBase {
	HomeBackupPage hbp;
	AllProductsPage app;

	@BeforeMethod
	void setUp() {

		
		initialisation();
		hbp = new HomeBackupPage();
		app = hbp.clickAllProductsPageField();
		System.out.println("AllProductsPageTest class intialised");

	}

	@Test
	public void verifyColorOfLearnMoreButton()
	{  
		System.out.println("Thread id" + Thread.currentThread().getId());
		System.out.println("AllProductsPageTest class and  verifyColorOfLearnMoreButton Starts");
		String color =app.hoverOverLearnMoreButton();
		Assert.assertEquals(prop.getProperty("Learn_More_Button_Hex_Code"), color);
		
	}
	
	
	//String color = Color.fromString(rgbValue).asHex();
	
	
	
	@AfterMethod
	void teraDown() {
		System.out.println("Web Browser Is Quit#######################");
        //DriverFactory.getObject().removeDriver();
		
	}
}
