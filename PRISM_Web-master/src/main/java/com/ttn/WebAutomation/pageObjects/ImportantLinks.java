package com.ttn.WebAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportantLinks {
	@FindBy(css="a[class='active'] span[class='nav_text']")
	WebElement importantLinks;

}
