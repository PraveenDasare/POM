package com.flipkart.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.pages.BasePage;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class SearchResultTest
{
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	
	@BeforeMethod
	public void setUp()
	{
		basepage = new BasePage();
		driver = basepage.init();
		prop = basepage.init_properties();
		loginpage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void SerachResultPage()
	{
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
