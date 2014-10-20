package ua.com.uklon.ui.baseElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.qaproject.selenium.WebDriverWrapper;

/**
 * Created by Nasty on 18.10.2014.
 */
public class Button {

    public static WebElement getButton (WebDriverWrapper driver, String buttonName)
    {
        return driver.findElement(By.xpath("//*[@type='button' and @value='" + buttonName +"']"));
    }
}
