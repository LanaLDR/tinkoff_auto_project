package ru.tinkoff.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IdPage {
    private SelenideElement
            formTitle = $("[automation-id = 'form-title']"),
            phoneInput = $("[automation-id = 'phone-input']"),
            submitButton = $("[automation-id = 'button-submit']"),
            loginErrorMessage = $("[automation-id = 'server-error']"),
            checkSmsFormTitle = $("[automation-id = 'form-title']"),
            smsCodeInput = $("[automation-id = 'otp-input']"),
            smsErrorMessage = $("[automation-id = 'server-error']");

    @Step("Отрываем страницу")
    public IdPage openPage() {
        open("/login");
        return this;
    }

    @Step("Вводим номер телефона")
    public IdPage setPhoneNumber(String number) {
        phoneInput.setValue(number);
        return this;
    }

    @Step("Кликаем на кнопку подтверждения")
    public IdPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем, что форма логина отобразилась")
    public IdPage idFormTitleIsVisible() {
        formTitle.shouldBe(visible).shouldHave(text("Вход в Тинькофф"));
        return this;
    }

    @Step("Проверяем, что сообщение о некорректном номере отобразилось")
    public IdPage loginErrorMessageIsVisible() {
        loginErrorMessage.shouldHave(text("Введен неверный номер телефона")).shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что страница ввода смс открылась")
    public IdPage checkSmsFormIsVisible() {
        checkSmsFormTitle.shouldHave(text("Введите код")).shouldBe(visible);
        return this;
    }

    @Step("Проверяем, что сообщение о некорректном смс отобразилось")
    public IdPage smsErrorMessageIsVisible() {
        smsErrorMessage.shouldHave(text("Введен неверный код")).shouldBe(visible);
        return this;
    }

    @Step("Вводим код из смс")
    public IdPage setSmsCode(String smsCode) {
        smsCodeInput.setValue(smsCode);
        return this;
    }

    @Step("Вводим корректный номер телефона и переходим на страницу смс")
    public IdPage setCorrectPhoneAndSubmit(String number) {
        setPhoneNumber(number);
        clickSubmitButton();
        return this;
    }
}
