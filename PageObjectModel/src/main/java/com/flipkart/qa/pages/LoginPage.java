package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//import com.flipkart.qa.tests.HomePage;

public class LoginPage extends BasePage
{
	
	@FindBy(xpath="//input[@autocomplete='off' and @class='_2zrpKA' and @type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@autocomplete='off' and @type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit' and @class ='_2AkmmA _1LctnI _7UHT_c']")
	WebElement Login_Btn;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}	
	
	
	public HomePage login(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Login_Btn.click();			
		return new HomePage(driver);			
		
	}
	
	public <T> T CommonLoginFunction(T page){
		username.sendKeys("");
		password.sendKeys("");
		Login_Btn.click();	      
	    return page;
	  }
	
	public <T> T readDataObject(T T)
	{
		return T;
	}
	
	
	
}
