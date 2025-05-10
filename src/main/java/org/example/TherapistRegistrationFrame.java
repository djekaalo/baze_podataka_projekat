package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TherapistRegistrationFrame extends JFrame {
    public TherapistRegistrationFrame() {
        setTitle("Registracija novog terapeuta");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JLabel titleLabel = new JLabel("Registracija novog psihoterapeuta");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);


        gbc.gridwidth = 1;


        JLabel personalInfoLabel = new JLabel("Lični podaci:");
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(personalInfoLabel, gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Ime:"), gbc);

        JTextField firstNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(firstNameField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Prezime:"), gbc);

        JTextField lastNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(lastNameField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Email:"), gbc);

        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(emailField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(new JLabel("Telefon:"), gbc);

        JTextField phoneField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(phoneField, gbc);


        JLabel professionalInfoLabel = new JLabel("Profesionalni podaci:");
        professionalInfoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        mainPanel.add(professionalInfoLabel, gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(new JLabel("Specijalizacija:"), gbc);

        String[] specializations = {
                "Kognitivno-bihevioralna terapija",
                "Terapija prihvatanja i posvećenosti",
                "Humanistička terapija",
                "Geštalt terapija",
                "Porodična terapija",
                "Sistemska terapija",
                "Psihodinamska terapija",
                "Mindfulness terapija",
                "Eksperimentalna terapija",
                "Somatska terapija"
        };
        JComboBox<String> specializationCombo = new JComboBox<>(specializations);
        gbc.gridx = 1;
        gbc.gridy = 7;
        mainPanel.add(specializationCombo, gbc);


        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(new JLabel("Datum sertifikacije:"), gbc);

        JTextField certificationDateField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 8;
        mainPanel.add(certificationDateField, gbc);


        JLabel credentialsLabel = new JLabel("Podaci za prijavu:");
        credentialsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        mainPanel.add(credentialsLabel, gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 10;
        mainPanel.add(new JLabel("Korisničko ime:"), gbc);

        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 10;
        mainPanel.add(usernameField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 11;
        mainPanel.add(new JLabel("Lozinka:"), gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 11;
        mainPanel.add(passwordField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 12;
        mainPanel.add(new JLabel("Potvrda lozinke:"), gbc);

        JPasswordField confirmPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 12;
        mainPanel.add(confirmPasswordField, gbc);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton registerButton = new JButton("Registruj");
        JButton cancelButton = new JButton("Otkaži");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                        emailField.getText().isEmpty() || usernameField.getText().isEmpty() ||
                        passwordField.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(TherapistRegistrationFrame.this,
                            "Sva polja su obavezna!",
                            "Greška",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!new String(passwordField.getPassword()).equals(new String(confirmPasswordField.getPassword()))) {
                    JOptionPane.showMessageDialog(TherapistRegistrationFrame.this,
                            "Lozinke se ne podudaraju!",
                            "Greška",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }



                JOptionPane.showMessageDialog(TherapistRegistrationFrame.this,
                        "Terapeut uspešno registrovan!",
                        "Uspeh",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }
}