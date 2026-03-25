package com.example.sportsbooking.service;

import com.example.sportsbooking.model.Booking;
import com.example.sportsbooking.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {

        List<Booking> existing = bookingRepository
            .findByFacilityIdAndBookingDateAndTimeSlot(
                booking.getFacility().getId(),
                booking.getBookingDate(),
                booking.getTimeSlot()
            );

        if (!existing.isEmpty()) {
            throw new RuntimeException("Slot already booked!");
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }
}