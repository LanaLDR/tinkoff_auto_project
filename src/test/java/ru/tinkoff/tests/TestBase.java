package ru.tinkoff.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.tinkoff.config.WebConfigProvider;
import ru.tinkoff.helpers.AttachmentAllure;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static final WebConfigProvider provider = new WebConfigProvider();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        provider.setUp();
    }

    @AfterEach
    void addAttachments() {
        AttachmentAllure.screenshotAs("Last screenshot");
        AttachmentAllure.pageSource();
        AttachmentAllure.browserConsoleLogs();
        AttachmentAllure.addVideo();
        closeWebDriver();
    }
}
