package com.d365.core;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class TransferOrderReceipt extends MasterClass{

public void generateTransferOrderReceipt(ExtentTest test, MasterDto masterDto) throws Exception {
		
		navigateToPage(transferOrderReceiptPage.lnkInventorymanagement(), transferOrderReceiptPage.lnkTransferOrder());
		 String noofboxes=StringUtils.defaultIfBlank(masterDto.getAttributeValue("NoOfBoxes"), "");

//		try {
//
//			if (transferOrderReceiptPage.btnNewTransferOrder().isDisplayed()
//					&& transferOrderReceiptPage.btnTransferOrderIcon().isDisplayed()
//					&& transferOrderReceiptPage.btnShip().isDisplayed()
//					&& transferOrderReceiptPage.btnReceive().isDisplayed()) {
//				reportHelper.generateLogFullScreenSS(test,
//						"Nvigating sucessfully of Transfer order page using following path Inventory management>>Outbound orders>>Transfer order:Is Passed");
//				reportHelper.onTestSuccess(test,
//						"Navigating sucessfully of Transfer order page using following path Inventory management>>Outbound orders>>Transfer order:Is Passed");
//			} else {
//				reportHelper.generateLogFullScreenSS(test,
//						"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order :Is Failed");
//				reportHelper.onTestFailure(test,
//						"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order : Is Failed");
//			}
//		} catch (Exception e) {
//			reportHelper.generateLogFullScreenSS(test,
//					"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order");
//			reportHelper.onTestFailure(test,
//					"Navigating not sucessfully of Transfer page using following path Inventory management>>Outbound orders>>Transfer order");
//
//		}
//		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.lnkInventorymanagement());
//		
//		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.lnkTransferOrder());
		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnNewTransferOrder());

		
		genericHelper.clearAndSendKeysAndEnter(transferOrderReceiptPage.txtFromWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
		genericHelper.clearAndSendKeysAndEnter(transferOrderReceiptPage.txtToWarehouse(),
				getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

		//genericHelper.sendKeysWithjavascriptExecutor(transferOrderReceiptPage.txtTransferType(),masterDto.getAttributeValue("Transfer Type"));
		
		genericHelper.clearAndSendKeysWithJavascriptExecutor(transferOrderReceiptPage.txtNoOfBoxes(), noofboxes);
	       Thread.sleep(200);

		reportHelper.generateLogFullScreenSS(test, "Succesfully select transfer type");
		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTransferOrderIcon());

		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTagScan());

		genericHelper.sendKeysWithjavascriptExecutor(transferOrderReceiptPage.txtTransTag(),
				masterDto.getAttributeValue("Scan Tag"));
		Thread.sleep(2000);
		transferOrderReceiptPage.btnOtherclick().click();
		reportHelper.generateLogFullScreenSS(test, "Release tag  scan sucessfully");
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTransGenerateLine());
		Thread.sleep(2000);

		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnShip());
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnShipTransfer());
		Thread.sleep(2000);
		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnOkS());
		
		 Thread.sleep(2000);
         genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnPrintTransfer());
         Thread.sleep(200);
         reportHelper.generateLogFullScreenSS(test, "Transfer order Print Receipt is generated Sucessfully");
         
		

//		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnReceive());
//		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnShipReceive());
//		genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnOkR());
	
//		checkNotificationPresenceAndHandle(masterDto);
//		
//		Thread.sleep(2000);
		
//		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Tag"), "");
//		String tsite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("TransferSite"), "");
//
//
//		genericHelper.clickWithJavascriptExecutor(allTagPage.lnkModules());
//		// genericHelper.clickWithJavascriptExecutor(atp.clickModules());
//		Thread.sleep(2000);
//		genericHelper.clickWithJavascriptExecutor(allTagPage.lnkJewellery());
//		genericHelper.clickWithJavascriptExecutor(allTagPage.lnkAllTags());
//		genericHelper.clickWithJavascriptExecutor(allTagPage.btnO	k());
//		Thread.sleep(1000);
//
//		WebElement batchn = allTagPage.btnBatchNo();
//		genericHelper.scrollingTillWebElement(batchn);
//		genericHelper.clickWithJavascriptExecutor(allTagPage.btnBatchNo());
//
//		allTagPage.txtbatchno().sendKeys(tag);
//		Thread.sleep(4000);
//		allTagPage.btnApply().click();
//		Thread.sleep(2000);
//		
//		WebElement site=allTagPage.txtCurrentSite();
//		String wsite=site.getAttribute("value");
//		System.out.println("Get Site is:"+wsite);
//		
//		
//		if (tsite.equals(wsite)) {
//			reportHelper.onTestSuccess(test, "Transfer Tag to specified location"  +tsite+  "is sucessfully: ");
//		} else {
//			reportHelper.onTestFailure(test, "Transfer Tag to specified location"  +tsite+  "is not sucessfully: ");
//		}
//		// driver.navigate().refresh();
//
	}

public void negativeTransferOrderReceipt(ExtentTest test, MasterDto masterDto) throws Exception {
	
	navigateToPage(transferOrderReceiptPage.lnkInventorymanagement(), transferOrderReceiptPage.lnkTransferOrder());
	 String noofboxes=StringUtils.defaultIfBlank(masterDto.getAttributeValue("NoOfBoxes"), "");

	
	genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnNewTransferOrder());

	
	genericHelper.clearAndSendKeysAndEnter(transferOrderReceiptPage.txtFromWarehouse(),
			getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
	genericHelper.clearAndSendKeysAndEnter(transferOrderReceiptPage.txtToWarehouse(),
			getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

	//genericHelper.sendKeysWithjavascriptExecutor(transferOrderReceiptPage.txtTransferType(),masterDto.getAttributeValue("Transfer Type"));
	
	genericHelper.clearAndSendKeysWithJavascriptExecutor(transferOrderReceiptPage.txtNoOfBoxes(), noofboxes);
       Thread.sleep(200);

	reportHelper.generateLogFullScreenSS(test, "Succesfully select transfer type");
	genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTransferOrderIcon());

	genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTagScan());

	genericHelper.sendKeysWithjavascriptExecutor(transferOrderReceiptPage.txtTransTag(),
			masterDto.getAttributeValue("Scan Tag"));
	Thread.sleep(2000);
	transferOrderReceiptPage.btnOtherclick().click();
	
	
	
}
public void validateNoOfBoxesField(ExtentTest test, MasterDto masterDto) throws Exception {
	
	navigateToPage(transferOrderReceiptPage.lnkInventorymanagement(), transferOrderReceiptPage.lnkTransferOrder());
	 String noofboxes=StringUtils.defaultIfBlank(masterDto.getAttributeValue("NoOfBoxes"), "");

	
	genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnNewTransferOrder());

	
	genericHelper.clearAndSendKeysAndEnter(transferOrderReceiptPage.txtFromWarehouse(),
			getValueOrDefault(masterDto.getAttributeValue("From Warehouse")));
	genericHelper.clearAndSendKeysAndEnter(transferOrderReceiptPage.txtToWarehouse(),
			getValueOrDefault(masterDto.getAttributeValue("To Warehouse")));

	//genericHelper.sendKeysWithjavascriptExecutor(transferOrderReceiptPage.txtTransferType(),masterDto.getAttributeValue("Transfer Type"));
	
	genericHelper.clearAndSendKeysWithJavascriptExecutor(transferOrderReceiptPage.txtNoOfBoxes(), noofboxes);
      Thread.sleep(200);

	reportHelper.generateLogFullScreenSS(test, "Succesfully select transfer type");
	genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTransferOrderIcon());

	genericHelper.clickWithJavascriptExecutor(transferOrderReceiptPage.btnTagScan());
	
}
}

