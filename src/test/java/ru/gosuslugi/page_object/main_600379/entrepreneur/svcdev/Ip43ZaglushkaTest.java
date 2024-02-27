package ru.gosuslugi.page_object.main_600379.entrepreneur.svcdev;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gosuslugi.page_object.main_600309.AuthPage;
import ru.gosuslugi.page_object.main_600309.BaseTest;
import ru.gosuslugi.listeners.BrowserTrafficTestListener;
import ru.gosuslugi.api.steps.LkApiSteps;
import ru.gosuslugi.page_object.main_600379.FormPage;

//[600379] [ИП] [43] [ФНС РФ] Заглушка. Азартные игры. Изменение номера телефона и имейла, загрузка подписанного заявления
public class Ip43ZaglushkaTest extends BaseTest{


    private BrowserTrafficTestListener listener;
    private LkApiSteps lkApiSteps;

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
        authPage.open("600379")
                .enterLogin("525-170-078 58") //SVCDEV
                .enterPassword("q0!7EGx~&") //SVCDEV
                .clickLogInButton()
                .chooseRoleEntrepreneur();

        ru.gosuslugi.page_object.main_600379.FormPage formPage = new FormPage(driver);
        formPage.clickStartButton()
                .enterLicenseNumber("480952485294")
                .enterDateInput("02.10.2021")
                .clickNextButton()
                .enterTheTypeOfActivity("Азартные игры")
                .chooseTheElement()
                .clickNextButton()
                .clickMainButton();
    }
}
