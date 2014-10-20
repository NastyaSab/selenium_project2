package selenium.qaproject.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.PropertyLoader;

import java.io.File;


/**
 * Created by Nasty on 10.10.2014.
 */
public class WebDriverFactory {
    public static final String CHROME = "Chrome";
    public static final String FIREFOX = "Firefox";

    public WebDriver driver;

    public WebDriverWrapper initDriver(String browser) {
        if (browser.equals(FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(CHROME)) {
            File file = new File(PropertyLoader.loadProperty("selenium.chrome.driver.path"));
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        WebDriverWrapper testDriver = new WebDriverWrapper(driver);
        return testDriver;
    }

}
