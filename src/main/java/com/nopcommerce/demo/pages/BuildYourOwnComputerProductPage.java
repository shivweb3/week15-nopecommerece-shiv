package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement computerText;

    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processor;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement selectRAMField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement selectHDDButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    WebElement selectOSField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    WebElement selectCheckBoxField;

    @CacheLookup
    @FindBy(xpath = "//span[text()='$1,475.00']")
    WebElement price;

    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement clickButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='bar-notification success']")
    WebElement textMessage;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/span[1]")
    WebElement closeMessage;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement hoverCart;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement clickCart;



    //*****************************Build Your Own Computer Product**********************************************//
    //2.5 Verify the Text "Build your own computer"
    public String getBuildYourComputerText(){
        Reporter.log("Verify the Text 'Build your own computer'" +computerText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Text 'Build your own computer'");
        return getTextFromElement(computerText);
    }

    //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
    public void selectProcessor(String text){
        Reporter.log("Select" +text+ "processor" +processor.toString());
        selectByVisibleTextFromDropDown(processor,text);
        CustomListeners.test.log(Status.PASS,"Select "+ text);
    }

    //2.7.Select "8GB [+$60.00]" using Select class.
    public void selectRAM(String text){
        Reporter.log("Select "+text+ " RAM" +selectRAMField.toString());
        selectByVisibleTextFromDropDown(selectRAMField,text);
        CustomListeners.test.log(Status.PASS,"Select "+ text);
    }

    //2.8 Select HDD radio "400 GB [+$100.00]"
    public void selectHDDRadioButton(){
        Reporter.log("Select  '400 GB [+$100.00]'" +selectHDDButton.toString());
        clickOnElement(selectHDDButton);
        CustomListeners.test.log(Status.PASS,"Select HDD radio '400 GB [+$100.00]'");

    }

    //2.9 Select OS radio "Vista Premium [+$60.00]"
    public void selectOSVistaPremium(){
        Reporter.log("Select OS radio 'Vista Premium [+$60.00]'" +selectOSField.toString());
        clickOnElement(selectOSField);
        CustomListeners.test.log(Status.PASS,"Select OS radio 'Vista Premium [+$60.00]'");
    }

    //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
    public void selectTwoCheckBox(){
        Reporter.log("Check Two Check boxes 'Microsoft Office [+$50.00]' and 'Total Commander [+$5.00]'" +selectCheckBoxField.toString());
        clickOnElement(selectCheckBoxField);
        CustomListeners.test.log(Status.PASS,"Check Two Check boxes 'Microsoft Office [+$50.00]' and 'Total Commander [+$5.00]'");
    }

    //2.11 Verify the price "$1,475.00"
    public String getTotal(){
        Reporter.log("Verify the price '$1,475.00'" +price.toString());
        CustomListeners.test.log(Status.PASS,"Verify the price '$1,475.00'");
        return getTextFromElement(price);
    }

    //2.12 Click on "ADD TO CARD" Button.
    public void clickOnAddToCart(){
        Reporter.log("Click on 'ADD TO CARD' Button" +clickButton.toString());
        clickOnElement(clickButton);
        CustomListeners.test.log(Status.PASS,"Click on 'ADD TO CARD' Button");
    }

    //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
    public String getProductAddedMessage(){
        Reporter.log("Verify the Message 'The product has been added to your shopping cart' on Top green Bar" +textMessage.toString());
        CustomListeners.test.log(Status.PASS,"Verify the Message 'The product has been added to your shopping cart' on Top green Bar");
        return getTextFromElement(textMessage);
    }

    //2.13 After on green bar Close the bar clicking on the cross button.
    public void clickOnCrossButtonOnGreenBar(){
        Reporter.log("On green bar Close the bar clicking on the cross button." +closeMessage.toString());
        clickOnElement(closeMessage);
        CustomListeners.test.log(Status.PASS,"On green bar Close the bar clicking on the cross button.");
    }

    //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    public void mouseHoverOnShoppingCart(){
        Reporter.log("Then MouseHover on \"Shopping cart\" and Click on \"GO TO CART\" button." +hoverCart.toString());
        mouseHoverToElement(hoverCart);
        CustomListeners.test.log(Status.PASS,"Then MouseHover on \"Shopping cart\" and Click on \"GO TO CART\" button.");
    }

    //2.14 Click on "GO TO CART" button.
    public void clickOnGoToCart(){
        Reporter.log("Click on \"GO TO CART\" button." +clickCart.toString());
        clickOnElement(clickCart);
        CustomListeners.test.log(Status.PASS,"Click on \"GO TO CART\" button.");
    }
}
