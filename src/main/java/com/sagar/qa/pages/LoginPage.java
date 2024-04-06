package com.sagar.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sagar.qa.base.TestBase;

public class LoginPage extends TestBase{

//	Page Factory - OR-> object repository
	
	@FindBy(id ="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(xpath ="//button[@name='login' ]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@role='button' and @id='u_0_0_tS']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[@class='fb_logo _8ilh img']")
	WebElement fbLogo;
	
//	Initializing the Page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFbLogo() {
		return fbLogo.isDisplayed();
	}
	
	public HomePage login(String email, String pass) {
		this.email.sendKeys(email);
		this.pass.sendKeys(pass);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
}
