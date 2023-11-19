package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class User {
    WebDriver webDriver;

    public User(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // Кнопка "Личный Кабинет"
    public By HeaderLoginButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX'][@href='/account']");
    // Кнопка "Войти в аккаунт"
    public By FooterLoginButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    // Гиперссылка "Зарегистрироваться"
    public By LinkRegistr = By.xpath("//a[@class='Auth_link__1fOlj'][@href='/register']");
    // Поле ввода "Имя"
    public By formName = By.xpath(".//fieldset[1]//div/input");
    // Поле ввода "Email"
    public By formEmail = By.xpath(".//fieldset[2]//div/input");
    // Поле ввода "Пароль"
    public By formPassword = By.xpath(".//div/input[@name = 'Пароль']");
    // Кнопка "Зарегистрироваться"
    public By buttonRegistr = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    // Форма входа
    public By loginForm = By.xpath("//div[@class='Auth_login__3hAey']");
    // Некорректный пароль
    public By passwordErrorLabel = By.xpath("//p[@class='input__error text_type_main-default']");
    // Вход. Поле ввода "Email"
    public By loginFormEmail = By.xpath(".//div/input[@name = 'name']");
    // Вход. Поле ввода "Пароль"
    public By loginFormPassword = By.xpath(".//div/input[@name = 'Пароль']");
    // Кнопка "Войти"
    public By buttonLogin = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    // Кнопка "Оформить заказ"
    public By createOrderButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Оформить заказ']");
    // Регистрация. Кнопка "Войти"
    public By buttonLoginRegistrForm = By.xpath("//a[@class='Auth_link__1fOlj'][@href='/login']");
    // Вход. Кнопка "Восстановить пароль"
    public By buttonForgotPasswordRegistrForm = By.xpath("//a[@class='Auth_link__1fOlj'][@href='/forgot-password']");
    // Форма "Личный Кабинет"
    public By cabinetForm = By.xpath("//div[@class='Account_account__vgk_w']");
    // Личный Кабинет. Кнопка "Конструктор"
    public By buttonConstructor = By.xpath("//a[@class='AppHeader_header__link__3D_hX'][@href='/']");

    // Личный Кабинет. Логотип "Stellar Burgers"
    public By logoButtonStellarBurgers = By.xpath("//a[@href='/']");
    // Форма главной страницы
    public By homePageForm = By.xpath("//h1[text()='Соберите бургер']");
    // Кнопка "Выход"
    public By buttonExit = By.xpath("//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");
    @Step("Отображение формы входа")
    public void showLoginForm(String type) {
        if(type == "header") {
            WebElement element = webDriver.findElement(HeaderLoginButton);
            element.click();
        } else if (type == "footer") {
            WebElement element = webDriver.findElement(FooterLoginButton);
            element.click();
        }
    }
    @Step("Отображение формы регистрации")
    public void showRegisterForm() {
        WebElement element = webDriver.findElement(LinkRegistr);
        element.click();
    }
    @Step("Заполнение формы регистрации")
    public void pasteRegisterForm(String name, String email, String password) {
        WebElement nameElement = webDriver.findElement(formName);
        nameElement.sendKeys(name);

        WebElement emailElement = webDriver.findElement(formEmail);
        emailElement.sendKeys(email);

        WebElement passwordElement = webDriver.findElement(formPassword);
        passwordElement.sendKeys(password);

        WebElement element = webDriver.findElement(buttonRegistr);
        element.click();
    }
    @Step("Проверка видимости формы входа")
    public boolean loginFormIsDisplayed() {
        return webDriver.findElement(loginForm).isDisplayed();
    }
    @Step("Проверка вывода ошибки пароля")
    public boolean passwordErrorLabelIsDisplayed() {
        return webDriver.findElement(passwordErrorLabel).isDisplayed();
    }
    @Step("Заполнение формы входа")
    public void pasteLoginForm(String email, String password) {
        WebElement emailElement = webDriver.findElement(loginFormEmail);
        emailElement.sendKeys(email);

        WebElement passwordElement = webDriver.findElement(loginFormPassword);
        passwordElement.sendKeys(password);

        WebElement element = webDriver.findElement(buttonLogin);
        element.click();
    }
    @Step("Проверка отображения кнопки создания заказа")
    public boolean createOrderButtonIsDisplayed() {
        return webDriver.findElement(createOrderButton).isDisplayed();
    }
    @Step("Проверка отображения кнопки логин в форме регистрации")
    public void showLoginInRegistrForm() {
        WebElement element = webDriver.findElement(buttonLoginRegistrForm);
        element.click();
    }
    @Step("Отображение формы смены пароля")
    public void showForgotPasswordRegistrForm() {
        WebElement element = webDriver.findElement(buttonForgotPasswordRegistrForm);
        element.click();
    }
    @Step("Проверка отображения формы редактирования пользователя")
    public boolean cabinetFormIsDisplayed() {
        return webDriver.findElement(cabinetForm).isDisplayed();
    }
    @Step("Переход на страницу конструктора по кнопке конструктор")
    public void showButtonConstructor() {
        WebElement element = webDriver.findElement(buttonConstructor);
        element.click();
    }
    @Step("Проверка отображения конструктора")
    public boolean constructorFormIsDisplayed() {
        return webDriver.findElement(homePageForm).isDisplayed();
    }
    @Step("Переход на страницу конструктора по клику на логотип")
    public void showLogoButtonStellarBurgers() {
        WebElement element = webDriver.findElement(logoButtonStellarBurgers);
        element.click();
    }
    @Step("Клик по кнопке выход")
    public void clickButtonExit() {
        WebElement element = webDriver.findElement(buttonExit);
        element.click();
    }
    @Step("Проверка отображения формы входа после выхода")
    public boolean exitLoginFormIsDisplayed() {
        return webDriver.findElement(loginForm).isDisplayed();
    }
}
