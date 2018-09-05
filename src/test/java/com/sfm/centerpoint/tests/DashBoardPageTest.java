package com.sfm.centerpoint.tests;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfm.centerpoint.base.TestBase;
import com.sfm.centerpoint.pages.DashBoardPage;
import com.sfm.centerpoint.pages.LoginPage;

import junit.framework.Assert;

public class DashBoardPageTest extends TestBase{
	
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	
	public DashBoardPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialize();
		loginpage = new LoginPage();
		dashboardpage = loginpage.PerformLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test()
	public void VerifyDashboardPage()
	{
		boolean flag = dashboardpage.SFMLogo();
		Assert.assertFalse("SFMLogo is not displayed", flag);
	}

	@AfterMethod
	public void tearDown()
	{
		loginpage.PerformLogout();
		driver.quit();
		Reporter.log("Browser Closed",true);
	}
}
