package com.datacom.qaexam.pages;

import com.datacom.qaexam.context.TestContext;

public abstract class BasePage {
    protected TestContext testContext;

    public BasePage(TestContext testContext) {
        this.testContext = testContext;
    }
}
