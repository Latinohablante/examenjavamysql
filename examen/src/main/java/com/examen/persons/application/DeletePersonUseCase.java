package com.examen.persons.application;

import com.examen.persons.domain.service.PersonService;

public class DeletePersonUseCase {
    private final PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Long id) {
        personService.deletePerson(id);
    }
}
