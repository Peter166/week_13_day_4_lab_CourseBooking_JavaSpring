package com.example.codeclan.demo;

import com.example.codeclan.demo.models.Booking;
import com.example.codeclan.demo.models.Course;
import com.example.codeclan.demo.models.Customer;
import com.example.codeclan.demo.repositories.BookingRepository;
import com.example.codeclan.demo.repositories.CourseRepository;
import com.example.codeclan.demo.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateCustomer(){
		Customer handsomePeter = new Customer("Peter","Glasgow", 28);
		customerRepository.save(handsomePeter);

		Course python = new Course("Python", "Edinburgh", 3);
		courseRepository.save(python);

		Booking booking1 = new Booking("Julemba", python, handsomePeter);
		bookingRepository.save(booking1);

	}

}
