package com.d365.core;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;


import org.apache.commons.lang3.StringUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.d365.utils.MasterClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration; 


public class Transfer extends MasterClass {
	
	
	    // Method definition
	    public void addTagTransfer() throws InterruptedException, IOException {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Correct WebDriverWait usage

	        String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
	        String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
	        String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
	        String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
	        String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
	        String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
	        String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");

	        genericHelper.clickWithJavascriptExecutor(transferpage.clickNewOrder());

	       
	        genericHelper.sendKeysAndEnterWithWait(transferpage.enterSite(), datasite, 0);
	        genericHelper.clearAndSendKeysAndEnter(transferpage.enterWarehouse(), datawarehouse);

	        genericHelper.clickWithJavascriptExecutor(transferpage.clickOk());
	        genericHelper.clickWithJavascriptExecutor(transferpage.clickTagScanning());

	        genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterTag(), datatag);
	       // Thread.sleep(2000);
	        genericHelper.actions.sendKeys(Keys.TAB).build().perform();

	        Thread.sleep(2000);
	        try {
	            // Wait for visibility of invalid tag
	            wait.until(ExpectedConditions.visibilityOf(transferpage.checkInvalidTag()));
	            if (transferpage.checkInvalidTag().isDisplayed()) {
	                System.out.println("Tag is not valid: Tag is either not from the selected location or not in release status.");
	                reportHelper.generateLogFullScreenSS(test, "Tag is not from selected location or Tag is not release status");
	               
	            }
	        } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
	            System.out.println("No invalid tag element found. Proceeding with valid tag actions.");
	            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterLocation(), datalocation);
	            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterCounter(), datalocationid);
	            genericHelper.clickWithJavascriptExecutor(transferpage.clickGenerateLine());

	            Thread.sleep(2000);

	            genericHelper.clickWithJavascriptExecutor(transferpage.clickReleased());
	            Thread.sleep(2000);

	            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterScanningStatus(), statusyes);
	            Thread.sleep(3000);

	            transferpage.clickValidate().click();
	            Thread.sleep(3000);

	            genericHelper.clickWithJavascriptExecutor(transferpage.clickValidateOk());
	            Thread.sleep(3000);

	            genericHelper.clickWithJavascriptExecutor(transferpage.clickLines());
	            genericHelper.clickWithJavascriptExecutor(transferpage.clickPost());

	            Thread.sleep(3000);
	            genericHelper.clickWithJavascriptExecutor(transferpage.clickPostOK());
	            Thread.sleep(2000);
	        }


	    }
	
	public void addBulkTagTransfer() throws InterruptedException, IOException {

		String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
		String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
		String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
		String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
		String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
		String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
		String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");
		


		genericHelper.clickWithJavascriptExecutor(transferpage.clickNewOrder());
		
		genericHelper.sendKeysAndEnterWithWait(transferpage.enterSite(), datasite, 0);
		genericHelper.clearAndSendKeysAndEnter(transferpage.enterWarehouse(), datawarehouse);

		genericHelper.clickWithJavascriptExecutor(transferpage.clickOk());
		genericHelper.clickWithJavascriptExecutor(transferpage.clickTagScanning());
		Thread.sleep(3000);
		
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickToggleButton());
		Thread.sleep(2000);

		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterTag(), datatag);
		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterLocation(), datalocation);
		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterCounter(), datalocationid);
		genericHelper.clickWithJavascriptExecutor(transferpage.clickGenerateLine());

		Thread.sleep(2000);

		genericHelper.clickWithJavascriptExecutor(transferpage.clickReleased());
		Thread.sleep(2000);

		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterScanningStatus(), statusyes);
		Thread.sleep(3000);

		transferpage.clickValidate().click();
		Thread.sleep(3000);
		genericHelper.clickWithJavascriptExecutor(transferpage.clickValidateOk());
		Thread.sleep(3000);
//		genericHelper.clickWithJavascriptExecutor(transferpage.clickLines());

		genericHelper.clickWithJavascriptExecutor(transferpage.clickPost());
		Thread.sleep(3000);
		genericHelper.clickWithJavascriptExecutor(transferpage.clickPostOK());

	}	
	public void validateNavigation() throws InterruptedException, IOException {

		String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
		String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
		String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
		String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
		String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
		String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
		String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");
		

		navigateToPage(transferpage.clickInventoryManagement(), transferpage.clickTransfer());
		genericHelper.clickWithJavascriptExecutor(transferpage.clickNewOrder());
		try {

			if (transferpage.saveButton().isDisplayed() && transferpage.clickNewOrder().isDisplayed()
					&& transferpage.clickValidate().isDisplayed()
					&& transferpage.clickReleased().isDisplayed()) {
				reportHelper.generateLogFullScreenSS(test,
						"Navigating sucessfully of Transfer page using following path Inventory management>>Journal entries>>Item>>Transfer:Is Passed");
				reportHelper.onTestSuccess(test,
						"Navigating sucessfully of Transfer page using following path Inventory management>>Journal entries>>Item>>Transfer:Is Passed");
			} else {
				reportHelper.generateLogFullScreenSS(test,
						"Navigating not sucessfully of Transfer page using following path Inventory management>>Journal entries>>Item>>Transfer:Is Passed");
				reportHelper.onTestFailure(test,
						"Navigating not sucessfully of Transfer page using following path Inventory management>>Journal entries>>Item>>Transfer:Is Passed");
			}
		} catch (Exception e) {
			reportHelper.generateLogFullScreenSS(test,
					"Navigating not sucessfully of Transfer page using following path Inventory management>>Journal entries>>Item>>Transfer:Is Passed");
			reportHelper.onTestFailure(test,
					"Navigating not sucessfully of Transfer page using following path Inventory management>>Journal entries>>Item>>Transfer:Is Passed");

		}
		Thread.sleep(2000);		
		 try {
	            // Wait for visibility of the name field
	            wait.until(ExpectedConditions.visibilityOf(transferpage.checkName()));
	            if (transferpage.checkName().isDisplayed()) {
	                reportHelper.generateLogFullScreenSS(test, "Name is Invt displayed");
	            }
	        } catch (NoSuchElementException | TimeoutException e) {  // Handle NoSuchElement and Timeout exceptions
	            reportHelper.generateLogFullScreenSS(test, "Name is Invt not displayed or took too long.");
	        }

	        try {
	            // Wait for visibility of the description field
	            wait.until(ExpectedConditions.visibilityOf(transferpage.checkDescription()));
	            if (transferpage.checkDescription().isDisplayed()) {
	                reportHelper.generateLogFullScreenSS(test, "Description is Transfer");
	            }
	        } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
	            reportHelper.generateLogFullScreenSS(test, "Description is not Transfer or took too long.");
	        }

		
		genericHelper.sendKeysAndEnterWithWait(transferpage.enterSite(), datasite, 10);
		genericHelper.clearAndSendKeysAndEnter(transferpage.enterWarehouse(), datawarehouse);

		genericHelper.clickWithJavascriptExecutor(transferpage.clickOk());
		genericHelper.clickWithJavascriptExecutor(transferpage.clickTagScanning());
		Thread.sleep(3000);
		
		genericHelper.clickWithJavascriptExecutor(transferorderpage.clickToggleButton());
		Thread.sleep(2000);

		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterTag(), datatag);
		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterLocation(), datalocation);
		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterCounter(), datalocationid);
		genericHelper.clickWithJavascriptExecutor(transferpage.clickGenerateLine());

		Thread.sleep(2000);

		genericHelper.clickWithJavascriptExecutor(transferpage.clickReleased());
		Thread.sleep(2000);

		genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterScanningStatus(), statusyes);
		Thread.sleep(3000);

		transferpage.clickValidate().click();
		Thread.sleep(3000);
		genericHelper.clickWithJavascriptExecutor(transferpage.clickValidateOk());
		Thread.sleep(3000);
//		genericHelper.clickWithJavascriptExecutor(transferpage.clickLines());

		genericHelper.clickWithJavascriptExecutor(transferpage.clickPost());
		Thread.sleep(3000);
		genericHelper.clickWithJavascriptExecutor(transferpage.clickPostOK());

	}	
	public void validateTagCounter() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Correct WebDriverWait usage

        String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
        String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
        String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
        String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
        String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
        String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
        String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");

        genericHelper.clickWithJavascriptExecutor(transferpage.clickNewOrder());

       
        genericHelper.sendKeysAndEnterWithjavascriptExecutor(transferpage.enterSite(), datasite);
        genericHelper.clearAndSendKeysAndEnter(transferpage.enterWarehouse(), datawarehouse);

        genericHelper.clickWithJavascriptExecutor(transferpage.clickOk());
        genericHelper.clickWithJavascriptExecutor(transferpage.clickTagScanning());

        genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterTag(), datatag);
       // Thread.sleep(2000);
        genericHelper.actions.sendKeys(Keys.TAB).build().perform();

        Thread.sleep(2000);
        try {
            // Wait for visibility of invalid tag
            wait.until(ExpectedConditions.visibilityOf(transferpage.checkInvalidTag()));
            if (transferpage.checkInvalidTag().isDisplayed()) {
                System.out.println("Tag is not valid: Tag is either not from the selected location or not in release status.");
                reportHelper.generateLogFullScreenSS(test, "Tag is not from selected location or Tag is not release status");
               
            }
        } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
            System.out.println("No invalid tag element found. Proceeding with valid tag actions.");
            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterLocation(), datalocation);
            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterCounter(), datalocationid);
            genericHelper.clickWithJavascriptExecutor(transferpage.clickGenerateLine());

            Thread.sleep(2000);

            genericHelper.clickWithJavascriptExecutor(transferpage.clickReleased());
            Thread.sleep(2000);

            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterScanningStatus(), statusyes);
            Thread.sleep(3000);

            transferpage.clickValidate().click();
            Thread.sleep(3000);

            genericHelper.clickWithJavascriptExecutor(transferpage.clickValidateOk());
            Thread.sleep(3000);

            genericHelper.clickWithJavascriptExecutor(transferpage.clickLines());
            genericHelper.clickWithJavascriptExecutor(transferpage.clickPost());

            Thread.sleep(3000);
            genericHelper.clickWithJavascriptExecutor(transferpage.clickPostOK());
            Thread.sleep(2000);
            String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Tag"), "");
    		String wloc = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ValidateLocation"), "");
    		System.out.println(wloc);
    		


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
    		
    		WebElement loc = alltagpage.scrollLocation();
    		genericHelper.scrollingTillWebElement(loc);
    		
    		
    		WebElement locatn=alltagpage.getLocation();
    		String location=locatn.getAttribute("value");
    		System.out.println("Get Site is:"+location);
    		
    		
    		if (wloc.equals(location)) {
    			reportHelper.onTestSuccess(test, "Transfer Tag to specified counter"  +wloc+  "is sucessfully: ");
    		} else {
    			reportHelper.onTestFailure(test, "Transfer Tag to specified counter"  +wloc+  "is not sucessfully: ");
    		}


           
        }
	}
        public void validateGeneratedTagDetails() throws InterruptedException, IOException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Correct WebDriverWait usage

            String Tagtype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag Type"), "");
            String datasite = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Site"), "");
            String datawarehouse = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Warehouse"), "");
            String datatag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Scan Individual Tag"), "");
            String datalocation = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Invent Location"), "");
            String datalocationid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SewMSLocationId"), "");
            String statusyes = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ScanningStatus"), "");
            String getquantity = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Quantity"), "");

            genericHelper.clickWithJavascriptExecutor(transferpage.clickNewOrder());

           
            genericHelper.sendKeysAndEnterWithjavascriptExecutor(transferpage.enterSite(), datasite);
            genericHelper.clearAndSendKeysAndEnter(transferpage.enterWarehouse(), datawarehouse);

            genericHelper.clickWithJavascriptExecutor(transferpage.clickOk());
            genericHelper.clickWithJavascriptExecutor(transferpage.clickTagScanning());

            genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterTag(), datatag);
           // Thread.sleep(2000);
            genericHelper.actions.sendKeys(Keys.TAB).build().perform();

            Thread.sleep(2000);
            try {
                // Wait for visibility of invalid tag
                wait.until(ExpectedConditions.visibilityOf(transferpage.checkInvalidTag()));
                if (transferpage.checkInvalidTag().isDisplayed()) {
                    System.out.println("Tag is not valid: Tag is either not from the selected location or not in release status.");
                    reportHelper.generateLogFullScreenSS(test, "Tag is not from selected location or Tag is not release status");
                   
                }
            } catch (NoSuchElementException | TimeoutException e) {  // Handle exceptions
                System.out.println("No invalid tag element found. Proceeding with valid tag actions.");
                genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterLocation(), datalocation);
                genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterCounter(), datalocationid);
                genericHelper.clickWithJavascriptExecutor(transferpage.clickGenerateLine());

                Thread.sleep(2000);
                
                WebElement qty=transferpage.getQuantity();
                String quantity=qty.getAttribute("title");
                System.out.println(quantity);
                
                reportHelper.performAssert(test, statusyes, getquantity, quantity);
                
                

                genericHelper.clickWithJavascriptExecutor(transferpage.clickReleased());
                Thread.sleep(2000);

                genericHelper.sendKeysWithjavascriptExecutor(transferpage.enterScanningStatus(), statusyes);
                Thread.sleep(3000);

                transferpage.clickValidate().click();
                Thread.sleep(3000);

                genericHelper.clickWithJavascriptExecutor(transferpage.clickValidateOk());
                Thread.sleep(3000);

                genericHelper.clickWithJavascriptExecutor(transferpage.clickLines());
                genericHelper.clickWithJavascriptExecutor(transferpage.clickPost());

                Thread.sleep(3000);
                genericHelper.clickWithJavascriptExecutor(transferpage.clickPostOK());
                Thread.sleep(2000);
                
          
               

               
            }

        }
}
    



		



