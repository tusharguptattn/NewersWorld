package com.ttn.WebAutomation.listeners;
/**
 * This Java program demonstrates the Listener Class of PRISM-Framework.
 *
 * @author TTN
 */

import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aventstack.extentreports.gherkin.model.Feature;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.ttn.WebAutomation.ELK.ResultSender;
import com.ttn.WebAutomation.base.BaseLib;
import com.ttn.WebAutomation.seleniumUtils.DetailReport;
import com.ttn.WebAutomation.utillib.GlobalVariables;
import com.ttn.WebAutomation.utillib.JiraOperations;
import com.ttn.WebAutomation.utillib.PropertyReader;
import com.ttn.WebAutomation.utillib.ScreenshotAs;
import com.ttn.WebAutomation.utillib.TestLinkUtil;

//import com.ttn.WebAutomation.ELK.TestStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

@SuppressWarnings("deprecation")
public class MyProjectListener extends BaseLib implements ITestListener{
	private static int iPassCount, iFailCount, iSkippedCount = 0;
	// private static Logger actiLog;
	private long startTime;
	private Logger logger = Logger.getLogger(MyProjectListener.class.getName());



	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();

	}

	// ITestListener
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Start on teststart");
		ExtentTest child = classLevelLogger.get().createNode(result.getName());
		methodLevelLogger.set(child);

	}

	// ITestListener
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub


		iPassCount++;
		MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN);

		logger.info("Test Completed");
		logger.info("\n *********************************** Ending Testcase *********************************** \n");
		// TestLink Set Result Configuration
		String testlinkstatus = properties.getProperty("testlink_status");

		logger.info("The status of TestLink is " + testlinkstatus);
		if (testlinkstatus.equalsIgnoreCase("YES")) {

			TestLinkUtil.setResult(testLinkID.get(), ExecutionStatus.PASSED);
			logger.info("TestLink connection done");

		} else {
			logger.info("TestLink connection is not required");

		}
	}

	// ITestListener
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// ITestListener
	@Override
	public void onTestFailure(ITestResult result) {

		iFailCount++;

		if(getTestLogger() !=null){

			String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			getTestLogger().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>" + " \n");
			getTestLogger().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
		}
		String snapshotFileName = DetailReport.getReportLocation() + "/" + DetailReport.getTestId() + "/"  + "fail.png";
		String extentReportSnapshotFileName = DetailReport.getTestId() + "/"  + "fail.png";

		File snapshotFile = ((TakesScreenshot) BaseLib.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(snapshotFile, new File(snapshotFileName));
		} catch (IOException e) {
			logger.log(Level.INFO, "Error occured, while creating the snapshot file" + snapshotFileName, e);
		}
		try {
			if (getTestLogger() != null) {
				getTestLogger().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(extentReportSnapshotFileName).build());
			}
		} catch (IOException e) {
			logger.info("IO Exception");
		}
		try{

			ExtentTest extentTest = BaseLib.test;
			if(extentTest !=null){
				extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			}
			ScreenshotAs screenshot = new ScreenshotAs (result);
			String screenshotDestination = screenshot.getScreenshot();
			Reporter.log("(" + result.getName() + ")" + "Taking screenshot of failed test " + "(" + result.getTestContext().getName() + ")" + "at location - " + screenshotDestination, true);
//			System.out.println(screenshotDestination);
			try {
				if (extentTest != null) {
					extentTest.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotDestination).build());
				}

			} catch (IOException e) {
				logger.info("IO exception");
			}


			getTestLogger().fail( result.getThrowable().getClass().getSimpleName());
			getTestLogger().info( "Test Completed");

			logger.info("Test Completed");

			logger.info("\n *********************************** Ending Testcase *********************************** \n");
			// TestLink SetResult
			String testlinkstatus = properties.getProperty("testlink_status");
			logger.info("The status of TestLink is " + testlinkstatus);
			if (testlinkstatus.equalsIgnoreCase("YES")) {
				TestLinkUtil.setResult(testLinkID.get(), ExecutionStatus.FAILED);
				logger.info("TestLink result set is done");

			}
			else {
				logger.info("TestLink result set is not done");

			}


			String testName = result.getName();
			// All Jira Related stuff Below -----------

			try {
				properties = PropertyReader.setup_properties();
			} catch (IOException e) {
				logger.info("IO exception");
			}
			String jirastatus = properties.getProperty("jira_status");
			logger.info("The status of jira is" + jirastatus);

			if (jirastatus.equalsIgnoreCase("YES")) {

				JiraOperations.createJiraInstance(properties.getProperty(GlobalVariables.JIRA_URL),
						properties.getProperty(GlobalVariables.JIRA_USERNAME),
						properties.getProperty(GlobalVariables.JIRA_PASSWORD));
				logger.info("Jira status updated");
				String jiraQuery = "project = " + properties.getProperty("projectName") + " and type="
						+ properties.getProperty("defectType") + " and summary~\"Test Automation Bug: " + testName
						+ "\"";

				System.out.println(jiraQuery);

				if (JiraOperations.issueAlreadyExist(jiraQuery, "AutomatedTestExecutionBug"))
					System.out.println("issue already exist!!");
				else {
					JiraOperations.createNewIssue("Test Automation Bug: " + testName,
							"Test failed for test case: " + testName, "AutomatedTestExecutionBug",
							properties.getProperty("assignee"));
				}



			}

			else {
				logger.info("Jira status not updated");

			}
		} catch (TestLinkAPIException e) {
			logger.info("TestLinkAPIException");
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		iSkippedCount++;

		if(getTestLogger() != null){
			getTestLogger().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			getTestLogger().skip(result.getThrowable());
		}
		ExtentTest extentTest = BaseLib.test;
		if(extentTest != null){
			extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			extentTest.skip(result.getThrowable());
		}
		getTestLogger().skip( "Test skipped " + result.getThrowable());
		getTestLogger().info("Test Completed");

		logger.info("\n *********************************** Ending Testcase *********************************** \n");
		String testlinkstatus = properties.getProperty("testlink_status");

		logger.info("The status of TestLink is " + testlinkstatus);
		if (testlinkstatus.equalsIgnoreCase("YES")) {

			TestLinkUtil.setResult(testLinkID.get(), ExecutionStatus.NOT_RUN);
			logger.info("TestLink connection done");

		} else {
			logger.info("TestLink connection is not required");

		}
	}
}
