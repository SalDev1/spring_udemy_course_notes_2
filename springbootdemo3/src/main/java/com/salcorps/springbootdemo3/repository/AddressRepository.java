package com.salcorps.springbootdemo3.repository;

import com.salcorps.springbootdemo3.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
