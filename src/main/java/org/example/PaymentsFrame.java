package org.example;

import javax.swing.*;
import java.awt.*;

public class PaymentsFrame extends JFrame {
    public PaymentsFrame() {
        setTitle("Pregled plaćanja");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Evidencija plaćanja će biti prikazana ovde", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        add(label);
    }
}
