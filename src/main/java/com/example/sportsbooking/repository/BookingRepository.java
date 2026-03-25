package com.example.sportsbooking.repository;

import com.example.sportsbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByFacilityIdAndBookingDate(Long facilityId, String bookingDate);

    List<Booking> findByFacilityIdAndBookingDateAndTimeSlot(
        Long facilityId, String bookingDate, String timeSlot
    );
}