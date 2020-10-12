package com;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import com.FrameworkConstants;
import com.pom.BasePage;
import com.pom.LoginPage;

public class FrameworkUtility {

	public WebDriver driver;
	public  String URL;
	protected static Properties properties;
	public  Actions action;
	
	@BeforeClass(alwaysRun=true)
	public void initializeDriver() throws NoSuchFieldException {
		URL = readConfigurationFile("URL");
		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		BasePage basepage=login.login();
	}
	
	public static synchronized String readConfigurationFile(String key) throws NoSuchFieldException {
		try{
			properties = new Properties();
			properties.load(new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH));
			return properties.getProperty(key).trim();	
		} catch (Exception e){
			throw new NoSuchFieldException("Cannot find key: "+key+" in Config file.");
		}
	}
}
