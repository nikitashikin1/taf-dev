package by.itacademy.shikin.Tests;

import by.itacademy.shikin.Pages.DevSearchJobsPage;
import by.itacademy.shikin.Pages.DriverSingleton;
import org.junit.jupiter.api.Test;

public class DevSearchJobsTests {


    @Test
    public void testSearch() {
        DevSearchJobsPage page = new DevSearchJobsPage();
        page.getBaseUrl();
        page.closePopupWindow();
        page.sendKeysSearchField("software engineer");
        page.clickButtonSearch();
        page.getSearchResultText().contains("software engineer");
        DriverSingleton.quit();
    }
}
