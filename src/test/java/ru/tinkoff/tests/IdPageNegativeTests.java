package ru.tinkoff.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.tinkoff.pages.IdPage;
import ru.tinkoff.utils.TestData;

import java.util.stream.Stream;


public class IdPageNegativeTests extends TestBase {

    IdPage idPage = new IdPage();
    TestData testData = new TestData();

    private static Stream<Arguments> badPhoneNumbers() {
        TestData testData = new TestData();
        return Stream.of(
                Arguments.of(testData.randomShortWrongPhone),
                Arguments.of(testData.randomLongWrongPhone),
                //Умышленно оставляю неработающий параметр, чтобы была демонстрация в Allure
                Arguments.of(testData.randomCorrectPhone)
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
                .setSmsCode(testData.randomWrongSmsCode)
                .smsErrorMessageIsVisible();
    }
}
