package com.example.codeclan.demo.controllers;

import com.example.codeclan.demo.repositories.CourseRepository;
import com.example.codeclan.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping()
    public ResponseEntity findAllCourses(
            @RequestParam(name = "courseName", required = false) String courseName,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "age", required = false) Integer age

    ){
        if(age != null && courseName != null && address != null){
            return new ResponseEntity(customerRepository.findByAddressAndBookingCourseNameAndAgeGreaterThankEquals(address,courseName,age),HttpStatus.OK);
        }
        if(courseName != null && address != null){
            return new ResponseEntity(customerRepository.findByAddressAndBookingsCourseName(address, courseName),HttpStatus.OK);
        }
        if(courseName != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
