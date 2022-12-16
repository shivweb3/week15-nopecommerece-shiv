package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class DesktopPageTest extends BaseTest {
    HomePage homePage ;
    DesktopPage desktopPage;
    ShoppingCartPage shoppingCartPage;
    BuildYourOwnComputerProductPage buildYourOwnComputerProductPage;
    CheckoutAsGuestOrLoginPage checkoutAsGuestOrLoginPage;
    OnePageCheckoutPage onePageCheckoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutAsGuestOrLoginPage = new CheckoutAsGuestOrLoginPage();
        buildYourOwnComputerProductPage = new BuildYourOwnComputerProductPage();
        onePageCheckoutPage = new OnePageCheckoutPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder(){
        homePage.clickOnComputerTab();
        homePage.clickOnDesktopTab();
        desktopPage.selectSortedPosition("Name: Z to A");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        homePage.clickOnComputerTab();
        homePage.clickOnDesktopTab();
        desktopPage.selectSortedPosition("Name: A to Z");
        Thread.sleep(500);
        desktopPage.clickOnAddToCartOfBuildYourOwnComputer();
        Assert.assertEquals(buildYourOwnComputerProductPage.getBuildYourComputerText(),"Build your own computer","Product not added");
        buildYourOwnComputerProductPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        buildYourOwnComputerProductPage.selectRAM("8GB [+$60.00]");
        buildYourOwnComputerProductPage.selectHDDRadioButton();
        buildYourOwnComputerProductPage.selectOSVistaPremium();
        buildYourOwnComputerProductPage.selectTwoCheckBox();
        Assert.assertEquals(buildYourOwnComputerProductPage.getTotal(),"$1,475.00","Price not match");
        buildYourOwnComputerProductPage.clickOnAddToCart();
        Assert.assertEquals(buildYourOwnComputerProductPage.getProductAddedMessage(),"The product has been added to your shopping cart");
        buildYourOwnComputerProductPage.clickOnCrossButtonOnGreenBar();
        buildYourOwnComputerProductPage.mouseHoverOnShoppingCart();
        buildYourOwnComputerProductPage.clickOnGoToCart();
        Thread.sleep(500);
        Assert.assertEquals(shoppingCartPage.getShoppingCartPageText(),"Shopping cart","Page not navigated to shopping cart ");
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.clickOnUpdateShoppingCart();
        Assert.assertEquals(shoppingCartPage.getTotalPrice(),"$2,950.00","Shopping cart not updated");
        shoppingCartPage.clickOnCheckBoxOfTermsAndService();
        shoppingCartPage.clickOnCheckOutButton();
        Assert.assertEquals(checkoutAsGuestOrLoginPage.getWelcomePleaseSignInText(),"Welcome, Please Sign In!","Not navigated to login page");
        checkoutAsGuestOrLoginPage.clickOnCheckoutAsGuest();
        onePageCheckoutPage.enterFirstName("Abc");
        onePageCheckoutPage.enterLastName("Xyz");
        onePageCheckoutPage.enterEmail("test123@gmail.com");
        onePageCheckoutPage.selectCountry("United Kingdom");
        onePageCheckoutPage.selectCity("London");
        onePageCheckoutPage.enterAddressLine1("10 Downing Street");
        onePageCheckoutPage.enterZipCode("EC1B 2JL");
        onePageCheckoutPage.enterPhoneNumber("0987654321");
        onePageCheckoutPage.clickOnContinueButton1();
        onePageCheckoutPage.clickOnNextDayAirRadioButton();
        onePageCheckoutPage.clickOnContinueButton2();
        onePageCheckoutPage.clickOnCreditCardRadioButton();
        onePageCheckoutPage.clickOnContinueButton3();
        onePageCheckoutPage.selectCreditCardFromDropDown("Master card");
        onePageCheckoutPage.enterCardHolderName("Abc Xyz");
        onePageCheckoutPage.enterCardNumber("5555 5555 5555 4444");
        onePageCheckoutPage.selectExpiryMonthOfCard("04");
        onePageCheckoutPage.selectExpiryYearOfCard("2026");
        onePageCheckoutPage.enterCardCode("123");
        onePageCheckoutPage.clickOnContinueButton4();
        Assert.assertTrue(onePageCheckoutPage.getPaymentMethodIsCreditCard().contains("Credit Card"), "Payment method is not selected as credit card");
        Assert.assertTrue(onePageCheckoutPage.getShoppingMethodIsNextDayAir().contains("Next Day Air"),"Shipping method is not selected Next Day Air");
        Assert.assertEquals(onePageCheckoutPage.getTotalPriceOfProduct(),"$2,950.00","Total not matched");
        onePageCheckoutPage.clickOnConfirm();
        Assert.assertEquals(onePageCheckoutPage.getThankYouText(),"Thank you","Not proceed");
        Assert.assertEquals(onePageCheckoutPage.getOrderSuccessfullyProcessed(),"Your order has been successfully processed!","Order not successfully proceed");
        onePageCheckoutPage.clickOnContinueButton();
        Assert.assertEquals(homePage.getWelcomeToOurStoreText(),"Welcome to our store","Ordered Successfully completed");
    }
}
