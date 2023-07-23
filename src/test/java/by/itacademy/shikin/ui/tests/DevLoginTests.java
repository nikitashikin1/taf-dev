package by.itacademy.shikin.ui.tests;

import by.itacademy.shikin.ui.domain.UserCredentials;
import by.itacademy.shikin.ui.driver.DriverSingleton;
import by.itacademy.shikin.ui.steps.DevLoginSteps;
import by.itacademy.shikin.ui.pages.DevLoginPage;
import by.itacademy.shikin.ui.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DevLoginTests {
    DevLoginPage page;
    DevLoginSteps devLoginSteps;

    @BeforeEach
    public void WarmUp() {
        page = new DevLoginPage();
        devLoginSteps = new DevLoginSteps();
        page.getBaseUrl();
    }

    @Test
    public void TestWithEmptyEmailAndPassword() {
        devLoginSteps.fillLoginFormAndSubmit("", "");
        Assertions.assertEquals(page.getErrorResultText(), page.resultWithBothFieldsEmpty);
    }

    @Test
    public void TestWithIncorrectEmail() {
        devLoginSteps.fillLoginFormAndSubmit("mail", "");
        Assertions.assertEquals(page.getErrorResultText(), page.resultWithEmptyPassword);
    }

    @Test
    public void TestWithEmptyEmailAndAnyPassword() {
        devLoginSteps.fillLoginFormAndSubmit("", Utils.generatePassword());
        Assertions.assertEquals(page.getErrorResultText(), page.resultWithEmptyEmail);
    }

    @Test
    public void TestWithAnyEmailAndEmptyPassword() {
        devLoginSteps.fillLoginFormAndSubmit(Utils.generateEmail(), "");
        Assertions.assertEquals(page.getErrorResultText(), page.resultWithEmptyPassword);
    }

    @Test
    public void TestWithAnyEmailAndAnyPassword() {
        devLoginSteps.fillLoginFormAndSubmit(Utils.generateEmail(), Utils.generatePassword());
        Assertions.assertEquals(page.getErrorResultText(), page.resultWithIncorrectData);
    }

    @Test
    public void TestWithActualCredentials(){
        devLoginSteps.fillLoginFormAndSubmit(UserCredentials.email,UserCredentials.password);
        Assertions.assertEquals(page.getLoginText(),UserCredentials.loginName);
    }

    @AfterEach
    public void tearsDown() {
        DriverSingleton.quit();
    }
}
