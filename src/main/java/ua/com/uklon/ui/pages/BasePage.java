package ua.com.uklon.ui.pages;

import org.openqa.selenium.WebDriver;
import selenium.qaproject.selenium.WebDriverWrapper;
import util.PropertyLoader;

/**
 * Created by Nasty on 10.10.2014.
 */
public abstract class BasePage {
    protected WebDriverWrapper driver;
    protected String pageUrl;
    protected String websiteUrl;

    protected BasePage(WebDriverWrapper driver, String pageUrl) {
        websiteUrl = PropertyLoader.loadProperty("site.url");
        this.driver = driver;
        this.pageUrl = websiteUrl + pageUrl;
    }

    public boolean isOpened()
    {
        return driver.getCurrentUrl().contains(pageUrl);
    }


}
