package com.carbonite.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carbonite.qa.base.TestBase;

public class BusinessBackupPage extends TestBase {
	JavascriptExecutor jse ;
	public BusinessBackupPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
//Page Repository
	@FindBy(id="btn-compare-safe")
	WebElement comparePlansButton;
	
	@FindBy(id="btn-try-vsb")
	WebElement startAbusinessTrialButton;
	
	@FindBy(xpath="//img[@src ='/globalassets/images/icons/custom/devices-laptop.svg']")
	WebElement laptopLogo;
	
	@FindBy(css=".social-icon")
	List<WebElement> socialMediaIcons;
	
	
    public CompareBackupPlanPage clickOnComparePlans(){
    	comparePlansButton.click();
    	return new CompareBackupPlanPage();
    }
	
    public HomeBackupPage clickOnBusinessTrial() {
    	startAbusinessTrialButton.click();
    	return new  HomeBackupPage();
    }
    
    public boolean laptopLogoIsDisplayed() {
    	return laptopLogo.isDisplayed();
    }
    
    public String verifyColor() {
    	jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",socialMediaIcons);
    	String rgbValue = socialMediaIcons.get(1).getCssValue("background-color");
    	String color = Color.fromString(rgbValue).asHex();
		return color;
    }
    
	public String getPageTitle() {
		String titleOfThePage = driver.getTitle();
		return titleOfThePage;
	}

}
