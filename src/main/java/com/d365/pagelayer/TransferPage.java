package com.d365.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.d365.utils.MasterClass;

public class TransferPage extends MasterClass {
	public TransferPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//Span[@class='workspace-image GroupedList-symbol']")
	private WebElement module;

	public WebElement clickModule() {
		return module;
	}

	@FindBy(xpath = "//span[contains(@id, 'SystemDefinedSaveButton_label')]")
	private WebElement Save_B;

	public WebElement saveButton() {
		return Save_B;
	}

	@FindBy(xpath = "//button[contains(@role,'button') and contains(@title,'Messages in list.')]")
	WebElement expandNotification;

	public WebElement expandNotificationBtn() {
		return expandNotification;
	}

	@FindBy(name = "Close")
	WebElement errorClose;

	public WebElement errorCloseButton() {
		return errorClose;
	}

	@FindBy(xpath = "(//button[@data-dyn-controlname='MessageBarToggle' and @class='messageBar-button messageBar-collapseButton'])[2]")
	private WebElement noteOpenButton;

	public WebElement notificationOpenButton() {
		return noteOpenButton;
	}

//	@FindBy(xpath = "//a[text()='Jewellery']")
//	private WebElement jewellery;
//
//	public WebElement clickJewellery() {
//		return jewellery;
//	}

	@FindBy(xpath = "//a[text()='Inventory management']")
	private WebElement inventorymanagement;

	public WebElement clickInventoryManagement() {
		return inventorymanagement;

	}

	@FindBy(xpath = "//a[text()='Transfer']")
	private WebElement transfer;

	public WebElement clickTransfer() {
		return transfer;

	}

	@FindBy(name = "SystemDefinedNewButton")
	private WebElement neworder;

	public WebElement clickNewOrder() {
		return neworder;

	}

	@FindBy(name = "RetailStoreInventory_InventSiteId")
	private WebElement site;

	public WebElement enterSite() {
		return site;

	}

	@FindBy(xpath = "//input[@name='RetailStoreInventory_InventLocationId']")
	private WebElement warehouse;

	public WebElement enterWarehouse() {
		return warehouse;

	}

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement ok;

	public WebElement clickOk() {
		return ok;

	}

	@FindBy(xpath = "//span[text()='Tag Scanning']")
	private WebElement tagscanning;

	public WebElement clickTagScanning() {
		return tagscanning;

	}
//	@FindBy(xpath="//span[contains(@id,'AcxBarcodeScanning_') and contains (@id,'_SeBulkTagMarking_toggle')]")
//	private WebElement togglebutton;
//
//	public WebElement clickToggleButton() {
//		return togglebutton;
//
//	}

	@FindBy(name = "SeTag")
	private WebElement releasetag;

	public WebElement enterTag() {
		return releasetag;

	}

	@FindBy(name = "SeInventLocation")
	private WebElement location;

	public WebElement enterLocation() {
		return location;

	}

	@FindBy(xpath = "//input[@name='SewMSLocationId']")
	private WebElement counter;

	public WebElement enterCounter() {
		return counter;

	}

	@FindBy(xpath = "//span[text()='Generate Line']")
	private WebElement generateline;

	public WebElement clickGenerateLine() {
		return generateline;

	}

	@FindBy(xpath = "//span[text()='Validate']")
	private WebElement validate;

	public WebElement clickValidate() {
		return validate;

	}

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement validateok;

	public WebElement clickValidateOk() {
		return validateok;

	}

	@FindBy(xpath = "//span[text()='Release']")
	private WebElement tagrelease;

	public WebElement clickReleased() {
		return tagrelease;

	}

	@FindBy(xpath = "//input[@name='InventJournalTable_ScanningStatus']")
	private WebElement scanningstatus;

	public WebElement enterScanningStatus() {
		return scanningstatus;

	}

	@FindBy(xpath = "//span[text()='Post']")
	private WebElement post;

	public WebElement clickPost() {
		return post;

	}

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement postok;

	public WebElement clickPostOK() {
		return postok;
	}

	@FindBy(xpath = "//span[contains(text(),'Journal:')]")
	private WebElement message;

	public WebElement checkValidMessage() {
		return message;
	}

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement home;

	public WebElement clickHome() {
		return home;

	}

	@FindBy(xpath = "//span[text()='Lines']")
	private WebElement lines;

	public WebElement clickLines() {
		return lines;

	}

	@FindBy(xpath = "//input[@aria-label='Vehicle No.']")
	private WebElement vehicleno;

	public WebElement enterVehicleNo() {
		return vehicleno;

	}

	@FindBy(xpath = "//input[@aria-label='Document No.']")
	private WebElement documentno;

	public WebElement enterDocumentNo() {
		return documentno;

	}

	@FindBy(xpath = "//input[@aria-label='Document date']")
	private WebElement documentdate;

	public WebElement enterDocumentDate() {
		return documentdate;

	}

	@FindBy(xpath = "//input[@aria-label='Document date']")
	private WebElement vehicletype;

	public WebElement enterVehicleType() {
		return vehicletype;

	}

	@FindBy(xpath = "//span[contains(@id,'AcxBarcodeScanning_') and contains (@id,'_SeBulkTagMarking_toggle')]")
	private WebElement togglebutton;

	public WebElement clickToggleButton() {
		return togglebutton;

	}

	@FindBy(name = "InventJournalTable_JournalNameId")
	// @FindBy(xpath="(//input[@title='InvT'])[3]")
	private WebElement name;

	public WebElement checkName() {
		return name;

	}

	@FindBy(name = "InventJournalTable_JournalNameId")
	private WebElement description;

	public WebElement checkDescription() {
		return description;

	}

	@FindBy(xpath = "//span[text()='Tag is not from selected location or Tag is not release status']")
	private WebElement invalidtag;

	public WebElement checkInvalidTag() {
		return invalidtag;

	}

	@FindBy(xpath = "//label[text()='Invent Location *']")
	private WebElement labellocation;

	public WebElement labelLocation() {
		return labellocation;

	}
	@FindBy(name = "//input[contains(@id, 'InventJournalTrans_Qty') and contains(@id, '_input')]")
	private WebElement qty;

	public WebElement getQuantity() {
		return qty;
	}
	

	@FindBy(name = "//input[contains(@id, 'InventJournalTrans_FineWeight') and contains(@id, '_input')]")
	private WebElement finewt;

	public WebElement getFineWeight() {
		return finewt;
	}
	@FindBy(name = "//input[contains(@id, 'InventJournalTrans_AcxNetWeight') and contains(@id, '_input')]")
	private WebElement netwt;

	public WebElement getNetWeight() {
		return netwt;
	}
	@FindBy(name = "//input[contains(@id, 'InventJournalTrans_Purity') and contains(@id, '_input')]")
	private WebElement purity;

	public WebElement getPurity() {
		return purity;
	}
	@FindBy(name = "//input[contains(@id, 'InventJournalTrans_PurchaseCost') and contains(@id, '_input')]")
	private WebElement purcost;

	public WebElement getPurchaseCost() {
		return purcost;
	}

}
