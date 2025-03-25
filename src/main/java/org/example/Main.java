package org.example;


import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println(" Conexión exitosa a la base de datos SQL Server");
            }
        } catch (SQLException e) {
            System.err.println(" Error de conexión: " + e.getMessage());
        }
    }
}
