package by.bsu.framework.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingCar {
    private String pickUpLocation;
    private String returnLocation;
    private LocalDate dateNow;
    private LocalTime pickUpTime;
    private LocalTime returnTime;

    public BookingCar(String pickUpLocation, String returnLocation) {
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.dateNow = LocalDate.now();
        this.pickUpTime = LocalTime.NOON;
    }

    public BookingCar(String pickUpLocation, String returnLocation,
                      LocalTime localTime, LocalTime returnTime) {
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.dateNow = LocalDate.now();
        this.pickUpTime = localTime;
        this.returnTime = returnTime;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookingCar that = (BookingCar) o;

        if (getPickUpLocation() != null ? !getPickUpLocation().equals(that.getPickUpLocation()) : that.getPickUpLocation() != null)
            return false;
        if (getReturnLocation() != null ? !getReturnLocation().equals(that.getReturnLocation()) : that.getReturnLocation() != null)
            return false;
        if (getDateNow() != null ? !getDateNow().equals(that.getDateNow()) : that.getDateNow() != null) return false;
        if (getPickUpTime() != null ? !getPickUpTime().equals(that.getPickUpTime()) : that.getPickUpTime() != null) return false;
        return getReturnTime() != null ? getReturnTime().equals(that.getReturnTime()) : that.getReturnTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getPickUpLocation() != null ? getPickUpLocation().hashCode() : 0;
        result = 31 * result + (getReturnLocation() != null ? getReturnLocation().hashCode() : 0);
        result = 31 * result + (getDateNow() != null ? getDateNow().hashCode() : 0);
        result = 31 * result + (getPickUpTime() != null ? getPickUpTime().hashCode() : 0);
        result = 31 * result + (getReturnTime() != null ? getReturnTime().hashCode() : 0);
        return result;
    }
}
