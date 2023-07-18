package by.itacademy.shikin.UI.Tests;

import by.itacademy.shikin.UI.Pages.DevSearchJobsPage;
import by.itacademy.shikin.Driver.DriverSingleton;
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
