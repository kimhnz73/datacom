package com.datacom.qaexam.pages;

import com.datacom.qaexam.configloader.AppConfig;
import com.microsoft.playwright.Page;

public class QAPracticeMainPage extends BasePage{
    public QAPracticeMainPage(Page page) {
        super(page);
    }

    public void openPage() {
        page.navigate(AppConfig.getInstance().getHomePageUrl());
    }

    public SpotBugsPage navigateToSpotTheBugsChallenge() {
        page.click("#bugs-form");
        return new SpotBugsPage(page);
    }
}
