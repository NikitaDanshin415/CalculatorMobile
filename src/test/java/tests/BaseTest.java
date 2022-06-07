package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import helpers.AllureAttach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static helpers.AllureAttach.sessionId;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        AllureAttach.screenshotAs("Last screenshot");
        AllureAttach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        AllureAttach.video(sessionId);
    }
}