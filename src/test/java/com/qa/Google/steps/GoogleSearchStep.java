package com.qa.Google.steps;

import com.qa.Google.pages.GoogleSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class GoogleSearchStep extends ScenarioSteps {

    GoogleSearchPage googleSearchPage;

    @Step
    public void iLaunchChromeAndEnterGoogleUrl() {
        googleSearchPage.iLaunchChromeAndEnterGoogleUrl();
    }

    @Step
    public boolean googlePageIsOpened() {
        return googleSearchPage.googlePageIsOpened();
    }

    @Step
    public void iEnterSearchText(String searchText) {
        googleSearchPage.iEnterSearchText(searchText)
                .iPressEnter();
    }

    @Step
    public String iVerifySearchIsSuccessful() {
        return googleSearchPage.iVerifySearchIsSuccessful();
    }
}
