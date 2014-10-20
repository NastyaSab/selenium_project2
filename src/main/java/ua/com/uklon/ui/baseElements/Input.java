package ua.com.uklon.ui.baseElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.qaproject.selenium.WebDriverWrapper;

/**
 * Created by Nasty on 18.10.2014.
 */
public class Input {
    public static WebElement getInput (WebDriverWrapper driver, String textInput)

    {
        return driver.findElement(By.xpath("//input[contains(@title,'" + textInput + "') or contains (@hint,'" + textInput + "')]"));
    }

}
