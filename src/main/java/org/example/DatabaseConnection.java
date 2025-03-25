package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de conexión con usuario y contraseña
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=VentasDB;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "walte";  // Usuario de SQL Server
    private static final String PASSWORD = "8291";  // Contraseña de SQL Server

    public static Connection getConnection() throws SQLException {
        // Usando el usuario y contraseña para la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
