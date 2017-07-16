package com.testing.stepdefs;


import com.testing.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SearchStep {

    private BaseStep baseStep;
    private HomePage homePage;

    public SearchStep(BaseStep bStep){
        baseStep = bStep;
    }

    @Given("^I am on the website$")
    public void i_am_on_the_website()  {
        homePage = new HomePage(baseStep.getDriver());
        homePage.open();
    }

    @When("^I enter \"([^\"]*)\" as search text$")
    public void search(String strArg1)  {
        homePage.setTextForSearchField(strArg1);
    }

    @Then("^I should get appropriate results$")
    public void i_should_get_appropriate_results()  {
        assertEquals(2, homePage.searchResultCount());
    }

    @And("^click search button$")
    public void click_search_button()  {
        homePage.search();
    }

    @Then("^I should get alert$")
    public void verifyAlter()  {
        assertEquals("Please enter some search keyword" , homePage.getAlertText());
    }

    @Then("^I should not get any results$")
    public void verifyThatNoResultsAreDisplayed()  {
        assertEquals("No products were found that matched your criteria.", homePage.getNoResultsDivText());
    }

    @And("^Advance search option should be shown$")
    public void verifyAdvanceSearchOption()  {
        homePage.advanceSearchChk.isDisplayed();
    }

    @When("^ I enter maximus characters in search text$")
    public void searchMax()  {
        homePage.setTextForSearchField(getMaxString());
    }


    @And("^I press enter key$")
    public void pressEnterKey()  {
        homePage.txtSearchBox.sendKeys(Keys.RETURN);
    }

    private String getMaxString(){
        char[] chars = new char[100];
        Arrays.fill(chars, 'a');
        return new String(chars);
    }
}
