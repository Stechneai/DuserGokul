package com.d365.testlayer;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class RunMonthlySavingSchemeDefaulterList extends MasterClass {
	ITestResult result;  
	
	@Test(enabled = true, groups = { "admin", "Jewellery", "MonthlySavingDefaulterList", "Validation" })
	public void validateDefaulterListReport() throws Throwable {

		List<MasterDto> masterDtos = excelHelper.getTestData(defaultmaturitylist, "Sheet1");
		for (MasterDto masterDto : masterDtos) {
//			try {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				monthlySavingSchemeDefaulterList.validateDefaulterListReport(test, masterDto);
				//checkNotificationPresenceAndHandleBR(masterDto);
//			} catch (Exception e) {
//				getResults(masterDto);
//			} finally {
//				reportHelper.generateExcelReport(test, result, masterDto);
//			}
		}
	
	}
}

