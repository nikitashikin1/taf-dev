package by.itacademy.shikin;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DevTests {
    ChromeDriver driver;
    DevPage page;
    Faker faker;
    DevSteps devSteps;

    @BeforeEach
    public void WarmUp() {
        driver = new ChromeDriver();
        page = new DevPage(driver);
        driver.get(page.baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        faker = new Faker();
        devSteps = new DevSteps(driver);
    }

    @Test
    public void TestWithEmptyEmailAndPassword() {
        devSteps.fillLoginFormAndSubmit("","");
        Assertions.assertEquals(page.getResultText(), page.resultWithBothFieldsEmpty);
    }
    @Test
    public void TestWithIncorrectEmail() {
        devSteps.fillLoginFormAndSubmit("mail","");
        Assertions.assertEquals(page.getResultText(), page.resultWithEmptyPassword);
    }
    @Test
    public void TestWithEmptyEmailAndAnyPassword() {
        devSteps.fillLoginFormAndSubmit("", Utils.generatePassword());
        Assertions.assertEquals(page.getResultText(), page.resultWithEmptyEmail);
    }
    @Test
    public void TestWithCorrectEmailAndEmptyPassword() {
        devSteps.fillLoginFormAndSubmit(Utils.generateEmail(),"");
        Assertions.assertEquals(page.getResultText(), page.resultWithEmptyPassword);
    }
    @Test
    public void TestWithCorrectEmailAndPassword() {
        devSteps.fillLoginFormAndSubmit(Utils.generateEmail(), Utils.generatePassword());
        Assertions.assertEquals(page.getResultText(), page.resultWithIncorrectData);
    }



    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
