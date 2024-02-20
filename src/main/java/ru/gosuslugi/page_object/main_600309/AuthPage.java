package ru.gosuslugi.page_object.main_600309;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class AuthPage extends BasePage {

    private static final String URL_PATTERN = "https://svcdev-beta.test.gosuslugi.ru/%s/1/form";
    private final SelenideElement logInInputField;
    private final SelenideElement passwordInputField;
    private final SelenideElement logInButton;
    //квиз выбор роли
    private final SelenideElement personAuthButton;
    private final SelenideElement entrepreneurAuthButton;
    private final SelenideElement legalAuthButton;

    public AuthPage(SelenideDriver driver) {
        super(driver);
        logInInputField = driver.$("#login");
        passwordInputField = driver.$("#password");
        logInButton = driver.$(byText("Войти"));
        personAuthButton = driver.$(byText("Частное лицо"));
        entrepreneurAuthButton = driver.$(byText("Предприниматель"));
        legalAuthButton = driver.$(byText("Руководитель"));
    }

    public AuthPage open(String serviceId) {
        driver.open(String.format(URL_PATTERN, serviceId));
        return this;
    }

    public AuthPage enterLogin(String login) {
        logInInputField.setValue(login);
        return this;
    }

    public AuthPage enterPassword(String password) {
        passwordInputField.setValue(password);
        return this;
    }

    public AuthPage clickLogInButton() {
        logInButton.click();
        return this;
    }

    public AuthPage chooseRolePerson() {
        personAuthButton.shouldBe(Condition.visible).click();
        return this;
    }

    public AuthPage chooseRoleEntrepreneur() {
        entrepreneurAuthButton.shouldBe(Condition.visible).click();
        return this;
    }

    public AuthPage chooseRoleLegal() {
        legalAuthButton.shouldBe(Condition.visible).click();
        return this;
    }
}