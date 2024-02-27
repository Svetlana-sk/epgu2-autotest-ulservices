package ru.gosuslugi.page_object.main_600379.entrepreneur.svcdev;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import ru.gosuslugi.api.steps.LkApiSteps;
import ru.gosuslugi.listeners.BrowserTrafficTestListener;
import ru.gosuslugi.page_object.main_600309.AuthPage;
import ru.gosuslugi.page_object.main_600309.BaseTest;
import ru.gosuslugi.page_object.main_600379.FormPage;

import static com.codeborne.selenide.Selenide.sleep;

//[600379] [ИП] [4] [Россельхознадзор] Фармацевтическая деятельность. Изменение номера телефона, загрузка подписанного заявления
public class Ip4RosselhozPhoneNumberTest extends BaseTest {
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
                .enterTheTypeOfActivity("Фармацевтическая деятельность")
                .chooseTheElement()
                .clickNextButton()
                .enterCheckTheLicensingAuthority("Россельхознадзор")
                .chooseTheElement()
                .clickNextButton()
                .clickGoToApplicationButton()
                .clickConfirmButton()
                .clickConfirmButton()
                .clickChangePhoneNumberButton()
                .enterPhoneInputField("888 888 88 88")
                .clickNextButton()
                .clickOldSignButton()
                .uploadFile("src/main/resources/sign.zip");

        sleep(2000);

        formPage.clickSendButton()
                .clickFinalButton();


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
