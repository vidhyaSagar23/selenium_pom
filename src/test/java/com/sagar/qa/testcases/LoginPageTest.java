package com.sagar.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sagar.qa.base.TestBase;
import com.sagar.qa.pages.HomePage;
import com.sagar.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	public LoginPage loginPage;
	public HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test
	public void fbLogoTest() {
		boolean flag = loginPage.validateFbLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest() {
	homePage = loginPage.login(props.getProperty("email"), props.getProperty("password"));
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
