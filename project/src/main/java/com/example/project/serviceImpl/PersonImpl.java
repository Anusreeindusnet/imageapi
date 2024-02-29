package com.example.project.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.project.Model.Person;
import com.example.project.repository.PersonRepo;
import  com.example.project.service.PersonService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service

public class PersonImpl implements PersonService {

    @Autowired
    PersonRepo personRepository;

    @Override
    public Person createPerson(Person persona) {
        Person savedPerson = personRepository.save(persona);
        return personRepository.save(savedPerson);

    }

    @Override
    public List<Person> createPersons(List<Person> persons) {
        List<Person> savedPersons = personRepository.saveAll(persons);
        return personRepository.saveAll(savedPersons);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);

    }

    @Override
    public Optional<Person> updatePersonById(Long id, Person updatedPerson) {
        return personRepository.findById(id).map(existingPerson -> {
            existingPerson.setName(updatedPerson.getName());
            
            existingPerson.setEmail(updatedPerson.getEmail());
            return personRepository.save(existingPerson);
        });
    }

    @Override
    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }

	
	}



