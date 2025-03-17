package com.d365.testlayer;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.d365.core.TransferOrder;
import com.d365.utils.MasterClass;

public class runTransferOrder extends MasterClass {

	@Test
	public void newTransferOrder() throws InterruptedException, Exception {
		loginPage(driver, username, password);
	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality" })
	public void addTagTransferOrder() throws Exception {
		// Navigate to the Transfer Order page
		

		try {
			for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
					"TransferOTag"); rowIndex++) {
				navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());
				// Click to create a new transfer order
				genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());

				try {

					if (transferorderpage.clickNewTransferOrder().isDisplayed()
							&& transferorderpage.clickTransferOrderIcon().isDisplayed()
							&& transferorderpage.clickship().isDisplayed()
							&& transferorderpage.clickReceive().isDisplayed()) {
						reportHelper.generateLogFullScreenSS(test,
								"Nvigating sucessfully of Transfer order page using following path Inventory management>>Outbound orders>>Transfer order:Is Passed");
						reportHelper.onTestSuccess(test,
								"Navigating sucessfully of Transfer order page using following path Inventory management>>Outbound orders>>Transfer order:Is Passed");
					} else {
						reportHelper.generateLogFullScreenSS(test,
								"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order :Is Failed");
						reportHelper.onTestFailure(test,
								"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order : Is Failed");
					}
				} catch (Exception e) {
					reportHelper.generateLogFullScreenSS(test,
							"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order");
					reportHelper.onTestFailure(test,
							"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order");

				}
				Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx",
						"TransferOTag", rowIndex);
				System.out.println("Order: " + orderData);

				// Set attributes from the Excel data
				for (Map.Entry<String, String> entry : orderData.entrySet()) {
					masterDto.setAttribute(entry.getKey(), entry.getValue());
				}

				test = reportHelper.createTestCase(test, extentReports, masterDto);
				try {
					transferorder.addTransferOrderBranchAndStateWithValidTag();
				//	transferorder.AllTagCheck();
				//	checkNotificationPresenceAndHandle(masterDto);
				} catch (Exception e) {
					getResults(masterDto);
				}
			}
		} catch (NoSuchElementException e) {
			// Log when no element is found
			reportHelper.onTestFailure(test, "Exception: " + e.getMessage());
			reportHelper.generateLog(test, "Exception: " + e.getMessage());
			reportHelper.generateLogWithScreenshot(test, "No message found.");
		} catch (AssertionError a) {
			reportHelper.onTestFailure(test, "Exception: " + a.getMessage());
			reportHelper.generateLog(test, "AssertionError: " + a.getMessage());
			reportHelper.generateLogWithScreenshot(test, "AssertionError: " + a.getMessage());
		}
	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality" })
	public void addBulkTagTransferOrder() throws Exception {

		
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
				"TransferOBulk"); rowIndex++) {
			// System.out.println("row count " + excelHelper.rowCountExcel(excelPath +
			// "TransferData.xlsx", "Sheet1"));
			navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());
			genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx",
					"TransferOBulk", rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transferorder.addTransferOrderBranchAndStateWithValidBulkTag();
                // transferorder.AllTagCheck();
				//checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			} catch (AssertionError a) {

				reportHelper.onTestFailure(test, "Exception: " + a.getMessage());
				reportHelper.generateLog(test, "AssertionError: " + a.getMessage());
				reportHelper.generateLogWithScreenshot(test, "AssertionError: " + a.getMessage());
				driver.navigate().refresh();
			}
		}

	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality" })
	public void addGCScanTagTransferOrder() throws Exception {

		navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
				"GCScan"); rowIndex++) {
			// System.out.println("row count " + excelHelper.rowCountExcel(excelPath +
			// "TransferData.xlsx", "Sheet1"));
			genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx", "GCScan",
					rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transferorder.addTransferOrderGCTag();
				checkNotificationPresenceAndHandle(masterDto);

			} catch (Exception e) {
				getResults(masterDto);

			}

		}

	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality" })
	public void addDocumentScan() throws Exception {

		navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
				"DocumentScan"); rowIndex++) {
			// System.out.println("row count " + excelHelper.rowCountExcel(excelPath +
			// "TransferData.xlsx", "Sheet1"));
			genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx",
					"DocumentScan", rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transferorder.addTransferOrderDocumentScan();
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}
		}
	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality" })
	public void addOldMetalCopy() throws Exception {

		navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());

		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
				"Sheet1"); rowIndex++) {
			// System.out.println("row count " + excelHelper.rowCountExcel(excelPath +
			// "TransferData.xlsx", "Sheet1"));
			genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx",
					"Sheet1", rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transferorder.addTransferOrderOldMetalCopy();
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}
		}

	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Validation" })
	public void validateDateReceiveShipFunctionality() throws Exception {

		navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());

		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
				"Validate"); rowIndex++) {
			
			genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx",
					"Validate", rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transferorder.validateData();
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}
		}
	}
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality/Validation" })
	public void validateNegativeTagTransferTag() throws Exception {

		navigateToPage(transferorderpage.clickInventoryManagement(), transferorderpage.clickTransferOrder());

		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "TransferData.xlsx",
				"TagBulkNegativeTestCase"); rowIndex++) {
			
			genericHelper.clickWithJavascriptExecutor(transferorderpage.clickNewTransferOrder());
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "TransferData.xlsx",
					"TagBulkNegativeTestCase", rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transferorder.validateNegativeTagData();
	         //	checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}
		}

	}
}
