package com.datacom.qaexam.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

/**
 * This is a page for CHALLENGE - Spot the BUGS!
 */
public class SpotBugsPage extends BasePage{
    private static final String A_ID_HOME_AND_TEXT_HOME = "//a[@id='home' and text()='Home']";
    private static final String A_ID_HOME_AND_TEXT_CONTACT = "//a[@id='home' and text()='Contact']";
    private static final String BUTTON_SIDEBAR_COLLAPSE = "button#sidebarCollapse";
    private static final String BUTTON_REGISTER_BTN = "button#registerBtn";
    private static final String INPUT_PHONE = "input#phone";
    private static final String SELECT_COUNTRIES_DROPDOWN_MENU = "select#countries_dropdown_menu";
    private static final String SELECT_COUNTRIES_DROPDOWN_MENU1 = "select#countries_dropdown_menu";
    private static final String INPUT_FIRST_NAME = "input#firstName";
    private static final String INPUT_LAST_NAME = "input#lastName";
    private static final String INPUT_EMAIL_ADDRESS = "input#emailAddress";
    private static final String INPUT_PASSWORD = "input#password";
    private static final String SELECT_A_COUNTRY = "Select a country...";

    public SpotBugsPage(Page page) {
        super(page);
    }

    public void clickHomeLink() {
        page.click(A_ID_HOME_AND_TEXT_HOME);
    }

    public void clickContactLink() {
        page.click(A_ID_HOME_AND_TEXT_CONTACT);
    }

    public void clickCloseMenuButton() {
        page.click(BUTTON_SIDEBAR_COLLAPSE);
    }

    public void clickRegisterButton() {
        page.click(BUTTON_REGISTER_BTN);
    }

    public void enterPhoneNumber(String phoneNumber) {
        page.fill(INPUT_PHONE, phoneNumber);
    }

    public void selectCountry(String country) {
        page.selectOption(SELECT_COUNTRIES_DROPDOWN_MENU, new SelectOption().setLabel(country));
    }

    public void clearCountry() {
        page.selectOption(SELECT_COUNTRIES_DROPDOWN_MENU1, new SelectOption().setLabel(SELECT_A_COUNTRY));
    }

    public void enterFirstName(String firstName) {
        page.fill(INPUT_FIRST_NAME, firstName);
    }

    public void enterLastName(String lastName) {
        page.fill(INPUT_LAST_NAME, lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        page.fill(INPUT_EMAIL_ADDRESS, emailAddress);
    }


    public void enterPassword(String password) {
        page.fill(INPUT_PASSWORD, password);
    }

}
