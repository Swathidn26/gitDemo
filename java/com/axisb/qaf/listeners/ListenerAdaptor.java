package com.axisb.qaf.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ListenerAdaptor {

	
	public static ExtentReports extent=new ExtentReports();
	public static Map<String,ExtentTest> eventListenerAvent=new HashMap<String, ExtentTest>();;
	public static Map<String,ExtentTest> eventListenerScenario=new HashMap<String, ExtentTest>();;
	public static boolean runfor1stTime=true;
	public static List<String> scenarioList=new ArrayList<String>();
	public static Map<String,ExtentTest> aventTest=new HashMap<String, ExtentTest>();
	public static ExtentSparkReporter spark;
	
}
