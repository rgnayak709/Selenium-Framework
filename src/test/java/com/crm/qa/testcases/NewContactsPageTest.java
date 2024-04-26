package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utilities.TestUtil;

public class NewContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	NewContactsPage newContactsPage;
	String sheetName= "Contacts";
	
	public NewContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		newContactsPage = new NewContactsPage();
		contactsPage = new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame();
		contactsPage= homePage.validateContactsLink();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException
	{
		Object data[][] =testUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 1,dataProvider = "getCRMTestData")
	public void createNewContacts(String title,String firstname,String lastname,String company,String status) throws InterruptedException
	{
	    contactsPage.clickOnNewContactBtn();
	    Thread.sleep(3000);
	    newContactsPage.createNewContact(title,firstname,lastname,company,status);
	    homePage.validateContactsLink();  
	    contactsPage.searchContact(firstname,lastname,company,status);
	    Boolean flag= contactsPage.ValidateContactsChkByName(firstname+" "+lastname);
		Assert.assertTrue(flag,"Selelcted name is not present");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
