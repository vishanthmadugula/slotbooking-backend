package com.example.sportsbooking.repository;

import com.example.sportsbooking.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    Page<Facility> findBySportType(String sportType, Pageable pageable);
}