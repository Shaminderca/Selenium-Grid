package com.carbonite.qa.testcases;

import com.carbonite.qa.base.TestBase;
import com.carbonite.qa.pages.HomeBackupPage;
import com.carbonite.qa.pages.StartTrialHomeBackupPage;

public class StartTrialHomeBackupPageTest extends TestBase {

	HomeBackupPage hp;
	StartTrialHomeBackupPage sthp;

	void setUp() {
		initialisation();
		hp = new HomeBackupPage();
		sthp = hp.clickStartFreeTrialField();

	}
	
	
	
	
	

	void tearDown() {
		System.out.println("Web Browser Is Quit#######################");
		 driver.quit();
	}
}
