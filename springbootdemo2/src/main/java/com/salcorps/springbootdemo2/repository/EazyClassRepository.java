package com.salcorps.springbootdemo2.repository;

import com.salcorps.springbootdemo2.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass,Integer> {
}
