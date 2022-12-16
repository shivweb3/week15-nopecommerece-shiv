package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class CellPhonesPageTest extends BaseTest {
    HomePage homePage;
    CellPhonesPage cellPhonesPage;
    NokiaLumiaPhonePage nokiaLumiaPhonePage;
    ShoppingCartPage shoppingCartPage;
    CheckoutAsGuestOrLoginPage checkoutAsGuestOrLoginPage ;
    RegisterPage registerPage;
    OnePageCheckoutPage onePageCheckoutPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        cellPhonesPage = new CellPhonesPage();
        nokiaLumiaPhonePage = new NokiaLumiaPhonePage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutAsGuestOrLoginPage = new CheckoutAsGuestOrLoginPage();
        registerPage = new RegisterPage();
        onePageCheckoutPage = new OnePageCheckoutPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        homePage.mouseHoverToElectronicTab();
        homePage.mouseHoverToCellPhoneLinkAndClick();
        Assert.assertEquals(cellPhonesPage.getCellPhoneText(),"Cell phones","User not navigate to cell phone page");

    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully () throws InterruptedException{
        homePage.mouseHoverToElectronicTab();
        homePage.mouseHoverToCellPhoneLinkAndClick();
        Assert.assertEquals(cellPhonesPage.getCellPhoneText(),"Cell phones","User not navigate to cell phone page");
        cellPhonesPage.clickOnListViewTab();
        Thread.sleep(500);
        cellPhonesPage.clickOnNokiaLumia1020CellPhone();
        Assert.assertEquals(nokiaLumiaPhonePage.getNokiaLumia1020Text(),"Nokia Lumia 1020"," User Not Navigate to nokia lumia product page");
        Assert.assertEquals(nokiaLumiaPhonePage.getTotal(),"$349.00","Product price not matched");
        nokiaLumiaPhonePage.changeTheQuantityTo("2");
        nokiaLumiaPhonePage.clickOnAddToCartButton();
        Assert.assertEquals(nokiaLumiaPhonePage.getProductAddedSuccessfullyText(),"The product has been added to your shopping cart","Product not added to Cart");
        nokiaLumiaPhonePage.clickOnCrossButtonOnGreenBar();
        nokiaLumiaPhonePage.mouseHoverOnShoppingCart();
        nokiaLumiaPhonePage.clickOnGoToCart();
        Assert.assertEquals(shoppingCartPage.getShoppingCartPageText(),"Shopping cart","User not navigate to shopping cart page");
        Assert.assertEquals(shoppingCartPage.getQuantityDisplayedOnPage("value"),"2","Quantity not updated");
        Assert.assertEquals(shoppingCartPage.getTotalPriceOfProduct(),"$698.00","Price not displayed according to two products");
        shoppingCartPage.clickOnCheckBoxOfTermsAndService();
        shoppingCartPage.clickOnCheckOutButton();
        checkoutAsGuestOrLoginPage.getWelcomePleaseSignInText();
        checkoutAsGuestOrLoginPage.clickOnRegisterTab();
        Assert.assertEquals(registerPage.getRegisterText(),"Register","User not Navigate to register page");
        registerPage.enterFirstName("Abc");
        registerPage.enterLastName("Xyz");
        registerPage.selectDateOfBirth("1");
        registerPage.selectMonthOfBirth("January");
        registerPage.selectYearOfBirth("1995");
        registerPage.enterEmail("Testuser"+getRandomString(2)+"@gmail.com");
        registerPage.enterPassword("Test123");
        registerPage.enterConfirmPassword("Test123");
        registerPage.clickOnRegister();
        Assert.assertEquals(registerPage.getRegistrationCompleted(),"Your registration completed","Registration not completed");
        registerPage.clickOnContinueButton();
        Assert.assertEquals(shoppingCartPage.getShoppingCartPageText1(),"Shopping cart","User not navigate to shopping cart");
        Thread.sleep(500);
        shoppingCartPage.clickOnCheckBoxOfTermsAndService1();
        shoppingCartPage.clickOnCheckOutButton1();
        onePageCheckoutPage.selectCountry("United Kingdom");
        //onePageCheckoutPage.selectState("England");
        onePageCheckoutPage.selectCity("London");
        onePageCheckoutPage.enterAddressLine1("10 Downing Street");
        onePageCheckoutPage.enterZipCode("EC1B 2JL");
        onePageCheckoutPage.enterPhoneNumber("0987654321");
        onePageCheckoutPage.clickOnContinueButton1();
        onePageCheckoutPage.clickOn2ndDayAirRadioButton();
        onePageCheckoutPage.clickOnContinueButton2();
        onePageCheckoutPage.clickOnCreditCardRadioButton();
        onePageCheckoutPage.clickOnContinueButton3();
        onePageCheckoutPage.selectCreditCardFromDropDown("Visa");
        onePageCheckoutPage.enterCardHolderName("Abc Xyz");
        onePageCheckoutPage.enterCardNumber("4111111111111111");
        onePageCheckoutPage.selectExpiryMonthOfCard("04");
        onePageCheckoutPage.selectExpiryYearOfCard("2026");
        onePageCheckoutPage.enterCardCode("123");
        onePageCheckoutPage.clickOnContinueButton4();
        Assert.assertTrue(onePageCheckoutPage.getPaymentMethodIsCreditCard().contains("Credit Card"), "Payment method is not selected as credit card");
        Assert.assertTrue(onePageCheckoutPage.getShoppingMethodIs2ndDayAir().contains("2nd Day Air"),"Shipping method is not selected 2nd Day Air");
        Assert.assertEquals(onePageCheckoutPage.getTotalPriceOfProduct(),"$698.00","Total not matched");
        onePageCheckoutPage.clickOnConfirm();
        Assert.assertEquals(onePageCheckoutPage.getThankYouText(),"Thank you","Not proceed");
        Assert.assertEquals(onePageCheckoutPage.getOrderSuccessfullyProcessed(),"Your order has been successfully processed!","Order not successfully proceed");
        onePageCheckoutPage.clickOnContinueButton();
        Assert.assertEquals(homePage.getWelcomeToOurStoreText(),"Welcome to our store","Ordered Successfully completed");
        homePage.clickOnLogOutLink();
       Assert.assertEquals(getCurrentUrl(),"https://demo.nopcommerce.com/","User not Logout");
    }
}
