package com.axisb.qaf.testrunner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features={"scenarios"},
		glue={"com.axisb.qaf.steps"},
		tags="@BeneAddition",
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		
	)				
public class JunitRunner{
	FileReader read = null;
	static Properties property= null;
	
	public static String getReportConfigPath(){
		String reportConfigPath = property.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Application.properties file for the Key:reportConfigPath");		
	}
	
	public void loadProperties() throws IOException {
		read = new FileReader(System.getProperty("user.dir")+"/resources/application.properties");
		property= new Properties();
		property.load(read);
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(getReportConfigPath()));
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	}
	
}
