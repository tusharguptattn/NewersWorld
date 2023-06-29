package com.ttn.WebAutomation.tests.NW;
import java.util.Hashtable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ttn.WebAutomation.base.BaseLib;

import com.ttn.WebAutomation.seleniumUtils.CommonUtility;
import com.ttn.WebAutomation.seleniumUtils.SeleniumHelper;
import com.ttn.WebAutomation.utillib.DataProviderSource;

public class TopHeaders extends BaseLib {

	//verify all the contents of Contact Us Top Header Section
	@Test(groups = {"sanity", "regression"},enabled=false )
	public void verifyContactUSTopHeaderSection() throws Exception
	  {
		WebDriver driver = BaseLib.getDriver();
		SeleniumHelper helper = new SeleniumHelper(driver);

	  }
	

	

}
			

