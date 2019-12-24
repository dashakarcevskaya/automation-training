package com.epam.ta.model;

import java.util.Objects;

public class SearchQueryMain {

    private String place;
    private String arrivalDate;
    private String departureDate;
    private String roomsNumber;


    public SearchQueryMain(String place, String arrivalDate, String departureDate, String roomsNumber) {
        this.place = place;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomsNumber = roomsNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {

        return departureDate;
    }

    public void setDepartureDate(String departureDate) {

        this.departureDate = departureDate;
    }

    public String getRoomsNumber() {

        return roomsNumber;
    }

    public void setRoomsNumber(String roomsNumber)
    {
        this.roomsNumber = roomsNumber;
    }

    @Override
    public String toString() {
        return "SearchQueryMain{" +
                "place='" + place + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", roomsNumber=" + roomsNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchQueryMain that = (SearchQueryMain) o;
        return getRoomsNumber() == that.getRoomsNumber() &&
                Objects.equals(getPlace(), that.getPlace()) &&
                Objects.equals(getArrivalDate(), that.getArrivalDate()) &&
                Objects.equals(getDepartureDate(), that.getDepartureDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlace(), getArrivalDate(), getDepartureDate(), getRoomsNumber());
    }

}
