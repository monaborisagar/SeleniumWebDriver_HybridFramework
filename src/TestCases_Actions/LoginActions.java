package TestCases_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import TestCases_PageEntity.LoginPageEntity;
import TestCases_PageObject.LoginPageObject;
import Utilities.General;

public class LoginActions extends General 
{
	
	private LoginPageObject loginobject = new LoginPageObject();
	private LoginPageEntity loginentity ;
	
	
	public void login(String sheetName) 
	{
		//loginobject = PageFactory.initElements(driver, LoginPageObject.class);
		loginentity = new LoginPageEntity(sheetName);
		LoginPageObject.Close_button_startpopup.click();
		loginobject.Link_login.click();
		
	}
		
	
	
	
}
	