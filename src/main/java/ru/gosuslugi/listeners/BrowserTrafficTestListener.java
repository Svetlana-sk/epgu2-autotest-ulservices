package ru.gosuslugi.listeners;

import static java.util.Objects.requireNonNull;
import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.util.HttpMessageContents;
import com.browserup.bup.util.HttpMessageInfo;
import com.codeborne.selenide.SelenideDriver;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.netty.handler.codec.http.HttpResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Cookie;

@Slf4j
@Setter
public class BrowserTrafficTestListener {

    private final SelenideDriver driver;
    private BrowserUpProxy proxy;
    private String orderId;
    private String accToken;

    public BrowserTrafficTestListener(SelenideDriver driver) {
        this.driver = driver;
        driver.close();
        driver.open();
        configureProxy();
    }

    private void configureProxy() {
        proxy = requireNonNull(driver.getProxy()).getProxy();
        proxy.addResponseFilter(this::filterOrderId);
        //proxy.addResponseFilter(this::filterAccToken);
    }

    private void filterOrderId(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
        if (orderId == null) {
            if (StringUtils.containsAnyIgnoreCase(messageInfo.getUrl(), "scenario/getNextStep")) {
                try {
                    DocumentContext json = JsonPath.parse(contents.getTextContents());
                    orderId = json.read("scenarioDto.orderId", String.class);
                    //System.out.println(orderId);
                } catch (Throwable t) {

                }
            }
        }
    }
    private void filterAccToken(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
        try {
            if (accToken == null) {
                Cookie cookie = driver.getWebDriver().manage().getCookieNamed("acc_t");
                if (cookie != null) {
                    accToken = cookie.getValue();
                    //System.out.println("acc_t Cookie Value: " + accToken);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public String getOrderId() {
        //System.out.println(orderId);
        return orderId;
    }
    public String getAccToken() {
        //System.out.println(accToken);
        return accToken;
    }

}

