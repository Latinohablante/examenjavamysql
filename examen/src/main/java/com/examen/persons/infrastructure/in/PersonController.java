package com.examen.persons.infrastructure.in;


import java.util.Scanner;

import com.examen.persons.application.CreatePersonUseCase;
import com.examen.persons.application.DeletePersonUseCase;
import com.examen.persons.application.FindPersonByIdUseCase;
import com.examen.persons.application.UpdatePersonUseCase;
import com.examen.persons.domain.entity.Person;


public class PersonController {
    private final CreatePersonUseCase createPersonUseCase;
    private final FindPersonByIdUseCase findPersonByIdUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;


    

    public PersonController(CreatePersonUseCase createPersonUseCase, FindPersonByIdUseCase findPersonByIdUseCase,
            UpdatePersonUseCase updatePersonUseCase, DeletePersonUseCase deletePersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
        this.findPersonByIdUseCase = findPersonByIdUseCase;
        this.updatePersonUseCase = updatePersonUseCase;
        this.deletePersonUseCase = deletePersonUseCase;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Persona");
            System.out.println("2. Actualizar persona");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Ver persona por ID");
            System.out.println("5. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createPerson(scanner);
                    break;
                case 2:
                    updatePerson(scanner);
                    break;
                case 3:
                    deletePerson(scanner);
                    break;
                case 4:
                    viewPersonById(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return;
                    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void createPerson(Scanner scanner) {

        System.out.println("Enter ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter lastname: ");
        String lastname = scanner.nextLine();

        System.out.println("Enter city ID: ");
        Integer cityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        System.out.println("Enter age: ");
        Integer age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter gender ID: ");
        Integer genderId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Person person = new Person(id, name, lastname, cityId, address, age, email, genderId);
        createPersonUseCase.execute(person);
        System.out.println("Persona registrada con éxito.");
    }

    private void viewPersonById(Scanner scanner) {
        System.out.println("Enter person ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Person person = findPersonByIdUseCase.execute(id);
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private void updatePerson(Scanner scanner) {
        System.out.println("Enter person ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Person person = findPersonByIdUseCase.execute(id);
        if (person == null) {
            System.out.println("Persona no encontrada.");
            return;
        }

        System.out.println("Enter new name (current: " + person.getName() + "): ");
        String name = scanner.nextLine();

        System.out.println("Enter new name (current: " + person.getLastname() + "): ");
        String lastname = scanner.nextLine();

        System.out.println("Enter new city ID (current: " + person.getIdcity() + "): ");
        Integer cityId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter new address (current: " + person.getAddress() + "): ");
        String address = scanner.nextLine();

        System.out.println("Enter new age (current: " + person.getAge() + "): ");
        Integer age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter new email (current: " + person.getEmail() + "): ");
        String email = scanner.nextLine();

        System.out.println("Enter new gender ID (current: " + person.getIdgender() + "): ");
        Integer genderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline


        person.setName(name);
        person.setLastname(lastname);
        person.setIdcity(cityId);
        person.setAddress(address);
        person.setAge(age);
        person.setEmail(email);
        person.setIdgender(genderId);

        updatePersonUseCase.execute(person);
        System.out.println("Avión actualizado con éxito.");
    }

    private void deletePerson(Scanner scanner) {
        System.out.println("Enter person ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        deletePersonUseCase.execute(id);
        System.out.println("Persona eliminada con éxito.");
    }

}

