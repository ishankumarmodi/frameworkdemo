package com.demoaut.newtours.ddfPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signon {

	@FindBy(linkText="SIGN-ON")
	private WebElement signOn;
	
	public Signon(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getsignOn() {
		return signOn;
	}
}
