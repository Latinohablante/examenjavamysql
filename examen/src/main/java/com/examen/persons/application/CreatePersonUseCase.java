package com.examen.persons.application;

import com.examen.persons.domain.entity.Person;
import com.examen.persons.domain.service.PersonService;

public class CreatePersonUseCase {
    private final PersonService personService;

    public CreatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person) {
        personService.createPerson(person);
    }
}
