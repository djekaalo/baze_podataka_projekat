package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Novi Početak - Glavni meni");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JMenuBar menuBar = new JMenuBar();


        JMenu fileMenu = new JMenu("Fajl");
        JMenuItem exitMenuItem = new JMenuItem("Izlaz");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        JMenu adminMenu = new JMenu("Administracija");
        JMenuItem registerMenuItem = new JMenuItem("Registruj terapeuta");
        registerMenuItem.addActionListener(e -> {
            TherapistRegistrationFrame registrationFrame = new TherapistRegistrationFrame();
            registrationFrame.setVisible(true);
        });
        adminMenu.add(registerMenuItem);
        menuBar.add(adminMenu);


        JMenu viewMenu = new JMenu("Pregledi");
        JMenuItem clientsMenuItem = new JMenuItem("Klijenti");
        JMenuItem sessionsMenuItem = new JMenuItem("Seanse");
        JMenuItem paymentsMenuItem = new JMenuItem("Plaćanja");
        JMenuItem terapeutMenuItem = new JMenuItem("Terapeuti");

        clientsMenuItem.addActionListener(e -> {
            ClientsFrame clientsFrame = new ClientsFrame();
            clientsFrame.setVisible(true);
        });

        sessionsMenuItem.addActionListener(e -> {
            SessionsFrame sessionsFrame = new SessionsFrame();
            sessionsFrame.setVisible(true);
        });

        paymentsMenuItem.addActionListener(e -> {
            PaymentsFrame paymentsFrame = new PaymentsFrame();
            paymentsFrame.setVisible(true);
        });

        terapeutMenuItem.addActionListener(e -> {
            TerapeutFrame terapeutsFrame = new TerapeutFrame();
            terapeutsFrame.setVisible(true);
        });

        JMenuItem pastSessionsMenuItem = new JMenuItem("Održane sesije");
        pastSessionsMenuItem.addActionListener(e -> {
            PastSessionsFrame pastSessionsFrame = new PastSessionsFrame();
            pastSessionsFrame.setVisible(true);
        });


        viewMenu.add(clientsMenuItem);
        viewMenu.add(sessionsMenuItem);
        viewMenu.add(paymentsMenuItem);
        viewMenu.add(terapeutMenuItem);
        viewMenu.add(pastSessionsMenuItem);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);


        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Dobrodošli u Savetovalište Novi Početak", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
