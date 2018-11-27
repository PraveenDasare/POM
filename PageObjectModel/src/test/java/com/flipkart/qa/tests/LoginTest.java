package com.flipkart.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.flipkart.qa.pages.BasePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.SearchResultPage;

import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest 
{
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	
	@BeforeMethod
	public void setUp()
	{
		basepage = new BasePage();
		driver = basepage.init();
		prop = basepage.init_properties();
		loginpage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	/*@Test
	public void verifylogintitletest()
	{
		String title = loginpage.getLoginPageTitle();
		System.out.println("title is "+ title);
		Assert.assertEquals(title, prop.getProperty("title"));
	}*/
	
	@Test
	public void loginTest()
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}

