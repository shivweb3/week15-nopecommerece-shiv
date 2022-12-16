package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'header-menu']/ul/li")
    List<WebElement> topMenuTabs;

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/ul[1]/li//a[text()='Computers ']")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//div[@class='item-grid']/div[1]/div[1]/h2/a")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Welcome to our store']")
    WebElement welcomeToOurStoreText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/ul[1]/li[2]/a")
    WebElement electronicTab;

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/ul[1]/li[2]/ul/li[2]/a[1]")
    WebElement cellPhoneLink;

    @CacheLookup
    @FindBy(css = "div.page-title")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement clickLogOut;

    //1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        Reporter.log("Click on the menu whatever name is passed as parameter" + topMenuTabs.toString());
         List<WebElement> topMenuList = topMenuTabs;
         try{
            for (WebElement element : topMenuList ) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        }catch(StaleElementReferenceException e){
             topMenuList = topMenuTabs;
        }
        CustomListeners.test.log(Status.PASS,"Click on the menu whatever name is passed as parameter");
    }

    //********************Computer**********************************//
    //1.1 Click on Computer Menu.
    public void clickOnComputerTab() {
        Reporter.log("Click on Computer Menu Tab" +computerTab.toString());
        mouseHoverToElementAndClick(computerTab);
        CustomListeners.test.log(Status.PASS,"Click on Computer Menu Tab");
    }

    //1.2 Click on Desktop
    public void clickOnDesktopTab() {
        Reporter.log("Click on Desktop" +desktopLink.toString());
        mouseHoverToElementAndClick(desktopLink);
        CustomListeners.test.log(Status.PASS,"Click on Desktop");
    }
    //2.37 Verify the text “Welcome to our store”
    public String getWelcomeToOurStoreText(){
        Reporter.log("Verify the text “Welcome to our store”" +welcomeToOurStoreText.toString());
        CustomListeners.test.log(Status.PASS,"Verify the text “Welcome to our store”");
        return getTextFromElement(welcomeToOurStoreText);
    }

    //********************Electronics**********************************//

    //1.1 Mouse Hover on “Electronics” Tab
    public void mouseHoverToElectronicTab() {
        Reporter.log("Mouse Hover on “Electronics” Tab" +electronicTab.toString());
        mouseHoverToElement(electronicTab);
        CustomListeners.test.log(Status.PASS,"Mouse Hover on “Electronics” Tab");
    }

    //1.2 Mouse Hover on “Cell phones” and click
    public void mouseHoverToCellPhoneLinkAndClick() {
        Reporter.log("Mouse Hover on “Cell phones” and click" +cellPhoneLink.toString());
        mouseHoverToElementAndClick(cellPhoneLink);
        CustomListeners.test.log(Status.PASS,"Mouse Hover on “Cell phones” and click");
    }

    //Verify page navigate to each tab whatever passed
    public String getTitleOfPage(){
        Reporter.log("Verify page navigate to each tab whatever passed" +pageTitle.toString());
        CustomListeners.test.log(Status.PASS,"Verify page navigate to each tab whatever passed");
        return getTextFromElement(pageTitle);

    }
    //2.43 Click on “Logout” link
    public void clickOnLogOutLink(){
        Reporter.log("Click on “Logout” link" +clickLogOut.toString());
        clickOnElement(clickLogOut);
        CustomListeners.test.log(Status.PASS,"Click on “Logout” link");
    }
    //verify the current Url

}
