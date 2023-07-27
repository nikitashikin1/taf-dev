package by.itacademy.shikin.ui.pages;

import by.itacademy.shikin.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevLoginPage {

    public WebDriver driver;
    String baseURL = "https://devby.io/";
    String closePopupLocator = "//div[@id='dismiss-button']";
    String buttonLoginLocator = "//div/a[@class='navbar__nav-item']";
    String inputEmailLocator =  " //li/input[@class='input']";
    String inputPasswordLocator = "password";
    String buttonEnterLocator = "//button[@type='submit']";
    String resultErrorTextLocator = "//span[@class='message message_error']";
    String resultLoginTextLocator = "//a[@class='navbar__user-name']";

    public String resultWithBothFieldsEmpty = "Введите адрес электронной почты или имя пользователя.";
    public String resultWithEmptyEmail = "Введите адрес электронной почты или имя пользователя.";
    public String resultWithEmptyPassword = "Введите пароль.";
    public String resultWithIncorrectData = "Неверный логин или пароль.";

    public DevLoginPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public void getBaseUrl(){
        driver.get(baseURL);
    }

    public void clickButtonLogin() {
        WebElement buttonLogin = driver.findElement(By.xpath(buttonLoginLocator));
        buttonLogin.click();
    }

    public void sendKeysEmailField(String value) {
        WebElement emailField = driver.findElement(By.xpath(inputEmailLocator));
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

    public String getErrorResultText() {
        WebElement resultText = driver.findElement(By.xpath(resultErrorTextLocator));
        return resultText.getText();
    }

    public String getLoginText(){
        WebElement loginText = driver.findElement(By.xpath(resultLoginTextLocator));
        return loginText.getText();
    }
}
