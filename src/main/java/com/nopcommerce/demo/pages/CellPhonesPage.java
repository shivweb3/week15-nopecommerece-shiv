package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CellPhonesPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Cell phones']")
    WebElement cellPhoneText;

    @CacheLookup
    @FindBy(xpath = "//a[text()='List']")
    WebElement clickListview;

    @CacheLookup
    @FindBy(linkText = "Nokia Lumia 1020")
    WebElement clickNokiaLumia;

    //1.3 Verify the text “Cell phones”
    public String getCellPhoneText(){
        Reporter.log("Verify the text “Cell phones”" +cellPhoneText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text “Cell phones”");
        return getTextFromElement(cellPhoneText);
    }

    //2.4 Click on List View Tab
    public void clickOnListViewTab(){
        Reporter.log("Click on List View Tab" +clickListview.toString());
        clickOnElement(clickListview);
        CustomListeners.test.log(Status.PASS,"Click on List View Tab");
    }

    //2.5 Click on product name “Nokia Lumia 1020” link
    public void clickOnNokiaLumia1020CellPhone() {
        Reporter.log("Click on product name “Nokia Lumia 1020” link" +clickNokiaLumia.toString());
        mouseHoverToElementAndClick(clickNokiaLumia);
        CustomListeners.test.log(Status.PASS,"Click on product name “Nokia Lumia 1020” link");
    }

}
