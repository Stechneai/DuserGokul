package com.d365.pagelayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d365.utils.MasterClass;

public class CommonFieldsV extends MasterClass {

	public CommonFieldsV() {
		PageFactory.initElements(driver, this);
	}

}
