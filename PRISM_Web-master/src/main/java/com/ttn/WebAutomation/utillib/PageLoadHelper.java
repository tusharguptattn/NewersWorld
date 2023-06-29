
package com.ttn.WebAutomation.utillib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadHelper {

 
  public static PageLoadHelper isLoaded() {
    PageLoadHelper load = new PageLoadHelper();
    return load;
  }


  public PageLoadHelper isElementIsClickable(WebDriver driver, WebElement element) {

    try {
      new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
      return this;
    } catch (WebDriverException ex) {
      throw new Error("Element is not clickable");
    }
  }

 
  public PageLoadHelper isElementIsVisible(WebDriver driver, WebElement element) {

    try {
      new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
      return this;
    } catch (WebDriverException ex) {
      throw new Error("Element is not visible");
    }
  }

}
