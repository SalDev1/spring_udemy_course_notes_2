package com.salcorps.springbootdemo3.repository;

import com.salcorps.springbootdemo3.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass,Integer> {
}
