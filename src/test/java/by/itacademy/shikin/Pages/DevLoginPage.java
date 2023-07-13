package by.itacademy.shikin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevLoginPage {
    public WebDriver driver;
    String buttonLoginLocator = "body > div.wrap > header > div.navbar__row > div.navbar__nav.navbar__nav_aside > a > svg";
    String inputEmailLocator = "#root > div > div > div > div > div > div > form > ul > li:nth-child(1) > input";
    String inputPasswordLocator = "password";
    String buttonEnterLocator = "//*[@id='root']/div/div/div/div/div/div/form/button/span/span";
    public String baseURL = "https://devby.io/";
    String resultTextLocator = "//*[@id='root']/div/div/div/div/div/div/form/span";

    public String resultWithBothFieldsEmpty = "Введите адрес электронной почты или имя пользователя.";
    public String resultWithEmptyEmail = "Введите адрес электронной почты или имя пользователя.";
    public String resultWithEmptyPassword = "Введите пароль.";
    public String resultWithIncorrectData = "Неверный логин или пароль.";

    public DevLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLogin() {
        WebElement buttonLogin = driver.findElement(By.cssSelector(buttonLoginLocator));
        buttonLogin.click();
    }

    public void sendKeysEmailField(String value) {
        WebElement emailField = driver.findElement(By.cssSelector(inputEmailLocator));
        emailField.sendKeys(value);
    }

    public void sendKeysPasswordField(String value) {
        WebElement passwordField = driver.findElement(By.name(inputPasswordLocator));
        passwordField.sendKeys(value);
    }

    public void clickButtonEnter() {
        WebElement buttonEnter = driver.findElement(By.xpath(buttonEnterLocator));
        buttonEnter.click();
    }

    public String getResultText() {
        WebElement resultText = driver.findElement(By.xpath(resultTextLocator));
        return resultText.getText();
    }
}
