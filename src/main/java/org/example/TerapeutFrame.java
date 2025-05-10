package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TerapeutFrame extends JFrame {
    public TerapeutFrame() {
        setTitle("Lista psihoterapeuta");
        setSize(800, 600);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Ime", "Prezime", "Email", "Telefon"};
        Object[][] data = {
                {1, "Petar", "Marković", "mare@example.com", "0611234566"},
                {2, "Ana", "Djekic", "anadj@example.com", "0622345666"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Dodaj psihoterapeuta");
        JButton editButton = new JButton("Izmeni psihoterapeuta");
        JButton deleteButton = new JButton("Obriši");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }



}
