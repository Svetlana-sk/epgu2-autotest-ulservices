package ru.gosuslugi.page_object.main_600309;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.gosuslugi.listeners.BrowserTrafficTestListener;


@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    protected SelenideDriver driver;
    protected BrowserTrafficTestListener browserTrafficTestListener;

    @BeforeAll
    public void initDriver() {
        SelenideConfig selenideConfig = new SelenideConfig();
        selenideConfig.proxyEnabled(true);
        driver = new SelenideDriver(selenideConfig);

    }

    @BeforeEach
    public void beforeEach() {
        browserTrafficTestListener = new BrowserTrafficTestListener(driver);
    }
}
