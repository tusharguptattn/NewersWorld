package com.ttn.WebAutomation.seleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitStatementLib 
{
	
	public static void implicitWaitForSeconds (WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void implicitWaitForMinutes (WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(time));
	}
	
	public static void explicitWaitForClickable (WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitForVisibility (WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicitWaitForInvisibility (WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void hardWaitFormiliSeconds (int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// Restore interrupted state...
			Thread.currentThread().interrupt();
		}
	}
	
}
