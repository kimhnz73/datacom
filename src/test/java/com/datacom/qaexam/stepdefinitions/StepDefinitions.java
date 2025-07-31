package com.datacom.qaexam.stepdefinitions;

import com.datacom.qaexam.context.TestContext;
import com.datacom.qaexam.pages.QAPracticeMainPage;
import com.datacom.qaexam.pages.SpotBugsPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Cucumber step definitions.
 */
public class StepDefinitions {
    private Page playWrightPage;

    private QAPracticeMainPage qaPracticePage;
    private SpotBugsPage spotBugsPage;

    public StepDefinitions(TestContext testContext){
        if (testContext == null) {
            throw new IllegalArgumentException("testContext must be specified");
        }
        this.playWrightPage = testContext.getPage();
    }

    @Given("I navigate to QA main page")
    public void navigateToQAMainPage(){
        qaPracticePage = new QAPracticeMainPage(playWrightPage);
        qaPracticePage.openPage();
        // To validate page loading successfully
        assertThat(playWrightPage).hasTitle("QA Practice | Learn with RV");
    }

    @When("I navigate to Spot the BUGS CHALLENGE page")
    public void navigateToSpotTheBugsChallenge(){
        spotBugsPage = qaPracticePage.navigateToSpotTheBugsChallenge();
    }

    @Then("I expect page to contain text {string}")
    public void pageTextContains(String text){
        String xpath = "//*[contains(text(), '" + text + "')]";
        Assertions.assertTrue(playWrightPage.locator(xpath).innerText().contains(text), "Cannot find an element with the given text: "
                + text + ". Xpath used: " + xpath);
    }

    @Then("I do not expect page to contain text {string}")
    public void pageTextNotContains(String text){
        String xpath = "//*[contains(text(), '" + text + "')]";
        Assertions.assertFalse(playWrightPage.locator(xpath).innerText().contains(text), "Found an element with the given text which is not expected "
                + text + ". Xpath used: " + xpath);
    }

    @Then("I expect menu to be hidden")
    public void expectMenuToBeHidden(){
        String css = "nav#sidebar.active";
        Assertions.assertTrue(playWrightPage.locator(css).count() == 1,
                "Expected one element with css selector: " + css);
    }

    @When("I click Home link")
    public void clickHomeLink(){
        spotBugsPage.clickHomeLink();
    }

    @When("I click Contact link")
    public void clickContactLink(){
        spotBugsPage.clickContactLink();
    }

    @When("I click Close menu button")
    public void clickCloseMenuButton(){
        spotBugsPage.clickCloseMenuButton();
    }

    @Then("I expect field label {string} to exist")
    public void fieldLabelToExist(String label){
        String xpath = "//label[contains(text(), '" + label + "')]";
        Assertions.assertTrue(playWrightPage.locator(xpath).innerText().equals(label), "Cannot find an element with the given label: "
                + label + ". Xpath used: " + xpath);
    }

    @Then("I expect field placeholder {string} to exist")
    public void fieldPlaceholderToExist(String placeholder){
        String css = "input[placeholder='" + placeholder + "']";
        Assertions.assertTrue(playWrightPage.locator(css).count() == 1,
                "Cannot find an element with the given placeholder: "
                + placeholder + ". Css selector used: " + css);
    }

    @Then("I expect field text helper {string} to exist")
    public void fieldTextHelperToExist(String textHelper){
        String xpath = "//div[@class='form-group']/small[contains(text(), '" + textHelper + "')]";
        Assertions.assertTrue(playWrightPage.locator(xpath).innerText().equals(textHelper),
                "Cannot find an element with the given text helper: "
                        + textHelper + ". XPath used: " + xpath);
    }

    @Then("I expect Terms and Condition checkbox to be enabled")
    public void termsAndConditionEnabled(){
        Assertions.assertTrue(playWrightPage.isEnabled("input#exampleCheck1"), "Expect terms and condition checkbox to be clickable");
    }

    @Given("I click Register button")
    public void clickRegisterButton(){
        spotBugsPage.clickRegisterButton();
    }

    @Then("I expect error message {string}")
    public void expectErrorMessage(String errorMsg){
        String xpath = "//*[@id='message' and text()='" + errorMsg +"']";
        Assertions.assertTrue(playWrightPage.locator(xpath).innerText().equals(errorMsg),
                "Cannot find an element with the given error message: "
                        + errorMsg + ". XPath used: " + xpath);
    }

    @Then("I do not expect error message {string}")
    public void doNotExpectErrorMessage(String errorMsg){
        String xpath = "//*[@id='message' and text()='" + errorMsg +"']";
        Assertions.assertFalse(playWrightPage.locator(xpath).innerText().equals(errorMsg),
                "Found an element with the given error message which is not expected: "
                        + errorMsg + ". XPath used: " + xpath);
    }

    @Given("I enter phone number {string}")
    public void enterPhoneNumber(String phoneNumber){
        spotBugsPage.enterPhoneNumber(phoneNumber);
    }

    @Given("I select country {string}")
    public void selectCountry(String country){
        spotBugsPage.selectCountry(country);
    }

    @Given("I clear country")
    public void clearCountry(){
        spotBugsPage.clearCountry();
    }

    @Given("I enter first name {string}")
    public void enterFirstName(String firstName){
        spotBugsPage.enterFirstName(firstName);
    }

    @Given("I enter last name {string}")
    public void enterLastName(String lastName){
        spotBugsPage.enterLastName(lastName);
    }

    @Given("I enter email address {string}")
    public void enterEmailAddress(String emailAddress){
        spotBugsPage.enterEmailAddress(emailAddress);
    }

    @Given("I enter password {string}")
    public void enterPassword(String password){
        spotBugsPage.enterPassword(password);
    }
}
