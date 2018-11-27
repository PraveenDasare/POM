package com.flipkart.qa.pages;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthStyle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage 
{
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement homePageHeadr;
	
	@FindBy(xpath="//input[@type='text' and @class='LM6RPg']")
	WebElement Search_Feild;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Search_Button;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePagrTilte()
	{
		return driver.getTitle();
	}
	
	public SearchResultPage SearchProduct() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Search_Feild.sendKeys("Trimmer");
		Search_Button.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SearchResultPage(driver);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void AddtoCart()
	{
		System.out.println("Adding to cart");
	}
	
	public String CheckHomePageHeadder()
	{
		if(homePageHeadr.isDisplayed())
		{
			System.out.println("ee loude " + homePageHeadr.getText());
			return homePageHeadr.getText();
		}
		
		else
		{
			return null;
			
		}
		 
	}
	
	public HomePage LoadApplicationINHomePage()
	{
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
	public LoginPage clickLoginlinkinHomePage()
	{
		//since flipkart has a pop page pop, i am just writing flow
		System.out.println("Login clicked and naviageted to login page");
		return new LoginPage(driver);
	}

}
