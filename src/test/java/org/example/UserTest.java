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
public class UserTest {
    User user;
    WebDriver webDriver;
    String browser;
    String name;
    String email;
    String password;

    public UserTest(
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
                {"chrome", "Guzel4", "karabaeva.guzel4@yandex.ru", "123456"},
                {"yandex", "Guzel5", "karabaeva.guzel5@yandex.ru", "123456"}
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
        boolean result = user.loginFormIsDisplayed();
        assertTrue("Не удалось зарегистрироваться", result);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }
}
