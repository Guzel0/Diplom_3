package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CabinetTest {
    User user;
    WebDriver webDriver;
    @Before
    public void setUp() {
        webDriver = WebDriverFactory.get("chrome");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user = new User(webDriver);
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        user.showLoginForm("header");
        user.pasteLoginForm("karabaeva.guzel5@yandex.ru", "123456");
    }

    @Test
    public void successShowCabinetTest() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user.showLoginForm("header");
        boolean result = user.cabinetFormIsDisplayed();
        assertTrue("Не удалось попасть в личный кабинет", result);
    }
    @Test
    public void showConstructorTest() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user.showLoginForm("header");
        user.showButtonConstructor();
        boolean result = user.constructorFormIsDisplayed();
        assertTrue("Не удалось попасть в конструктор", result);
    }
    @Test
    public void showConstructorAfterLogoTest() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user.showLoginForm("header");
        user.showLogoButtonStellarBurgers();
        boolean result = user.constructorFormIsDisplayed();
        assertTrue("Не удалось попасть в Stellar Burgers", result);
    }
    @Test
    public void showExitLoginFormTest() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user.showLoginForm("header");
        user.clickButtonExit();
        boolean result = user.exitLoginFormIsDisplayed();
        assertTrue("Не удалось осуществить выход", result);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }
}
