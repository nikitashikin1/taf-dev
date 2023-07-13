package by.itacademy.shikin.Steps;

import by.itacademy.shikin.Pages.DevLoginPage;
import org.openqa.selenium.WebDriver;

public class DevLoginSteps {
    DevLoginPage page;

    public DevLoginSteps(WebDriver driver) {
        page = new DevLoginPage(driver);
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.clickButtonLogin();
        page.sendKeysEmailField(email);
        page.sendKeysPasswordField(password);
        page.clickButtonEnter();
    }
}
