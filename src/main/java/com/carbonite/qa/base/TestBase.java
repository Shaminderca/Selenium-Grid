package com.carbonite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.BeforeClass;

import com.carbonite.qa.utils.DriverFactory;
import com.carbonite.qa.utils.DriverFactoryTwo;
import com.carbonite.qa.utils.Utils;
import com.carbonite.qa.utils.WebEventsListener;

public class TestBase {
	
public static WebDriver driver=null;
public static Properties prop;
public static Logger logger;
public static EventFiringWebDriver edriver;
public static WebEventsListener eventListener;


public TestBase() {
	
	
	
	prop = new Properties();
	FileInputStream fis;//this should be discussed
	
	try {
		fis = new FileInputStream("C:\\Project\\CarboniteQA\\src\\main\\java\\com\\carbonite\\qa\\configuration\\config.properties");
		prop.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



@BeforeClass
public void loggersetUp() {
	logger = Logger.getLogger(TestBase.class);//instatnsation of class
	PropertyConfigurator.configure("log4j.properties");
	//BasicConfigurator.configure(); 
	logger.setLevel(Level.DEBUG);
	
}

public void initialisation()  {
	
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName("chrome");
	//cap.setVersion("85.0.4183.83");
	cap.setPlatform(Platform.WINDOWS);

	//2 set chrome optiond
   //   ChromeOptions op = new ChromeOptions();
	//FirefoxOptions op = new FirefoxOptions();
//	op.merge(cap);
	
	//String hubUrl = "http://192.168.0.25:4444/wd/hub";
	//WebDriver driver = new RemoteWebDriver(new URL(hubUrl),op);
	
	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		DriverFactoryTwo.newDriver();
		driver = DriverFactoryTwo.getDriver();
		
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		System.out.println("Broswer Not Avalaible");
	}
	else
	{
		System.out.println("Broswer Not Avalaible");
	}
	
	
	//edriver = new EventFiringWebDriver(driver);
	//eventListener = new WebEventsListener();
	//edriver.register(eventListener);
	//driver=edriver;
	
	driver.manage().window().maximize();
 	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOADOUT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	//logger.info("=====Application Started=====");
	driver.get(prop.getProperty("url"));
	
	
}
}
