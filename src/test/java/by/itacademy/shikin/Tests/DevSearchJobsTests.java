package by.itacademy.shikin.Tests;

import by.itacademy.shikin.Pages.DevSearchJobsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DevSearchJobsTests {
    WebDriver driver;

    @Test
    public void testSearch() {
        driver = new ChromeDriver();
        DevSearchJobsPage page = new DevSearchJobsPage(driver);
        driver.get(page.baseURL);
        driver.manage().window().maximize();
        page.closePopupWindow();
        page.sendKeysSearchField("software engineer");
        page.clickButtonSearch();
        page.getSearchResultText().contains("software engineer");
        driver.quit();
    }
}
