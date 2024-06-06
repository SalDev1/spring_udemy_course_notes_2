package com.salcorps.springbootdemo2.repository;

import com.salcorps.springbootdemo2.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
    
}
