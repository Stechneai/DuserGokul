package com.d365.core;

import java.io.IOException;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.d365.utils.MasterClass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class TransferOrder extends MasterClass {
	public void addTransferOrderBranchAndStateWithValidTag() throws Exception {
		
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferType(),
				masterDto.getAttributeValue("Transfer Type"));

		reportHelper.generateLogFullScreenSS(test, "Succesfully select transfer type");
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransferOrderIcon());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTagScan());

		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransTag(),
				masterDto.getAttributeValue("Scan Tag"));
		Thread.sleep(2000);
		transferorderpage.clickOtherclick().click();
		reportHelper.generateLogFullScreenSS(test, "Release tag  scan sucessfully");
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransGenerateLine());
		Thread.sleep(2000);

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickship());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipTransfer());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());
		
		checkNotificationPresenceAndHandle(masterDto);
		
		Thread.sleep(2000);
		
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Tag"), "");
		String tsite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("TransferSite"), "");


		genericHelper.clickWithJavascriptExecutor(alltagpage.clickModules());
		// genericHelper.clickWithJavascriptExecutor(atp.clickModules());
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickJewellery());
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickAllTags());
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickOkButton());
		Thread.sleep(1000);

		WebElement batchn = alltagpage.clickBatchNo();
		genericHelper.scrollingTillWebElement(batchn);
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickBatchNo());

		alltagpage.enterBatchNo().sendKeys(tag);
		Thread.sleep(4000);
		alltagpage.clickApply().click();
		Thread.sleep(2000);
		
		WebElement site=alltagpage.getCurrentSite();
		String wsite=site.getAttribute("value");
		System.out.println("Get Site is:"+wsite);
		
		
		if (tsite.equals(wsite)) {
			reportHelper.onTestSuccess(test, "Transfer Tag to specified location"  +tsite+  "is sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Transfer Tag to specified location"  +tsite+  "is not sucessfully: ");
		}

		
		// driver.navigate().refresh();

	}

	public void addTransferOrderBranchAndStateWithValidBulkTag() throws Exception {

		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));
		Thread.sleep(2000);

		if (transferorderpage.validateTransferStatus().isDisplayed()) {
			reportHelper.generateLogFullScreenSS(test, "Initially Transfer Type name is Created");
		} else {
			reportHelper.generateLogFullScreenSS(test, "Initially Transfer Type name is not  'Created'");

		}
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterTransferType(),
				masterDto.getAttributeValue("Transfer Type"));
		reportHelper.generateLogFullScreenSS(test, "Succesfully select transfer type");
		Thread.sleep(2000);
		String type = transferorderpage.validateTransferOrder().getAttribute("title");
		// String type1=
		// transferorderpage.validateStockTransfer().getAttribute("title");

		System.out.println("type:" + type);

		Thread.sleep(2000);
		if (type.equals("Transfer order")) {
			reportHelper.generateLogFullScreenSS(test, "Tag Transfer is branch to branch");
		} else {
			reportHelper.generateLogFullScreenSS(test, "Tag Transfer is state to state");
		}

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransferOrderIcon());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTagScan());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickToggleButton());

		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransTag(),
				masterDto.getAttributeValue("Scan Tag"));
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransGenerateLine());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickship());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipTransfer());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());
		
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Tag"), "");
		String tsite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("TransferSite"), "");


		genericHelper.clickWithJavascriptExecutor(alltagpage.clickModules());
		// genericHelper.clickWithJavascriptExecutor(atp.clickModules());
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickJewellery());
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickAllTags());
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickOkButton());
		Thread.sleep(1000);

		WebElement batchn = alltagpage.clickBatchNo();
		genericHelper.scrollingTillWebElement(batchn);
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickBatchNo());

		alltagpage.enterBatchNo().sendKeys(tag);
		Thread.sleep(4000);
		alltagpage.clickApply().click();
		Thread.sleep(2000);
		
		WebElement site=alltagpage.getCurrentSite();
		String wsite=site.getAttribute("value");
		System.out.println("Get Site is:"+wsite);
		
		
		if (tsite.equals(wsite)) {
			reportHelper.onTestSuccess(test, "Transfer Tag to specified location"  +tsite+  "is sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Transfer Tag to specified location"  +tsite+  "is not sucessfully: ");
		}

		
		// driver.navigate().refresh();
	}

	public void addTransferOrderGCTag() throws Exception {

		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferType(),
				masterDto.getAttributeValue("Transfer Type"));

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransferOrderIcon());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickGcScan());

		// genericHelper.clickWithJavascriptExecutor(transferorderpage.clickGcNew());
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFrombatch(),
				masterDto.getAttributeValue("From Batch"));
		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTobatch(),
				masterDto.getAttributeValue("To Batch"));

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickScan());
		Thread.sleep(2000);

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickGenerate());

		// genericHelper.clickWithJavascriptExecutor(transferorderpage.clickToggleButton());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickship());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipTransfer());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());

	}

	public void addTransferOrderDocumentScan() throws Exception {

		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferType(),
				masterDto.getAttributeValue("Transfer Type"));
		reportHelper.generateLogFullScreenSS(test, "Succesfully select transfer type");
		Thread.sleep(2000);
		transferorderpage.enterTransferTagType().clear();
		transferorderpage.enterTransferTagType().sendKeys(masterDto.getAttributeValue("Transfer Tag Type"), Keys.ENTER);
		Thread.sleep(2000);
		try {

			if (transferorderpage.enterTransferTagType().isDisplayed()) {
				reportHelper.generateLogFullScreenSS(test, "Document scan is selected");
			}
		} catch (NoSuchElementException | TimeoutException e) { // Handle exceptions
			reportHelper.generateLogFullScreenSS(test, "Document scan is not selected or took too long.");
		}

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickSearchButton());
		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferid(),
				masterDto.getAttributeValue("Document Id"));
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkButton());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransferOrderIcon());
		// genericHelper.doubleClickOn(transferorderpage.clickship());
		transferorderpage.clickship().click();
		// Thread.sleep(2000);
		transferorderpage.clickShipTransfer().click();
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());

	}

	public void addTransferOrderOldMetalCopy() throws Exception {

		// Step 1: Set From Warehouse
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));

		// Step 2: Set To Warehouse
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

		// Step 3: Select Transfer Type with JS
		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferType(),
				masterDto.getAttributeValue("Transfer Type"));
		reportHelper.generateLogFullScreenSS(test, "Successfully selected transfer type");

		// Step 4: Set Transfer Tag Type
		transferorderpage.enterTransferTagType().clear();
		transferorderpage.enterTransferTagType().sendKeys(masterDto.getAttributeValue("Transfer Tag Type"), Keys.ENTER);
		Thread.sleep(2000);

		// Step 5: Validate if Old Metal Copy is selected
		try {
			if (transferorderpage.enterTransferTagType().isDisplayed()) {
				reportHelper.generateLogFullScreenSS(test, "Old metal copy is selected");
			}
		} catch (NoSuchElementException | TimeoutException e) {
			reportHelper.generateLogFullScreenSS(test, "Old metal copy is not selected or took too long.");
		}

		// Step 6: Search
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickSearchButton());
//		transferorderpage.enterDate().click();
//		Thread.sleep(3000);

	
		
//		genericHelper.clearAndsendKeysAndEnter(transferorderpage.enterDate(),
//				masterDto.getAttributeValue("Date"));
//		reportHelper.generateLog(test, "Date entered");
//		Thread.sleep(10000);
	
		//String fromDateStr = getValueOrDefault(masterDto.getAttributeValue("From Date"));
		String toDateStr = getValueOrDefault(masterDto.getAttributeValue("Date"));
 
		// Safely handle null/empty dates
	//	String formattedFromDate = (fromDateStr != null && !fromDateStr.trim().isEmpty()) ? formatDate(fromDateStr): "";
		String formattedToDate = (toDateStr != null && !toDateStr.trim().isEmpty()) ? formatDate(toDateStr) : "";
 
		genericHelper.scrollingTillWebElement(transferorderpage.enterDate());
		//genericHelper.clearAndSendKeysWithJavascriptExecutor(transferorderpage.enterDate(), formattedFromDate);
		genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterDate(), formattedToDate);
		
		Thread.sleep(2000);
		
	// Step 7: Enter Product Group
		
		genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterProductGroup(),
				getValueOrDefault(masterDto.getAttributeValue("Product Group")));
		reportHelper.generateLog(test, "Product group entered");
		System.out.println("Entered product group");
		Thread.sleep(20000);

		// Step 9: Click Ok Button
//		genericHelper.actions.sendKeys(Keys.TAB);
//		genericHelper.actions.sendKeys(Keys.TAB);
//		genericHelper.actions.sendKeys(Keys.ENTER);
		transferorderpage.clickOkButton().click();

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickship());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipTransfer());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());

		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());

	}
	public static String convertExcelSerialDate(double excelDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1900, Calendar.JANUARY, 1); // Excel starts counting from 1900-01-01
		calendar.add(Calendar.DATE, (int) excelDate - 2); // Excel offset (leap year bug)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
 
// Method to format any date string to "MM/dd/yyyy"
	public static String formatDate(String dateStr) {
		String targetFormat = "MM/dd/yyyy"; // Desired output format
 
		try {
			if (dateStr.matches("\\d+(\\.0)?")) { // Check if it's an Excel serial date
				dateStr = convertExcelSerialDate(Double.parseDouble(dateStr));
			}
			SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat desiredFormat = new SimpleDateFormat(targetFormat);
			Date date = originalFormat.parse(dateStr);
			return desiredFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void validateData() throws Exception {
	    // Fetch values from `masterDto`
	    String shipMessage = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ValidateSMessage"), "");
	    String receiveMessage = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ValidateRMessage"), "");
	    String expectedDate = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ShipCurrentDate"), "");
	    System.out.println("Expected Ship Date: " + expectedDate);

	    // Populate "From Warehouse" and "To Warehouse" fields
	    genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
	            getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
	    genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
	            getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

	    try {
	        // Validate Ship Date
	        WebElement shipDateElement = transferorderpage.validateShipDate();
	        String shipDateText = shipDateElement.getAttribute("title"); // Example: "12/7/2024"

	        // Parse and compare dates
	        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	        LocalDate webDate = LocalDate.parse(shipDateText, dateFormat);
	        LocalDate currentDate = LocalDate.now();

	        System.out.println("Displayed Ship Date: " + shipDateText);
	        System.out.println("Parsed Ship Date: " + webDate);
	        System.out.println("Current System Date: " + currentDate);

	        // Compare displayed date with current date
	        if (webDate.equals(currentDate)) {
	            System.out.println("The displayed date matches the current date.");
	        } else {
	            System.out.println("The displayed date does NOT match the current date.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("An error occurred while validating the ship date.");
	    }

	    // Enter "Transfer Type"
	    genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferType(),
	            masterDto.getAttributeValue("Transfer Type"));

	    // Perform Tag Scan
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransferOrderIcon());
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTagScan());
	    genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransTag(),
	            masterDto.getAttributeValue("Scan Tag"));

	    Thread.sleep(2000);
	    transferorderpage.clickOtherclick().click();
	    Thread.sleep(2000);

	    // Generate Transfer Lines
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransGenerateLine());
	    Thread.sleep(2000);


	    // Perform Ship operation
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickship());
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipTransfer());
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());

	    // Validate Ship Message
	    WebElement shipMessageElement = transferorderpage.validateShipMessage();
	    String actualShipMessage = shipMessageElement.getText();
	    if (actualShipMessage.equalsIgnoreCase(shipMessage)) {
	        reportHelper.generateLogFullScreenSS(test, "Ship functionality is completed");
	    } else {
	        reportHelper.generateLogFullScreenSS(test, "Ship functionality is not completed");
	    }

	    Thread.sleep(2000);

	    // Perform Receive operation
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());

	    // Validate Receive Message
	    WebElement receiveMessageElement = transferorderpage.validateShipMessage();
	    String actualReceiveMessage = receiveMessageElement.getText();
	    if (actualReceiveMessage.equalsIgnoreCase(receiveMessage)) {
	        reportHelper.generateLogFullScreenSS(test, "Receive functionality is completed");
	    } else {
	        reportHelper.generateLogFullScreenSS(test, "Receive functionality is not started");
	    }
	}
	public void validateNegativeTagData() throws Exception {
	    // Fetch values from `masterDto`
	    String shipMessage = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ValidateSMessage"), "");
	    String receiveMessage = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ValidateRMessage"), "");
	    String expectedDate = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ShipCurrentDate"), "");
	    System.out.println("Expected Ship Date: " + expectedDate);

	    // Populate "From Warehouse" and "To Warehouse" fields
	    genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterFromWarehouse(),
	            getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
	    genericHelper.clearAndSendKeysAndEnter(transferorderpage.enterToWarehouse(),
	            getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

	    // Enter "Transfer Type"
	    genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransferType(),
	            masterDto.getAttributeValue("Transfer Type"));

	    // Perform Tag Scan
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransferOrderIcon());
	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTagScan());
	    genericHelper.sendKeysWithjavascriptExecutor(transferorderpage.enterTransTag(),
	            masterDto.getAttributeValue("Scan Tag"));

	    Thread.sleep(2000);
	    transferorderpage.clickOtherclick().click();
	    Thread.sleep(2000);
	    checkNotificationPresenceAndHandle(masterDto);

//	    // Generate Transfer Lines
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickTransGenerateLine());
//	    Thread.sleep(2000);
//		
//	    // Perform Ship operation
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickship());
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipTransfer());
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkSButton());
//
//	    Thread.sleep(2000);
//
//	    // Perform Receive operation
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickReceive());
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickShipReceive());
//	    genericHelper.clickWithJavascriptExecutor(transferorderpage.clickOkRButton());
//	    Thread.sleep(2000);
//		//checkNotificationPresenceAndHandle(masterDto);

	}
	public void AllTagCheck() throws IOException, InterruptedException {

		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Tag"), "");
		String tsite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("TransferSite"), "");


		genericHelper.clickWithJavascriptExecutor(alltagpage.clickModules());
		// genericHelper.clickWithJavascriptExecutor(atp.clickModules());
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickJewellery());
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickAllTags());
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickOkButton());
		Thread.sleep(1000);

		WebElement batchn = alltagpage.clickBatchNo();
		genericHelper.scrollingTillWebElement(batchn);
		genericHelper.clickWithJavascriptExecutor(alltagpage.clickBatchNo());

		alltagpage.enterBatchNo().sendKeys(tag);
		Thread.sleep(4000);
		alltagpage.clickApply().click();
		Thread.sleep(2000);
		
		WebElement site=alltagpage.getCurrentSite();
		String wsite=site.getAttribute("value");
		System.out.println("Get Site is:"+wsite);
		
		
		if (tsite.equals(wsite)) {
			reportHelper.onTestSuccess(test, "Transfer Tag to specified location"  +tsite+  "is sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Transfer Tag to specified location"  +tsite+  "is not sucessfully: ");
		}

		
		// driver.navigate().refresh();
	}


	public String getValueOrDefault(String value) {
		return value != null ? value : "";
	}

}
