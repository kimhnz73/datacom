package com.datacom.qaexam.pages;

import com.datacom.qaexam.context.TestContext;

public class QAPracticeMainPage extends BasePage{
    public QAPracticeMainPage(TestContext textContext) {
        super(textContext);
    }

    public void openPage() {
        testContext.getPage().navigate("https://qa-practice.netlify.app");
    }

    public void navigateToSpotTheBugsChallenge() {
        testContext.getPage().click("#bugs-form");
    }
}
