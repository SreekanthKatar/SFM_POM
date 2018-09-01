package com.sfm.centerpoint.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.sfm.centerpoint.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@id='Username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="/html/body/div/center/a/img")
	WebElement CP_Logo;
	
	@FindBy(xpath="//*[contains(text(),'Sales Force Management System')]")
	WebElement MainHeading;
	
	@FindBy(xpath="//*[@id=\"mainnav\"]/nav/div/div[2]/ul/li[3]/a")
	WebElement Profile;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String LoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String LoginPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String LoginPageMainHeading() 
	{
		return MainHeading.getText();
	}
	
	public String LoginButtonText()
	{
		return LoginButton.getText();
	}
	
	public boolean CenterpointLogo()
	{
		return CP_Logo.isDisplayed();
	}
	
	public DashBoardPage PerformLogin(String username, String password)
	{
		UserName.click();
		UserName.sendKeys(username);
		
		Password.click();
		Password.sendKeys(password);
		
		LoginButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Reporter.log("Login Performed Successfully..!!!",true);
		return new DashBoardPage();
	}
	
	public void PerformLogout() {
		Profile.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logout.click();
		Reporter.log("Logout Performed Successfully..!!!",true);
	}
	
}
