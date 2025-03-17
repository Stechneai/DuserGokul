package com.d365.testlayer;


import java.util.Map;

import org.testng.annotations.Test;

import com.d365.utils.MasterClass;


public class runTransfer extends MasterClass {
   @Test
	public void transferRun() throws Exception
	{
	loginPage(driver, username, password);
	//	transfer.newTransfer();
	//	transfer.newBulkTransfer();
	//	transfer.newValidate();
	//	transfer.newValidateCounter();
	}
	@Test(groups = { "Admin", "Inventory Management", "Transfer", "Functionality" }) 
   public void newTransfer() throws InterruptedException, Exception {
		
		navigateToPage(transferpage.clickInventoryManagement(), transferpage.clickTransfer());
		
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "Transfer.xlsx",
				"TransferTag"); rowIndex++) {
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "Transfer.xlsx", "TransferTag",
					rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			// System.out.println("data " + masterDto.getAttributeValue("Site"));

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transfer.addTagTransfer();
				checkNotificationPresenceAndHandle(masterDto);

			} catch (Exception e) {
				getResults(masterDto);

			}

		}
	}
	@Test(groups = { "Admin", "Inventory Management", "Transfer", "Funtionality" }) 
	public void newBulkTransfer() throws InterruptedException, Exception {
		loginPage(driver, username, password);
		navigateToPage(transferpage.clickInventoryManagement(), transferpage.clickTransfer());

		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "Transfer.xlsx",
				"TransferBulk"); rowIndex++) {
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "Transfer.xlsx", "TransferBulk",
					rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			// System.out.println("data " + masterDto.getAttributeValue("Site"));

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transfer.addBulkTagTransfer();
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}

		}
	}
	@Test(groups = { "Admin", "Inventory Management", "Transfer", "Validation" }) 
	public void newValidate() throws InterruptedException, Exception {
		loginPage(driver, username, password);
		
       for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "Transfer.xlsx",
				"NavigationValidate"); rowIndex++) {
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "Transfer.xlsx", "NavigationValidate",
					rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			// System.out.println("data " + masterDto.getAttributeValue("Site"));

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transfer.validateNavigation();
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}

		}
	}
	@Test(groups = { "Admin", "Inventory Management", "Transfer", "Validation" }) 
	public void newValidateCounter() throws InterruptedException, Exception {
		loginPage(driver, username, password);
		
       for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "Transfer.xlsx",
				"TransferTagValidate"); rowIndex++) {
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "Transfer.xlsx", "TransferTagValidate",
					rowIndex);
			System.out.println("Order " + orderData);

			for (Map.Entry<String, String> entry : orderData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			// System.out.println("data " + masterDto.getAttributeValue("Site"));

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			try {
				transfer.validateTagCounter();
			//	checkNotificationPresenceAndHandle(masterDto);
			} catch (Exception e) {
				getResults(masterDto);
			}

		}
	}

	

}