@GstinMasterReports 
Feature: GSTIN MasterReports 
Background: GSTIN Reports 
Given user is on Login page{"Environment":"UAT", "Path":"GST Payment", "corpid":"DP2", "username":"ENTERER"} 

Scenario: Customizing the template 
	Given user clicks on Reports,GSTIN Master Reports
	When user clicks on custom template,selects options to add to template 
		|options|
		|Last Approver|
		|Next Approver|		
	Then user clicks on save button and enters name and clicks on save as new template:{'name':'Axisbank12'} 

Scenario: Deleting the template 
	Given user clicks on Reports,GSTIN Master Reports
	And user clicks on custom template,selects a Template and clicks on delete icon:{'Template':'Axisbank12'}
	When user clicks on Delete button 
	Then template successfully deleted toast message is displayed

Scenario: Generate GSTIN Master Reports entering all the details
	Given user clicks on Reports,GSTIN Master Reports
	And user enters start date end date Pan State InitiatedBy Gstin status Template
		|start date|end date|State|status|
		|28122021|07022022|BIHAR|Pending|
	When user clicks on Generate Reports, download to download the reports in PDF format
    Then user verifies the pdf downloaded
	
Scenario: Generate GSTIN Master Reports for last 1 week 
	Given user clicks on Reports,GSTIN Master Reports
	When user selects Last one week from Calendar,clicks on Generate Reports, download to download the reports in PDF format
	Then user verifies the pdf downloaded
	
Scenario: Generate GSTIN Master Reports for last 1 Month 
	Given user clicks on Reports,GSTIN Master Reports
	When user selects Last one Month from Calendar,clicks on Generate Reports,download to download the reports in PDF format
	Then user verifies the pdf downloaded
	
Scenario: Generate GSTIN Master Reports for last 3 Months 
	Given user clicks on Reports,GSTIN Master Reports
	When user selects Last three Months from Calendar,clicks on Generate Reports,download to download three months reports in PDF format
	Then user verifies the pdf downloaded
	
Scenario: Generate GSTIN Master Reports entering start date end date by customizing 
	Given user clicks on Reports,GSTIN Master Reports
	And user enters start date and end date,clicks on Generate Reports
		|start date|end date|
		|28122021|07022022|
	And user clicks on customize button to select columns and clicks on save changes 
	|columns|
	|State|
	|Company|
	And user enters template name and clicks on save as new template:{'template':'Axisbank39'}
	When user clicks on download to download the reports in PDF format
    Then user verifies the pdf downloaded
    
Scenario: Generate GSTIN Master Reports for the successful status
Given user clicks on Reports,GSTIN Master Reports
When user selects start data and end date and successful status, clicks on Generate Reports,download to download three months reports in PDF format
|start date|end date|status|
|28122021|07022022|Successful|
Then user verifies the pdf downloaded

Scenario: Generate GSTIN Master Reports for the pending status
Given user clicks on Reports,GSTIN Master Reports
When user selects start data and end date and pending status, clicks on Generate Reports,download to download three months reports in PDF format
|start date|end date|status|
|28122021|07022022|Pending|
Then user verifies the pdf downloaded 

Scenario: Generate GSTIN Master Reports for the expired status
Given user clicks on Reports,GSTIN Master Reports
When user selects start data and end date and expired status, clicks on Generate Reports,download to download three months reports in PDF format
|start date|end date|status|
|28122021|07022022|Expired|
Then user verifies the pdf downloaded
    
    
    
    
