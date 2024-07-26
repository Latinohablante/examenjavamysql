package com.examen.persons.application;

import com.examen.persons.domain.entity.Person;
import com.examen.persons.domain.service.PersonService;

public class UpdatePersonUseCase {
    private final PersonService personService;

    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person) {
        personService.updatePerson(person);
    }
}
