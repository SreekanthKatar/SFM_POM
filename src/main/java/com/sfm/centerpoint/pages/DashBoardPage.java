package com.sfm.centerpoint.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfm.centerpoint.base.TestBase;

public class DashBoardPage extends TestBase{
	
	@FindBy(xpath="//img[@class='mainlogo']")
	WebElement SFMLogo;

	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean SFMLogo() {
		
		return SFMLogo.isDisplayed();
		
	}
}
