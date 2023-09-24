package ru.tinkoff.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement
            loginButton = $("[data-test='loginButton']"),
            webBankLoginButton = $("[data-test='login-first']"),
            businessLoginButton = $("[data-test='login-second']"),
            investmentsLoginButton = $("[data-test='login-third']"),
            searchAutoCompleteInput = $("[data-qa-type='uikit/inputAutocomplete.value.input']"),
            langEnglishSwitcher = $("[data-qa-file='Lang");

    private ElementsCollection quickSearchMessageButtons = $$("[data-qa-type='search-tag']");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("https://www.tinkoff.ru/");
        return this;
    }

    @Step("Наводим мышку на личный кабинет")
    public MainPage movingMouseToPersonalAccount() {
        loginButton.hover();
        return this;
    }

    @Step("Кликаем на элемент {element}")
    public MainPage clickToElement(SelenideElement element) {
        $(element).click();
        return this;
    }

    @Step("Открываем личный кабинет {element}")
    public MainPage openPersonalAccount(SelenideElement element) {
        movingMouseToPersonalAccount();
        clickToElement(element);
        return this;
    }

    @Step("Кликаем по перекрытому элементу {element}")
    public MainPage clickOnOverlappedElement(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click()", element);
        return this;
    }

    @Step("Кликаем по сообщению быстрого поиска {message}")
    public MainPage clickToQuickSearchMessage(SelenideElement message) {
        clickOnOverlappedElement(message);
        return this;
    }

    @Step("Переключаемся на английскую версию")
    public MainPage openEngVersion() {
        clickToElement(langEnglishSwitcher);
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
