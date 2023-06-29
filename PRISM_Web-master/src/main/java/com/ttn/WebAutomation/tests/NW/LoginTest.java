package com.ttn.WebAutomation.tests.NW;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ttn.WebAutomation.base.BaseLib;
import com.ttn.WebAutomation.pageObjects.LoginPage;

public class LoginTest extends BaseLib { 
	LoginPage loginpage;
	WebDriver driver;
//	HomePageTest homepage;
//	SearchResultFuncTest searchResult;
//	UEVTest uevTest;
	
	@Test
	public void loginPageTitleTest() throws InterruptedException, IOException {	
		driver = getDriver();
		loginpage = new LoginPage(driver);
//		homepage = new HomePageTest();
//		searchResult = new SearchResultFuncTest();
//		uevTest = new UEVTest();
//		String title = driver.getTitle();
//		assertEquals(title,"Newersworld");
//		loginpage.Login();
//		homepage.HomePageTests();
//		searchResult.searchResultIsDisplayed();
//		uevTest.UEV();
		
	}

}
