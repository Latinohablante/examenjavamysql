package com.examen.persons.domain.service;

import com.examen.persons.domain.entity.Person;

public interface PersonService {
    void createPerson(Person person);
    Person findPersonById(Long id);
    void updatePerson(Person person);
    void deletePerson(Long id);
}
