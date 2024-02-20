package ru.gosuslugi.page_object.main_600309;

import com.codeborne.selenide.SelenideDriver;

public class BasePage {

    protected final SelenideDriver driver;

    public BasePage(SelenideDriver driver) {
        this.driver = driver;
    }

}
