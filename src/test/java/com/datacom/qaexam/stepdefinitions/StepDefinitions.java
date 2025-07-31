package com.datacom.qaexam.stepdefinitions;

import com.datacom.qaexam.context.TestContext;
import com.datacom.qaexam.pages.QAPracticeMainPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class StepDefinitions {
    private TestContext testContext;
    private QAPracticeMainPage qaPracticePage;
    private Page playWrightPage;


    public StepDefinitions(TestContext testContext){
        if (testContext == null) {
            throw new IllegalArgumentException("testContext must be specified");
        }
        this.testContext = testContext;
        this.playWrightPage = testContext.getPage();
    }

    @Given("I navigate to QA main page")
    public void navigateToQAMainPage(){
        qaPracticePage = new QAPracticeMainPage(testContext);
        qaPracticePage.openPage();
        assertThat(playWrightPage).hasTitle("QA Practice | Learn with RV");
    }

    @When("I navigate to Spot the BUGS CHALLENGE")
    public void navigateToSpotTheBugsChallenge(){
        qaPracticePage.navigateToSpotTheBugsChallenge();
    }

    @Then("I expect page to contain text {string}")
    public void pageTextContains(String text){
        String xpath = "//*[contains(text(), '" + text + "')]";
        Assertions.assertTrue(playWrightPage.locator(xpath).innerText().contains(text), "Cannot find an element with the given text: "
                + text + ". Xpath used: " + xpath);
    }
}
