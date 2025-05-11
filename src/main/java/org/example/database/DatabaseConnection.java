package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/savetovaliste4";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() {
        System.out.println("Testiram konekciju sa bazom...");
        try (Connection conn = getConnection()) {
            System.out.println("✅ Uspesno povezano sa bazom!");
            System.out.println("🔹 Baza: " + URL);
            System.out.println("🔹 Korisnik: " + USER);
        } catch (SQLException e) {
            System.err.println("❌ Greška pri povezivanju:");
            e.printStackTrace();
        }
    }
}
