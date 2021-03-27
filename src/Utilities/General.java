package Utilities;

import java.io.File;

import atu.testng.reports.ATUReports;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;

public class General

{
	protected static WebDriver driver;
	public static StringBuffer verificationErrors = new StringBuffer() ;
	protected static Properties pro = new Properties();
	protected static Logger log = Logger.getLogger("");
	public static File currentDir = new File("");
	{System.setProperty("atu.reporter.config", currentDir.getAbsolutePath()+ "\\resources\\atu.properties");}
	
	public void readPropFile()
	{
		try
		{
			 InputStream stream = new FileInputStream(new File(currentDir.getAbsolutePath()+"\\resources\\PageObjectFramework.properties"));
			 pro.load(stream);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		


	}
	
	public void getBrowser() throws Exception
	{
		readPropFile();
		
		String browser= pro.getProperty("browser");
		if (browser.equals("FF"))
	  	{
			driver = new FirefoxDriver();
			log.info("Start Test Using FireFox");
		}
		else if (browser.equals("IE"))
		{	
			System.setProperty("webdriver.ie.driver", pro.getProperty("IEDriverServer"));
			driver = new InternetExplorerDriver();
			log.info("Start Test Using Internet Explorer");
		}
		else if (browser.equals("CH")) 
		{
			System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriverServer"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Start Test Using Chrome");
		}
		else 
		{
			System.out.println("No Browser Found");
			log.info("No Browser Found");
		}	
		ATUReports.setWebDriver(driver);

	}
		
	public void getURL(String link)
	{
		readPropFile();
		log.info("Start Test Using URL: " + pro.getProperty(link));
		driver.manage().window().maximize();
		driver.get(pro.getProperty(link));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	
	public String trimFluentwait(String value)
	 {
	  if (value.contains("xpath"))
	  {
	   value = value.substring(value.lastIndexOf(":"));
	   value = value.substring(1,value.length()-1);
	  }
	  else
	  {
	   value = value.substring(value.lastIndexOf(":"));
	   value = value.substring(1,value.length()-1).trim();
	  }
	  return value;
	 }
	
	public void fluentlyWait(FluentWait<By> fluentWait) {
		  fluentWait.pollingEvery(500, TimeUnit.MILLISECONDS);
		  fluentWait.withTimeout(10, TimeUnit.MINUTES);
		  fluentWait.until(new Predicate<By>() {
		   public boolean apply(By by) {
		    try {
		     return driver.findElement(by)!=null;
		    } catch (NoSuchElementException ex) {
		     System.out.println("Fluentwait no such element");
		     return false;
		    }
		   }
		  });
		 }

	
}
