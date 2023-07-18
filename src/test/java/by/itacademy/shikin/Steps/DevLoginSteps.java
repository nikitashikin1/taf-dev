package by.itacademy.shikin.Steps;

import by.itacademy.shikin.Pages.DevLoginPage;

public class DevLoginSteps {
    DevLoginPage page;

    public DevLoginSteps() {
        page = new DevLoginPage();
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.clickButtonLogin();
        page.sendKeysEmailField(email);
        page.sendKeysPasswordField(password);
        page.clickButtonEnter();
    }
}
