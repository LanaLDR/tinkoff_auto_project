package ru.tinkoff.tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import ru.tinkoff.pages.IdPage;
import ru.tinkoff.pages.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    IdPage idPage = new IdPage();

    private static Stream<Arguments> personalAccountLinks() {
        MainPage mainPage = new MainPage();
        return Stream.of(
                Arguments.of(mainPage.getWebBankLoginButton()),
                Arguments.of(mainPage.getBusinessLoginButton()),
                Arguments.of(mainPage.getInvestmentsLoginButton())
        );
    }

    @DisplayName("Ссылки на личные кабинеты кликабельны")
    @MethodSource("personalAccountLinks")
    @ParameterizedTest(name = "Проверка ссылки с селектором: {0}")
    void linksToPersonalAccountsAreClickable(SelenideElement personalAccountLink) {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });

        step("Открываем личный кабинет", () -> {
            mainPage.openPersonalAccount(personalAccountLink);
        });

        step("Проверяем, что открылась страница авторизации", () -> {
            switchTo().window(WebDriverRunner.getWebDriver().getWindowHandles().size() - 1);
            idPage.idFormTitleIsVisible();
        });
    }

    @DisplayName("Текст кнопок быстрых сообщений отображается в поиске")
    @Test
    void quickMessageButtonsAppearInSearch() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });

        for (SelenideElement messageButton : mainPage.getQuickSearchMessageButtons()) {
            step("Кликаем по кнопке быстрого сообщения", () -> {
                // метод клика по перекрытому элементу (меню с продуктами не исчезает без доп скрола)
                mainPage.clickToQuickSearchMessage(messageButton);
            });

            step("Проверяем, что текст быстрого сообщения отобразился в строке поиска", () -> {
                String messageButtonText = messageButton.getText();
                String searchInputText = mainPage.getActualValueSearchInput();
                Assertions.assertEquals(
                        messageButtonText,
                        searchInputText,
                        "Текст быстрого сообщения не отобразился в поиске");
            });
        }
    }
}
