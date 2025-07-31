package com.datacom.qaexam.pages;

import com.microsoft.playwright.Page;

public class QAPracticeMainPage extends BasePage{
    public QAPracticeMainPage(Page page) {
        super(page);
    }

    public void openPage() {
        page.navigate("https://qa-practice.netlify.app");
    }

    public SpotBugsPage navigateToSpotTheBugsChallenge() {
        page.click("#bugs-form");
        return new SpotBugsPage(page);
    }
}
