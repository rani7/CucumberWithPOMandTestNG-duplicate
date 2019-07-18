package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;


public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase()
	{
		try{
			prop=new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Ranita\\workspace\\CucumberWithPOM\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Personal\\Selenium\\selenium_files\\chromedriver.exe");
			  driver = new ChromeDriver();	
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","D:\\Personal\\Selenium\\selenium_files\\geckodriver-v0.20.1-win32\\geckodriver.exe");  
			  driver = new FirefoxDriver();
		}	  
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	          driver.get(prop.getProperty("url"));
			
	}
	

}
