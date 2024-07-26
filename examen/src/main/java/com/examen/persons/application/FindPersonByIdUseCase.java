package com.examen.persons.application;

import com.examen.persons.domain.entity.Person;
import com.examen.persons.domain.service.PersonService;

public class FindPersonByIdUseCase {
    private final PersonService personService;

    public FindPersonByIdUseCase(PersonService personService)  {
        this.personService = personService;
    }

    public Person execute (Long id) {
        Person person = personService.findPersonById(id);
        return person; // Devuelve el objeto
    }
}
