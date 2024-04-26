package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame();
		contactsPage= homePage.validateContactsLink();
	}
	
	@Test(priority = 1)
	public void contactsLabelTest()
	{
		Boolean flag = contactsPage.valaidateContactsLabel();
		Assert.assertTrue(flag, "Contact label is not displaying");
	}
	
	@Test(priority = 2)
	public void selectContactsChkByNameTest()
	{
		contactsPage.selectContactsChkByName("Ravi M");
		Boolean flag = contactsPage.validateContactsChkSelectedByName("Ravi M");
		Assert.assertTrue(flag,"Selelcted name checkbox is not selelcted");
		
	}
	
	@Test(priority = 3)
	public void searchContactTest() throws InterruptedException
	{
		Thread.sleep(3000);
		//contactsPage.searchContact("Active","Ravi M",);
		Boolean flag= contactsPage.ValidateContactsChkByName("Ravi M");
		Assert.assertTrue(flag,"Selelcted name is not present");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
