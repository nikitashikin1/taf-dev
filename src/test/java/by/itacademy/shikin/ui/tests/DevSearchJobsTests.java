package by.itacademy.shikin.ui.tests;

import by.itacademy.shikin.ui.pages.DevSearchJobsPage;
import by.itacademy.shikin.ui.driver.DriverSingleton;
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
