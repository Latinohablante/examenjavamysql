package com.examen.common.infrastructure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    // acceder a mysql: mysql -u campus2023 -p
    // contraseña: campus2023
    private static final String URL = "jdbc:mysql://localhost:3306/sgpzf";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "campus2023";

    /*
    private static final String URL = "jdbc:mysql://localhost:3306/sgpzf";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
     */

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}