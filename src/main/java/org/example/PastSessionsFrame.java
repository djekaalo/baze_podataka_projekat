package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PastSessionsFrame extends JFrame {
    public PastSessionsFrame() {
        setTitle("Pregled održanih seansi");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Održane sesije", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {
                "ID",
                "Klijent",
                "Datum održavanja",
                "Trajanje (min)",
                "Tip sesije",
                "Zakazano vreme",
                "Stvarno trajanje",
                "Status",
                "Beleške"
        };

        Object[][] data = {
                {1, "Marko Marković", "01.12.2023", 60, "Individualna", "14:00", 55, "Završeno", "Klijent pokazuje napredak u kontroli anksioznosti"},
                {2, "Ana Anić", "05.12.2023", 45, "Porodična", "10:00", 50, "Završeno", "Porodični konflikti - potrebno raditi na komunikaciji"},
                {3, "Jovan Jovanović", "08.12.2023", 60, "Individualna", "16:30", 60, "Završeno", "Preventivna sesija - klijent stabilan"},
                {4, "Milica Petrović", "10.12.2023", 90, "Grupna", "11:00", 85, "Završeno", "Grupna dinamika dobra, svi učesnici aktivni"},
                {5, "Nikola Nikolić", "12.12.2023", 60, "Individualna", "13:00", 60, "Završeno", "Pracenje terapije - redukovana doza lekova"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 8;
            }
        };

        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        table.getColumnModel().getColumn(8).setPreferredWidth(300); // Šira kolona za beleške

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton detailsButton = new JButton("Pregledaj detalje");
        detailsButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Morate selektovati sesiju iz tabele.", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            } else {
                showSessionDetails(
                        table.getValueAt(selectedRow, 1).toString(), // Klijent
                        table.getValueAt(selectedRow, 2).toString(), // Datum
                        table.getValueAt(selectedRow, 4).toString(), // Tip sesije
                        table.getValueAt(selectedRow, 8).toString()  // Beleške
                );
            }
        });

        JButton reportButton = new JButton("Generiši izveštaj");
        reportButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Izveštaj o sesiji je generisan.", "Informacija", JOptionPane.INFORMATION_MESSAGE);
        });


        JButton closeButton = new JButton("Zatvori");
        closeButton.addActionListener(e -> dispose());

        buttonPanel.add(detailsButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(closeButton);


        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filteri"));

        JLabel clientLabel = new JLabel("Klijent:");
        JTextField clientFilter = new JTextField(15);

        JLabel dateLabel = new JLabel("Datum od:");
        JTextField dateFromFilter = new JTextField(10);
        dateFromFilter.setToolTipText("dd.MM.yyyy");

        JLabel toLabel = new JLabel("do:");
        JTextField dateToFilter = new JTextField(10);
        dateToFilter.setToolTipText("dd.MM.yyyy");

        JButton filterButton = new JButton("Filtriraj");
        filterButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funkcionalnost filtriranja će biti implementirana.", "Informacija", JOptionPane.INFORMATION_MESSAGE);
        });

        filterPanel.add(clientLabel);
        filterPanel.add(clientFilter);
        filterPanel.add(dateLabel);
        filterPanel.add(dateFromFilter);
        filterPanel.add(toLabel);
        filterPanel.add(dateToFilter);
        filterPanel.add(filterButton);

        bottomPanel.add(filterPanel, BorderLayout.NORTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void showSessionDetails(String client, String date, String type, String notes) {
        JDialog detailsDialog = new JDialog(this, "Detalji sesije", true);
        detailsDialog.setSize(500, 400);
        detailsDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        infoPanel.add(new JLabel("Klijent: " + client));
        infoPanel.add(new JLabel("Datum: " + date));
        infoPanel.add(new JLabel("Tip sesije: " + type));

        panel.add(infoPanel, BorderLayout.NORTH);

        JLabel notesLabel = new JLabel("Beleške:");
        JTextArea notesArea = new JTextArea(notes);
        notesArea.setEditable(true);
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);
        notesArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane notesScroll = new JScrollPane(notesArea);
        panel.add(notesLabel, BorderLayout.CENTER);
        panel.add(notesScroll, BorderLayout.CENTER);

        JButton saveButton = new JButton("Sačuvaj beleške");
        saveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(detailsDialog, "Beleške su uspešno sačuvane.", "Potvrda", JOptionPane.INFORMATION_MESSAGE);
            detailsDialog.dispose();
        });

        panel.add(saveButton, BorderLayout.SOUTH);

        detailsDialog.add(panel);
        detailsDialog.setVisible(true);
    }

}

