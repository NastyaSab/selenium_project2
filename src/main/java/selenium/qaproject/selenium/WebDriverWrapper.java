package selenium.qaproject.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.PropertyLoader;
import util.ReportWriter;

import java.util.List;
import java.util.Set;


public class WebDriverWrapper implements WebDriver{

    private static final long MAX_TIMEOUT = Long.parseLong(PropertyLoader.loadProperty("selenium.max.timeout"));
    private static final long RETRY_TIME = Long.parseLong(PropertyLoader.loadProperty("selenium.retry.time"));
    private static Wait<WebDriver> wait;

    private WebDriver driver;

    public WebDriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitAndVerifyElementPresent (final By by)
    {
        wait = new WebDriverWait(driver, MAX_TIMEOUT, RETRY_TIME * 1000);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver dr) {
                    return dr.findElement(by) != null;
                }
            });
        } catch (Exception e) {

        ReportWriter.logElementNotPresent(by.toString());
        return false;
    }
        ReportWriter.logElementPresent(by.toString());
        return true;
    }

    public boolean waitAndAssertElementPresent (final By by)
    {
        wait = new WebDriverWait(driver, MAX_TIMEOUT, RETRY_TIME * 1000);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver dr) {
                    return dr.findElement(by) != null;
                }
            });
        } catch (Exception e) {
            Assert.fail(ReportWriter.logElementNotPresent(by.toString()));
        }
        System.out.println(ReportWriter.logElementPresent(by.toString()));
        return true;
    }

    public boolean waitAndVerifyURL(final String url) {
        wait = new WebDriverWait(driver, MAX_TIMEOUT, RETRY_TIME * 1000);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver dr) {
                    return dr.getCurrentUrl().contains(url);
                }
            });
        } catch (Exception e) {
            ReportWriter.logPageNotLoaded(url);
            return false;
        }
        return true;
    }

    public boolean waitAndAssertURL(final String url) {
        wait = new WebDriverWait(driver, MAX_TIMEOUT, RETRY_TIME * 1000);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver dr) {
                    return dr.getCurrentUrl().contains(url);
                }
            });
        } catch (Exception e) {
            Assert.fail(ReportWriter.logPageNotLoaded(url));
    }
        return true;
    }


    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        try
        {
            return driver.findElement(by);
        }
        catch (Exception e)
        {
            Assert.fail("There is no element: " + by.toString());
        }
        return null;
    }

    @Override
    public String getPageSource() {
        return getPageSource();
    }

    @Override
    public void close() {
    driver.close();
    }

    @Override
    public void quit() {
    driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
}
