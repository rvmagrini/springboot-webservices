package com.rvmagrini.springbootwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvmagrini.springbootwebservices.entity.Person;
import com.rvmagrini.springbootwebservices.exception.ResourceNotFoundException;
import com.rvmagrini.springbootwebservices.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	// Get all persons
	@GetMapping
	public List<Person> getAllPersons() {
		return this.personRepository.findAll();
	}
	
	
	// Get person by id
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable("id") long personId) {
		return this.personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
	}
	
	
	// Create person
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return this.personRepository.save(person);
	}
	
	
	// Update person data
	@PutMapping("/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable("id") long personId) {
		Person existingPerson = this.personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setEmail(person.getEmail());
		return this.personRepository.save(existingPerson);
	}
	
	
	// Delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable("id") long personId) {
		Person existingPerson = this.personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
		this.personRepository.delete(existingPerson);
		return ResponseEntity.ok().build();
	}

}
