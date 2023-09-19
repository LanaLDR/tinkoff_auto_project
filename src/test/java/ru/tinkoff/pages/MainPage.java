package ru.tinkoff.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement
            loginButton = $("[data-test='loginButton']"),
            webBankLoginButton = $("[data-test='login-first']"),
            businessLoginButton = $("[data-test='login-second']"),
            investmentsLoginButton = $("[data-test='login-third']"),
            searchAutoCompleteInput = $("[data-qa-type='uikit/inputAutocomplete.value.input']");

    private ElementsCollection quickSearchMessageButtons = $$("[data-qa-type='search-tag']");

    public MainPage openPage() {
        open("https://www.tinkoff.ru/");
        return this;
    }

    public MainPage movingMouseToPersonalAccount() {
        loginButton.hover();
        return this;
    }

    public MainPage clickToElement(SelenideElement element) {
        $(element).click();
        return this;
    }

    public MainPage openPersonalAccount(SelenideElement element) {
        movingMouseToPersonalAccount();
        clickToElement(element);
        return this;
    }

    public MainPage clickOnOverlappedElement(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click()", element);
        return this;
    }

    public MainPage clickToQuickSearchMessage(SelenideElement message) {
        clickOnOverlappedElement(message);
        return this;
    }

    public String getActualValueSearchInput() {
        return searchAutoCompleteInput.getValue();
    }

    public SelenideElement getWebBankLoginButton() {
        return webBankLoginButton;
    }

    public SelenideElement getBusinessLoginButton() {
        return businessLoginButton;
    }

    public SelenideElement getInvestmentsLoginButton() {
        return investmentsLoginButton;
    }

    public ElementsCollection getQuickSearchMessageButtons() {
        return quickSearchMessageButtons;
    }
}
