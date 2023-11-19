package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    Constructor constructor;
    WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.get("chrome");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        constructor = new Constructor(webDriver);
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    public void successClickSauceBlockTest() {
        constructor.clickSauceBlock();
        boolean result = constructor.sauceBlockLabelIsDisplayed();
        assertTrue("Не отобразился блок соусов", result);
    }

    @Test
    public void successClickIngredientBlockTest() {
        constructor.clickIngredientBlock();
        boolean result = constructor.ingredientBlockLabelIsDisplayed();
        assertTrue("Не отобразился блок начинок", result);
    }
    @Test
    public void successClickBunBlockTest() {
        constructor.clickSauceBlock();
        constructor.clickBunBlock();
        boolean result = constructor.bunBlockLabelIsDisplayed();
        assertTrue("Не отобразился блок булок", result);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }
}
