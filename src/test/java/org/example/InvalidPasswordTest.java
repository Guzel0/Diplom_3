package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class InvalidPasswordTest {
    User user;
    WebDriver webDriver;
    String browser;
    String name;
    String email;
    String password;

    public InvalidPasswordTest(
            String browser,
            String name,
            String email,
            String password
    ) {
        this.browser = browser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {"chrome", "Guzel2", "karabaeva.guzel2@yandex.ru", "12345"},
                {"yandex", "Guzel3", "karabaeva.guzel3@yandex.ru", "12345"}
        };
    }

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.get(this.browser);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user = new User(webDriver);
    }

    @Test
    public void successRegisterTest() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        user.showLoginForm("header");
        user.showRegisterForm();
        user.pasteRegisterForm(this.name, this.email, this.password);
        boolean result = user.passwordErrorLabelIsDisplayed();
        assertTrue("Не выводится ошибка о некорректном пароле", result);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }
}
