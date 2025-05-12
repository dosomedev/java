package com.dosomedev;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutExample {
    public void run() {
        // Create the main frame.
        JFrame frame = new JFrame("Grid Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set layout.
        frame.setLayout(new GridLayout(6, 2, 5, 5));

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

        frame.add(lblFirstName);
        frame.add(txtFirstName);
        frame.add(lblLastName);
        frame.add(txtLastName);
        frame.add(lblAge);
        frame.add(txtAge);
        frame.add(lblPlaceOfBirth);
        frame.add(txtPlaceOfBirth);
        frame.add(lblOccupation);
        frame.add(txtOccupation);
        frame.add(lblMail);
        frame.add(txtMail);

        // Set it visible.
        frame.setVisible(true);
    }
}
