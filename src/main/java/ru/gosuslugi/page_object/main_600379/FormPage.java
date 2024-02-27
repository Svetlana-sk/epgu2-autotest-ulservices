package ru.gosuslugi.page_object.main_600379;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import ru.gosuslugi.page_object.main_600309.BasePage;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;

public class FormPage extends BasePage {

    private final SelenideElement startButton;
    private final SelenideElement licenseNumberField;
    private final SelenideElement dateInputField;
    private final SelenideElement nextButton;
    private final SelenideElement theTypeOfActivity;
    private final SelenideElement chooseTheElement;
    private final SelenideElement goToApplicationButton;
    private final SelenideElement confirmButton;
    private final SelenideElement changePhoneNumberButton;
    private final SelenideElement changeEmailButton;
    private final SelenideElement changePhoneNumberAndEmailButton;
    private final SelenideElement phoneInputField;
    private final SelenideElement emailInputField;
    private final SelenideElement signPlaginButton;
    private final SelenideElement oldSignButton;
    private final SelenideElement fileInputField;
    private final SelenideElement sendButton;
    private final SelenideElement finalButton;
    private final SelenideElement mainButton;
    private final SelenideElement checkTheLicensingAuthority;


    public FormPage(SelenideDriver driver) {
        super(driver);
        startButton = driver.$(byText("Начать"));
        licenseNumberField = driver.$("#si6");
        dateInputField = driver.$("input[name='di6']");
        nextButton = driver.$(byText("Продолжить"));
        theTypeOfActivity = driver.$("#s2lookup");
        chooseTheElement = driver.$(".lookup-item-text.ng-star-inserted");
        checkTheLicensingAuthority = driver.$("#s3lookup");
        goToApplicationButton = driver.$(byText("Перейти к заявлению"));
        confirmButton = driver.$(byText("Верно"));
        changePhoneNumberButton = driver.$(byText("Требуется поменять номер телефона"));
        changeEmailButton = driver.$(byText("Требуется поменять адрес электронной почты"));
        changePhoneNumberAndEmailButton = driver.$(byText("Требуется поменять и номер телефона, и адрес электронной почты"));
        phoneInputField = driver.$("input[name='si8_phone']");
        emailInputField = driver.$("input[name='si8_email']");
        signPlaginButton = driver.$(byText("С помощью плагина Госуслуг"));
        oldSignButton = driver.$(byText("Загрузка подписанного заявления"));
        fileInputField = driver.$("input[type=file]");
        sendButton = driver.$(byText("Отправить"));
        finalButton = driver.$(byText("В личный кабинет"));
        mainButton = driver.$(byText("На главную"));
    }

    public FormPage clickStartButton() {
        startButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage enterLicenseNumber(String number) {
        licenseNumberField.shouldBe(Condition.visible).setValue(number);
        return this;
    }
    public FormPage enterDateInput(String number) {
        dateInputField.shouldBe(Condition.visible).setValue(number);
        return this;
    }
    public FormPage clickNextButton() {
        nextButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage enterTheTypeOfActivity(String number) {
        theTypeOfActivity.shouldBe(Condition.visible).setValue(number);
        return this;
    }

    public FormPage chooseTheElement() {
        chooseTheElement.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage enterCheckTheLicensingAuthority(String number) {
        checkTheLicensingAuthority.shouldBe(Condition.visible).setValue(number);
        return this;
    }

    public FormPage clickGoToApplicationButton() {
        goToApplicationButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage clickConfirmButton() {
        confirmButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage clickChangePhoneNumberButton() {
        changePhoneNumberButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage clickChangeEmailButton() {
        changeEmailButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage clickChangePhoneNumberAndEmailButton() {
        changePhoneNumberAndEmailButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage enterPhoneInputField(String number) {
        phoneInputField.shouldBe(Condition.visible).setValue(number);
        return this;
    }
    public FormPage enterEmailInputField(String number) {
        emailInputField.shouldBe(Condition.visible).setValue(number);
        return this;
    }
    public FormPage clickSignPlaginButton() {
        signPlaginButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickOldSignButton() {
        oldSignButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage uploadFile(String filePath) {
        fileInputField.uploadFile(new File(filePath));
        return this;
    }
    public FormPage clickSendButton() {
        sendButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage clickFinalButton() {
        finalButton.shouldBe(Condition.visible).click();
        return this;
    }
    public FormPage clickMainButton() {
        mainButton.shouldBe(Condition.visible).click();
        return this;
    }

}