package com.ttn.WebAutomation.tests.NW;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ttn.WebAutomation.base.BaseLib;
import com.ttn.WebAutomation.pageObjects.LoginPage;
import com.ttn.WebAutomation.pageObjects.SearchResultFor;
import com.ttn.WebAutomation.pageObjects.UEV; 

public class UEVTest extends BaseLib {
	public static WebDriver driver;
	public static LoginPage login;
	public static SearchResultFor searchFor;
	public static UEV uev;
	@Test
	public void UEV() throws IOException, InterruptedException {
		driver = getDriver();
		login = new LoginPage(driver);
		login.Login();
		searchFor = new SearchResultFor(driver);
		searchFor.searchResultTitle();
		searchFor.goToUev();
		uev = new UEV(driver);
		
//		assertion for is displayed for every webelement
		assertTrue(uev.nameIsDisplaying());
		assertTrue(uev.userDesignationIsDisplaying());
		assertTrue(uev.YOEIsDisplaying());
		assertTrue(uev.threeDotsIsDisplaying());
//		assertTrue(uev.profileIsDisplaying());
//		assertTrue(uev.resumeThreeDotsIsDisplaying());
//		assertTrue(uev.locationInThreeDotsIsDisplaying());
		assertTrue(uev.mobileNoIsDisplayed());
		assertTrue(uev.legalEntityIsDisplayed());
		assertTrue(uev.emailIsDisplaying());
		assertTrue(uev.businessUnitIsDisplaying());
		assertTrue(uev.newerIdIsDisplaying());
		assertTrue(uev.competencyIsDisplaying());
		assertTrue(uev.projectIsDisplaying());
//		assertTrue(uev.resumeIsDisplaying());
		
		
	}
	

}
