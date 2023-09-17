package ru.tinkoff.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.tinkoff.helpers.AttachmentAllure;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.tinkoff.ru";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        AttachmentAllure.screenshotAs("Last screenshot");
        AttachmentAllure.pageSource();
        AttachmentAllure.browserConsoleLogs();
        AttachmentAllure.addVideo();
    }
}
