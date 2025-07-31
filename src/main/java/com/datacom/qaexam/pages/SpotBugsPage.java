package com.datacom.qaexam.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class SpotBugsPage extends BasePage{
    public SpotBugsPage(Page page) {
        super(page);
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

    public void selectCountry(String country) {
        page.selectOption("select#countries_dropdown_menu", new SelectOption().setLabel(country));
    }

    public void clearCountry() {
        page.selectOption("select#countries_dropdown_menu", new SelectOption().setLabel("Select a country..."));
    }

    public void enterFirstName(String firstName) {
        page.fill("input#firstName", firstName);
    }

    public void enterLastName(String lastName) {
        page.fill("input#lastName", lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        page.fill("input#emailAddress", emailAddress);
    }


    public void enterPassword(String password) {
        page.fill("input#password", password);
    }

}
