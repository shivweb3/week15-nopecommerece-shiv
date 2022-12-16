package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Register']")
    WebElement registerText;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstNameField ;
    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement dateField;
    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement monthField;
    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement yearField;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;
    @CacheLookup
    @FindBy(id = "register-button")
    WebElement clickRegister;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompleteText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickContinue;

    //2.19 Verify the text “Register”
    public String getRegisterText(){
        Reporter.log("Verify the text “Register”" +  registerText.toString());
        CustomListeners.test.log(Status.PASS, "Verify the text “Register”");
        return getTextFromElement(registerText);
    }
    //*************************************************************2.20 Fill the mandatory fields for Register*************************************//

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

    //Select Date
    public void selectDateOfBirth(String date){
        Reporter.log("Select Date" +date + " from date field " + dateField.toString());
        selectByVisibleTextFromDropDown(dateField,date);
        CustomListeners.test.log(Status.PASS, "Select Date " +date);
    }

    //Select month
    public void selectMonthOfBirth(String month){
        Reporter.log("Select Month" +month + " from Month field " + monthField.toString());
        selectByVisibleTextFromDropDown(monthField,month);
        CustomListeners.test.log(Status.PASS, "Select Month " +month);
    }

    //Select Year
    public void selectYearOfBirth(String year){
        Reporter.log("Select Year" +year+ " from Year field " + yearField.toString());
        selectByVisibleTextFromDropDown(yearField,year);
        CustomListeners.test.log(Status.PASS, "Select Year " + year);
    }

    //Enter Email
    public void enterEmail(String email){
        Reporter.log("Enter Email " +email+ " to Email field " + emailField.toString());
        sendTextToElement(emailField,email);
        CustomListeners.test.log(Status.PASS, "Enter Email " + email);
    }

    //Enter Password
    public void enterPassword(String password){
        Reporter.log("Enter Password " +password+ " to Password field " +passwordField.toString());
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    //Enter Confirm Password
    public void enterConfirmPassword(String confirmPassword){
        Reporter.log("Enter Confirm Password " +confirmPassword+ " to Password field " +confirmPasswordField.toString());
        sendTextToElement(confirmPasswordField,confirmPassword);
        CustomListeners.test.log(Status.PASS, "Enter Confirm Password " +confirmPassword);
    }

    //2.21 Click on “REGISTER” Button
    public void clickOnRegister(){
        Reporter.log("Click on “REGISTER” Button " +clickRegister.toString());
        clickOnElement(clickRegister);
        CustomListeners.test.log(Status.PASS, "Click on “REGISTER” Button");
    }

    //2.22 Verify the message “Your registration completed”
    public String getRegistrationCompleted(){
        Reporter.log(" Verify the message “Your registration completed” is display " +registrationCompleteText.toString());
        CustomListeners.test.log(Status.PASS, " Verify the message “Your registration completed”");
        return getTextFromElement(registrationCompleteText);
    }

    //2.23 Click on “CONTINUE” tab
    public void clickOnContinueButton(){
        Reporter.log("Click on “CONTINUE” tab " +clickContinue.toString());
        try {
            Thread.sleep(500);
            mouseHoverToElementAndClick(clickContinue);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        CustomListeners.test.log(Status.PASS, "Click on “CONTINUE” tab");

    }





}
