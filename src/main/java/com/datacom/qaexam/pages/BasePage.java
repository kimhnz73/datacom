package com.datacom.qaexam.pages;

import com.microsoft.playwright.Page;

/**
 * Base class for all pages in POM (Page object model design pattern)
 */
public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        if (page == null) {
            throw new IllegalArgumentException("page must be specified");
        }
        this.page = page;
    }
}
