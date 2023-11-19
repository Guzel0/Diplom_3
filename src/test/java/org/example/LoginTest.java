package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    User user;
    WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.get("chrome");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user = new User(webDriver);
    }

    @Test
    public void successLoginHeaderTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        user.showLoginForm("header");
        user.pasteLoginForm("karabaeva.guzel5@yandex.ru", "123456");
        boolean result = user.createOrderButtonIsDisplayed();
        assertTrue("Не удалось авторизоваться", result);
    }

    @Test
    public void successLoginFooterTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        user.showLoginForm("footer");
        user.pasteLoginForm("karabaeva.guzel5@yandex.ru", "123456");
        boolean result = user.createOrderButtonIsDisplayed();
        assertTrue("Не удалось авторизоваться", result);
    }
    @Test
    public void successLoginFromRegisterTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        user.showLoginForm("footer");
        user.showRegisterForm();
        user.showLoginInRegistrForm();
        user.pasteLoginForm("karabaeva.guzel5@yandex.ru", "123456");
        boolean result = user.createOrderButtonIsDisplayed();
        assertTrue("Не удалось авторизоваться", result);
    }
    @Test
    public void successLoginFromForgotPasswordTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        user.showLoginForm("footer");
        user.showForgotPasswordRegistrForm();
        user.showLoginInRegistrForm();
        user.pasteLoginForm("karabaeva.guzel5@yandex.ru", "123456");
        boolean result = user.createOrderButtonIsDisplayed();
        assertTrue("Не удалось авторизоваться", result);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }
}
