package ru.gosuslugi.page_object.main_600309;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormPage extends BasePage {

    private final SelenideElement startButton;
    private final SelenideElement vipiskaButton;
    private final SelenideElement kopiyaButton;
    private final SelenideElement svouButton;
    private final SelenideElement chuzhuyuButton;
    private final SelenideElement goToApplicationButton;
    private final SelenideElement confirmButton;
    private final SelenideElement theTypeOfActivity;
    private final SelenideElement chooseTheElement;
    private final SelenideElement nextButton;
    private final SelenideElement legalDataButton;
    private final SelenideElement licenseNumberButton;
    private final SelenideElement entrepreneurDataButton;
    private final SelenideElement iNNLegalField;
    private final SelenideElement licenseNumberField;
    private final SelenideElement iNNEntrepreneurField;
    private final SelenideElement checkLicenseButton;
    private final SelenideElement finalButton;
    private final SelenideElement elementOutsideInputField;

    public FormPage(SelenideDriver driver) {
        super(driver);
        //TODO сделать как в AuthPage
        startButton = driver.$(byText("Начать"));
        vipiskaButton = driver.$(byText("Выписка из реестра лицензий"));
        kopiyaButton = driver.$(byText("Копия акта лицензирующего органа о принятом решении"));
        svouButton = driver.$(byText("Свою"));
        chuzhuyuButton = driver.$(byText("Чужую"));
        goToApplicationButton = driver.$(byText("Перейти к заявлению"));
        confirmButton = driver.$(byText("Верно"));
        theTypeOfActivity = driver.$("#s6lookup");
        chooseTheElement = driver.$(".lookup-item-text.ng-star-inserted");
        nextButton = driver.$(byText("Продолжить"));
        legalDataButton = driver.$(byText("По данным организации"));
        licenseNumberButton = driver.$(byText("По номеру лицензии"));
        entrepreneurDataButton = driver.$(byText("По данным предпринимателя"));
        iNNLegalField = driver.$("input[name='s11bLegalInnInput']");
        licenseNumberField = driver.$("#s11aStringInput");
        iNNEntrepreneurField = driver.$("input[name='s11cPersonInnInput']");
        checkLicenseButton = driver.$(byText("Проверить лицензию"));
        finalButton = driver.$(byText("На главную"));
        elementOutsideInputField = driver.$("h1");


    }

    public FormPage clickStartButton() {
        startButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickVipiskaButton() {
        vipiskaButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickKopiyaButton() {
        kopiyaButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickSvouButton() {
        svouButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickChuzhuyuButton() {
        chuzhuyuButton.shouldBe(Condition.visible).click();
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

    public FormPage enterTheTypeOfActivity() {
        theTypeOfActivity.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage chooseTheElement() {
        chooseTheElement.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickNextButton() {
        nextButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickLegalDataButton() {
        legalDataButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickLicenseNumberButton() {
        licenseNumberButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickEntrepreneurDataButton() {
        entrepreneurDataButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage enterINNLegal(String number) {
        iNNLegalField.shouldBe(Condition.visible).setValue(number);
        return this;
    }

    public FormPage enterLicenseNumber(String number) {
        licenseNumberField.shouldBe(Condition.visible).setValue(number);
        return this;
    }

    public FormPage enterINNEntrepreneur(String number) {
        iNNEntrepreneurField.shouldBe(Condition.visible).setValue(number);
        return this;
    }

    public FormPage clickCheckLicenseNumber() {
        checkLicenseButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FormPage clickElementOutsideInputField() {
        elementOutsideInputField.shouldBe(Condition.visible) .click();
        return this;

    }

    public FormPage availableFinalButton() {
        finalButton.shouldBe(Condition.visible).click();
        return this;
    }
}