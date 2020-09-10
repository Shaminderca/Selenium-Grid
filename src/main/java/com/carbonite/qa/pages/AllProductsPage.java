package com.carbonite.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carbonite.qa.base.TestBase;

public class AllProductsPage extends TestBase {

	public AllProductsPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	//ObjectRepositry
	
	@FindBy(id="hero-btn-cyber-pg")
	WebElement learnMoreButton;

	
	//Methods
	public String getPageTitle() { 
		String titleOfThePage = driver.getTitle();
		return titleOfThePage;
	}
	
	public String hoverOverLearnMoreButton() {
		Actions a =  new Actions(driver);
	    a.moveToElement(learnMoreButton).build().perform();
	    String rgbaValue = learnMoreButton.getCssValue("background-color");
	    String color = Color.fromString(rgbaValue).asHex();
	  //  System.out.println(color);
	    return color;
	    
		
	}

	//String color = Color.fromString(rgbValue).asHex();
}
