package com.ttn.WebAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UEV {
	WebDriver driver ;
	
	@FindBy(xpath="//h2[normalize-space()='Bhanu Gusain']")
	WebElement Name;
	
	@FindBy(xpath="//span[@class='user_designation']")
	WebElement userDesignation;
	
	@FindBy(xpath = "//span[@class='year_duration ng-star-inserted']")
	WebElement YOE;
	
	@FindBy(xpath="//span[@class='more_icon']//span[@class='more_options']")
	WebElement ThreeDots;
	
//	@FindBy(xpath = "//li[normalize-space()='Profile']") 
//	WebElement profilethreedots;
	
//	@FindBy(xpath="//li[contains(text(),'Resume')]")
//	WebElement Resumethreedots;
	
//	@FindBy(xpath="//li[@data-bs-toggle='modal']")
//	WebElement locationInThreeDots;
//	
	@FindBy(xpath = "(//span[@class=\"user_list_text\"])[1]")
	WebElement mobileNo;
	
	@FindBy(xpath="//span[normalize-space()='TO THE NEW Private Limited']")
	WebElement LegalEntity;
	
	@FindBy(xpath="//span[normalize-space()='bhanu.gusain@tothenew.com']")
	WebElement Email;
	
	@FindBy(xpath="//span[normalize-space()='TTN Projects']")
	WebElement BusinessUnit;
	
	@FindBy(xpath="//span[normalize-space()='6975']")
	WebElement newerID;
	
	@FindBy(xpath="//span[normalize-space()='Quality Engineering']")
	WebElement competency;
	
	@FindBy(xpath="//span[normalize-space()='Newers World']")
	WebElement project;
	
//	@FindBy(xpath="//span[normalize-space()='Resume']")
//	WebElement resume;
	
	
	
	public UEV(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	public boolean nameIsDisplaying() {
		return Name.isDisplayed();
	}
	public boolean userDesignationIsDisplaying() {
		return userDesignation.isDisplayed();
	}
	public boolean YOEIsDisplaying() {
		return YOE.isDisplayed();
	}
	public boolean threeDotsIsDisplaying() {
		return ThreeDots.isDisplayed();
	}
//	public boolean profileIsDisplaying() {
//		return profilethreedots.isDisplayed();
//	}
//	public boolean resumeThreeDotsIsDisplaying() {
//		return Resumethreedots.isDisplayed();
//	}
//	public boolean locationInThreeDotsIsDisplaying() {
//		return locationInThreeDots.isDisplayed();
//	}
	public boolean mobileNoIsDisplayed() {
		return mobileNo.isDisplayed();
	}
	public boolean legalEntityIsDisplayed() {
		return LegalEntity.isDisplayed();
	}
	public boolean emailIsDisplaying() {
		return Email.isDisplayed();
	}
	public boolean businessUnitIsDisplaying() {
		return BusinessUnit.isDisplayed();
	}
	public boolean newerIdIsDisplaying() {
		return newerID.isDisplayed();
	}
	public boolean competencyIsDisplaying() {
		return competency.isDisplayed();
	}
	public boolean projectIsDisplaying() {
		return project.isDisplayed();
	}
//	public boolean resumeIsDisplaying() {
//		return resume.isDisplayed();
//	}

}
