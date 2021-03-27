package TestCases_PageEntity;

import Utilities.TestDataProvider;

public class LoginPageEntity 
{

	private String userName ;
	private String password ;
	
	public LoginPageEntity(String sheetName) 
	{
		TestDataProvider.syncPageData(this, sheetName);
	}

	public String getUserName() 
	{
		return userName;
	}

	public String getPassword() 
	{
		return password;
	}
}