package com.qa.Google.stepDefs;

import com.qa.Google.steps.GoogleSearchStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSearchStepDef {

    @Steps
    GoogleSearchStep googleSearchStep;

    @When("^I Launch Chrome And I Enter Google Url$")
    public void i_Launch_Chrome_And_Enter_Google_Url(){
        googleSearchStep.iLaunchChromeAndEnterGoogleUrl();
    }

    @Then("^Google Page is opened$")
    public void google_Page_Is_Opened(){
        assertTrue(googleSearchStep.googlePageIsOpened());
    }

    @When("^I enter search text as \"([^\"]*)\"$")
    public void i_Enter_Search_Text(String searchText){
        googleSearchStep.iEnterSearchText(searchText);
    }

    @Then("^search is successful$")
    public void i_Verify_Search_Is_Successful(){
        assertEquals(googleSearchStep.iVerifySearchIsSuccessful(),"Test automation Software");
    }
}

