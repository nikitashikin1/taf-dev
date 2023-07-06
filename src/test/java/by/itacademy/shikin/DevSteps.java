package by.itacademy.shikin;

import org.openqa.selenium.chrome.ChromeDriver;

public class DevSteps {
    DevPage page;

    DevSteps(ChromeDriver driver){
        page =  new DevPage(driver);
    }

    public void fillLoginFormAndSubmit(String email, String password){
        page.clickButtonLogin();
        page.sendKeysEmailField(email);
        page.sendKeysPasswordField(password);
        page.clickButtonEnter();
    }


}
