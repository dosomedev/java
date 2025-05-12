package com.dosomedev;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardLayoutExample {
    public void run() {
        // Create the main frame.
        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set layout.
        frame.setLayout(new BorderLayout());
        CardLayout cardLayout = new CardLayout();
        JPanel pnlCards = new JPanel(cardLayout);

        // Add components.
        JLabel lblFirstName = new JLabel("First Name:");
        JTextField txtFirstName = new JTextField(15);

        JLabel lblLastName = new JLabel("Last Name:");
        JTextField txtLastName = new JTextField(15);

        JLabel lblAge = new JLabel("Age:");
        JTextField txtAge = new JTextField(15);

        JLabel lblPlaceOfBirth = new JLabel("Place of Birth:");
        JTextField txtPlaceOfBirth = new JTextField(15);

        JLabel lblOccupation = new JLabel("Occupation:");
        JTextField txtOccupation = new JTextField(15);

        JLabel lblMail = new JLabel("Mail:");
        JTextField txtMail = new JTextField(15);

        JPanel pnlPersonal = new JPanel();
        pnlPersonal.add(lblFirstName);
        pnlPersonal.add(txtFirstName);
        pnlPersonal.add(lblLastName);
        pnlPersonal.add(txtLastName);
        pnlCards.add(pnlPersonal, "personal");

        JPanel pnlBirth = new JPanel();
        pnlBirth.add(lblAge);
        pnlBirth.add(txtAge);
        pnlBirth.add(lblPlaceOfBirth);
        pnlBirth.add(txtPlaceOfBirth);
        pnlCards.add(pnlBirth, "birth");

        JPanel pnlOther = new JPanel();
        pnlOther.add(lblOccupation);
        pnlOther.add(txtOccupation);
        pnlOther.add(lblMail);
        pnlOther.add(txtMail);
        pnlCards.add(pnlOther, "other");

        // Create navigation buttons.
        JButton btnFirst = new JButton("First");
        JButton btnPrevious = new JButton("Previous");
        JButton btnNext = new JButton("Next");
        JButton btnLast = new JButton("Last");

        // Add action listeners to the navigation buttons.
        btnFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.first(pnlCards);
            }
        });

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(pnlCards);
            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(pnlCards);
            }
        });

        btnLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.last(pnlCards);
            }
        });

        // Create a panel for the navigation buttons.
        JPanel pnlNavigation = new JPanel();
        pnlNavigation.add(btnFirst);
        pnlNavigation.add(btnPrevious);
        pnlNavigation.add(btnNext);
        pnlNavigation.add(btnLast);

        // Add the panels to the frame.
        frame.add(pnlCards, BorderLayout.CENTER);
        frame.add(pnlNavigation, BorderLayout.SOUTH);

        // Set it visible.
        frame.setVisible(true);
    }
}
