package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FrameworkUtility;

public class BasePage extends FrameworkUtility {

	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement AccountandListsButton;
	
	
	
	public  BasePage login() throws NoSuchFieldException
	{
		String UserName = readConfigurationFile("UserName");
		String Password = readConfigurationFile("Password");
		AccountandListsButton.click();
		return new BasePage(driver);
	}
	
}
