package by.bsu.gettransfer.test;

import by.bsu.gettransfer.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GettransferTest {
    private WebDriver driver;
    private HomePage page;
    private final String pickUpLocation = "Minsk, Belarus";
    private final String returnLocation = "Grodno, Belarus";
    private final String phoneNumber = "123456";
    private final String fullName = "Darya";
    private final String emptyPhoneNumber = "";

    @BeforeClass
    public void browserSetUp() {
       driver = new ChromeDriver();
       page = new HomePage(driver);
       driver.manage().window().maximize();
    }


    @Test
    public void attemptSignUp() {
        page.signUp();
        page.enterFullName(fullName);
        page.enterPhoneNumberInSignUpForm(emptyPhoneNumber);
        page.signUpClick();
        Assert.assertTrue(page.isErrorMessageVisible1());
    }

    @Test
    public void bookingShowsErrorWhenInvalidNumber() {
        page.inputPickUpLocation(pickUpLocation);
        page.inputReturnLocation(returnLocation);
        page.selectCar();
        page.enterPhoneNumber(phoneNumber);
        page.getOffers();
        Assert.assertTrue(page.isErrorMessageVisible2());

    }

    @AfterClass
    public void browserTearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}