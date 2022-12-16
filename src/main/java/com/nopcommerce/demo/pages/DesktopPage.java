package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement selectSorted;

    @CacheLookup
    @FindBy(xpath = "//div[@data-productid='1']/div[2]/div[3]/div[2]/button[1]")
    WebElement clickComputer;

    //1.3 Select Sort By position "Name: Z to A"
    public void selectSortedPosition(String text) {
        Reporter.log("Select Sort By position \"Name: Z to A\"" +selectSorted.toString());
        clickOnElement(selectSorted);
        selectByVisibleTextFromDropDown(selectSorted, text);
        CustomListeners.test.log(Status.PASS,"Select Sort By position \"Name: Z to A\"");
    }

    //Click on add to cart of product "Build your own computer"
    public void clickOnAddToCartOfBuildYourOwnComputer(){
        Reporter.log("Click on add to cart of product \"Build your own computer\"" +clickComputer.toString());
        mouseHoverToElementAndClick(clickComputer);
        CustomListeners.test.log(Status.PASS,"Click on add to cart of product \"Build your own computer\"");
    }
}
