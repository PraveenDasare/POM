package com.flipkart.qa.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.pages.BasePage;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.PaymentPage;

public class HomePageTest 
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Flow1()
	{
		new HomePage(driver).LoadApplicationINHomePage();
		new HomePage(driver).SearchProduct();
		new HomePage(driver).AddtoCart();
		new LoginPage(driver).CommonLoginFunction(new PaymentPage(driver));		
				
	}
	
	@Test
	public void Flow2()
	{
		new HomePage(driver).LoadApplicationINHomePage();
		new LoginPage(driver).CommonLoginFunction(new HomePage(driver));
		new HomePage(driver).SearchProduct();		
	}	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	} 

}
