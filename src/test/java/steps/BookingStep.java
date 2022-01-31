package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.BookingPage;

public class BookingStep {
    WebDriver driver;
    BookingPage bookingPage;
    String hotelName;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        bookingPage = new BookingPage(driver);
    }

    @Given("name hotel in island {string}")
    public void nameHotelInIsland(String hotelName) {
        this.hotelName = hotelName;
        hotelName.contentEquals("Hotel Vagar");
    }

    @When("user opened hotel page")
    public void userOpenedHotelPage() {
      driver.get("https://www.booking.com/searchresults.en-gb.html");
      driver.findElement(By.xpath("//input[@id='ss']")).sendKeys(hotelName);
      driver.findElement(By.xpath("//div[text()='Check-in date']")).click();
      driver.findElement(By.xpath("//*[@id='frm']/div[5]/div[2]/button/span[1]")).submit();


    }

    @Then("check first title hotel name is {string}")
    public void checkFirstTitleHotelNameIs(String hotelName) {
        Assert.assertEquals(driver.findElement(By.xpath("//a/div[text()='Hotel Vagar']")).getText(), hotelName, "Name Hotel dose not match");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
