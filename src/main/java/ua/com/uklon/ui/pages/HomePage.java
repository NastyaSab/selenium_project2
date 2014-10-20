package ua.com.uklon.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.qaproject.selenium.WebDriverWrapper;
import ua.com.uklon.ui.baseElements.Button;
import ua.com.uklon.ui.baseElements.Input;
import ua.com.uklon.ui.baseElements.Link;
import util.ReportWriter;

public class HomePage extends BasePage {

    private static final String PAGE_URL = "/Main";

    public HomePage(WebDriverWrapper driver) {
        super(driver, PAGE_URL);
    }

    public void open() {
        driver.get(pageUrl);
    }

    public void news () {
        Link.getLink(driver, "Новости сайта").click();
    }

    public void switchMenu () {
        Link.getLink(driver, "Главная").click();
        Link.getLink(driver, "Новости").click();
        Link.getLink(driver, "Форум").click();
    }

    public void search () {
        Input.getInput(driver, "Поиск...").sendKeys("карты");
        Button.getButton(driver, "Найти").click();
        ReportWriter.info("test");
    }
}
