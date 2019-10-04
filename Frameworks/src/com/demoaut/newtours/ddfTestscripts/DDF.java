package com.demoaut.newtours.ddfTestscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoaut.newtours.ddfPages.Login;
import com.demoaut.newtours.ddfPages.Signon;

import utils.ReadExcel;

public class DDF {

	WebDriver driver;
		
	@BeforeTest	
	public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.newtours.demoaut.com/");
}
	
	@Test
	
	public void userValidationTest() throws IOException {
		Login lp = new Login(driver);
		Signon so = new Signon(driver);
		String[][] data = ReadExcel.getData("testdata.xlsx", "Sheet1");
		for (int i=1; i<data.length; i++) {
			String username = data[i][1];
			String password = data[i][2];
			lp.applicationLogin(username, password);
			boolean signonvisible = so.getsignOn().isDisplayed();
			Assert.assertTrue(signonvisible);
			}
				
	}
	
	@AfterTest
	public void closeBrowser() {
	driver.close();
	}
	
}
