package com.ttn.WebAutomation.utillib;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestContext;

public class DataProviderSource {

	@org.testng.annotations.DataProvider
	public Object[][] configuratorModel(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorModelSelection", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorModelVariant(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorModelVariant", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorSignuppopupinvalidnumber(ITestContext c)
			throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorSignupInvalidNumber", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorSignuppopup(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorSignupValidNumber", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorSignupInvalidOTP(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorSignupInvalidOTP", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorSignupWrongOTP(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorSignupWrongOTP", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorAccessories(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorAddAccessories", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] smartFinanceCustomer(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("SmartFinanceCustomer", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] smartFinanceChooseCar(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("SmartFinanceChooseCar", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] smartFinanceChooseCarVariantAndColor(ITestContext c)
			throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("SmartFinanceChooseCarVariantAndColor", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] smartFinanceBackButton(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("SmartFinanceBackButton", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] smartFinanceTopFeatures(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("SmartFinanceTopFeatures", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] smartFinanceDealer(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("SmartFinanceDealer", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] footers(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("Footers", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] leadFormsRequiredDataMessage(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("LeadFormsRequiredDataMessage", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] leadFormsInvalidEmailData(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("LeadFormsEmailInvalidDataMessage", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] leadFormsInvalidMobileData(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("LeadFormsMobileInvalidDataMessage", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] leadFormsValidData(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("LeadFormsValidData", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] registerYourInterestPopupBrandPage(ITestContext c)
			throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("NexaCarsLeadForms", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] eBookInvalidDP() throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("EBookInvalidData");

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] eBookValidDP() throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("EBookValidData");

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] header(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("Headers", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
    public Object[][] topHeadersLocation(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("TopHeaderLocation_Elements", c.getIncludedGroups()[0]);

        return data;
    }
    
    @org.testng.annotations.DataProvider
    public Object[][] mediaRegistration(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("MediaRegistration_FormElements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    
    @org.testng.annotations.DataProvider
    public Object[][] feedbackForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("FeedbackForm_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
   
    @org.testng.annotations.DataProvider
    public Object[][] queryForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("QueryForm_Elements", c.getIncludedGroups()[0]);

        return data;
    }
    
    @org.testng.annotations.DataProvider
    public Object[][] complaintForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("ComplaintForm_Elements", c.getIncludedGroups()[0]);

        return data;
    }
    
   
    @org.testng.annotations.DataProvider
    public Object[][] firstEscalate(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("FirstEscalate_Elements", c.getIncludedGroups()[0]);

        return data;
    }
    
    @org.testng.annotations.DataProvider
    public Object[][] finalEscalate(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("FinalEscalate_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] nexaUserLogin(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("Login_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
      
    @org.testng.annotations.DataProvider
    public Object[][] topHeadersInvalidLocation(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("TopHeaderInvalidLocation_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] errorMsgForFeedbackForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("FeedBackFormErrorMessages_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] errorMsgForComplaintForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("ComplaintFormErrorMessages_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    
    @org.testng.annotations.DataProvider
    public Object[][] errorMsgForQueryForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("QueryFormErrorMessages_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] errorMsgForMediaRegistrationForm(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("MediaRegistrationErrorMessages", c.getIncludedGroups()[0]);

        return data;
    }
    
    @org.testng.annotations.DataProvider
    public Object[][] RegistrationForLogin(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("LoginRegistration_Elements", c.getIncludedGroups()[0]);

        return data;
           
    }
    @org.testng.annotations.DataProvider
    public Object[][] dataForForgotUserNamePasswordForAllUser(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("DataForgotUserNamePasswordForAllUser_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] VerifyFieldsForForgotUserNamePasswordForAllUser(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("VerifyFieldsForgotUserNamePasswordForAllUser_Elements", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] errorMsgForForgotUserNamePassword(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("ErrorMsg_ForgotUserNamePassword", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] Data_CreateAccountForNewUser(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("Data_CreateAccountForNewUser", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] ErrorMsg_CreateAccountForNewUser(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("ErrorMsg_CreateAccountForNewUser", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] GoogleSignUpCredentials(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("GoogleSignUpCredentials", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] FacebookLoginCredentials(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("FacebookLoginCredentials", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] LoginLoyaltyPopUp(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("LoginLoyaltyPopUp", c.getIncludedGroups()[0]);

        return data;
    } 
    
    @org.testng.annotations.DataProvider
    public Object[][] LoginLoyaltyReferToFriendFormFields(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("LoginLoyaltyReferToFriendFormFields", c.getIncludedGroups()[0]);

        return data;
    }     
    
    @org.testng.annotations.DataProvider
    public Object[][] LoginLoyaltyReferToFriendFormFieldsErrorMsg(ITestContext c) throws EncryptedDocumentException, IOException {

        Object data [][] = ExcelReader.read_data("LoginLoyaltyReferToFriendFormFieldsErrorMsg", c.getIncludedGroups()[0]);

        return data;
    }  
	@org.testng.annotations.DataProvider
	public Object[][] ebrochure(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("EBrochure", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] ebrochureExplore(ITestContext c) throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("EBrochureExplore", c.getIncludedGroups()[0]);

		return data;
	}

	@org.testng.annotations.DataProvider
	public Object[][] configuratorModelVariantTopFeature(ITestContext c)
			throws EncryptedDocumentException, IOException {

		Object data[][] = ExcelReader.read_data("ConfiguratorCarInfoLogoCarInfoTextTopFeature",
				c.getIncludedGroups()[0]);

		return data;
	}
	   @org.testng.annotations.DataProvider
	    public Object[][] bookTestDriveContent(ITestContext c) throws EncryptedDocumentException, IOException {

	        Object data [][] = ExcelReader.read_data("BookTestDriveContent",c.getIncludedGroups()[0]);

	        return data;
	    }
	   @org.testng.annotations.DataProvider
	    public Object[][] testDriveBlankDataMessage(ITestContext c) throws EncryptedDocumentException, IOException {

	    	Object data [][] = ExcelReader.read_data("TestDriveBlankDataMessage", c.getIncludedGroups()[0]);

	        return data;
	    }

}
