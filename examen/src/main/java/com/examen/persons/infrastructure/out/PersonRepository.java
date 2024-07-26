package com.examen.persons.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.examen.common.infrastructure.config.DatabaseConfig;
import com.examen.persons.domain.entity.Person;
import com.examen.persons.domain.service.PersonService;

public class PersonRepository implements PersonService {

    @Override
    public void createPerson(Person person) {
        String sql = "INSERT INTO persons (id, name, lastname, idcity, address, age, email, idgender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setLong(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getLastname());
            statement.setInt(4, person.getIdcity());
            statement.setString(5, person.getAddress());
            statement.setInt(6, person.getAge());
            statement.setString(7, person.getEmail());
            statement.setInt(8, person.getIdgender());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    person.setId(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updatePerson(Person person) {
        String sql = "UPDATE persons SET name = ?, lastname = ?, idcity = ?, address = ?, age = ?, email = ?, idgender = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, person.getName());
                statement.setString(2, person.getLastname());
                statement.setInt(3, person.getIdcity());
                statement.setString(4, person.getAddress());
                statement.setInt(5, person.getAge());
                statement.setString(6, person.getEmail());
                statement.setInt(7, person.getIdgender());
                statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletePerson(Long id) {
        String sql = "DELETE FROM persons WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person findPersonById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPersonById'");
    }
    

}
