package com.ttn.WebAutomation.tests.NW;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ttn.WebAutomation.base.BaseLib;
import com.ttn.WebAutomation.pageObjects.LoginPage;
import com.ttn.WebAutomation.pageObjects.SearchResultFor;

public class SearchResultFuncTest extends BaseLib {
	public static WebDriver driver;
	public static LoginPage login;
	public static SearchResultFor searchResultFor;

	@Test
	public void searchResultIsDisplayed() throws InterruptedException, IOException {
		driver = getDriver();
		login = new LoginPage(driver);
		login.Login();
		searchResultFor = new SearchResultFor(driver);
		String searchResultTitle = searchResultFor.searchResultTitle();
		
		assertEquals(searchResultTitle,"Search Results");
		Thread.sleep(5000);
//		assertEquals(searchResultFor.resultForName(),"Results for “bhanu gusain”");

	}
}
