package com.carbonite.qa.utils;

import org.openqa.selenium.WebDriver;
    
public class DriverFactory {
	
	private DriverFactory()
	{
		 
	}
	private static DriverFactory object = null;
	
	public static DriverFactory getObject()
	{
		if(object==null)
		{
			object=new DriverFactory();
		}
		return object;
		
	}
	ThreadLocal<WebDriver> driver = new  ThreadLocal<WebDriver>();//thread local driver object for webdriver
	
	public WebDriver getDriver()//call this method to get the driver object and launch the browser
	{
		return driver.get();
		
	}
	
	public void setDriver(WebDriver driverParam)//call this method to set the driver object
	{
		driver.set(driverParam);
	}
	
	public void removeDriver()//Quits the driver and close the browser
	{
		driver.get().quit();
		driver.remove();
	}

}
