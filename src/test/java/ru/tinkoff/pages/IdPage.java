package ru.tinkoff.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class IdPage {
    private SelenideElement
            loginFormTitle = $("[automation-id = 'form-title']");

    public SelenideElement getLoginFormTitle() {
        return loginFormTitle;
    }
}
