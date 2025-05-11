package org.example;

import org.example.database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.testConnection();
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}