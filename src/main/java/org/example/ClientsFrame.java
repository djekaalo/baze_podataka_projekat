package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientsFrame extends JFrame {
    public ClientsFrame() {
        setTitle("Pregled klijenata");
        setSize(800, 600);
        setLocationRelativeTo(null);


        String[] columns = {"ID", "Ime", "Prezime", "Email", "Telefon"};
        Object[][] data = {
                {1, "Marko", "Marković", "marko@example.com", "0611234567"},
                {2, "Ana", "Anić", "ana@example.com", "0622345678"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Dodaj klijenta");
        JButton editButton = new JButton("Izmeni");
        JButton deleteButton = new JButton("Obriši");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
