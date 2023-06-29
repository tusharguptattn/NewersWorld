package com.ttn.WebAutomation.tests.NW;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ttn.WebAutomation.base.BaseLib;
import com.ttn.WebAutomation.pageObjects.LogTicket;
import com.ttn.WebAutomation.pageObjects.LoginPage;

public class LogTicketTest extends BaseLib {
	WebDriver driver;
	LoginPage login;
	LogTicket log;
	
	
	@Test
	public void logticketTest() throws IOException, InterruptedException {
		driver = getDriver();
		login = new LoginPage(driver);
		login.Login();
		log = new LogTicket(driver);
		log.logTicketFunc();
		
//		assertEquals(count.get(1),count.get(0));
		
	}
}
