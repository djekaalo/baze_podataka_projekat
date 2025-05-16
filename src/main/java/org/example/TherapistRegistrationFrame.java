package org.example;

import org.example.database.JDBCUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TherapistRegistrationFrame extends JFrame {
    public TherapistRegistrationFrame() {
        // Postavljanje osnovnih parametara prozora
        setTitle("Registracija novog terapeuta");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Kreiranje glavnog panela
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Naslov
        JLabel titleLabel = new JLabel("Registracija novog psihoterapeuta");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        // Lični podaci
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Lični podaci:"), gbc);

        // Polja za unos
        JTextField jmbgField = new JTextField(20);
        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);
        JTextField birthDateField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField certDateField = new JTextField(20);
        JComboBox<String> specializationCombo = new JComboBox<>(new String[]{
                "Kognitivno-bihevioralna terapija",
                "Psihodinamska terapija",
                "Humanistička terapija",
                "Geštalt terapija",
                "Porodična terapija"
        });

        // Dodavanje polja u formular
        addFormRow(mainPanel, gbc, "JMBG:", jmbgField, 2);
        addFormRow(mainPanel, gbc, "Ime:", firstNameField, 3);
        addFormRow(mainPanel, gbc, "Prezime:", lastNameField, 4);
        addFormRow(mainPanel, gbc, "Datum rođenja (YYYY-MM-DD):", birthDateField, 5);
        addFormRow(mainPanel, gbc, "Telefon:", phoneField, 6);
        addFormRow(mainPanel, gbc, "Email:", emailField, 7);
        addFormRow(mainPanel, gbc, "Datum sertifikacije (YYYY-MM-DD):", certDateField, 8);
        addFormRow(mainPanel, gbc, "Specijalizacija:", specializationCombo, 9);

        // Dugmad
        JPanel buttonPanel = new JPanel();
        JButton registerButton = new JButton("Registruj");
        JButton cancelButton = new JButton("Otkaži");

        registerButton.addActionListener(e -> {
            // Validacija podataka
            if (!validateFields(jmbgField, firstNameField, lastNameField, birthDateField,
                    phoneField, emailField, certDateField)) {
                return;
            }

            // Registracija terapeuta
            boolean success = JDBCUtils.registrujTerapeuta(
                    jmbgField.getText(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    birthDateField.getText(),
                    phoneField.getText(),
                    emailField.getText(),
                    certDateField.getText(),
                    (String) specializationCombo.getSelectedItem()
            );

            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Terapeut uspešno registrovan!",
                        "Uspeh",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Greška pri registraciji terapeuta!",
                        "Greška",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, String label, JComponent field, int row) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(field, gbc);
    }

    private boolean validateFields(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Sva polja su obavezna!",
                        "Greška",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}