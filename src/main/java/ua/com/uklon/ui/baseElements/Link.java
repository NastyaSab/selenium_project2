package ua.com.uklon.ui.baseElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.qaproject.selenium.WebDriverWrapper;

/**
 * Created by Nasty on 18.10.2014.
 */
public class Link {

    public static WebElement getLink (WebDriverWrapper driver, String linkName)
    {
        //return driver.findElement(By.xpath("//a[contains(text(),'" + linkName + "')]"));
        return driver.findElement(By.linkText(linkName));
    }
}
