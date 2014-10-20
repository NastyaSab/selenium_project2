package ua.com.uklon.ui.pages;

import selenium.qaproject.selenium.WebDriverWrapper;
import ua.com.uklon.ui.baseElements.Button;

/**
 * Created by Nasty on 18.10.2014.
 */
public class OrderTaxiPage extends BasePage {
    private static final String PAGE_URL = "/taxi";

    public OrderTaxiPage(WebDriverWrapper driver) {
        super(driver, PAGE_URL);
    }

    public void open() {
        driver.get(pageUrl);
    }

    public void buttonClick () {
        Button.getButton(driver,"Узнать стоимость").click();
    }

}
