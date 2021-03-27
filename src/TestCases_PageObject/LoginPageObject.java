package TestCases_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.General;


public class LoginPageObject extends General
{
	
// Method -  1
	//public WebElement Close_button_visible = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.close")));
	
	@FindBy(how = How.XPATH, using = ".//*[@id='modal']/button")
	public static WebElement Close_button_startpopup ;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='top']/body/div[1]/div[1]/div/div[1]/div/div[1]/div/a[4]/span")
	public  static WebElement Link_login ;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='email']")
	public WebElement txtUserName ;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pass']")
	public WebElement txtPassword ;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='send2']")
	public WebElement btnOK ;
    
//	@FindBy(how = How.XPATH, using = ".//*[@id='wrapper']/div[1]/div[2]/div/form/div[7]/span[2]/a")
//	public WebElement registerLink ;
//	
//	@FindBy(how = How.XPATH, using = ".//*[@id='wrapper']/div[1]/div[2]/div/form/div[7]/span[1]/a")
//	public WebElement recoverPasswordLink ;

	
	
// Method -  2	
//	private static WebElement element;
//
//	public WebElement txtUserName()  
//	{
//		try 
//		{
//			fluentlyWait(new FluentWait<By>(By.id("UserName")));
//			element = driver.findElement(By.id("UserName"));
//			log.info("Username text box is found on the Login Page");
//		} 
//		catch (Exception e) 
//		{
//			log.error("UserName text box is not found on the Login Page");
//			throw (e);
//		}
//		return element;
//	}

}
