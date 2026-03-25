package com.example.sportsbooking.controller;

import com.example.sportsbooking.dto.BookingRequest;
import com.example.sportsbooking.model.Booking;
import com.example.sportsbooking.model.Facility;
import com.example.sportsbooking.repository.BookingRepository;
import com.example.sportsbooking.repository.FacilityRepository;
import com.example.sportsbooking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService service;

    @Autowired
    private BookingRepository repo;

    @Autowired
    private FacilityRepository facilityRepository;

    @PostMapping
    public Booking create(@Valid @RequestBody BookingRequest request) {
        Facility facility = null;

        if (request.getFacilityId() != null) {
            facility = facilityRepository.findById(request.getFacilityId())
                .orElseThrow(() -> new RuntimeException("Facility not found"));
        } else if (request.getFacility() != null && request.getFacility().getId() != null) {
            facility = facilityRepository.findById(request.getFacility().getId())
                .orElseThrow(() -> new RuntimeException("Facility not found"));
        }

        if (facility == null) {
            throw new RuntimeException("Facility not provided in request");
        }

        Booking booking = new Booking();
        booking.setFacility(facility);
        booking.setBookingDate(request.getBookingDate().trim());
        booking.setTimeSlot(request.getTimeSlot().trim());

        return service.createBooking(booking);
    }

    @GetMapping
    public Page<Booking> getAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }

    @GetMapping("/slots")
    public List<String> getBookedSlots(@RequestParam Long facilityId,
                                       @RequestParam String date) {

        return repo.findByFacilityIdAndBookingDate(facilityId, date)
                .stream()
                .map(Booking::getTimeSlot)
                .toList();
    }
}