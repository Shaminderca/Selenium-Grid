package com.carbonite.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carbonite.qa.base.TestBase;

public class DownloadPage extends TestBase {

	public DownloadPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@alt ='Carbonite download']")
	public WebElement downloadPageImage;

	public String getPageTitle() {
		String titleOfThePage = driver.getTitle();
		return titleOfThePage;
	}

}
