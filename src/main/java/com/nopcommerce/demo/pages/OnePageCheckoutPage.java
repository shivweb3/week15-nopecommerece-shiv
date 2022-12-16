package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OnePageCheckoutPage extends Utility {
    @CacheLookup
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement state;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement city;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberField;
    @CacheLookup
    @FindBy(xpath = "//div[@id='billing-buttons-container']/button[4]")
    WebElement clickContinue;
    @CacheLookup
    @FindBy(id = "shippingoption_1")
    WebElement clickRadioButton;
    @CacheLookup
    @FindBy(id = "shippingoption_2")
    WebElement clickRadioButton1;
    @CacheLookup
    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
    WebElement clickContinue1;
    @CacheLookup
    @FindBy(xpath = "//input[@id='paymentmethod_1']")
    WebElement radioClick;

    @CacheLookup
    @FindBy(xpath = "//div[@id='payment-method-buttons-container']/button")
    WebElement click;
    @CacheLookup
    @FindBy(id = "CreditCardType")
    WebElement selectCard;
    @CacheLookup
    @FindBy(id = "CardholderName")
    WebElement cardHolder;
    @CacheLookup
    @FindBy(id = "CardNumber")
    WebElement cardNumberField;
    @CacheLookup
    @FindBy(id = "ExpireMonth")
    WebElement expiryMonthField;
    @CacheLookup
    @FindBy(id = "ExpireYear")
    WebElement expiryYearField;
    @CacheLookup
    @FindBy(id = "CardCode")
    WebElement cardCodeField;
    @CacheLookup
    @FindBy(xpath = "//div[@id='payment-info-buttons-container']/button")
    WebElement clickContinue2;
    @CacheLookup
    @FindBy(xpath = "//div[@class='payment-method-info']/ul/li")
    WebElement creditCardText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='shipping-method-info']/ul/li")
    WebElement nextDayAirText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='shipping-method-info']/ul/li")
    WebElement secondDayAirText;
    @CacheLookup
    @FindBy(xpath = "//tr[@class ='order-total']/td[2]/span//strong")
    WebElement totalPriceText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='confirm-order-buttons-container']//button")
    WebElement clickConfirm;
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Thank you']")
    WebElement thankYouText;
    @CacheLookup
    @FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
    WebElement successfullyText;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 order-completed-continue-button']")
    WebElement continue1;

    //************************************************2.22 Fill the all mandatory field*************************************************//
    //Enter FirstName
    public void enterFirstName(String firstName){
        Reporter.log("Enter Firstname " + firstName+ " to Firstname field " + firstNameField.toString());
        sendTextToElement(firstNameField,firstName+getRandomString(2));
        CustomListeners.test.log(Status.PASS, "Enter FirstName " + firstName);
    }

    //Enter LastName
    public void enterLastName(String lastName){
        Reporter.log("Enter LastName " + lastName+ " to LastName field " + lastNameField.toString());
        sendTextToElement(lastNameField,lastName+getRandomString(2));
        CustomListeners.test.log(Status.PASS, "Enter LastName " + lastName);
    }

    //Enter Email
    public void enterEmail(String email){
        Reporter.log("Enter Email " + email+ " to Email field " + emailField.toString());
        sendTextToElement(emailField,email);
        CustomListeners.test.log(Status.PASS, "Enter Email " + email);
    }

    //Select country
    public void selectCountry(String countryName){
        Reporter.log("Select country " + country.toString());
        selectByVisibleTextFromDropDown(country,countryName);
        CustomListeners.test.log(Status.PASS, "Select country "+ countryName);
    }

    //Select State
    public void selectState(String stateName){
        Reporter.log("Select State " + state.toString());
        selectByVisibleTextFromDropDown(state,stateName);
        CustomListeners.test.log(Status.PASS, "Select country "+ stateName);
    }

    //Enter City
    public void selectCity(String cityName){
        Reporter.log("Enter City" + city.toString());
        sendTextToElement(city,cityName);
        CustomListeners.test.log(Status.PASS, "Enter City "+ cityName);
    }

    //Enter Address 1
    public void enterAddressLine1(String addressLine){
        Reporter.log("Enter Address Line 1" + address.toString());
        sendTextToElement(address,addressLine);
        CustomListeners.test.log(Status.PASS, "Enter Address Line 1 "+ addressLine);
    }

    //Enter Zip code
    public void enterZipCode(String zipCode){
        Reporter.log("Enter Zip code " + zipCodeField.toString());
        sendTextToElement(zipCodeField,zipCode);
        CustomListeners.test.log(Status.PASS, "Enter Zip code "+ zipCode);
    }

    //Enter PhoneNumber
    public void enterPhoneNumber(String phoneNumber){
        Reporter.log("Enter PhoneNumber" + phoneNumberField.toString());
        sendTextToElement(phoneNumberField,phoneNumber);
        CustomListeners.test.log(Status.PASS, "Enter PhoneNumber "+ phoneNumber);
    }

    //2.23 Click on “CONTINUE”
    public void clickOnContinueButton1(){
        Reporter.log("Click on “CONTINUE”" + clickContinue.toString());
        clickOnElement(clickContinue);
        CustomListeners.test.log(Status.PASS, "Click on “CONTINUE” ");
    }

    //2.24 Click on Radio Button “Next Day Air($0.00)”
    public void clickOnNextDayAirRadioButton(){
        Reporter.log("Click on Radio Button “Next Day Air($0.00)”" + clickRadioButton.toString());
        clickOnElement(clickRadioButton);
        CustomListeners.test.log(Status.PASS, "Click on Radio Button “Next Day Air($0.00)” ");
    }

    //2.29 Click on Radio Button “2nd Day Air ($0.00)”
    public void clickOn2ndDayAirRadioButton(){
        Reporter.log("Click on Radio Button “2nd Day Air ($0.00)”" + clickRadioButton1.toString());
        clickOnElement(clickRadioButton1);
        CustomListeners.test.log(Status.PASS, "Click on Radio Button “2nd Day Air ($0.00)” ");
    }

    //2.25 Click on “CONTINUE”
    public void clickOnContinueButton2(){
        Reporter.log("Click on “CONTINUE”" + clickContinue1.toString());
        clickOnElement(clickContinue1);
        CustomListeners.test.log(Status.PASS, "Click on “CONTINUE”");
    }

    //2.26 Select Radio Button “Credit Card”
    public void clickOnCreditCardRadioButton(){
        Reporter.log("Select Radio Button “Credit Card”" + radioClick.toString());
        clickOnElement(radioClick);
        CustomListeners.test.log(Status.PASS, "Select Radio Button “Credit Card”");
    }

    //Click on “CONTINUE”
    public void clickOnContinueButton3(){
        Reporter.log("Click on “CONTINUE”" + click.toString());
        clickOnElement(click);
        CustomListeners.test.log(Status.PASS, "Click on “CONTINUE”");
    }

    //2.27 Select “Master card” From Select credit card dropdown
    public void selectCreditCardFromDropDown(String card){
        Reporter.log("Select “Master card” From Select credit card dropdown" + selectCard.toString());
        selectByVisibleTextFromDropDown(selectCard,card);
        CustomListeners.test.log(Status.PASS, "Select “Master card” From Select credit card dropdown");
    }
    //*********2.28 Fill all the details**************//

    //Enter CardHolder Name
    public void enterCardHolderName(String name){
        Reporter.log("Enter CardHolder Name" +name+ " to CardHolder name field " +cardHolder.toString());
        sendTextToElement(cardHolder,name+getRandomString(1));
        CustomListeners.test.log(Status.PASS, "Enter CardHolder Name " +name);
    }

    //Enter card number
    public void enterCardNumber(String cardNumber){
        Reporter.log("Enter Card Number" +cardNumber+ " to Card Number field " + cardNumberField.toString());
        sendTextToElement(cardNumberField,cardNumber);
        CustomListeners.test.log(Status.PASS, "Enter Card Number" +cardNumber);
    }

    //Select Expiry month
    public void selectExpiryMonthOfCard(String month){
        Reporter.log("Select Expiry Month" + expiryMonthField.toString());
        selectByVisibleTextFromDropDown(expiryMonthField,month);
        CustomListeners.test.log(Status.PASS, "Select Expiry Month" +month);
    }

    //Select Expiry Year
    public void selectExpiryYearOfCard(String year){
        Reporter.log("Select Expiry Year" + expiryYearField.toString());
        selectByVisibleTextFromDropDown(expiryYearField,year);
        CustomListeners.test.log(Status.PASS, "Select Expiry Year" +year);
    }

    //Enter Card code
    public void enterCardCode(String code){
        Reporter.log("Enter Card coder" +code+ "to card code field" +  cardCodeField.toString());
        sendTextToElement(cardCodeField,code);
        CustomListeners.test.log(Status.PASS, "Enter Card code" +code);
    }

    //2.29 Click on “CONTINUE”
    public void clickOnContinueButton4(){
        Reporter.log("Click on “CONTINUE”" +  clickContinue2.toString());
        clickOnElement(clickContinue2);
        CustomListeners.test.log(Status.PASS, "Click on “CONTINUE”");
    }

    //2.30 Verify “Payment Method” is “Credit Card”
    public String getPaymentMethodIsCreditCard(){
        Reporter.log("Verify “Payment Method” is “Credit Card”" +  creditCardText.toString());
        CustomListeners.test.log(Status.PASS, "Verify “Payment Method” is “Credit Card”");
        return getTextFromElement(creditCardText);
    }

    //2.32 Verify “Shipping Method” is “Next Day Air”
    public String getShoppingMethodIsNextDayAir(){
        Reporter.log(" Verify “Shipping Method” is “Next Day Air”" + nextDayAirText.toString());
        CustomListeners.test.log(Status.PASS, " Verify “Shipping Method” is “Next Day Air”");
        return getTextFromElement(nextDayAirText);
    }

    //2.36 Verify “Shipping Method” is “2nd Day Air”
    public String getShoppingMethodIs2ndDayAir(){
        Reporter.log(" Verify “Shipping Method” is “2nd Day Air”" + secondDayAirText.toString());
        CustomListeners.test.log(Status.PASS, "Verify “Shipping Method” is “2nd Day Air”");
        return getTextFromElement(secondDayAirText);
    }

    //2.33 Verify Total is “$2,950.00”
    public String getTotalPriceOfProduct(){
        Reporter.log("  Verify Total is “$2,950.00”" + secondDayAirText.toString());
        CustomListeners.test.log(Status.PASS, " Verify Total is “$2,950.00”");
        return getTextFromElement(totalPriceText);
    }

    //2.34 Click on “CONFIRM”
    public void clickOnConfirm(){
        Reporter.log("Click on “CONFIRM”" +clickConfirm.toString());
        clickOnElement(clickConfirm);
        CustomListeners.test.log(Status.PASS, " Click on “CONFIRM”");

    }

    //2.35 Verify the Text “Thank You”
    public String getThankYouText(){
        Reporter.log("Verify the Text “Thank You”" + thankYouText.toString());
        CustomListeners.test.log(Status.PASS, "Verify the Text “Thank You”");
        return getTextFromElement(thankYouText);
    }

    //2.36 Verify the message “Your order has been successfully processed!”
    public String getOrderSuccessfullyProcessed(){
        Reporter.log("Verify the message “Your order has been successfully processed!”" + successfullyText.toString());
        CustomListeners.test.log(Status.PASS, "Verify the message “Your order has been successfully processed!”");
        return getTextFromElement(successfullyText);
    }

    //2.37 Click on “CONTINUE”
    public void clickOnContinueButton(){
        Reporter.log("Click on “CONTINUE”" +continue1.toString());
        clickOnElement(continue1);
        CustomListeners.test.log(Status.PASS, "Click on “CONTINUE”");
    }
}
