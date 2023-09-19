package ru.tinkoff.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.tinkoff.pages.IdPage;
import ru.tinkoff.pages.MainPage;
import ru.tinkoff.utils.TestData;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class IdPageNegativeTests extends TestBase {

    IdPage idPage = new IdPage();
    TestData testData = new TestData();

    private static Stream<Arguments> badPhoneNumbers() {
        TestData testData = new TestData();
        return Stream.of(
                Arguments.of(testData.randomShortWrongPhone),
                Arguments.of(testData.randomLongWrongPhone)
        );
    }

    @DisplayName("Логин не проходит с некорректным номером")
    @MethodSource("badPhoneNumbers")
    @ParameterizedTest(name = "Некорректный номер {0}")
    void loginFailsWithIncorrectNumber(String number) {
        idPage.openPage()
                .setPhoneNumber(number)
                .clickSubmitButton()
                .loginErrorMessageIsVisible();
    }

    @DisplayName("Логин не проходит с некорректным кодом смс")
    @Test
    void loginFailWithIncorrectSms() {
        idPage.openPage()
                .setCorrectPhoneAndSubmit(testData.randomCorrectPhone)
                .checkSmsFormIsVisible()
                .smsErrorMessageIsVisible();
    }
}
