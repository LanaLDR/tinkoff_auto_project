package ru.tinkoff.helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class SelenideSteps {

    @Step("Переключаемся на новую открытую вкладку")
    public void switchToNewHandles() {
        switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
    }
}
