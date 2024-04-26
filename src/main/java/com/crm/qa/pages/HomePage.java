package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'User: Rad N')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUserNameLabel()
	{
		return userNameLabel.isDisplayed();
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public ContactsPage validateContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage ValidateDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactLink() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
		
	}
}
