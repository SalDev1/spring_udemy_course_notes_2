package com.salcorps.springbootdemo2.repository;

import com.salcorps.springbootdemo2.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday,String> {

}
