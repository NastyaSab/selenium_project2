package ua.com.uklon.tests;

import org.testng.annotations.Test;
import ua.com.uklon.ui.pages.HomePage;
import ua.com.uklon.ui.pages.OrderTaxiPage;


/**
 * Created by Nasty on 10.10.2014.
 */
public class SmokeTest extends TestBase{

    @Test
    public void smoke_test() {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.search();

    }


}
