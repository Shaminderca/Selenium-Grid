package com.carbonite.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.carbonite.qa.base.TestBase;

public class HomeBackupPage extends TestBase {

	public HomeBackupPage() {
		PageFactory.initElements(driver, this);
	}

	// Object Repository

	@FindBy(name = "Email")
	WebElement inputEmailField;

	@FindBy(name = "confirmEmail")
	WebElement inputConfirmEmailField;

	@FindBy(name = "Password")
	WebElement inputPasswordField;

	@FindBy(name = "ConfirmPassword")
	WebElement inputConfirmPasswordField;

	@FindBy(name = "Country")
	WebElement inputCountryField;

	@FindBy(css = ".button.sm-btn.green-btn")
	WebElement submitButton;

	@FindBy(xpath = "//a[@title ='Business solutions']")
	WebElement businessSolutionFiled;

	@FindBy(xpath = "//a[@title='Compare backup plans']")
	WebElement compareBackupPlanField;

	@FindBy(xpath = "//a[@title ='All products']")
	WebElement allProductFiled;

	@FindBy(xpath = "//a[@title ='Free Trials']")
	WebElement freeTrialsFiled;

	@FindBy(xpath = "//*[text()='Start Trial']")
	WebElement startTrialField;
	
	
	//@FindBy(xpath="//nav[@class='main']/ul")
	

	public void inputValuesInTheField(String email, String confirmEmail, String password, String confirmPassword) {
		inputEmailField.sendKeys(email);
		inputConfirmEmailField.sendKeys(confirmEmail);
		inputPasswordField.sendKeys(password);
		inputConfirmPasswordField.sendKeys(confirmPassword);
	}

	public void selectDropDown() {
		Select obj = new Select(inputCountryField);
		obj.selectByIndex(2);
	}

	public DownloadPage clickSubmitButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
		return new DownloadPage();

	}

	public AllProductsPage clickAllProductsPageField() {
		allProductFiled.click();
		return new AllProductsPage();

	}

	public BusinessBackupPage clickBusinessBackupPageField() {
		businessSolutionFiled.click();
		return new BusinessBackupPage();

	}

	public CompareBackupPlanPage clickCompareBackupPlanPageField() {
		compareBackupPlanField.click();
		return new CompareBackupPlanPage();

	}

	public FreeTrialPage clickFreeTrialPageField() {
		freeTrialsFiled.click();
		return new FreeTrialPage();
	}

	public StartTrialHomeBackupPage clickStartFreeTrialField() {

		startTrialField.click();
		return new StartTrialHomeBackupPage();

	}

}
