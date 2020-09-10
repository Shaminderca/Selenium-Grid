package com.carbonite.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carbonite.qa.base.TestBase;

public class FreeTrialPage extends TestBase {

	public FreeTrialPage() {
		PageFactory.initElements(driver, this);
	}

//object repository
	@FindBy(id = "btn-home-trial")
	WebElement startFreeTrialButton;

	@FindBy(xpath = "//*[text()='Learn more']")
	WebElement learnMoreButton;

	@FindBy(xpath = "//h1[text()='Select a free trial']")
	WebElement headingDispaly;

	// @FindBy(xpath = "//*[text()='15 day trial']")
	@FindBy(xpath = "//div[@class='col-sm-12 col-md-6']//div[@class='media media-style10']//p//em[.='15 day trial']")
	WebElement fifteenDayTrialHeading;
//methods

	public StartTrialHomeBackupPage clickOnStartFreeTrialButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", startFreeTrialButton);
		startFreeTrialButton.click();
		return new StartTrialHomeBackupPage();
	}

	public HomeBackupPage clickOnLearnMoreButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", learnMoreButton);
		learnMoreButton.click();
		return new HomeBackupPage();

	}

	public String getPageTitle() {
		String titleOfThePage = driver.getTitle();
		return titleOfThePage;
	}

	public boolean headingDispalyMethod() {
		return headingDispaly.isDisplayed();

	}

	public String headingComaprision() {
		String valueTwo = fifteenDayTrialHeading.getText();
		return valueTwo;    

	}
}
