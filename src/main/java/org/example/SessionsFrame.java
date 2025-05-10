package org.example;

import javax.swing.*;
import java.awt.*;

public class SessionsFrame extends JFrame {
    public SessionsFrame() {
        setTitle("Pregled seansi");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Lista svih seansi će biti prikazana ovde", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        add(label);
    }
}