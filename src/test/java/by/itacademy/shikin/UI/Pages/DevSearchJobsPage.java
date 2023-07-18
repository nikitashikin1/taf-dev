package by.itacademy.shikin.UI.Pages;

import by.itacademy.shikin.Driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevSearchJobsPage {
    WebDriver driver;
    String baseURL = "https://jobs.devby.io/";
    String searchFieldLocator = "filter_search";
    String buttonSearchLocator = "//button[@class='search__button']";
    String resultSearchLocator = "//a[@class='vacancies-list-item__link_block'][1]";
    String popupWindowCloseButtonLocator = "/html/body/div[1]/div/form/button";

    public DevSearchJobsPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public void getBaseUrl(){
        driver.get(baseURL);
    }

    public void closePopupWindow() {
        WebElement buttonClosePopup = driver.findElement(By.xpath(popupWindowCloseButtonLocator));
        buttonClosePopup.click();
    }

    public void sendKeysSearchField(String value) {
        WebElement searchField = driver.findElement(By.id(searchFieldLocator));
        searchField.sendKeys(value);
    }

    public void clickButtonSearch() {
        WebElement buttonSearch = driver.findElement(By.xpath(buttonSearchLocator));
        buttonSearch.click();
    }

    public String getSearchResultText() {
        WebElement searchResultTex = driver.findElement(By.xpath(resultSearchLocator));
        return searchResultTex.getText();
    }
}