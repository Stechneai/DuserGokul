package com.d365.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class MonthlySavingSchemeDefaulterList extends MasterClass {

	public void validateDefaulterListReport(ExtentTest test, MasterDto masterDto)
			throws InterruptedException, IOException, AWTException {
		String store = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Store"), "");
		String schemetype = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SchemeType"), "");
		String fromdate = StringUtils.defaultIfBlank(masterDto.getAttributeValue("FromDate"), "");
		System.out.println("From date" + fromdate);
		String todate = StringUtils.defaultIfBlank(masterDto.getAttributeValue("ToDate"), "");
		String type = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Type"), "");
		String customercode1 = StringUtils.defaultIfBlank(masterDto.getAttributeValue("CustomerCode1"), "");
		String customercode2 = StringUtils.defaultIfBlank(masterDto.getAttributeValue("CustomerCode2"), "");
		String customercode3 = StringUtils.defaultIfBlank(masterDto.getAttributeValue("CustomerCode3"), "");
		String schemeentryno1 = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SchemeEntryNumber1"), "");
		String schemeentryno2 = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SchemeEntryNumber2"), "");
		String schemeentryno3 = StringUtils.defaultIfBlank(masterDto.getAttributeValue("SchemeEntryNumber3"), "");

		genericHelper.clickWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.lnkModule());
		genericHelper.clickWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.lnkJewellery());
		genericHelper.scrollingTillWebElement(monthlySavingSchemeDefaulterListPage.lnkSchemeDefaulterList());

		genericHelper.clickWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.lnkSchemeDefaulterList());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(monthlySavingSchemeDefaulterListPage.dropDownStore(),
				store);
		Thread.sleep(2000);
		genericHelper.clearAndSendKeysWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.dropDownSchemeType(),
				schemetype);
		Thread.sleep(2000);

		String excelDate = "01-14-2025"; // Example input from Excel
		String formattedDate = convertDateFormatJava8(excelDate);
		genericHelper.clearAndSendKeysWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.datePickerFromDate(),
				formattedDate);

		// genericHelper.clearAndSendKeysWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.datePickerFromDate(),fromdate);
		Thread.sleep(2000);
		genericHelper.clearAndSendKeysWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.datePickerToDate(),
				todate);
		Thread.sleep(2000);
		genericHelper.clearAndSendKeysWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.dropDownType(), type);
		Thread.sleep(2000);
		monthlySavingSchemeDefaulterListPage.btnok().click();
		// genericHelper.clickWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.btnok());
		Thread.sleep(2000);
		 //genericHelper.clickWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.btnDownload());
		//monthlySavingSchemeDefaulterListPage.btnDownload().click();

		//Runtime.getRuntime().exec("C:/Users/lenovo/Downloads/downloadClick.exe");
		genericHelper.clickWithJavascriptExecutor(monthlySavingSchemeDefaulterListPage.btnDownload());
		 // Use Robot Class to handle system pop-ups
        Robot robot = new Robot();

        // Simulate pressing the "Enter" key to confirm download
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


		
		WebElement cuscode1 = monthlySavingSchemeDefaulterListPage.txtCustomerCode1();
		String actualCustomerCode1 = cuscode1.getAttribute("value");
		System.out.println("Value:" + actualCustomerCode1);

		WebElement schmentry1 = monthlySavingSchemeDefaulterListPage.txtSchemeEntryNo1();
		String actualSchemeEntryNo1 = schmentry1.getAttribute("value");
		System.out.println("Value:" + actualSchemeEntryNo1);
		
		
				WebElement cuscode2 = monthlySavingSchemeDefaulterListPage.txtCustomerCode2();
				String actualCustomerCode2 = cuscode2.getAttribute("value");
				System.out.println("Value:" + actualCustomerCode2);

				WebElement schmentry2 = monthlySavingSchemeDefaulterListPage.txtSchemeEntryNo2();
				String actualSchemeEntryNo2 = schmentry2.getAttribute("value");
				System.out.println("Value:" + actualSchemeEntryNo2);
				
				// Validate Making Item No.
				WebElement cuscode3 = monthlySavingSchemeDefaulterListPage.txtCustomerCode3();
				String actualCustomerCode3 = cuscode3.getAttribute("value");
				System.out.println("Value:" + actualCustomerCode3);

				WebElement schmentry3 = monthlySavingSchemeDefaulterListPage.txtSchemeEntryNo3();
				String actualSchemeEntryNo3 = schmentry3.getAttribute("value");
				System.out.println("Value:" + actualSchemeEntryNo3);

		if (customercode1.equalsIgnoreCase(actualCustomerCode1)
				&& schemeentryno1.equalsIgnoreCase(actualSchemeEntryNo1)) {
			reportHelper.onTestSuccess(test, "Customer code1 and SchemeEntryNo1 are correctly fetched.");
			reportHelper.generateLogFullScreenSS(test, "Customer code1 and SchemeEntryNo1 are correctly fetched.");
		} else {
			reportHelper.onTestFailure(test, "Customer code1 and SchemeEntryNo1 are not  correctly fetched.");
			reportHelper.generateLogFullScreenSS(test, "Customer code1 and SchemeEntryNo1 are not correctly fetched.");
		}
	
	if(customercode2.equalsIgnoreCase(actualCustomerCode2)&&schemeentryno2.equalsIgnoreCase(actualSchemeEntryNo2))

	{
		reportHelper.onTestSuccess(test, "Customer code2 and SchemeEntryNo2 are correctly fetched.");
		reportHelper.generateLogFullScreenSS(test, "Customer code2 and SchemeEntryNo2 are correctly fetched.");
	}else
	{
		reportHelper.onTestFailure(test, "Customer code2 and SchemeEntryNo2 are not  correctly fetched.");
		reportHelper.generateLogFullScreenSS(test, "Customer code2 and SchemeEntryNo2 are not correctly fetched.");
	}
 if(customercode3.equalsIgnoreCase(actualCustomerCode3)&&schemeentryno3.equalsIgnoreCase(actualSchemeEntryNo3))
{
reportHelper.onTestSuccess(test,"Customer code3 and SchemeEntryNo3 are correctly fetched.");
reportHelper.generateLogFullScreenSS(test,"Customer code1 and SchemeEntryNo1 are correctly fetched.");
}
else
{reportHelper.onTestFailure(test,"Customer code3 and SchemeEntryNo3 are not  correctly fetched.");
reportHelper.generateLogFullScreenSS(test,"Customer code3 and SchemeEntryNo3 are not correctly fetched.");
}
 }
	}
