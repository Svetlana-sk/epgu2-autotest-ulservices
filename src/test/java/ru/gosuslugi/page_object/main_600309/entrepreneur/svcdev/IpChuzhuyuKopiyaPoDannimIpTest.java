package ru.gosuslugi.page_object.main_600309.entrepreneur.svcdev;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gosuslugi.page_object.main_600309.AuthPage;
import ru.gosuslugi.page_object.main_600309.BaseTest;
import ru.gosuslugi.page_object.main_600309.FormPage;

//[600309] [ИП] Чужую. Копия акта по данным предпринимателя
public class IpChuzhuyuKopiyaPoDannimIpTest extends BaseTest {

    @BeforeEach
    public void setup() {
        Configuration.browser = "chrome";
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void positiveCase() {
        AuthPage authPage = new AuthPage(driver);
        // Поменять void на AuthPage во всех методах
        authPage.open("600309")
            .enterLogin("525-170-078 58") //SVCDEV
            .enterPassword("q0!7EGx~&") //SVCDEV
            .clickLogInButton()
            .chooseRoleEntrepreneur();

        FormPage formPage = new FormPage(driver);
        formPage.clickStartButton()
            .clickChuzhuyuButton()
            .clickKopiyaButton()
            .clickGoToApplicationButton()
            .enterTheTypeOfActivity()
            .chooseTheElement()
            .clickNextButton()
            .clickEntrepreneurDataButton()
            .enterINNEntrepreneur("480952485294")
            .clickElementOutsideInputField()
            .clickCheckLicenseNumber()
            .availableFinalButton();

    }
}