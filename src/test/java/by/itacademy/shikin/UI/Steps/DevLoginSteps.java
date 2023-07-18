package by.itacademy.shikin.UI.Steps;

import by.itacademy.shikin.UI.Pages.DevLoginPage;

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
