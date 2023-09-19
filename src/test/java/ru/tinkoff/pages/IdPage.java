package ru.tinkoff.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IdPage {
    private SelenideElement
            formTitle = $("[automation-id = 'form-title']"),
            phoneInput = $("[automation-id = 'phone-input']"),
            submitButton = $("[automation-id = 'button-submit']"),
            loginErrorMessage = $("[automation-id = 'server-error']")
                    .$(byText("Введен неверный номер телефона")),
            checkSmsFormTitle = $("[automation-id = 'form-title']"),
            smsErrorMessage = $("[automation-id = 'server-error']")
                    .$(byText("Введен неверный код"));

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
        loginErrorMessage.isDisplayed();
        return this;
    }

    @Step("Проверяем, что страница ввода смс открылась")
    public IdPage checkSmsFormIsVisible() {
        checkSmsFormTitle.shouldHave(text("Введите код")).isDisplayed();
        return this;
    }

    @Step("Проверяем, что сообщение о некорректном смс отобразилось")
    public IdPage smsErrorMessageIsVisible() {
        smsErrorMessage.isDisplayed();
        return this;
    }

    @Step("Вводим корректный номер телефона и переходим на страницу смс")
    public IdPage setCorrectPhoneAndSubmit(String number) {
        setPhoneNumber(number);
        clickSubmitButton();
        return this;
    }
}
