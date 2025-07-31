package com.datacom.qaexam.cucumberhooks;

import com.datacom.qaexam.configloader.AppConfig;
import com.datacom.qaexam.context.TestContext;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.awt.*;

public class CucumberHook {
    private TestContext testContext;

    public CucumberHook(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp(){
        testContext.setPlaywright(Playwright.create());
        BrowserType browserType = null;
        switch (AppConfig.getInstance().getBrowser()) {
            case "chromium":
                browserType = testContext.getPlaywright().chromium();
                break;
            case "chrome":
                browserType = testContext.getPlaywright().chromium();
                break;
            case "firefox":
                browserType = testContext.getPlaywright().firefox();
                break;
            case "webkit":
                browserType = testContext.getPlaywright().webkit();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + AppConfig.getInstance().getBrowser() +". Supported browsers are chromium, firefox, webkit, chrome");
        }
        testContext.setBrowser(browserType.launch(new BrowserType.LaunchOptions().setHeadless(AppConfig.getInstance().isHeadless())));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        testContext.setBrowserContext(testContext.getBrowser().newContext(new Browser.NewContextOptions().setViewportSize((int)dimension.getWidth(), (int)dimension.getHeight())));
        testContext.setPage(testContext.getBrowserContext().newPage());
        testContext.getPage().setDefaultTimeout(AppConfig.getInstance().getTimeoutInMillSeconds());
    }

    @After
    public void tearDown(){
        if(testContext == null) return;
        if(testContext.getPage() != null) testContext.getPage().close();
        if(testContext.getBrowserContext()!= null) testContext.getBrowserContext().close();
        if(testContext.getBrowser()!= null) testContext.getBrowser().close();
        if(testContext.getPlaywright()!= null) testContext.getPlaywright().close();
    }
}
