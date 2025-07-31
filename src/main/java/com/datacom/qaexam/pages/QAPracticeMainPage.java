package com.datacom.qaexam.pages;

import com.datacom.qaexam.configloader.AppConfig;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

/**
 * Main welcome page.
 */
public class QAPracticeMainPage extends BasePage{
    public QAPracticeMainPage(Page page) {
        super(page);
    }

    /**
     * Open the main welcome page
     */
    public void openPage() {
        page.navigate(AppConfig.getInstance().getHomePageUrl());
        page.waitForLoadState(LoadState.LOAD); // wait until the main page is fully loaded
    }

    /**
     * Navigate to Spot The Bugs Challenge
     * @return an instance of SpotBugsPage
     */
    public SpotBugsPage navigateToSpotTheBugsChallenge() {
        page.click("#bugs-form");
        return new SpotBugsPage(page);
    }
}
