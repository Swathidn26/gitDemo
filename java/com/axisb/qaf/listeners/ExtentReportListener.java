package com.axisb.qaf.listeners;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.And;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.axisb.qaf.utils.CommonUtility;
import com.qmetry.qaf.automation.step.QAFTestStepListener;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class ExtentReportListener  extends WebDriverBaseTestPage<WebDriverTestPage> implements IReporter,QAFTestStepListener {

	static ExtentTest scenario;
	static ExtentTest feature;

	static ExtentTest step;
	static String featurefile;
	String screenshotPath=System.getProperty("user.dir")+"/target/img/";

	
	@Override
	public void onFailure(StepExecutionTracker stepExecutionTracker) {
		step.log(Status.FAIL, "Test Case Failed for '"+stepExecutionTracker.getStep().getDescription()+"'.\n Reason for Failure-"+stepExecutionTracker.getException().getMessage());

	}

	@Override
	public void beforExecute(StepExecutionTracker stepExecutionTracker) {
		if(ListenerAdaptor.runfor1stTime) {
			String currentDay=new SimpleDateFormat("dd_MMM_yyyy").format(new Date());
			String currentDayTS=new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss").format(new Date());
			try {
				CommonUtility.cCreateFolder(System.getProperty("user.dir")+"/Reports/"+currentDay);
			} catch (Exception e) {
				Validator.assertTrue(false, "Unable to create the Folders for-"+System.getProperty("user.dir")+"/Reports/"+currentDay,"");
			}
			ListenerAdaptor.spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+currentDay+"/ExtentSparkReport_"+currentDayTS+".html");
		
			ListenerAdaptor.extent.attachReporter(ListenerAdaptor.spark);
			ListenerAdaptor.runfor1stTime=false;
		}
		featurefile=(stepExecutionTracker.getScenario().getSignature().split("[//.]"))[1];
		if(!ListenerAdaptor.eventListenerAvent.containsKey(featurefile)) {
			feature=ListenerAdaptor.extent.createTest(featurefile);

			ListenerAdaptor.eventListenerAvent.putIfAbsent(featurefile, feature);
		}
		if(!ListenerAdaptor.scenarioList.contains(stepExecutionTracker.getScenario().getSignature())) {

			ListenerAdaptor.scenarioList.add(stepExecutionTracker.getScenario().getSignature());
			feature=ListenerAdaptor.eventListenerAvent.get(featurefile);
			scenario=feature.createNode(stepExecutionTracker.getScenario().getQualifiedName());
			ListenerAdaptor.eventListenerScenario.put(stepExecutionTracker.getScenario().getQualifiedName(), scenario);
		}
		scenario=ListenerAdaptor.eventListenerScenario.get(stepExecutionTracker.getScenario().getQualifiedName());
		
		step=scenario.createNode(stepExecutionTracker.getStep().getDescription());



	}
	
	public ExtentTest createTestStepNode(ExtentTest extentStep, String step) {
		if(step.toUpperCase().startsWith("GIVEN")) {
			return extentStep.createNode(Given.class, step);
		}else if(step.toUpperCase().startsWith("WHEN")) {
			return extentStep.createNode(When.class, step);
		}else if(step.toUpperCase().startsWith("AND")) {
			return extentStep.createNode(And.class, step);
		}else if(step.toUpperCase().startsWith("THEN")) {
			return extentStep.createNode(Then.class, step);
		}else {
			return null;
		}
	}

	@Override
	public void afterExecute(StepExecutionTracker stepExecutionTracker) {
		String screenshotBase64="";
		try {
			screenshotBase64=CommonUtility.cEncodeImageFileToBase64String(createAndSaveScreenshot());
		}catch (Exception e) {
			screenshotBase64=System.getProperty("user.dir")+"/dashboard/images/wrong.png";
		}
		step.addScreenCaptureFromBase64String(screenshotBase64,"Click to view Screenshot");
		if(!step.getStatus().equals(Status.FAIL)) {
			step.log(Status.PASS, "Test Step '"+stepExecutionTracker.getStep().getDescription()+"' successfully completed");
		}
		ListenerAdaptor.eventListenerScenario.put(stepExecutionTracker.getScenario().getQualifiedName(), scenario);

	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ListenerAdaptor.extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		ListenerAdaptor.extent.setSystemInfo("User Name", System.getProperty("user.name"));
		ListenerAdaptor.extent.setSystemInfo("OS", System.getProperty("os.name"));
		ListenerAdaptor.extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		try {
			ListenerAdaptor.extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		} catch (Exception e1) {
			Validator.assertTrue(false, "Unable to Generate Report as Execution ended before starting the driver", "");
		}
		ListenerAdaptor.extent.setSystemInfo("Environment", "UAT");

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				try {
					assignCategory(context.getPassedTests());
					assignCategory(context.getFailedTests());
					assignCategory(context.getSkippedTests());
				} catch (Exception e) {
					Validator.assertTrue(false,"Unable to Generate Report as Execution ended due to "+e.getMessage(), "");
				}
			}
		}
		try {
			ListenerAdaptor.extent.flush();

		}catch (Exception e) {
			Validator.assertTrue(false,"Unable to Close the Generated Report as Execution ended "+e.getMessage(), "");
		}

	}
	private void assignCategory(IResultMap tests) throws Exception {

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				for (String group : result.getMethod().getGroups())
				{
					ListenerAdaptor.eventListenerScenario.get(result.getMethod().getMethodName()).assignCategory(group);
				}
			}
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
	public String createAndSaveScreenshot() throws Exception {
		String currentDay=new SimpleDateFormat("dd_MMM_yyyy").format(new Date());
		String currentDayTS=new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss").format(new Date());

		CommonUtility.cCreateFolder(screenshotPath+currentDay);
		String screenShotPath=CommonUtility.cCaptureScreenshot(driver, screenshotPath+currentDay+"/Screenshot_"+currentDayTS);
		return screenShotPath;
	}
	


}
