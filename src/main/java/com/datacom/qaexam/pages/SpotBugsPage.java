package com.datacom.qaexam.pages;

import com.microsoft.playwright.Page;

public class SpotBugsPage extends BasePage{
    public SpotBugsPage(Page page) {
        super(page);
    }

    public void openPage() {
        page.navigate("https://qa-practice.netlify.app");
    }

    public void navigateToSpotTheBugsChallenge() {
        page.click("#bugs-form");
    }

    public void clickHomeLink() {
        page.click("//a[@id='home' and text()='Home']");
    }

    public void clickContactLink() {
        page.click("//a[@id='home' and text()='Contact']");
    }

    public void clickCloseMenuButton() {
        page.click("button#sidebarCollapse");
    }

    public void clickRegisterButton() {
        page.click("button#registerBtn");
    }

    public void enterPhoneNumber(String phoneNumber) {
        page.fill("input#phone", phoneNumber);
    }

    public void enterFirstName(String firstName) {
        page.fill("input#firstName", firstName);
    }

    public void enterLastName(String lastName) {
        page.fill("input#lastName", lastName);
    }


}
