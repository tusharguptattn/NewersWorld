package com.ttn.WebAutomation.seleniumUtils;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.ttn.WebAutomation.seleniumUtils.DetailReport;

/**
 * class to ensure that object is being used by same thread
 * 
 * @author TTN
 *
 */
public class ThreadManager {

	public static WebElement getPreviousElement() {
		return previousElement.get();
	}

	public static void setPreviousElement(WebElement previousWebElement) {
		previousElement.set(previousWebElement);
	}
	public static SoftAssert getSoftAssert() {
        return softAssert.get();
    }
	public static void setSoftAssert(SoftAssert softAssertRef) {
    	softAssert.set(softAssertRef);
    }
	
	public static String getPreviousWindowHandle() {
        return previousWindowHandle.get();
    }
    
	static void setPreviousWindowHandle(String previousWindowHandleString) {
    	previousWindowHandle.set(previousWindowHandleString);
    }
	public static DetailReport getDetailReport() {
        return detailReport.get();
    }
	public static void setDetailReport(DetailReport detailReportRef) {
    	detailReport.set(detailReportRef);
    }
	
	private static ThreadLocal<DetailReport> detailReport = new ThreadLocal<DetailReport>();
	private static ThreadLocal<WebElement> previousElement = new ThreadLocal<WebElement>();

	private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<SoftAssert>();
	private static ThreadLocal<String> previousWindowHandle = new ThreadLocal<String>();
	public void unload(){
		detailReport.remove();
		previousElement.remove();
		softAssert.remove();
		previousWindowHandle.remove();
	}
}
