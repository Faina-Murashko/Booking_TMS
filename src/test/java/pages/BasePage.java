package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    BookingPage bookingPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    }

