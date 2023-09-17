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

    public MainPage movingMouseToLocator(SelenideElement element) {
        $(element).hover();
        return this;
    }

    public MainPage clickToElement(SelenideElement element) {
        $(element).click();
        return this;
    }

    public MainPage clickOnOverlappedElement(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click()", element);
        return this;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
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

    public SelenideElement getSearchAutoCompleteInput() {
        return searchAutoCompleteInput;
    }

    public ElementsCollection getQuickSearchMessageButtons() {
        return quickSearchMessageButtons;
    }
}
