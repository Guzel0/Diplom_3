package org.example;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Constructor {
    WebDriver webDriver;

    public Constructor(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // Заголовок блока "Соусы"
    public By sauceBlockLabel = By.xpath("//h2[text()='Соусы']");
    // Кнопка "Соусы"
    public By sauceHeaderButton = By.xpath("//span[text()='Соусы']");
    // Заголовок блока "Начинки"
    public By ingredientBlockLabel = By.xpath("//h2[text()='Начинки']");
    // Кнопка "Начинки"
    public By ingredientHeaderButton = By.xpath("//span[text()='Начинки']");
    // Заголовок блока "Булки"
    public By bunBlockLabel = By.xpath("//h2[text()='Булки']");
    // Кнопка "Булки"
    public By bunHeaderButton = By.xpath("//span[text()='Булки']");
    @Step("Клик по блоку Соусы")
    public void clickSauceBlock() {
        WebElement element = webDriver.findElement(sauceHeaderButton);
        element.click();
    }
    @Step("Проверка скрола к блоку Соусы")
    public boolean sauceBlockLabelIsDisplayed() {
        return webDriver.findElement(sauceBlockLabel).isDisplayed();
    }
    @Step("Клик по блоку Начинки")
    public void clickIngredientBlock() {
        WebElement element = webDriver.findElement(ingredientHeaderButton);
        element.click();
    }
    @Step("Проверка скрола к блоку Начинки")
    public boolean ingredientBlockLabelIsDisplayed() {
        return webDriver.findElement(ingredientBlockLabel).isDisplayed();
    }
    @Step("Клик по блоку Булки")
    public void clickBunBlock() {
        WebElement element = webDriver.findElement(bunHeaderButton);
        element.click();
    }
    @Step("Проверка скрола к блоку Булки")
    public boolean bunBlockLabelIsDisplayed() {
        return webDriver.findElement(bunBlockLabel).isDisplayed();
    }
}
