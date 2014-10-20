package ua.com.uklon.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.qaproject.selenium.WebDriverFactory;
import selenium.qaproject.selenium.WebDriverWrapper;
import util.PropertyLoader;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriverWrapper driver;
    private static String browser_name = PropertyLoader.loadProperty("browser.name");

    @BeforeSuite
    public void setUp() {
        driver = new WebDriverFactory().initDriver(browser_name);

        int xDimension = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.x"));
        int yDimension = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.y"));
        driver.manage().window().setSize(new Dimension(xDimension,yDimension));
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyLoader.loadProperty("selenium.implicitly.wait")), TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
