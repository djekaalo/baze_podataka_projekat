package org.example.database;

import java.sql.*;

public class JDBCUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/savetovaliste4?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean proveriTerapeuta(String email, String lozinka) {
        String query = "SELECT COUNT(*) FROM Sertifikovani_psihoterapeut WHERE email = ? AND br_telefona = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, lozinka);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registrujTerapeuta(String jmbg, String ime, String prezime, String datumRodjenja,
                                             String telefon, String email, String datumSertifikacije,
                                             String specijalizacija) {
        String query = "INSERT INTO Sertifikovani_psihoterapeut (jmbg, ime, prezime, datum_rodjenja, " +
                "br_telefona, email, datum_sertifikacije, uza_oblast) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, jmbg);
            stmt.setString(2, ime);
            stmt.setString(3, prezime);
            stmt.setDate(4, Date.valueOf(datumRodjenja));
            stmt.setString(5, telefon);
            stmt.setString(6, email);
            stmt.setDate(7, Date.valueOf(datumSertifikacije));
            stmt.setString(8, specijalizacija);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
