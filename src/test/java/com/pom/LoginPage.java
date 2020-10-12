package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver){
		super(driver);
	}

	@FindBy(id="ap_email")
	private WebElement EmailTextbox;
	
	@FindBy(id="ap_email")
	private WebElement ContinueButton;
	
	public  BasePage login() throws NoSuchFieldException
	{
		String UserName = readConfigurationFile("UserName");
		String Password = readConfigurationFile("Password");
		enterText(EmailTextbox, UserName);
		clickElement(ContinueButton);
		return new BasePage(driver);
	
	}
	
	public void enterText(WebElement webelement, String value) {
		webelement.clear();
		webelement.sendKeys(value);
	}
	
	public void clickElement(WebElement webelement) {
		webelement.click();
	}
	
}
