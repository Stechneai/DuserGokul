package com.d365.core;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.d365.utils.MasterClass;
import com.sharedutils.MasterDto;

public class ReprintingOfLabel extends MasterClass {

	public void changeCategory(ExtentTest test, MasterDto masterDto) throws InterruptedException {

		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String item = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Item"), "");
		String category = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Category"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItem(), item);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownCategory(), category);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(), tag);

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());

	}

	public void addSubSmith(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {

		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String subsmith = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Sub Smith Change"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(), tag);

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		//String tagg="ACP000000076";
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

	//	genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGrossWt());
//		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelSubsmith());
//		genericHelper.javascriptExecutor.executeScript("arguments[0].scrollIntoView({ inline: 'center' });",
//				reprintingoflabelpage.labelSubsmith());
	//	genericHelper.actions.moveToElement(reprintingoflabelpage.labelGrossWt()).perform();
	//	genericHelper.actions.moveToElement(reprintingoflabelpage.labelSubsmith()).perform();
		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetSubsmith());
		
		WebElement sname = reprintingoflabelpage.txtGetSubsmith();
		
		String actualsubsmith = sname.getAttribute("value");
		System.out.println("Subsmit Name:" + actualsubsmith);

		if (actualsubsmith.equals(subsmith)) {
			reportHelper.onTestSuccess(test, "Subsmith is added " + actualsubsmith + " sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Subsmith is not added " + actualsubsmith + " sucessfully:");
		}

	}

	public void validate(ExtentTest test, MasterDto masterDto) throws InterruptedException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String subsmith = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Sub Smith Change"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(), tag);

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());

	}

	public void post(ExtentTest test, MasterDto masterDto) throws InterruptedException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String subsmith = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Sub Smith Change"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(), tag);

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());

	}

	public void negativeTestCasesSubSmith(ExtentTest test, MasterDto masterDto) throws InterruptedException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String subsmith = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Sub Smith Change"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		//genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(), tag);

//		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());

	}
	public void negativeTestCasesSubSmithChange(ExtentTest test, MasterDto masterDto) throws InterruptedException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String subsmith = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Sub Smith Change"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		//genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysWithjavascriptExecutor(reprintingoflabelpage.dropDownSubSmith(), subsmith);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(), tag);

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());

	}
	
	public void validateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String subsmithlabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Sub Smith Change"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		WebElement subsmithn=reprintingoflabelpage.labelGetSubsmith();
		String actualsubsmithn=subsmithn.getText();
		System.out.println(actualsubsmithn);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actualsubsmithn.equals(subsmithlabel))
		{
			reportHelper.onTestSuccess(test, "Field is  " + actualsubsmithn + " displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Field is not  " + actualsubsmithn + " displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Field is  " + actualtagn + " displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Field is not  " + actualtagn + " displayed:");
		}
		
	}
	
	public void attributeValidateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangelabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		WebElement attributechangen=reprintingoflabelpage.labelGetAttributeChange();
		String actualattributechangen=attributechangen.getText();
		System.out.println(actualattributechangen);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actualattributechangen.equals(attributechangelabel))
		{
			reportHelper.onTestSuccess(test, "Attribute Change  " + actualattributechangen + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Attribute Change  " + actualattributechangen + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, " Scan Tag fields  " + actualtagn + "  is displayed: ");
		} else {
			reportHelper.onTestFailure(test, " Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	public void ornamentValidateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String valuelabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		WebElement valuen=reprintingoflabelpage.labelGetValue();
		String actalvaluen=valuen.getText();
		System.out.println(actalvaluen);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actalvaluen.equals(valuelabel))
		{
			reportHelper.onTestSuccess(test, "value fields  " + actalvaluen + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, " value fields  " + actalvaluen + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	
	public void addSize(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		System.out.println("Value is:"+value);
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetValue(),value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		//String tagg="ACP000000076";
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelOrnamentSize());
		
		WebElement ornaments = reprintingoflabelpage.labelOrnamentSize();
		
		String actualornamentsize = ornaments.getAttribute("value");
		System.out.println("Ornament Size:" + actualornamentsize);

		if (actualornamentsize.equals(value)) {
			reportHelper.onTestSuccess(test, "Ornammen size is added " + actualornamentsize + " sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Ornament Size is not added " + actualornamentsize + " sucessfully:");
		}
	}
	
	public void validateF(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
	
	
	}
	
	public void postF(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
	
	}
	
	public void negativeOrnament(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");
 
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		//genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
	
	
	}
	
	public void addDesignCode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtDesigncodeValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetDesigncode());
		
		WebElement designcode = reprintingoflabelpage.txtGetDesignCode();
		
		String actualdesigncode = designcode.getAttribute("value");
		System.out.println("Ornament Size:" + actualdesigncode);

		if (actualdesigncode.equals(value)) {
			reportHelper.onTestSuccess(test, "Design Code is added " + actualdesigncode + " sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Design Code is not added " + actualdesigncode + " sucessfully:");
		}
	}
	
	public void negativeDesignCode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtDesigncodeValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		//genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		//genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
	}
	
	public void validateDesigncode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtDesigncodeValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		
		
	}
	public void postDesigncode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");
		String expectedMessage = getValueOrDefault(masterDto.getAttributeValue("Expected Message"));
		System.out.println("expectedMessage:" + expectedMessage);

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtDesigncodeValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
	}
	public void addHmPcs(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetDesigncode());
		
		WebElement hmpcs = reprintingoflabelpage.txtGetHmPcs();
		
		String actualhmpcs = hmpcs.getAttribute("value");
		System.out.println("Hm Pcs:" + actualhmpcs);

		if (actualhmpcs.equals(value)) {
			reportHelper.onTestSuccess(test, "Hm Pcs is added " + actualhmpcs + " sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Hm Pcs Code is not added " + actualhmpcs + " sucessfully:");
		}
	}
	
	public void negativeHmPcs(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtTagNo(),
				tag);
		
	//	genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
	//	genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
	}
	public void validateHmPcs(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");
		

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
	}
	public void postHmPcs(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		reprintingoflabelpage.txtGetValue().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
	}
	public void addCollectionCode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		//reprintingoflabelpage.txtGetCollectionCode().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetCollectionCode());
		
		WebElement collectioncode = reprintingoflabelpage.txtGetCollectionCode();
		
		String actualcollectioncode = collectioncode.getAttribute("value");
		System.out.println("Collection Code:" + actualcollectioncode);

		if (actualcollectioncode.equals(value)) {
			reportHelper.onTestSuccess(test, "Collection code is added " + actualcollectioncode + " sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Collection code is not added " + actualcollectioncode + " sucessfully:");
		}
	}
	public void negativeCollectionCode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
	//	genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
	//	genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
	}
	public void validateCollectionCode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
				
	}
	public void postCollectionCode(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
	}

	public void addCertificateNo(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetCerticateNo());
		
		WebElement certificateno = reprintingoflabelpage.txtGetCertificateNo();
		
		String actualcertificateno = certificateno.getAttribute("value");
		System.out.println("Certificate No:" + actualcertificateno);

		if (actualcertificateno.equals(value)) {
			reportHelper.onTestSuccess(test, "Certificate No  is added " + actualcertificateno + " sucessfully: ");
		} else {
			reportHelper.onTestFailure(test, "Certificate No is not added " + actualcertificateno + " sucessfully:");
		}
	}
	public void negativeCertificateNo(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		//genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		//genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		}
	public void validateCertificateNo(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
	}
	public void postCertificateNo(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String value = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtDesigncodeValue(),
				value);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
	}
	public void designCodeValidateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String valuelabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		WebElement valuen=reprintingoflabelpage.labelGetValue();
		String actalvaluen=valuen.getText();
		System.out.println(actalvaluen);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actalvaluen.equals(valuelabel))
		{
			reportHelper.onTestSuccess(test, "value fields  " + actalvaluen + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, " value fields  " + actalvaluen + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	public void hmPcsValidateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String valuelabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		WebElement valuen=reprintingoflabelpage.labelGetValue();
		String actalvaluen=valuen.getText();
		System.out.println(actalvaluen);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actalvaluen.equals(valuelabel))
		{
			reportHelper.onTestSuccess(test, "value fields  " + actalvaluen + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, " value fields  " + actalvaluen + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	public void collectionCodeValidateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String valuelabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		WebElement valuen=reprintingoflabelpage.labelGetValue();
		String actalvaluen=valuen.getText();
		System.out.println(actalvaluen);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actalvaluen.equals(valuelabel))
		{
			reportHelper.onTestSuccess(test, "value fields  " + actalvaluen + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, " value fields  " + actalvaluen + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	public void certificateNoValidateField(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String attributechangetxt = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Attribute Change"), "");
		String valuelabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Value"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtGetAttributeChange(),
				attributechangetxt);
		
		WebElement valuen=reprintingoflabelpage.labelGetValue();
		String actalvaluen=valuen.getText();
		System.out.println(actalvaluen);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actalvaluen.equals(valuelabel))
		{
			reportHelper.onTestSuccess(test, "value fields  " + actalvaluen + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, " value fields  " + actalvaluen + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	public void navigationRepritingofLabel(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());
		
		try {

			if (reprintingoflabelpage.btnNew().isDisplayed() && reprintingoflabelpage.lnkValidate().isDisplayed()
					&& reprintingoflabelpage.lnkPost().isDisplayed()
					&& reprintingoflabelpage.labelGetTag().isEnabled()) {
				reportHelper.generateLogFullScreenSS(test,
						"Repriting of label navigation sucessfully 1. New  2.Validate 3. Post 4. Scan tag :Is Passed");
				reportHelper.onTestSuccess(test,
						"Repriting of label navigation sucessfully 1. New  2.Validate 3. Post 4. Scan tag :Is Passed");
			} else {
				reportHelper.generateLogFullScreenSS(test,
						"Repriting of label navigation not sucessfully 1. New  2.Validate 3. Post 4. Scan tag :Is Passed:Is Failed");
				reportHelper.onTestFailure(test,
						"Repriting of label navigation sucessfully 1. New 2.Validate 3. Post 4. Scan tag :Is Passed : Is Failed");
			}
		} catch (Exception e) {
			reportHelper.generateLogFullScreenSS(test,
					"Repriting of label navigation not sucessfully 1. New  2.Validate 3. Post 4. Scan tag :Is Passed");
			reportHelper.onTestFailure(test,
					"Repriting of label navigation not sucessfully 1. New  2.Validate 3. Post 4. Scan tag :Is Passed");

		}
		
	}
	public void selectDropdownLocation(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
	    String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
	    System.out.println("Selecting location: " + location);

	    // Navigate to the "Reprinting of Label" page
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

	    // Click the dropdown arrow to open the options
	    WebElement dropdownArrow = driver.findElement(By.xpath("(//div[@class='lookupButton'])[2]"));
	    genericHelper.clickWithJavascriptExecutor(dropdownArrow); // Force-click the dropdown

	    Thread.sleep(2000); // Wait for dropdown to appear

	    // Locate and click the "Checking1" option inside the dropdown
	    WebElement checking1Option = driver.findElement(By.xpath("//div[contains(@class,'lookup-popup')]//td[contains(text(),'Checking1')]"));
	    genericHelper.clickWithJavascriptExecutor(checking1Option); // Ensure it gets selected

	    Thread.sleep(1000); // Wait for the selection to reflect

	    // Press Enter to confirm selection (if needed)
	    checking1Option.sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000); // Wait to see if the selection updates the field

	    // Click outside to close the dropdown and confirm selection
	    Actions action = new Actions(driver);
	    action.moveToElement(dropdownArrow).click().perform(); // Click outside dropdown

	    Thread.sleep(2000); // Wait for value to update

	    // Verify the selected value in the location field
	    WebElement locatn = reprintingoflabelpage.dropDownLocation();
	    String selectedValue = locatn.getAttribute("value").trim(); // Ensure we compare trimmed values
	    System.out.println("Selected Value: " + selectedValue);

	    if (selectedValue.equals("Checking1")) {
	        reportHelper.onTestSuccess(test, "Location selection successful: " + selectedValue);
	        reportHelper.generateLogFullScreenSS(test, "Location selection successful: " + selectedValue);
	    } else {
	        reportHelper.onTestFailure(test, "Location selection failed! Expected: " + location + ", Found: " + selectedValue);
	        reportHelper.generateLogFullScreenSS(test, "Location selection failed! Expected: " + location + ", Found: " + selectedValue);
	    }
	}

	
	public void validateSingleSelectionDropdownLocation(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
	    // Navigate to "Reprinting of Label" page
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
	    genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

	    // Click dropdown to open options
	    WebElement dropdown = reprintingoflabelpage.dropDownLocation();
	    genericHelper.clickWithJavascriptExecutor(dropdown);

	    Thread.sleep(2000); // Wait for options to load

	    // Select first option
	    WebElement firstOption = driver.findElement(By.xpath("//input[@value='Checking1']"));
	    firstOption.click();

	    Thread.sleep(1000); // Allow selection time

	    // Try selecting another option
	    genericHelper.clickWithJavascriptExecutor(dropdown); // Open dropdown again
	    Thread.sleep(1000);
	    WebElement secondOption = driver.findElement(By.xpath("//input[@value='Checking2']"));
	    secondOption.click();

	    Thread.sleep(1000); // Allow time for selection change

	    // Get the value of the location field after selecting second option
	    String selectedValue = dropdown.getAttribute("value");

	    if (selectedValue.equals("Checking2")) {
	        reportHelper.onTestSuccess(test, "Dropdown is a single-selection dropdown.");
	    } else {
	        reportHelper.onTestFailure(test, "Dropdown allows multiple selections.");
	    }

	    reportHelper.generateLogFullScreenSS(test, "Dropdown validation completed.");
	}

	public void addRateOrnament(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String wastagecode = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Wastage Code"), "");
		String mrate = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Making Rate"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.dropDownWastageCode(),
				wastagecode);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetMakingCode());
		
		WebElement makingcode = reprintingoflabelpage.txtGetMakingCode();
		
		String actualmakingcode = makingcode.getAttribute("value");
		System.out.println("Makingcode :" + actualmakingcode);
		
        genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetMakingRate());
		
		WebElement makingrate = reprintingoflabelpage.txtGetMakingRate();
		
		String actualmakingrate = makingrate.getAttribute("value");
		System.out.println("Making rate:" + actualmakingrate);

		reportHelper.performAssert(test, "Wastage Code", actualmakingcode, wastagecode);
		
		reportHelper.performAssert(test, "Making Rate", actualmakingrate, mrate);
	}
	public void negativeRateOrnament(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String wastagecode = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Wastage Code"), "");
		String mrate = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Making Rate"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.dropDownWastageCode(),
				wastagecode);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		
	}
	
	public void rateOrnamentFields(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		WebElement itemidl=reprintingoflabelpage.labelGetItemId();
		String actualitemidl=itemidl.getText();
		System.out.println(actualitemidl);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actualitemidl.equals(itemid))
		{
			reportHelper.onTestSuccess(test, "Item Id Field  " + actualitemidl + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Item Id Field " + actualitemidl + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	
	public void itemidOrnamentFields(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String wastagec = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Wastage Code"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		
		WebElement wastagecode=reprintingoflabelpage.labelGetWastageCode();
		String actualwastagecode=wastagecode.getText();
		System.out.println(actualwastagecode);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actualwastagecode.equals(wastagec))
		{
			reportHelper.onTestSuccess(test, "Wastage Code Field  " + actualwastagecode + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Wastage Code Field" + actualwastagecode + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	
	public void itemidMRPSterlingSilverFields(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String ratel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Rate Label"), "");
		String taglabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		
		WebElement rate=reprintingoflabelpage.labelGetRate();
		String actualrate=rate.getText();
		System.out.println(actualrate);
		
		WebElement tagn=reprintingoflabelpage.labelGetTag();
		String actualtagn=tagn.getText();
		System.out.println(actualtagn);
		
		if(actualrate.equals(ratel))
		{
			reportHelper.onTestSuccess(test, "Rate Field  " + actualrate + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Rate  Field" + actualrate + " is not displayed:");
		}
		
		if(actualtagn.equals(taglabel))
		{
			reportHelper.onTestSuccess(test, "Scan Tag fields  " + actualtagn + " is not displayed: ");
		} else {
			reportHelper.onTestFailure(test, "Scan Tag fields  " + actualtagn + " is not displayed:");
		}
		
	}
	public void addRateMRPSterlingSilver(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String ratev = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Rate"), "");
		String mrpv = StringUtils.defaultIfBlank(masterDto.getAttributeValue("MRP"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		reprintingoflabelpage.txtGetRate().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetRate(),
				ratev);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
		
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkAllTags());

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnOk());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.labelGetBatchNo());

		
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetBatchNo(), tag);
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnApply());

		genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetMRP());
		
		WebElement mrp = reprintingoflabelpage.txtGetMRP();
		
		String actualmrp = mrp.getAttribute("value");
		System.out.println("MRP value :" + actualmrp);
		
	//	reportHelper.performAssert(test, "MRP", actualmrp, mrpv);
		
		if(actualmrp.equals(mrpv))
		{
			reportHelper.onTestSuccess(test, "MRP value  " + actualmrp + " is displayed: ");
		} else {
			reportHelper.onTestFailure(test, "MRP Value" + actualmrp + " is not displayed:");
		}
//        genericHelper.scrollingTillWebElement(reprintingoflabelpage.labelGetRate());
//		
//		WebElement rate = reprintingoflabelpage.txtGetRate();
//		
//		String actualrate = rate.getAttribute("value");
//		System.out.println("Rate:" + actualrate);
//
//		
//		
//		reportHelper.performAssert(test, "Rate", actualrate, ratev);
	}
	
	public void negativeRateMRPSterlingSilver(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String ratev = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Rate"), "");
		String mrpv = StringUtils.defaultIfBlank(masterDto.getAttributeValue("MRP"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		reprintingoflabelpage.txtGetRate().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetRate(),
				ratev);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
	//	genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
	
		
	}
	public void validateRateMRPSterlingSilver(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String ratev = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Rate"), "");
		String mrpv = StringUtils.defaultIfBlank(masterDto.getAttributeValue("MRP"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		reprintingoflabelpage.txtGetRate().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetRate(),
				ratev);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
	}
	public void postRateMRPSterlingSilver(ExtentTest test, MasterDto masterDto) throws InterruptedException, IOException {
		String location = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Location"), "");
		System.out.println(location);
		String reoflabel = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Purpose of Reprinting"), "");
		String itemid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Select Item"), "");
		String ratev = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Rate"), "");
		String mrpv = StringUtils.defaultIfBlank(masterDto.getAttributeValue("MRP"), "");
		String tag = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Tag"), "");

		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkModules());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkJewellery());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkReprintingOfLabel());
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.btnNew());

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownLocation(), location);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownPurposeOfReprinting(),
				reoflabel);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.dropDownItemid(),
				itemid);
		
		reprintingoflabelpage.txtGetRate().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		genericHelper.clearAndSendKeysAndEnter(reprintingoflabelpage.txtGetRate(),
				ratev);
		
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(reprintingoflabelpage.txtTagNo(),
				tag);
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkValidate());
		
		genericHelper.clickWithJavascriptExecutor(reprintingoflabelpage.lnkPost());
	
	}
	
}
