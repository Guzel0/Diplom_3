package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriverFactory {
    public static WebDriver get(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/org/example/resorces/chromedriver.exe");
                return new ChromeDriver();

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/java/org/example/resorces/yandexdriver.exe");
                return new ChromeDriver();


            default: throw new RuntimeException("Browser is not find!");
        }
    }
}
