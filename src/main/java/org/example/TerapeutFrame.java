package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


import org.example.database.JDBCUtils;

import java.sql.*;

public class TerapeutFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public TerapeutFrame() {
        setTitle("Lista psihoterapeuta");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"ID", "Ime", "Prezime", "Email", "Telefon", "Specijalizacija"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        ucitajTerapeute();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Dodaj psihoterapeuta");
        JButton editButton = new JButton("Izmeni psihoterapeuta");
        JButton deleteButton = new JButton("Obriši");

        addButton.addActionListener(e -> dodajTerapeuta());
        editButton.addActionListener(e -> izmeniTerapeuta());
        deleteButton.addActionListener(e -> obrisiTerapeuta());

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void ucitajTerapeute() {
        try (Connection conn = JDBCUtils.getConnection()) {
            String query = "SELECT jmbg, ime, prezime, email, br_telefona, uza_oblast FROM Sertifikovani_psihoterapeut";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            model.setRowCount(0); // Clear existing data

            while (rs.next()) {
                Object[] row = {
                        rs.getString("jmbg"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("br_telefona"),
                        rs.getString("uza_oblast")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Greška pri učitavanju terapeuta: " + e.getMessage(),
                    "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dodajTerapeuta() {
        TherapistRegistrationFrame registrationFrame = new TherapistRegistrationFrame();
        registrationFrame.setVisible(true);
        registrationFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                ucitajTerapeute();
            }
        });
    }

    private void izmeniTerapeuta() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati terapeuta iz tabele.",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String jmbg = (String) model.getValueAt(selectedRow, 0);
    }

    private void obrisiTerapeuta() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati terapeuta iz tabele.",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(this,
                "Da li ste sigurni da želite da obrišete selektovanog terapeuta?",
                "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            String jmbg = (String) model.getValueAt(selectedRow, 0);

            try (Connection conn = JDBCUtils.getConnection()) {
                String query = "DELETE FROM Sertifikovani_psihoterapeut WHERE jmbg = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, jmbg);
                stmt.executeUpdate();

                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Terapeut uspešno obrisan.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Greška pri brisanju terapeuta: " + e.getMessage(),
                        "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
