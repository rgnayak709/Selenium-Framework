package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;

public class ContactsPage extends TestBase{
	TestUtil testUtil;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@CacheLookup  //store in cache memory, when called it will not look in dom directly looks in cache.Script performance will be fast
	//Disadvantage: If page gets refresh all the cache elements wil get corrupted, give stale element exception
	WebElement contactsLabel;
	
	@FindBy(name = "cs_status")
	WebElement statusDrpDwn;
	
	@FindBy(name = "cs_name")
	WebElement name;
	
	@FindBy(name ="cs_company_name")
	WebElement company;
	
	@FindBy(xpath = "//input[@name='cs_submit' and @value='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//input[@value='New Contact']")
	WebElement newContactBtn;
		
	private WebElement getContactName(String name)
	{
		WebElement contactsChkByName =  driver.findElement(By.xpath("//a[text()='"+name+"']//..//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		return contactsChkByName;
	}
																																																																																																										
	public ContactsPage()																																																																						
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean valaidateContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	

	
	
	public Boolean ValidateContactsChkByName(String name)
	{
		//WebElement contactsChkByName =  driver.findElement(By.xpath("//a[text()='"+name+"']//..//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		
		return getContactName(name).isDisplayed();
	}
	
	public void selectContactsChkByName(String name)
	{
		//WebElement chkBox =  driver.findElement(By.xpath("//a[text()='"+name+"']//..//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		WebElement chkBox = getContactName(name);
		chkBox.click();		
	}
	
	public Boolean validateContactsChkSelectedByName(String name)
	{
		//WebElement chkBox =  driver.findElement(By.xpath("//a[text()='"+name+"']//..//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		WebElement chkBox = getContactName(name);
		return chkBox.isSelected();		
	}
	
//	public void searchContact(String title, String fName)
//	{
//		//testUtil.selectDropDownValues(statusDrpDwn,title);
//			Select select =new Select(statusDrpDwn);
//			select.selectByVisibleText(title);
//		name.sendKeys(fName);
//		searchBtn.click();
//	}
	
	public void searchContact(String fName,String lName,String companyName,String status)
	{
		//testUtil.selectDropDownValues(statusDrpDwn,title);
			Select select =new Select(statusDrpDwn);
			select.selectByVisibleText(status);
		name.sendKeys(fName+" "+lName);
		company.sendKeys(companyName);
		searchBtn.click();
	}
	
	public NewContactsPage clickOnNewContactBtn()
	{
		newContactBtn.click();
		return new NewContactsPage();
	}
	
	
}
