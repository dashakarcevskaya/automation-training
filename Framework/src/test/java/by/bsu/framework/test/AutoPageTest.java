package by.bsu.framework.test;

import by.bsu.framework.model.BookingCar;
import by.bsu.framework.page.HomePage;
import by.bsu.framework.service.BookingCarCreator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AutoPageTest extends CommonConditions {
    private static final Logger logger = LogManager.getLogger(AutoPageTest.class);
    private HomePage homePage = new HomePage(driver);

    @Test
    public void updateBookingCarParameters() {
        BookingCar bookingCar = BookingCarCreator.withPickUpReturnDifferentLocation();
        String changingReturnInfoLocation =
                homePage.bookingCar(bookingCar)
                        .clickModifyLink()
                        .inputDropLocValue(bookingCar.getReturnLocation())
                        .clickUpdateButton()
                        .getLocationInfo();
        assertThat(changingReturnInfoLocation, is(equalTo(bookingCar.getReturnLocation())));
        logger.log(Level.INFO, "Test update booking car parameters was performed");
    }
}
