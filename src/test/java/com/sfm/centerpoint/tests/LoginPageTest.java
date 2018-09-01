package com.sfm.centerpoint.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfm.centerpoint.base.TestBase;
import com.sfm.centerpoint.pages.DashBoardPage;
import com.sfm.centerpoint.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialize();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void VerifyPageTitle()
	{
		String title = loginpage.LoginPageTitle();
		Assert.assertEquals("PageTitle is not matched", prop.getProperty("loginpagetitle"), title);
	}
	
	@Test(priority=2)
	public void VerifyPageURL()
	{
		String URL = loginpage.LoginPageURL();
		Assert.assertEquals("PageURLis not matched", "http://103.231.43.144/", URL);
	}
	
	@Test(priority=3)
	public void VerifyPageLogo()
	{
		boolean flag = loginpage.CenterpointLogo();
		Assert.assertTrue("CenterPoint Logo is not displayed", flag);
	}
	
	@Test(priority=4)
	public void VerifyLoginButtonText()
	{
		String buttonval = loginpage.LoginButtonText();
		Assert.assertEquals("Not Displayed Button Text As Expected", "Login", buttonval);
	}
	
	@Test(priority=5)
	public void Verify_Login()
	{
		dashboardpage = loginpage.PerformLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals("DashboardPage is not displayed after Login", prop.getProperty("dashboardurl"), driver.getCurrentUrl());
		loginpage.PerformLogout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		Reporter.log("Browser Closed",true);
	}

}
