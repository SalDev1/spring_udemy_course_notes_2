package com.salcorps.springbootdemo2.repository;

import com.salcorps.springbootdemo2.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    Roles getByRoleName(String roleName);
}
// JPA Repository will provide all the methods that are
// available inside the Spring Data JPA Library.
