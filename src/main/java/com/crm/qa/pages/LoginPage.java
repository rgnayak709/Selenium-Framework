package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repo
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginSubmit;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath = "(//img[contains(@class,'img-responsive')] )[1]")
	WebElement crmImage;
	
	//Initializing the page objects:
	
	//this - Pointing to the current class objects.
	//instead of this we can also use LoginPage.class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	//Get login page title
	public String  validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	//Validate CRM logo
	public boolean validateCRMImage()
	{
		return crmImage.isDisplayed();
	}
	
	//Validate Sign Up link
	public boolean validateSignUpLink()
	{
		return signUpLink.isEnabled();
	}
	
	public HomePage login(String txtUsername, String txtPassword)
	{
		username.sendKeys(txtUsername);
		password.sendKeys(txtPassword);
		loginSubmit.click();
		
		return new HomePage();
	}
	
}
