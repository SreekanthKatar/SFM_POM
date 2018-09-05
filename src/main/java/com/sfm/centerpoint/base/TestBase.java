package com.sfm.centerpoint.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Reporter;

import com.sfm.centerpoint.utils.TestUtil;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream("D:\\Repositories\\SFM_POM\\src\\main\\java\\com\\sfm\\centerpoint\\config\\config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			Reporter.log("Launching Chrome Browser..",true);
			System.setProperty("webdriver.chrome.driver", "D:\\Repositories\\SFM_POM\\src\\main\\java\\com\\sfm\\centerpoint\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome Browser Launched",true);
		}
		else if(browserName.equals("firefox"))
		{
			Reporter.log("Launching Firefox Browser..",true);
			System.setProperty("webdriver.gecko.driver", "D:\\Repositories\\SFM_POM\\src\\main\\java\\com\\sfm\\centerpoint\\browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
			Reporter.log("Firefox Browser Launched",true);
		}
		else if (browserName.equals("opera")) {
			Reporter.log("Launching Opera Browser..",true);
			System.setProperty("webdriver.opera.driver", "D:\\Repositories\\SFM_POM\\src\\main\\java\\com\\sfm\\centerpoint\\browsers\\operadriver.exe");
			driver = new OperaDriver();
			Reporter.log("Opera Browser Launched",true);
		}
		else if (browserName.equals("ie")) {
			Reporter.log("Launching Internet Explorer Browser..",true);
			System.setProperty("webdriver.ie.driver", "D:\\Repositories\\SFM_POM\\src\\main\\java\\com\\sfm\\centerpoint\\browsers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("IE Browser Launched",true);
		}
		else {
			Reporter.log("No Browser Driver for Browser Instance..!!",true);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("appurl"));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
