package com.examen;

import com.examen.persons.application.CreatePersonUseCase;
import com.examen.persons.application.DeletePersonUseCase;
import com.examen.persons.application.UpdatePersonUseCase;
import com.examen.persons.infrastructure.in.PersonController;
import com.examen.persons.infrastructure.out.PersonRepository;
import com.examen.persons.domain.service.PersonService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Servicios y casos de uso para Person
        PersonRepository personRepository = new PersonRepository();
        PersonService personService = personRepository;
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        UpdatePersonUseCase updatePersonUseCase = new UpdatePersonUseCase(personService);
        DeletePersonUseCase deletePersonUseCase = new DeletePersonUseCase(personService);
        PersonController personController = new PersonController(createPersonUseCase, null, updatePersonUseCase, deletePersonUseCase);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Gestionar persona");
            System.out.println("2. Registrar habilidad");
            System.out.println("3. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    personController.start();
                    
                    break;
                case 2:
                    //userController.start();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}