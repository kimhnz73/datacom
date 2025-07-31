package com.datacom.qaexam.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * This is a test context that contains access to Playwright objects including Playwright, Browser, BrowserContext and Page.
 * Note that this will be initialised by CucumberHook.
 */
public class TestContext {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    public Playwright getPlaywright() {
        return playwright;
    }

    public TestContext setPlaywright(Playwright playwright) {
        this.playwright = playwright;
        return this;
    }

    public Browser getBrowser() {
        return browser;
    }

    public TestContext setBrowser(Browser browser) {
        this.browser = browser;
        return this;
    }

    public BrowserContext getBrowserContext() {
        return browserContext;
    }

    public TestContext setBrowserContext(BrowserContext browserContext) {
        this.browserContext = browserContext;
        return this;
    }

    public Page getPage() {
        return page;
    }

    public TestContext setPage(Page page) {
        this.page = page;
        return this;
    }
}
