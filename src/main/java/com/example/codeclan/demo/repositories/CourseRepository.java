package com.example.codeclan.demo.repositories;

import com.example.codeclan.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByRating(int rating);
    List<Course> findByBookingsCustomerName(String name);
}
