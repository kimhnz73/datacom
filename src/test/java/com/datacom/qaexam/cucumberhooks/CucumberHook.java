package com.datacom.qaexam.cucumberhooks;

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
        testContext.setBrowser(testContext.getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        testContext.setBrowserContext(testContext.getBrowser().newContext(new Browser.NewContextOptions().setViewportSize((int)dimension.getWidth(), (int)dimension.getHeight())));
        testContext.setPage(testContext.getBrowserContext().newPage());

        // TODO remove this code
        // TODO remove this code
        // TODO remove this code
        // TODO remove this code
        // TODO remove this code
        // TODO remove this code
        // TODO remove this code
        // TODO remove this code
        testContext.getPage().setDefaultTimeout(5000);

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
