package ru.gosuslugi.page_object.main_600309.person.svcdev;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gosuslugi.page_object.main_600309.AuthPage;
import ru.gosuslugi.page_object.main_600309.BaseTest;
import ru.gosuslugi.page_object.main_600309.FormPage;

//[600309] [ФЛ] Копия акта по данным организации. ИНН
public class FlKopiyaPoDannimOrgTest extends BaseTest {

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
        authPage.open("600309")
                .enterLogin("525-170-078 58") //SVCDEV
                .enterPassword("q0!7EGx~&") //SVCDEV
                .clickLogInButton()
                .chooseRolePerson();

        FormPage formPage = new FormPage(driver);
        formPage.clickStartButton()
                .clickKopiyaButton()
                .clickGoToApplicationButton()
                .clickConfirmButton()
                .enterTheTypeOfActivity()
                .chooseTheElement()
                .clickNextButton()
                .clickLegalDataButton()
                .enterINNLegal("5539256523")
                .clickElementOutsideInputField()
                .clickCheckLicenseNumber()
                .availableFinalButton();

    }

}