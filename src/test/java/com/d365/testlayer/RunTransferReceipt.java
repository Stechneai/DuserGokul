package com.d365.testlayer;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class RunTransferReceipt extends MasterClass{
	ITestResult result;  
	@Test(priority=1, groups = { "Admin", "Inventory Management", "TransferReceipt", "Functionality" }) 
	   public void generateTransferReceipt() throws InterruptedException, Exception {
			//login();
			
			navigateToPage(transferReceiptPage.lnkInventorymanagement(), transferReceiptPage.lnktTransfer());
			
			List<MasterDto> masterDtos = excelHelper.getTestData(transferReceiptModuleSheet, "Sheet2");
			for (MasterDto masterDto : masterDtos) {

				try {
					test = reportHelper.createTestCase(test, extentReports, masterDto);

					transferReceipt.generateTransferReceipt(test, masterDto);
					checkNotificationPresenceAndHandle(masterDto);
				}  catch (Exception e) {
					getResults(masterDto);
				} finally {
					reportHelper.generateExcelReport(test, result, masterDto);
				}
			}
		
	}
	@Test(priority=1, groups = { "Admin", "Inventory Management", "TransferReceipt", "Functionality" }) 
	   public void negativeTransferReceipt() throws InterruptedException, Exception {
			//login();
			
			navigateToPage(transferReceiptPage.lnkInventorymanagement(), transferReceiptPage.lnktTransfer());
			
			List<MasterDto> masterDtos = excelHelper.getTestData(transferReceiptModuleSheet, "Negative");
			for (MasterDto masterDto : masterDtos) {

				try {
					test = reportHelper.createTestCase(test, extentReports, masterDto);

					transferReceipt.negativeTransferReceipt(test, masterDto);
					//checkNotificationPresenceAndHandle(masterDto);
				}  catch (Exception e) {
					getResults(masterDto);
				} finally {
					reportHelper.generateExcelReport(test, result, masterDto);
				}
			}
		
	}
	@Test(priority=1, groups = { "Admin", "Inventory Management", "TransferReceipt", "Functionality" }) 
	   public void negativeBulkTransferReceipt() throws InterruptedException, Exception {
			//login();
			
			navigateToPage(transferReceiptPage.lnkInventorymanagement(), transferReceiptPage.lnktTransfer());
			
			List<MasterDto> masterDtos = excelHelper.getTestData(transferReceiptModuleSheet, "NegativeBulk");
			for (MasterDto masterDto : masterDtos) {

				try {
					test = reportHelper.createTestCase(test, extentReports, masterDto);

					transferReceipt.negativeBulkTransferReceipt(test, masterDto);
					//checkNotificationPresenceAndHandle(masterDto);
				}  catch (Exception e) {
					getResults(masterDto);
				} finally {
					reportHelper.generateExcelReport(test, result, masterDto);
				}
			}
		
	}
}
