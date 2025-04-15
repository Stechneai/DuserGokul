package com.d365.core;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class TransferReceipt extends MasterClass{
	  public void generateTransferReceipt(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Correct WebDriverWait usage

	        String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
	        String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
	        String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
	        String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
	        String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
	        String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
	        String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");
            String noofboxes=StringUtils.defaultIfBlank(masterDto.getAttributeValue("NoOfBoxes"), "");
            String inventorylocation=StringUtils.defaultIfBlank(masterDto.getAttributeValue("InventoryLocation"), "");
	        
	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnNeworder());

	        genericHelper.sendKeysAndEnterWithWait(transferReceiptPage.txtSite(), datasite, 0);
	        Thread.sleep(2000);
	        genericHelper.clearAndSendKeysAndEnter(transferReceiptPage.txtWarehouse(), datawarehouse);
	        Thread.sleep(2000);
	     //   genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtInventoryLcation(), inventorylocation);
	        
	        

	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnOk());
	        
	        genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtNoOfBoxes(), noofboxes);
		       Thread.sleep(200);
	      
		      
		        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnTagScanning());

		        genericHelper.sendKeysWithjavascriptExecutor(transferReceiptPage.txtEnterTag(), datatag);
		       // Thread.sleep(2000);
		        genericHelper.actions.sendKeys(Keys.TAB).build().perform();

		    

	        //Thread.sleep(200);
	        try {
	            // Wait for visibility of invalid tag
	            wait.until(ExpectedConditions.visibilityOf(transferReceiptPage.txtInvalidTag()));
	            if (transferReceiptPage.txtInvalidTag().isDisplayed()) {
	               
	                reportHelper.generateLogFullScreenSS(test, "Tag is not from selected location or Tag is not release status//Cannot Select Bulk Tag");
	            
	            }
	        } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
	            System.out.println("No invalid tag element found. Proceeding with valid tag actions.");
	            
	            genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtEnterTag(), datatag);
	            genericHelper.sendKeysWithjavascriptExecutor(transferReceiptPage.txtLocation(), datalocation);
	            genericHelper.sendKeysWithjavascriptExecutor(transferReceiptPage.txtCounter(), datalocationid);
	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnGenerateLine());

	            Thread.sleep(200);

	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnTagrelease());
	            Thread.sleep(200);

	     
	            genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtScanningStatus(), statusyes);
	            Thread.sleep(300);

	            transferReceiptPage.btnValidate().click();
	            Thread.sleep(300);

	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnValidateOk());
	            Thread.sleep(300);

	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnLines());
	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnPost());

	            Thread.sleep(300);
	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnPostOK());
	            Thread.sleep(200);
	            genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnPrintTransfer());
	            Thread.sleep(200);
	            
	            reportHelper.generateLogFullScreenSS(test, "Transfer Print Receipt is generated Sucessfully");
	            
	        }
	  }
	  
	  public void negativeTransferReceipt(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Correct WebDriverWait usage

	        String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
	        String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
	        String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
	        String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
	        String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
	        String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
	        String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");
          String noofboxes=StringUtils.defaultIfBlank(masterDto.getAttributeValue("NoOfBoxes"), "");
          String inventorylocation=StringUtils.defaultIfBlank(masterDto.getAttributeValue("InventoryLocation"), "");
	        
	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnNeworder());

	        genericHelper.sendKeysAndEnterWithWait(transferReceiptPage.txtSite(), datasite, 0);
	        Thread.sleep(2000);
	        genericHelper.clearAndSendKeysAndEnter(transferReceiptPage.txtWarehouse(), datawarehouse);
	        Thread.sleep(2000);
	     //   genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtInventoryLcation(), inventorylocation);
	        
	        

	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnOk());
	        
	        genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtNoOfBoxes(), noofboxes);
		       Thread.sleep(200);
		       
		      
		        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnTagScanning());

		        genericHelper.sendKeysWithjavascriptExecutor(transferReceiptPage.txtEnterTag(), datatag);
		       // Thread.sleep(2000);
		        genericHelper.actions.sendKeys(Keys.TAB).build().perform();

		    

	        //Thread.sleep(200);
	        try {
	            // Wait for visibility of invalid tag
	            wait.until(ExpectedConditions.visibilityOf(transferReceiptPage.txtInvalidTag()));
	            if (transferReceiptPage.txtInvalidTag().isDisplayed()) {
	               
	                reportHelper.generateLogFullScreenSS(test, "Tag is not from selected location or Tag is not release status");
	                checkNotificationPresenceAndHandle(masterDto);
	            }
	        } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
	            System.out.println("No invalid tag element found. Proceeding with valid tag actions.");
	            
	        }
	  }
	  
	  public void negativeBulkTransferReceipt(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Correct WebDriverWait usage

	        String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
	        String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
	        String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
	        String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
	        String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
	        String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
	        String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");
        String noofboxes=StringUtils.defaultIfBlank(masterDto.getAttributeValue("NoOfBoxes"), "");
        String inventorylocation=StringUtils.defaultIfBlank(masterDto.getAttributeValue("InventoryLocation"), "");
	        
	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnNeworder());

	        genericHelper.sendKeysAndEnterWithWait(transferReceiptPage.txtSite(), datasite, 0);
	        Thread.sleep(2000);
	        genericHelper.clearAndSendKeysAndEnter(transferReceiptPage.txtWarehouse(), datawarehouse);
	        Thread.sleep(2000);
	     //   genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtInventoryLcation(), inventorylocation);
	        
	        

	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnOk());
	        
	        genericHelper.clearAndSendKeysWithJavascriptExecutor(transferReceiptPage.txtNoOfBoxes(), noofboxes);
		       Thread.sleep(200);
	      
		      
		        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnTagScanning());

		        genericHelper.sendKeysWithjavascriptExecutor(transferReceiptPage.txtEnterTag(), datatag);
		       // Thread.sleep(2000);
		        genericHelper.actions.sendKeys(Keys.TAB).build().perform();

		    

	        //Thread.sleep(200);
	        try {
	            // Wait for visibility of invalid tag
	            wait.until(ExpectedConditions.visibilityOf(transferReceiptPage.txtInvalidBulkTag()));
	            if (transferReceiptPage.txtInvalidTag().isDisplayed()) {
	               
	                reportHelper.generateLogFullScreenSS(test, "Cannot Select Bulk Tag");
	                checkNotificationPresenceAndHandle(masterDto);
	            }
	        } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
	            System.out.println("No invalid tag element found. Proceeding with valid tag actions.");
	            
	        }
	  }
	  public void fieldsTransferPage(ExtentTest test, MasterDto masterDto) throws Exception {
		  String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
	        String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
			
			navigateToPage(transferOrderReceiptPage.lnkInventorymanagement(), transferOrderReceiptPage.lnkTransferOrder());
			genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnNeworder());

	        genericHelper.sendKeysAndEnterWithWait(transferReceiptPage.txtSite(), datasite, 0);
	        Thread.sleep(2000);
	        genericHelper.clearAndSendKeysAndEnter(transferReceiptPage.txtWarehouse(), datawarehouse);
	        Thread.sleep(2000);
	        genericHelper.clickWithJavascriptExecutor(transferReceiptPage.btnOk());
			

			try {

				if (transferReceiptPage.btnNeworder().isDisplayed()
						&& transferOrderPage.btnTransferOrderIcon().isDisplayed()
						&& transferOrderReceiptPage.btnShip().isDisplayed()
						&& transferOrderReceiptPage.btnReceive().isDisplayed()) {
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
		}
}
