package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//On same browser if we execute 100 testcases browser will be exhausted 
	//Leads to memory issue, cookies or cache issue becuase we are not delelting
	//browser will be crashed or become slow
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page not matching");
	}
	
	@Test(priority=2)
	public void userNameLabelTest()
	{
		testUtil.swithToFrame();
		Boolean flag=homePage.validateUserNameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void contactsLinkTest()
	{
		testUtil.swithToFrame();
		contactsPage = homePage.validateContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
