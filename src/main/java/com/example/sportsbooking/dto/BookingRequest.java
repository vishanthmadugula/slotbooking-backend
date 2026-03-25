package com.example.sportsbooking.dto;

import com.example.sportsbooking.model.Facility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingRequest {

    private Long facilityId;

    private Facility facility;

    @NotBlank(message = "bookingDate is required")
    private String bookingDate;

    @NotBlank(message = "timeSlot is required")
    private String timeSlot;

    public BookingRequest() {
    }

    public BookingRequest(Long facilityId, Facility facility, String bookingDate, String timeSlot) {
        this.facilityId = facilityId;
        this.facility = facility;
        this.bookingDate = bookingDate;
        this.timeSlot = timeSlot;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
