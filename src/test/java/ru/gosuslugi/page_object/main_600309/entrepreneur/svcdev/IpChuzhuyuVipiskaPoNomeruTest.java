package ru.gosuslugi.page_object.main_600309.entrepreneur.svcdev;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import ru.gosuslugi.api.steps.LkApiSteps;
import ru.gosuslugi.listeners.BrowserTrafficTestListener;
import ru.gosuslugi.page_object.main_600309.AuthPage;
import ru.gosuslugi.page_object.main_600309.BaseTest;
import ru.gosuslugi.page_object.main_600309.FormPage;

//[600309] [ИП] Чужую. Выписка из реестра по номеру лицензии
public class IpChuzhuyuVipiskaPoNomeruTest extends BaseTest {


    private BrowserTrafficTestListener listener;
    private LkApiSteps lkApiSteps;
    private String accToken;

    @BeforeEach
    public void setup() {
        Configuration.browser = "chrome";
        listener = new BrowserTrafficTestListener(driver);
        lkApiSteps = new LkApiSteps();
    }

    @AfterEach
    public void tearDown() {
        String orderId = listener.getOrderId();
        System.out.println(orderId);
    }

    @Test
    public void positiveCase() {
        AuthPage authPage = new AuthPage(driver);
        authPage.open("600309")
                .enterLogin("525-170-078 58") //SVCDEV
                .enterPassword("q0!7EGx~&") //SVCDEV
                .clickLogInButton()
                .chooseRoleEntrepreneur();

        FormPage formPage = new FormPage(driver);
        formPage.clickStartButton()
                .clickChuzhuyuButton()
                .clickVipiskaButton()
                .clickGoToApplicationButton()
                .enterTheTypeOfActivity("Азартные игры")
                .chooseTheElement()
                .clickNextButton()
                .clickLicenseNumberButton()
                .enterLicenseNumber("1230 ёЁ MDCLXVI().,;:-'\"№/!\"№;%:?*()_+-=/|[]{}^.,#")
                .clickCheckLicenseNumber()
                .availableFinalButton();

        if (accToken == null) {
            Cookie cookie = driver.getWebDriver().manage().getCookieNamed("acc_t");
            if (cookie != null) {
                accToken = cookie.getValue();
            }
        }
        String orderId = listener.getOrderId();

        lkApiSteps.getOrderStatus(accToken, orderId);

    }

}