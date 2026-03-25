package com.example.sportsbooking.config;

import com.example.sportsbooking.model.Facility;
import com.example.sportsbooking.model.User;
import com.example.sportsbooking.repository.FacilityRepository;
import com.example.sportsbooking.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(FacilityRepository facilityRepo, UserRepository userRepo) {
        return args -> {
            System.out.println("Starting data loading...");

            if (userRepo.count() == 0) {
                System.out.println("Creating test users...");
                // Create test users
                userRepo.save(new User(null, "Test User", "test@example.com", "password", "USER"));
                userRepo.save(new User(null, "Admin User", "admin@example.com", "admin", "ADMIN"));
                System.out.println("Test users created successfully");
            } else {
                System.out.println("Users already exist, skipping creation");
            }

            if (facilityRepo.count() == 0) {
                System.out.println("Creating facilities...");

                // random cricket turfs
                facilityRepo.save(new Facility(null, "Cricket Turf A", "Hyderabad", "Cricket"));
                facilityRepo.save(new Facility(null, "Cricket Turf B", "Hyderabad", "Cricket"));
                facilityRepo.save(new Facility(null, "Cricket Turf Lucky 7", "Hyderabad", "Cricket"));
                facilityRepo.save(new Facility(null, "Cricket Turf Speedster", "Hyderabad", "Cricket"));
                facilityRepo.save(new Facility(null, "Cricket Turf Centurion", "Hyderabad", "Cricket"));

                // random badminton courts
                facilityRepo.save(new Facility(null, "Badminton Court A", "Hyderabad", "Badminton"));
                facilityRepo.save(new Facility(null, "Badminton Court B", "Hyderabad", "Badminton"));
                facilityRepo.save(new Facility(null, "Badminton Court Smashers", "Hyderabad", "Badminton"));
                facilityRepo.save(new Facility(null, "Badminton Court Shuttle Express", "Hyderabad", "Badminton"));
                facilityRepo.save(new Facility(null, "Badminton Court NetMasters", "Hyderabad", "Badminton"));

            }
        };
    }
}