package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, "Free CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority = 2)
	public void crmImageTest()
	{
		Boolean bool = loginPage.validateCRMImage();
		Assert.assertTrue(bool);		
	}
	
	@Test(priority = 3)
	public void signUpLinkTest()
	{
		Boolean flag  =loginPage.validateSignUpLink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
