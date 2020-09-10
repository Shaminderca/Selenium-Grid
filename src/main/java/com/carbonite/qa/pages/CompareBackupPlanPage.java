package com.carbonite.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carbonite.qa.base.TestBase;

public class CompareBackupPlanPage extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	JavascriptExecutor jse ;

	public CompareBackupPlanPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//button[@type='button' and @aria-checked='true' and @class='toggle-button j-option1 on']")
	WebElement iconNumberOne;

	@FindBy(xpath = "//button[contains(@class,'toggle-button j-option')]")
	List<WebElement> iconOfPlans;

	@FindBy(xpath = "//button[contains(text(),'Start home trial')]")
	public WebElement startHomeTrialButton;

	public String getPageTitle() {
		String titleOfThePage = driver.getTitle();
		return titleOfThePage;
	}

	public boolean clickOnIcons() {
		iconOfPlans.get(0).click();
	    wait.until(ExpectedConditions.visibilityOf(iconNumberOne));
		return iconNumberOne.isDisplayed();

	}

	public HomeBackupPage clickStartHomeTrialButton() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",startHomeTrialButton);
		startHomeTrialButton.click();
		return new HomeBackupPage();

	}

}
