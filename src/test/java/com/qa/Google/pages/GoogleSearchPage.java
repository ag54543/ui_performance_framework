package com.qa.Google.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends PageObject {
//    @FindBy(css = "#hplogo")
    @FindBy(xpath = "//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']")
    private  WebElementFacade imgGoogle;

    @FindBy(css=".gLFyf.gsfi")
    private WebElementFacade txtBxSearchBox;

    @FindBy(css=".Wkr6U.z4P7Tc")
    private WebElementFacade txtSearchResult;

    public void iLaunchChromeAndEnterGoogleUrl() {
        open();
        getDriver().manage().window().maximize();
    }

    public boolean googlePageIsOpened() {
        imgGoogle.waitUntilVisible();
        return imgGoogle.isDisplayed();
    }

    public GoogleSearchPage iEnterSearchText(String searchText) {
        txtBxSearchBox.sendKeys(searchText);
        return this;
    }

    public String iVerifySearchIsSuccessful() {
        return txtSearchResult.getText();
    }

    public void iPressEnter() {
        txtBxSearchBox.sendKeys(Keys.ENTER);
    }
}
