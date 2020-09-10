package com.carbonite.qa.utils;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactoryTwo {
	private static String grid ="http://192.168.0.25:4444/wd/hub";
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static synchronized void newDriver()
	{
		ChromeOptions options = new ChromeOptions();
	    try {
			driver.set(new RemoteWebDriver(new URL(grid), options));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //driver = new RemoteWebDriver(new URL(hubUrl),op);
	}
   
	public static synchronized WebDriver getDriver() {
		return driver.get();
	}
}
