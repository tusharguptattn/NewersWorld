package com.ttn.WebAutomation.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ttn.WebAutomation.base.BaseLib;
import com.ttn.WebAutomation.seleniumUtils.WaitStatementLib;


public class Homepage extends BaseLib {
	WebDriver driver;
	
	@FindBy(xpath = "(//a[@href='#/home'])[1]")
	WebElement NWlogo;
	@FindBy(xpath="(//a[@href='#/home'])[2]")
	WebElement home;
	
	@FindBy(xpath = "(//input[@placeholder=\"Search for Newers, Posts and Hashtags\"])[1]")
	WebElement searchNewer;

	@FindBy(xpath = "//div[@id=\"step4\"]/span")
	WebElement LogTicketLogo;
	
	@FindBy(xpath = "//div[@id='step5']/span")
	WebElement NotificationLogo;
	
	@FindBy(xpath = "//div[@id='step6']/span")
	WebElement ApplicationDrawerLogo;
	
	@FindBy(xpath = "(//img[@alt=\"Profile Pic\"])[1]")
	WebElement MyProfileLogo;
	
	@FindBy(xpath = "//input[@placeholder='What’s on your mind?']")
	WebElement WhatsOnYourMind;
	
	@FindBy(xpath = "(//span[@class='text_gestures'])[1]")
	WebElement PhotoAndVideo;
	
	@FindBy(xpath = "//div[@class='picture_gestures ng-star-inserted']/span[2]")
	WebElement RecognizeLogo;
	
	@FindBy(xpath = "(//span[@class=\"like-icon reactions_icon ng-star-inserted\"])[1]")
	WebElement FirstPostLikeButton;
	
	@FindBy(xpath = "(//div[@class='comment_reaction reactions_box'])[1]")
	WebElement FirstPostCommentButton;
	
	@FindBy(xpath = "(//textarea[@id='firstNameField'])[1]")
	WebElement FirstPostCommentArea;
	
	@FindBy(xpath = "//span[contains(text(),'Manage My Time')]")
	WebElement managemytime;

	@FindBy(xpath = "//span[contains(text(),'My Tickets')]")
	WebElement mytickets;

	@FindBy(xpath = "//span[contains(text(),'Important Links')]")
	WebElement implinks;

	@FindBy(xpath = "//span[contains(text(),'Org Chart')]")
	WebElement orgchart;
	
	@FindBy(xpath="//button[normalize-space()='LOG OUT']")
	WebElement logOutButtonMiniProfile;
	
	@FindBy(css="input[placeholder='Search here']")
	WebElement insideImportantLinkSearchBar;
	
	public Homepage(WebDriver driver) throws IOException
	{
		this.driver = driver; 
		PageFactory.initElements(driver,this);
//		wd = new WebDriverWait(wd1, Duration.ofSeconds(10)); 
	}
	
	
	public String ValidateTitle() throws InterruptedException {
		WaitStatementLib.explicitWaitForVisibility(driver, 10,NWlogo);
//		Thread.sleep(5000);
		return driver.getTitle();
	}
	
	public boolean nwLogo () throws InterruptedException {
//		Thread.sleep(3000);
		return NWlogo.isDisplayed();
	}
	
	public boolean searchNewerFuncIsDisplayed() throws IOException {
		return searchNewer.isDisplayed();	
	}
	
	
	
	public boolean logTicketLogoIsDisplayed() throws InterruptedException{
//		Thread.sleep(3000);
		return LogTicketLogo.isDisplayed();
	}
	
	public boolean notificcationLogoIsDisplayed() throws InterruptedException {
		NotificationLogo.click();
		Thread.sleep(2000);
		NotificationLogo.click();
		return NotificationLogo.isDisplayed();
	}
	
	public boolean appplicationDrawerLogoIsDisplayed() throws InterruptedException {
//		wd.until(ExpectedConditions.elementToBeClickable(ApplicationDrawerLogo));
//		Thread.sleep(2000);
		ApplicationDrawerLogo.click();
		Thread.sleep(1000);
		ApplicationDrawerLogo.click();
		return ApplicationDrawerLogo.isDisplayed();
	}
	
	public boolean myProfileLogoIsDisplayed() {
		return MyProfileLogo.isDisplayed();
	}
	public boolean myProfileLogoOpening() throws InterruptedException {
		MyProfileLogo.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",logOutButtonMiniProfile);
		Thread.sleep(5000);
		boolean flag  =logOutButtonMiniProfile.isDisplayed();
		MyProfileLogo.click();
		return flag;
	}
	public boolean WhatsOnYourMindIsDisplayed() {
		return WhatsOnYourMind.isDisplayed();
	}
	public boolean photoAndVideoIsDisplayed() {
		return PhotoAndVideo.isDisplayed();
	}
	public boolean recognizeLogoIsDisplayed() {
		return RecognizeLogo.isDisplayed();
	}
	public boolean firstPostLikeButtonIsDisplayed() {
		return FirstPostLikeButton.isDisplayed();
	}
	
	public void scrollHomepage() throws InterruptedException {
		home.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(10000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1200)");
		Thread.sleep(5000);		
	}
	
	public List<Boolean> importantLinksFunc() {
		List<Boolean> li = new ArrayList<>();
		boolean impDisplay = implinks.isDisplayed();
		implinks.click();
		boolean searchBar = insideImportantLinkSearchBar.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		li.add(impDisplay);
		li.add(searchBar);
		return li;
		
	}
	
	

}
