package by.bsu.framework.service;

import by.bsu.framework.model.BookingCar;

import java.time.LocalTime;

import static by.bsu.framework.service.TestData.*;
import static by.bsu.framework.util.FormatterPattern.TIME_FORMATTER;

public class BookingCarCreator {
    public static BookingCar withPickUpLocation() {
        return new BookingCar(TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION), null);
    }

    public static BookingCar withPickUpReturnLocation() {
        return new BookingCar(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION_FAR_AWAY),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_PICK_UP_TIME), TIME_FORMATTER),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_RETURN_TIME), TIME_FORMATTER));
    }

    public static BookingCar withPickUpReturnLocationAndTime() {
        return new BookingCar(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION_FAR_AWAY),
                null, null);
    }

    public static BookingCar withPickUpLocationAndCloserTime() {
        return new BookingCar(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                null,
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_PICK_UP_TIME_PLACE_CLOSER), TIME_FORMATTER),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_RETURN_TIME_PLACE_CLOSER), TIME_FORMATTER));
    }

    public static BookingCar withPickUpLocationAndSameTime() {
        return new BookingCar(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                null,
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_SAME_TIME), TIME_FORMATTER),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_SAME_TIME), TIME_FORMATTER));
    }

    public static BookingCar withPickUpReturnImpossibleLocation() {
        return new BookingCar(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION_IMPOSSIBLE));
    }

    public static BookingCar withPickUpReturnDifferentLocation() {
        return new BookingCar(TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION_TO_CHANGE),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION));
    }
}
