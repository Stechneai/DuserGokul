package com.d365.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.d365.utils.MasterClass;

public class AllTagPage extends MasterClass{

	public AllTagPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-dyn-title='Modules']")
	private WebElement module;

	public WebElement clickModules() {
		return module;
	}

	@FindBy(xpath = "//a[text()='Jewellery']") // add
	private WebElement jewellery;

	public WebElement clickJewellery() {
		return jewellery;
	}
	@FindBy(xpath = "//a[text()='All Tags']") // add
	private WebElement alltags;

	public WebElement clickAllTags() {
		return alltags;
	}
	@FindBy(xpath="//span[text()='OK']")
	private WebElement okbutton;	
	public WebElement clickOkButton()
	{
		return okbutton;
	}
	@FindBy(xpath="//input[contains(@id,\"AcxPreTagHeader_TagNo_3158_0_0_\")]")
	private WebElement gettagno;	
	public WebElement getTagNo()
	{
		return gettagno;
	}
	@FindBy(xpath="//div[text()='Batch No']")
	private WebElement batchno;	
	public WebElement clickBatchNo()
	{
		return batchno;
	}
	@FindBy(name="FilterField_MainGrid_InventBatchId_InventBatchId_Input_0")
	private WebElement enterbatchno;	
	public WebElement enterBatchNo()
	{
		return enterbatchno;
	}
	@FindBy(xpath="//span[@id='__MainGrid_InventBatchId_ApplyFilters_label']")
	private WebElement apply;	
	public WebElement clickApply()
	{
		return apply;
	}	
	@FindBy(xpath="//div[text()='Stone Weight(CT)']")
	private WebElement stoneweight;	
	public WebElement getStoneWeightName()
	{
		return stoneweight;
	}

//	@FindBy(xpath="//input[contains(@id,'MainGrid_TagT')]")
//	private WebElement getstatus;	
//	public WebElement getStatusName()
//	{
//		return getstatus;
//	}
	@FindBy(xpath="//input[contains(@id, 'MainGrid_TagType') and contains(@id, '_input')]")
	private WebElement tagtype;	
	public WebElement getStatusName()
	{
		return tagtype;
	}
	@FindBy(xpath="//input[contains(@id, 'MainGrid_InventSiteId') and contains(@id, '_input')]")
	private WebElement csite;	
	public WebElement getCurrentSite()
	{
		return csite;
	}
	@FindBy(xpath="//div[text()='Location']")
	private WebElement locationf;	
	public WebElement scrollLocation()
	{
		return locationf;
	}
	@FindBy(xpath="//input[contains(@id, 'MainGrid_wMSLocationId') and contains(@id, '_input')]")
	private WebElement location;	
	public WebElement getLocation()
	{
		return location;
	}


}
