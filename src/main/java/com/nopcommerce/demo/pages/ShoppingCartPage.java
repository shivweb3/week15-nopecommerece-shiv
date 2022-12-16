package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'page-title']//h1")
    WebElement shoppingCartText1;
    @CacheLookup
    @FindBy(xpath = "//td[@class='quantity']/input")
    WebElement quantity;
    @CacheLookup
    @FindBy(xpath = "//button[@id='updatecart']")
    WebElement clickUpdateCart;
    @CacheLookup
    @FindBy(xpath = "//td[@class= 'subtotal']/span")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement clickCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement clickCheckBox1;
    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;
    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton1;
    @CacheLookup
    @FindBy(xpath = "//input[@class='qty-input']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//td[@class='subtotal']//span[text()='$698.00']")
    WebElement total;

   //2.15 Verify the message "Shopping cart"
    public String getShoppingCartPageText(){
        Reporter.log("Verify the message \"Shopping cart\" is display" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Verify the message \"Shopping cart\"");
        return getTextFromElement(shoppingCartText);
    }
    public String getShoppingCartPageText1(){
        Reporter.log("Verify the message \"Shopping cart\" is display" + shoppingCartText1.toString());
        CustomListeners.test.log(Status.PASS, "Verify the message \"Shopping cart\"");
        return getTextFromElement(shoppingCartText1);
    }

   // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
    public void changeQuantity(String text){
        Reporter.log("Change the Qty to "+ text + quantity.toString());
        sendTextToElement(quantity,text);
        CustomListeners.test.log(Status.PASS, "Change the Qty to "+ text);

    }

    //2.16and Click on "Update shopping cart"
    public void clickOnUpdateShoppingCart(){
        Reporter.log("Click on 'Update shopping cart'"+ clickUpdateCart.toString());
        clickOnElement(clickUpdateCart);
        CustomListeners.test.log(Status.PASS, "Click on 'Update shopping cart'");
    }

    //2.17 Verify the Total"$2,950.00"
    public String getTotalPrice(){
        Reporter.log("Verify the Total\"$2,950.00\" is display" + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "Verify the Total\"$2,950.00\"");
        return getTextFromElement(totalPrice);
    }

    //2.18 click on checkbox “I agree with the terms of service”
    public void clickOnCheckBoxOfTermsAndService(){
        Reporter.log("Click on checkbox “I agree with the terms of service”" + clickCheckBox.toString());
        clickOnElement(clickCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on checkbox “I agree with the terms of service”");
    }
    public void clickOnCheckBoxOfTermsAndService1(){
        Reporter.log("Click on checkbox “I agree with the terms of service”" + clickCheckBox1.toString());
        clickOnElement(clickCheckBox1);
        CustomListeners.test.log(Status.PASS, "Click on checkbox “I agree with the terms of service”");
    }

    //2.19 Click on “CHECKOUT
    public void clickOnCheckOutButton(){
        Reporter.log("Click on “CHECKOUT button" + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS, "Click on “CHECKOUT button");
    }
    public void clickOnCheckOutButton1(){
        Reporter.log("Click on “CHECKOUT button" + checkoutButton1.toString());
        clickOnElement(checkoutButton1);
        CustomListeners.test.log(Status.PASS, "Click on “CHECKOUT button");
    }

    //2.13 Verify the quantity is 2
    public String getQuantityDisplayedOnPage(String text){
        Reporter.log("Verify the quantity is 2" + quantityField.toString());
        String text1 = getAttributeFromElement(quantityField,text);
        CustomListeners.test.log(Status.PASS, "Verify the quantity is "+ text1);
        return text1;
    }

    //2.14 Verify the Total $698.00
    public String getTotalPriceOfProduct(){
        Reporter.log("Verify the Total $698.00" + total.toString());
        CustomListeners.test.log(Status.PASS, "Verify the Total $698.00");
        return getTextFromElement(total);
    }

}
