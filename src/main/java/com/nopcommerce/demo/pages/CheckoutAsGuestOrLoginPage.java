package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutAsGuestOrLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Checkout as Guest')]")
    WebElement clickCheckout;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement clickRegister;

    //2.20 Verify the Text “Welcome, Please Sign In!”
    public String getWelcomePleaseSignInText(){
        Reporter.log("Verify the Text “Welcome, Please Sign In!”" +welcomeText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Text “Welcome, Please Sign In!”");
        return getTextFromElement(welcomeText);

    }

    //2.21 Click on “CHECKOUT AS GUEST” Tab
    public void clickOnCheckoutAsGuest(){
        Reporter.log("Click on “CHECKOUT AS GUEST” Tab" +clickCheckout.toString());
        clickOnElement(clickCheckout);
        CustomListeners.test.log(Status.PASS,"Click on “CHECKOUT AS GUEST” Tab");
    }


    //2.18 Click on “Register” Tab
    public void clickOnRegisterTab(){
        Reporter.log("Click on “Register” Tab" +clickRegister.toString());
        clickOnElement(clickRegister);
        CustomListeners.test.log(Status.PASS,"Click on “Register” Tab");
    }
}
