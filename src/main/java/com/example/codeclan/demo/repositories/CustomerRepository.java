package com.example.codeclan.demo.repositories;

import com.example.codeclan.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String name);
    List<Customer> findByAddressAndBookingsCourseName(String address, String name);
    List<Customer> findByAddressAndBookingCourseNameAndAgeGreaterThankEquals(String address,String name, int age);
}
