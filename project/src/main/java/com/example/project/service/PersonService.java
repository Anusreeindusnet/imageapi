package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.Model.Person;

public interface PersonService {
	Person createPerson(Person person);

    List<Person> createPersons(List<Person> persons);

    Person getPersonById(Long personId);

    List<Person> getAllPersons();

   Optional<Person> updatePersonById(Long personId, Person updatedPerson);

    void deletePerson(Long personId);
}
