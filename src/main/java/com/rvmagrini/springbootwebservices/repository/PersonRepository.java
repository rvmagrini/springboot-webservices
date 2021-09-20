package com.rvmagrini.springbootwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmagrini.springbootwebservices.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
