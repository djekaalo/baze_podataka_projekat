package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Novi Početak - Prijava terapeuta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Prijava terapeuta");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Lozinka:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Prijavi se");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (emailField.getText().equals("test@test.com")) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Pogrešni podaci za prijavu",
                            "Greška",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }
}
