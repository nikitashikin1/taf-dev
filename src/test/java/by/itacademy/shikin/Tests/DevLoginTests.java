package by.itacademy.shikin.Tests;

import by.itacademy.shikin.Pages.DriverSingleton;
import by.itacademy.shikin.Steps.DevLoginSteps;
import by.itacademy.shikin.Pages.DevLoginPage;
import by.itacademy.shikin.Utils.Utils;
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
        Assertions.assertEquals(page.getResultText(), page.resultWithBothFieldsEmpty);
    }

    @Test
    public void TestWithIncorrectEmail() {
        devLoginSteps.fillLoginFormAndSubmit("mail", "");
        Assertions.assertEquals(page.getResultText(), page.resultWithEmptyPassword);
    }

    @Test
    public void TestWithEmptyEmailAndAnyPassword() {
        devLoginSteps.fillLoginFormAndSubmit("", Utils.generatePassword());
        Assertions.assertEquals(page.getResultText(), page.resultWithEmptyEmail);
    }

    @Test
    public void TestWithCorrectEmailAndEmptyPassword() {
        devLoginSteps.fillLoginFormAndSubmit(Utils.generateEmail(), "");
        Assertions.assertEquals(page.getResultText(), page.resultWithEmptyPassword);
    }

    @Test
    public void TestWithCorrectEmailAndPassword() {
        devLoginSteps.fillLoginFormAndSubmit(Utils.generateEmail(), Utils.generatePassword());
        Assertions.assertEquals(page.getResultText(), page.resultWithIncorrectData);
    }

    @AfterEach
    public void tearsDown() {
        DriverSingleton.quit();
    }
}
