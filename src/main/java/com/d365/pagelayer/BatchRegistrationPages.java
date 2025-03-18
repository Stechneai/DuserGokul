package com.d365.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.d365.utils.MasterClass;

public class BatchRegistrationPages extends MasterClass
{
     public BatchRegistrationPages()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     
   //----- Module
     @FindBy(xpath = "//div[@id='navPaneModuleID']")
     private WebElement btnModule;
     public WebElement btnModule() {
         return btnModule;
     }

     //----- Jewellery
     @FindBy(xpath = "//a[text()='Jewellery']")
     private WebElement btnJewellery;
     public WebElement btnJewellery() {
         return btnJewellery;
     }

     //---- Batch Registration
     @FindBy(xpath = "(//a[text()='Batch Registration'])[2]")
     private WebElement btnBatchRegistration;
     public WebElement btnBatchRegistration() {
         return btnBatchRegistration;
     }

     //---- New Button of Batch Registration
     @FindBy(xpath = "//span[text()='New']")
     private WebElement btnNewBatchRegistration;
     public WebElement btnNewBatchRegistration() {
         return btnNewBatchRegistration;
     }

     //--- PMC Button
     @FindBy(xpath = "//span[text()='PMC']")
     private WebElement btnPmc;
     public WebElement btnPmc() {
         return btnPmc;
     }

     //---- Challan Number
     @FindBy(xpath = "//input[contains(@name,'TA_BatchDocHeader_ChallanNo')]")
     private WebElement txtChallanNumber;
     public WebElement txtChallanNumber() {
         return txtChallanNumber;
     }

     //---- Purchase Transaction Price (100% Purity)
     @FindBy(xpath = "//input[contains(@name,'TA_BatchDocHeader_PurchTransPrice')]")
     private WebElement txtPurchaseTransPrice100;
     public WebElement txtPurchaseTransPrice100() {
         return txtPurchaseTransPrice100;
     }

     //--- Generate Line Button
     @FindBy(xpath = "(//span[text()='Generate Line'])[1]")
     private WebElement btnGenerateLine;
     public WebElement btnGenerateLine() {
         return btnGenerateLine;
     }

     //---- Item ID
     @FindBy(xpath = "//input[contains(@id,'AcxPreTagHeader_ItemId')]")
     private WebElement txtItemId;
     public WebElement txtItemId() {
         return txtItemId;
     }

     //---- Number of Pieces
     @FindBy(xpath = "//input[contains(@id,'AcxPreTagHeader_NoOfPieces')]")
     private WebElement txtNumberOfPieces;
     public WebElement txtNumberOfPieces() {
         return txtNumberOfPieces;
     }

     //---- Gross Weight
     @FindBy(xpath = "//input[contains(@id,'AcxPreTagHeader_GrossWeight')]")
     private WebElement txtGrossWeight;
     public WebElement txtGrossWeight() {
         return txtGrossWeight;
     }

     //---- Net Weight
     @FindBy(xpath = "//input[contains(@id,'AcxPreTagHeader_NetWeight')]")
     private WebElement txtNetWeight;
     public WebElement txtNetWeight() {
         return txtNetWeight;
     }

     //--- Pre-Tag Line
     @FindBy(xpath = "//span[text()='Pre Tag Lines']")
     private WebElement btnPreTagLine;
     public WebElement btnPreTagLine() {
         return btnPreTagLine;
     }

     //--- Purchase Transaction Value of Pre-Tag Line
     @FindBy(xpath = "//input[contains(@id,'AcxPreTagLines_LineAmount')]")
     private WebElement txtPreTagLinePurchaseValue;
     public WebElement txtPreTagLinePurchaseValue() {
         return txtPreTagLinePurchaseValue;
     }

     //--- Purchase Transaction Price of Pre-Tag Line
     @FindBy(xpath = "//input[contains(@id,'AcxPreTagLines_PurchPrice')]")
     private WebElement txtPreTagLinePurchasePrice;
     public WebElement txtPreTagLinePurchasePrice() {
         return txtPreTagLinePurchasePrice;
     }

     //---- Release Button
     @FindBy(xpath = "(//span[text()='Release'])[2]")
     private WebElement btnRelease;
     public WebElement btnRelease() {
         return btnRelease;
     }

     //--- Save Button
     @FindBy(xpath = "//span[contains(@id, 'SystemDefinedSaveButton_label')]")
     private WebElement btnSave;
     public WebElement btnSave() {
         return btnSave;
     }

     //--- Expand Notification Button
     @FindBy(xpath = "//button[contains(@role,'button') and contains(@title,'Messages in list.')]")
     private WebElement btnExpandNotification;
     public WebElement btnExpandNotification() {
         return btnExpandNotification;
     }

     //--- Error Close Button
     @FindBy(name = "Close")
     private WebElement btnErrorClose;
     public WebElement btnErrorClose() {
         return btnErrorClose;
     }

     //--- Invalid Error Message
     @FindBy(xpath = "(//h2[text()='Some of the information that you entered is not valid. You must enter valid information before you can continue.'])[1]")
     private WebElement txtInvalidErrorMessage;
     public WebElement txtInvalidErrorMessage() {
         return txtInvalidErrorMessage;
     }

     //--- Duplicate Error Message
     @FindBy(xpath = "//h1[contains (@id,'titleField') and contains(text(), 'The record already exists.')]")
     private WebElement txtDuplicateErrorMessage;
     public WebElement txtDuplicateErrorMessage() {
         return txtDuplicateErrorMessage;
     }

     //--- Post Button
     @FindBy(xpath = "//span[text()='Post']")
     private WebElement btnPost;
     public WebElement btnPost() {
         return btnPost;
     }
     
   //---btnpreTagheader
 	@FindBy(xpath="//span[text()=\"Pre Tag Header\"]")
 		private WebElement btnpreTagheader;	
 		public WebElement btnpreTagheader()
 		{
 		  return btnpreTagheader;
 		}
 		
 		//----txtreferenceDocNO
 		@FindBy(xpath="//input[contains(@id,\"AcxPreTagHeader_PurchId\")]")
 		private WebElement txtreferenceDocNO;	
 		public WebElement txtreferenceDocNO()
 		{
 		  return txtreferenceDocNO;
 		}

 		 //-----Module
 	    @FindBy(xpath="//div[@id=\"navPaneModuleID\"]")
 	    private WebElement btnclickModule;	
 	    public WebElement btnclickModule() {
 	        return btnclickModule;
 	    }

 	    //-----Jewellery
 	    @FindBy(xpath="//a[text()=\"Jewellery\"]")
 	    private WebElement btnclickJewellery;	
 	    public WebElement btnclickJewellery() {
 	        return btnclickJewellery;
 	    }

 	    //-----Provisional Parcel
 	    @FindBy(xpath="//a[contains(text(),\"Provisional Parc\")]")
 	    private WebElement btnprovisionalParcel;	
 	    public WebElement btnprovisionalParcel() {
 	        return btnprovisionalParcel;
 	    }

 	    //-----New button
 	    @FindBy(xpath="(//span[text()=\"New\"])[1]")
 	    private WebElement btnNew;	
 	    public WebElement btnNew() {
 	        return btnNew;
 	    }	

 	    //---Receive from
 	    @FindBy(xpath="//input[@name=\"TA_ParcelReceiveHeaderTable_SourceType\"]")
 	    private WebElement txtReceiveFrom;	
 	    public WebElement txtReceiveFrom() {
 	        return txtReceiveFrom;
 	    }

 	    //---Karigar/Vendor Code *
 	    @FindBy(xpath="//input[@name=\"TA_ParcelReceiveHeaderTable_karigarCode\"]")
 	    private WebElement txtVendorCode;	
 	    public WebElement txtVendorCode() {
 	        return txtVendorCode;
 	    }

 	    //---Chalan No
 	    @FindBy(xpath="//input[contains(@name,\"TA_BatchDocHeader_ChallanNo\")]")
 	    private WebElement txtChallanNo;	
 	    public WebElement txtChallanNo() {
 	        return txtChallanNo;
 	    }

 	    //---Warehouse
 	    @FindBy(xpath="//input[@name=\"TA_ParcelReceiveHeaderTable_InventLocationId\"]")
 	    private WebElement txtWareHouse;	
 	    public WebElement txtWareHouse() {
 	        return txtWareHouse;
 	    }

 	    //---new_parcel_receive_details
 	    @FindBy(xpath="(//span[text()=\"New\"])[2]")
 	    private WebElement btnNewParcelReceive;	
 	    public WebElement btnNewParcelReceive() {
 	        return btnNewParcelReceive;
 	    }

 	    //----ItemID
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_ItemId\")]")
 	    private WebElement txtItemID;	
 	    public WebElement txtItemID() {
 	        return txtItemID;
 	    }

 	    //---Configuration
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_Stand\")]")
 	    private WebElement txtConfiguration;	
 	    public WebElement txtConfiguration() {
 	        return txtConfiguration;
 	    }

 	    //----Purity
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_Ca\")]")
 	    private WebElement txtPurity;	
 	    public WebElement txtPurity() {
 	        return txtPurity;
 	    }

 	    //--RcvPcs
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_PRPcs\")]")
 	    private WebElement txtRcvPcs;	
 	    public WebElement txtRcvPcs() {
 	        return txtRcvPcs;
 	    }

 	    //-----MinimumWt
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_MinWei\")]")
 	    private WebElement txtMinimumWT;	
 	    public WebElement txtMinimumWT() {
 	        return txtMinimumWT;
 	    }

 	    //----MaxWt
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_MaxWei\")]")
 	    private WebElement txtMaximumWT;	
 	    public WebElement txtMaximumWT() {
 	        return txtMaximumWT;
 	    }

 	    //---Rcv Gross Wt
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_PRGrWeigh\")]")
 	    private WebElement txtRcvGrossWt;	
 	    public WebElement txtRcvGrossWt() {
 	        return txtRcvGrossWt;
 	    }

 	    //----Confirm button
 	    @FindBy(xpath="//span[text()=\"Confirm\"]")
 	    private WebElement btnConfirm;	
 	    public WebElement btnConfirm() {
 	        return btnConfirm;
 	    }

 	    //----Confirm Ok button
 	    @FindBy(xpath="//button[@name=\"Ok\"]")
 	    private WebElement btnConfirmOK;	
 	    public WebElement btnConfirmOK() {
 	        return btnConfirmOK;
 	    }

 	    //-----Issue button
 	    @FindBy(xpath="(//span[contains(@class,\"button-label button-label-dropDown\")])[4]")
 	    private WebElement btnIssue;	
 	    public WebElement btnIssue() {
 	        return btnIssue;
 	    }

 	    //----Issue to Design check
 	    @FindBy(xpath="//span[contains(text(),\"Issue To DC\")]")
 	    private WebElement chkIssueToDesignCheck;	
 	    public WebElement chkIssueToDesignCheck() {
 	        return chkIssueToDesignCheck;
 	    }

 	    //---WebElement of Home button
 	    @FindBy(xpath="//div[@id=\"home\"]")
 	    private WebElement btnHome;	
 	    public WebElement btnHome() {
 	        return btnHome;
 	    }

 	    //--close error message
 	    @FindBy(xpath="//span[@id=\"SysBoxForm_3_Close_label\"]")
 	    private WebElement btnCloseErrorMessage;	
 	    public WebElement btnCloseErrorMessage() {
 	        return btnCloseErrorMessage;
 	    }

 	    //---WEbElement of RcvStoneWT
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_RCVStoneWeight\")]")
 	    private WebElement txtRcvStoneWT;	
 	    public WebElement txtRcvStoneWT() {
 	        return txtRcvStoneWT;
 	    }

 	    //----WebElement of StoneName
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_StoneName\")]")
 	    private WebElement txtStoneName;	
 	    public WebElement txtStoneName() {
 	        return txtStoneName;
 	    }

 	    //-----WebElement of stoneVariant
 	    @FindBy(xpath="//input[contains(@id,\"TA_ParcelReceiveDetailsTable_StoneV\")]")
 	    private WebElement txtStoneVariant ;	
 	    public WebElement txtStoneVariant() {
 	        return txtStoneVariant;
 	    }

 	    //---InvalidChallanNoErrorMessage
 	    @FindBy(xpath="//span[contains(text(),\"Challen No should not be greater than 11\")]")
 	    private WebElement msgInvalidChallanNoError;	
 	    public WebElement msgInvalidChallanNoError() {
 	        return msgInvalidChallanNoError;
 	    }

 	    //----IssuetoQCfromPR
 	    @FindBy(xpath="//span[text()=\"Issue To QC\"]")
 	    private WebElement btnIssuetoQCfromPR ;	
 	    public WebElement btnIssuetoQCfromPR() {
 	        return btnIssuetoQCfromPR;
 	    }

 	    //---issueToHmfromProvisionalParcel
 	    @FindBy(xpath="//span[text()=\"Issue To HM\"]")
 	    private WebElement btnIssueToHmfromProvisionalParcel ;	
 	    public WebElement btnIssueToHmfromProvisionalParcel() {
 	        return btnIssueToHmfromProvisionalParcel;
 	    }

 	    //---IssuetoLMfromProvisionalParcel
 	    @FindBy(xpath="//span[text()=\"Issue To LM\"]")
 	    private WebElement btnIssuetoLMfromProvisionalParcel ;	
 	    public WebElement btnIssuetoLMfromProvisionalParcel() {
 	        return btnIssuetoLMfromProvisionalParcel;
 	    }

 	    //---IsuuetoPofromProvisionalParcel
 	    @FindBy(xpath="//span[text()=\"Issue To PO\"]")
 	    private WebElement btnIsuuetoPofromProvisionalParcel ;	
 	    public WebElement btnIsuuetoPofromProvisionalParcel() {
 	        return btnIsuuetoPofromProvisionalParcel;
 	    }

 	
 	    @FindBy(xpath = "(//button[@data-dyn-controlname='MessageBarToggle' and @class='messageBar-button messageBar-collapseButton'])[2]")
 	    private WebElement btnNotificationOpen;
 	    public WebElement btnNotificationOpen() {
 	        return btnNotificationOpen;
 	    }

 	    //---voucherNoprovisionalParcel
 	    @FindBy(xpath="//*[@id=\"TA_ParcelReceiveHeaderTable_VoucherNo1_3_0_0_input\"]")
 	    private WebElement txtVoucherNoprovisionalParcel ;	
 	    public WebElement txtVoucherNoprovisionalParcel() {
 	        return txtVoucherNoprovisionalParcel;
 	    }

 	    //--RejDCPCS
 	    @FindBy(xpath="//div[text()=\"Rej QC Net Weight\"]")
 	    private WebElement txtRejDCPCS ;	
 	    public WebElement txtRejDCPCS() {
 	        return txtRejDCPCS;
 	    }

 	    //---qcNetWt
 	    @FindBy(xpath="//div[contains(@id,\"TA_ParcelReceiveDetailsTable_IssQCNetWeight_206_0_hea\")]")
 	    private WebElement txtQcNetWt ;	
 	    public WebElement txtQcNetWt() {
 	        return txtQcNetWt;
 	    }

 	    @FindBy(xpath = "(//h2[text()='Some of the information that you entered is not valid. You must enter valid information before you can continue.'])[1]")
 	    private WebElement msgInvalidError;
 	    public WebElement msgInvalidError() {
 	        return msgInvalidError;
 	    }

 	    @FindBy(xpath = "//h1[contains (@id,'titleField') and contains(text(), 'The record already exists.')]")
 	    private WebElement msgDuplicateError;
 	    public WebElement msgDuplicateError() {
 	        return msgDuplicateError;
 	    }

 	    //---stonePcs
 	    @FindBy(xpath = "//input[contains(@id,\"TA_ParcelReceiveDetailsTable_NoofStonePcs\")]")
 	    private WebElement txtStonePcs;
 	    public WebElement txtStonePcs() {
 	        return txtStonePcs;
 	    }

 	    //---poRateType
 	    @FindBy(xpath = "//input[contains(@name,\"TA_ParcelReceiveHeaderTable_PoRateType\")]")
 	    private WebElement txtPoRateType;
 	    public WebElement txtPoRateType() {
 	        return txtPoRateType;
 	    }

 	    //---itemIdofFirstLine
 	    @FindBy(xpath = "(//input[contains(@id,\"TA_ParcelReceiveDetailsTable_ItemId\")])[1]")
 	    private WebElement txtItemIdofFirstLine;
 	    public WebElement txtItemIdofFirstLine() {
 	        return txtItemIdofFirstLine;
 	    }

 	    //---itemIdoSecondLine
 	    @FindBy(xpath = "(//input[contains(@id,\"TA_ParcelReceiveDetailsTable_ItemId\")])[2]")
 	    private WebElement txtItemIdoSecondLine;
 	    public WebElement txtItemIdoSecondLine() {
 	        return txtItemIdoSecondLine;
 	    }
 	    
 	   @FindBy(xpath="//input[contains(@name,\"TA_BatchDocHeader_InventLocati\")]")
 	  private WebElement txtCurrentWarehouseBR;
 	  public WebElement txtCurrentWarehouseBR() {
 	      return txtCurrentWarehouseBR;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"TA_BatchDocHeader_InventSite\")]")
 	  private WebElement txtCurrentSiteBR;
 	  public WebElement txtCurrentSiteBR() {
 	      return txtCurrentSiteBR;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"TA_BatchDocHeader_VendAccount\")]")
 	  private WebElement txtVendorAccount;
 	  public WebElement txtVendorAccount() {
 	      return txtVendorAccount;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"TA_BatchDocHeader_PurchTran\")]")
 	  private WebElement txtPurchTrans100Purity;
 	  public WebElement txtPurchTrans100Purity() {
 	      return txtPurchTrans100Purity;
 	  }

 	  @FindBy(xpath="(//input[contains(@name,\"TA_BatchDocHeader_Rate\")])[2]")
 	  private WebElement txtPurchTransRate99Purity;
 	  public WebElement txtPurchTransRate99Purity() {
 	      return txtPurchTransRate99Purity;
 	  }

 	  @FindBy(xpath="(//span[contains(@class,\"toggle-thumb\")])[1]")
 	  private WebElement btnToggleJobWork;
 	  public WebElement btnToggleJobWork() {
 	      return btnToggleJobWork;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"TA_BatchDocHeader_KaragirTy\")]")
 	  private WebElement radioAcceptorBoth;
 	  public WebElement radioAcceptorBoth() {
 	      return radioAcceptorBoth;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"AcceptAmount\")]")
 	  private WebElement txtAcceptAmountBR;
 	  public WebElement txtAcceptAmountBR() {
 	      return txtAcceptAmountBR;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"RejectAmount\")]")
 	  private WebElement txtRejectAmountBR;
 	  public WebElement txtRejectAmountBR() {
 	      return txtRejectAmountBR;
 	  }

 	  @FindBy(xpath="//input[contains(@name,\"TotalAmount\")]")
 	  private WebElement txtTotalAmount;
 	  public WebElement txtTotalAmount() {
 	      return txtTotalAmount;
 	  }

 	  @FindBy(xpath="//input[contains(@id,\"AcxPreTagHeader_NetWeight\")]")
 	  private WebElement txtNetWeightBRHeader;
 	  public WebElement txtNetWeightBRHeader() {
 	      return txtNetWeightBRHeader;
 	  }

 	  @FindBy(xpath="//button[contains(@name,\"CmdBtnNewPMC\")]")
 	  private WebElement btnNewPMC;
 	  public WebElement btnNewPMC() {
 	      return btnNewPMC;
 	  }

 	  @FindBy(xpath="//input[contains(@id,\"FormGridControl2_ItemCategory_\")]")
 	  private WebElement dropDownItemCategoryPMC;
 	  public WebElement dropDownItemCategoryPMC() {
 	      return dropDownItemCategoryPMC;
 	  }

 	  @FindBy(xpath="(//span[text()=\"Delete\"])[3]")
 	  private WebElement btnDeletePMC;
 	  public WebElement btnDeletePMC() {
 	      return btnDeletePMC;
 	  }

 	  @FindBy(xpath="//input[contains(@id,\"FormGridControl2_RateType\")]")
 	  private WebElement dropDownMakingTypePMC;
 	  public WebElement dropDownMakingTypePMC() {
 	      return dropDownMakingTypePMC;
 	  }

 	  @FindBy(xpath="//input[contains(@id,\"AcxPreTagHeader_MakingAmount\")]")
 	  private WebElement txtMakingAmountPreTagHeader;
 	  public WebElement txtMakingAmountPreTagHeader() {
 	      return txtMakingAmountPreTagHeader;
 	  }

 	  @FindBy(xpath="//span[text()=\"Pre Tag Header\"]")
 	  private WebElement labelPreTagHeader;
 	  public WebElement labelPreTagHeader() {
 	      return labelPreTagHeader;
 	  }

 	  @FindBy(xpath="(//div[contains(@class,\"dyn-container _31p7er dyn-svg-symbol dyn-combobo\")])[2]")
 	  private WebElement btnArrowItemCategory;
 	  public WebElement btnArrowItemCategory() {
 	      return btnArrowItemCategory;
 	  }

 	  @FindBy(xpath="//input[contains(@id,\"AcxPreTagHeader_PurchId\")]")
 	  private WebElement txtReferenceDocNo;
 	  public WebElement txtReferenceDocNo() {
 	      return txtReferenceDocNo;
 	  }

 	  @FindBy(xpath="(//input[contains(@id,\"FormGridControl2_PurchTransValue\")])[2]")
 	  private WebElement txtPMCValue;
 	  public WebElement txtPMCValue() {
 	      return txtPMCValue;
 	  }


 		
   

} 
     

