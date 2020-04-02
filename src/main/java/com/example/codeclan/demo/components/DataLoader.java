package com.example.codeclan.demo.components;

import com.example.codeclan.demo.models.Booking;
import com.example.codeclan.demo.models.Course;
import com.example.codeclan.demo.models.Customer;
import com.example.codeclan.demo.repositories.BookingRepository;
import com.example.codeclan.demo.repositories.CourseRepository;
import com.example.codeclan.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Course python = new Course("Python", "Edinburgh", 3);
        courseRepository.save(python);
        Course java = new Course("Java","Glasgow", 5);
        courseRepository.save(java);

        Customer handsomePeter = new Customer("Peter","Glasgow", 28);
        customerRepository.save(handsomePeter);
        Customer peterWithAccent = new Customer("Peter", "Antarctica", 31);
        customerRepository.save(peterWithAccent);

        Booking booking1 = new Booking("Julemba", python, handsomePeter);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("Julemba", python, peterWithAccent);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("Julemba", java, handsomePeter);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("Julemba", java, peterWithAccent);
        bookingRepository.save(booking4);
    }
}
