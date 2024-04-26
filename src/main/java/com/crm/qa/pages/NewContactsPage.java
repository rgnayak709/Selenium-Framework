package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;

public class NewContactsPage extends TestBase{
	TestUtil testUtil;
	
	@FindBy(name = "title")
	WebElement titleDrpDwn;
	
	@FindBy(name = "first_name")
	WebElement first_Name;
	
	@FindBy(name = "surname")
	WebElement last_Name;
	
	@FindBy(name ="client_lookup")
	WebElement company;
	
	@FindBy(name ="status")
	WebElement statusDrpDwn;
	
	@FindBy(xpath = "//form[@name='contactForm']//input[@value='Save' and @type='submit']")
	WebElement saveBtn;
	
	public NewContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact( String title,String fName,String lName,String companyName, String status)
	{
		Select select =new Select(titleDrpDwn);
		select.selectByVisibleText(title);
		first_Name.sendKeys(fName);
		last_Name.sendKeys(lName);
		company.sendKeys(companyName);
		select =new Select(statusDrpDwn);
		select.selectByVisibleText(status);
		saveBtn.click();
		
	}

}
