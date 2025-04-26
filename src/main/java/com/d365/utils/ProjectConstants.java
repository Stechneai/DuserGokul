package com.d365.utils;

import java.io.File;

public interface ProjectConstants {

	public String qaName = "Kiran Dhanepkar";
//	public String CustomerOrderDocTitle = "RNG";
//	public String CustomerOrderReportName = "Customer Order";
	public String docTitle = "TransferOrderReceiptNegative";
	public String reportName = "TransferOrderReceiptNegative";
	public String username = "testing@csjewels.co.in";
	public String password = "Branch@4321";
	public String docTitle = "D365";
	public String reportName = "D365";
	public String username = "kiran.dhanepkar@techneai.com";
	public String password = "1994@Kiru";

	public String excelPath = "./public/data/";
	public String reprintingOfLabel = "ReprintingOfLabeling.xlsx";
	public String hmtype = "HmTypeP2P.xlsx";
	public String pdcreport = "PDCSheet.xlsx";
	public String defaultmaturitylist = "MaturityDefaulterList.xlsx";
	public String transferOrderModuleSheet = "TransferOrderModule_TestData.xlsx";
	public String transferModuleSheet = "TransferModule_TestData.xlsx";
	
	public String transferReceiptModuleSheet="TransferReceiptModule.xlsx";
	public String transferOrderReceiptModuleSheet="TransferOrderReceiptModule.xlsx";

	public String unFixMasterSheet = "Unfix.xlsx";
	public String duplicateentryProvisional ="Provisionalparcel1";
	public final String propertyFile = "./testResources/appData.properties";
	public final String configFile = "./testResources/config.properties";
	public final String DOWNLOAD_DIR = System.getProperty("user.home") + File.separator + "Downloads";
	
//	public final String currentDir = System.getProperty("user.dir");
//	public final String extentReportSSPath = "./extentReport/screenshot/";
//	public final String reportPath = "./extentReport/"; 

}
