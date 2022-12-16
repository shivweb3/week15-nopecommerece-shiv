package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class NokiaLumiaPhonePage extends Utility {
    //*****************************Nokia Lumia 1020 Product**********************************************//
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Nokia Lumia 1020']")
    WebElement nokiaLumiaText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-price']//span[text()=' $349.00 ']")
    WebElement price;
    @CacheLookup
    @FindBy(id = "product_enteredQuantity_20")
    WebElement editQuantity;
    @CacheLookup
    @FindBy(id = "add-to-cart-button-20")
    WebElement clickAddToCart;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]")
    WebElement productAddedText;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/span[1]")
    WebElement closeMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement hoverCart;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement clickCart;



    // Verify text “Nokia Lumia 1020”
    public String getNokiaLumia1020Text(){
        Reporter.log("Verify text “Nokia Lumia 1020”" +nokiaLumiaText.toString());
        CustomListeners.test.log(Status.PASS,"Verify text “Nokia Lumia 1020”");
        return getTextFromElement(nokiaLumiaText);
    }

    //2.7 Verify the price “$349.00”
    public String getTotal(){
        Reporter.log("Verify the price “$349.00”" +price.toString());
        CustomListeners.test.log(Status.PASS,"Verify the price “$349.00”");
        return getTextFromElement(price);
    }

    //2.8 Change quantity to 2
    public void changeTheQuantityTo(String quantity){
        Reporter.log("Change quantity to"+quantity+" in quantity field" +editQuantity.toString());
        sendTextToElement(editQuantity,quantity);
        CustomListeners.test.log(Status.PASS,"Change quantity to "+ quantity);

    }

    //2.9 Click on “ADD TO CART” tab
    public void clickOnAddToCartButton(){
        Reporter.log("Click on “ADD TO CART” tab" +clickAddToCart.toString());
        mouseHoverToElementAndClick(clickAddToCart);
        CustomListeners.test.log(Status.PASS,"Click on “ADD TO CART” tab");

    }

    //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
    public String getProductAddedSuccessfullyText(){
        Reporter.log("Verify the Message \"The product has been added to your shopping cart\" on Top green Bar" +productAddedText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Message \"The product has been added to your shopping cart\" on Top green Bar");
        return getTextFromElement(productAddedText);
    }

    // 2.10 After that close the bar clicking on the cross button.
    public void clickOnCrossButtonOnGreenBar(){
        Reporter.log("Close the green bar clicking on the cross button" +closeMessage.toString());
        clickOnElement(closeMessage);
        CustomListeners.test.log(Status.PASS,"Close the green bar clicking on the cross button");
    }

    //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    public void mouseHoverOnShoppingCart(){
        Reporter.log("MouseHover on \"Shopping cart\"" +hoverCart.toString());
        mouseHoverToElement(hoverCart);
        CustomListeners.test.log(Status.PASS,"MouseHover on \"Shopping cart\"");
    }

    //2.14 Click on "GO TO CART" button.
    public void clickOnGoToCart(){
        Reporter.log("Click on \"GO TO CART\" button." +clickCart.toString());
        clickOnElement(clickCart);
        CustomListeners.test.log(Status.PASS,"Click on \"GO TO CART\" button.");
    }
}
