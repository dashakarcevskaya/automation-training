package by.bsu.gettransfer.test;

import by.bsu.gettransfer.driver.DriverSingleton;
import by.bsu.gettransfer.model.User;
import by.bsu.gettransfer.page.HomePage;
import by.bsu.gettransfer.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GettransferTest {
    private WebDriver driver;
    private HomePage page;
    private final String PICK_UP_LOCATION = "Minsk, Belarus";
    private final String RETURN_LOCATION = "Grodno, Belarus";
    private final String PHONE_NUMBER = "123456";
    private final String FULL_NAME = "Darya";
    private final String EMPTY_PHONE_NUMBER = "";

    @BeforeClass
    public void browserSetUp() {
       driver = DriverSingleton.getDriver();
    }


    @Test
    public void attemptSignUp() {
        User testUser = UserCreator.withCredentialsFromProperty();
        page.signUp();
        page.enterFullName(FULL_NAME);
        page.enterPhoneNumberInSignUpForm(EMPTY_PHONE_NUMBER);
        page.signUpClick();
        Assert.assertTrue(page.isErrorMessageVisible1());
    }

    @Test
    public void bookingShowsErrorWhenInvalidNumber() {
        page.inputPickUpLocation(PICK_UP_LOCATION);
        page.inputReturnLocation(RETURN_LOCATION);
        page.selectCar();
        page.enterPhoneNumber(PHONE_NUMBER);
        page.getOffers();
        Assert.assertTrue(page.isErrorMessageVisible2());

    }

    @AfterClass
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}