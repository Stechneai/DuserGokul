package com.d365.testlayer;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class RunTransferOrderReceipt extends MasterClass {
	ITestResult result;

	@Test(groups = { "Admin", "Inventory Management", "TransferOrderReceipt", "Functionality" })
	public void negativeNoOfBoxesField() throws Exception {

//		navigateToPage(transferOrderPage.lnkInventorymanagement(), transferOrderPage.lnkTransferOrder());
//		genericHelper.clickWithJavascriptExecutor(transferOrderPage.btnNewTransferOrder());
		List<MasterDto> masterDtos = excelHelper.getTestData(transferOrderReceiptModuleSheet, "NegativeNoOfBoxes");
		for (MasterDto masterDto : masterDtos) {

			try {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				transferOrderReceipt.validateNoOfBoxesField(test, masterDto);
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Throwable e) {
				getResults(masterDto);
			} finally {
				reportHelper.generateExcelReport(test, result, masterDto);
			}
		}
	}
	
	@Test(groups = { "Admin", "Inventory Management", "TransferOrder", "Functionality" })
	public void negativeTransferOrderReceipt() throws Exception {

//		navigateToPage(transferOrderPage.lnkInventorymanagement(), transferOrderPage.lnkTransferOrder());
//		genericHelper.clickWithJavascriptExecutor(transferOrderPage.btnNewTransferOrder());
		List<MasterDto> masterDtos = excelHelper.getTestData(transferOrderReceiptModuleSheet, "Negative");
		for (MasterDto masterDto : masterDtos) {

			try {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				transferOrderReceipt.negativeTransferOrderReceipt(test, masterDto);
				checkNotificationPresenceAndHandle(masterDto);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				reportHelper.generateExcelReport(test, result, masterDto);
			}
		}
	}

}
